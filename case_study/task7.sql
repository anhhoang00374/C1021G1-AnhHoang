use case_study_furama;

SELECT dich_vu.ma_dich_vu,dich_vu.ten_dich_vu,
dich_vu.dien_tich,dich_vu.so_nguoi_toi_da,dich_vu.chi_phi_thue,loai_dich_vu.ten_loai_dich_vu
FROM 
dich_vu INNER JOIN hop_dong 
ON dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
INNER JOIN loai_dich_vu
ON dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
WHERE 
Year(hop_dong.ngay_lam_hop_dong) = 2020 
AND 
dich_vu.ma_dich_vu NOT IN (
SELECT dich_vu.ma_dich_vu
	FROM dich_vu
    INNER JOIN hop_dong
    ON dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
	WHERE Year(hop_dong.ngay_lam_hop_dong) = 2021 )
GROUP BY dich_vu.ma_dich_vu;
;
