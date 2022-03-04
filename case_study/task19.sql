use case_study_furama;

select dich_vu_di_kem.ma_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem
from hop_dong join hop_dong_chi_tiet
on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
join dich_vu_di_kem 
on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
where year(hop_dong.ngay_lam_hop_dong) = 2020 
and hop_dong_chi_tiet.so_luong > 10;

create TEMPORARY table temp 
select dich_vu_di_kem.ma_dich_vu_di_kem
from hop_dong join hop_dong_chi_tiet
on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
join dich_vu_di_kem 
on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
where year(hop_dong.ngay_lam_hop_dong) = 2020 
and hop_dong_chi_tiet.so_luong > 10;


update dich_vu_di_kem
set gia = dich_vu_di_kem.gia*2
where ma_dich_vu_di_kem in (
select * from temp);

drop TEMPORARY table temp;