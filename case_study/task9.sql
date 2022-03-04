use case_study_furama;

SELECT MONTH(hop_dong.ngay_lam_hop_dong) AS thang, 
COUNT(hop_dong.ma_khach_hang) AS so_luong_khach_hang
FROM hop_dong
WHERE YEAR(hop_dong.ngay_lam_hop_dong) = 2021
GROUP BY MONTH(hop_dong.ngay_lam_hop_dong)
ORDER BY thang;