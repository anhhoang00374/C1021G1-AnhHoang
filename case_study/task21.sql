use case_study_furama;
create view v_nhan_vien as
select nhan_vien.* from
nhan_vien inner join hop_dong 
on hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
where hop_dong.ngay_lam_hop_dong = "2019-12-12"
and nhan_vien.dia_chi = "hải châu"
and hop_dong.ma_nhan_vien is null;
