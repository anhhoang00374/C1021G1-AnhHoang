use case_study_furama;

select hop_dong.ma_hop_dong,loai_dich_vu.ten_loai_dich_vu,
dich_vu_di_kem.ten_dich_vu_di_kem,1 as "so_lan_su_dung"
from
hop_dong join hop_dong_chi_tiet
on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
join dich_vu_di_kem
on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
join dich_vu 
on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
join loai_dich_vu 
on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
where hop_dong_chi_tiet.ma_dich_vu_di_kem in
(select hop_dong_chi_tiet.ma_dich_vu_di_kem from
hop_dong
join hop_dong_chi_tiet
on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
group by hop_dong_chi_tiet.ma_dich_vu_di_kem
having count(hop_dong_chi_tiet.ma_dich_vu_di_kem) = 1
)
order by hop_dong.ma_hop_dong;
