USE case_study_furama;

SELECT hop_dong.ma_hop_dong, nhan_vien.ho_ten ho_ten_nhan_vien,
khach_hang.ho_ten ho_ten_khach_hang,
khach_hang.so_dien_thoai,dich_vu.ma_dich_vu, dich_vu.ten_dich_vu , 
CASE 
	WHEN SUM(hop_dong_chi_tiet.so_luong)>0 THEN SUM(hop_dong_chi_tiet.so_luong)
    ELSE 0
    END
,hop_dong.tien_dat_coc
FROM
hop_dong JOIN nhan_vien 
ON hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
JOIN khach_hang 
ON hop_dong.ma_khach_hang  = khach_hang.ma_khach_hang
JOIN dich_vu
ON hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
LEFT JOIN hop_dong_chi_tiet
ON hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
 WHERE 
	(dich_vu.ten_dich_vu IN
	(SELECT dich_vu.ten_dich_vu FROM
    hop_dong INNER JOIN dich_vu
    ON hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
    WHERE (MONTH(hop_dong.ngay_lam_hop_dong)IN (10,11,12))AND(YEAR(hop_dong.ngay_lam_hop_dong)=2020)))
  AND hop_dong.ma_hop_dong NOT IN
 (SELECT hop_dong.ma_hop_dong FROM hop_dong
	WHERE MONTH(hop_dong.ngay_lam_hop_dong)IN (1,2,3,4,5,6)AND(YEAR(hop_dong.ngay_lam_hop_dong)=2021))
 GROUP BY hop_dong.ma_hop_dong
 ORDER BY ma_hop_dong;
