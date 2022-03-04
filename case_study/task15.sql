USE case_study_furama;

SELECT nhan_vien.ma_nhan_vien,nhan_vien.ho_ten,
nhan_vien.ma_trinh_do, nhan_vien.ma_bo_phan, nhan_vien.so_dien_thoai,
nhan_vien.dia_chi
FROM 
nhan_vien LEFT JOIN hop_dong
ON nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
GROUP BY nhan_vien.ma_nhan_vien 
HAVING COUNT(nhan_vien.ma_nhan_vien)IN(0,1,2,3)

;