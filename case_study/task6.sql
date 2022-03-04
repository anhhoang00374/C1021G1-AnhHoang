use case_study_furama;
SELECT dich_vu.ma_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu
FROM hop_dong
JOIN dich_vu ON  dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
JOIN loai_dich_vu ON loai_dich_vu.ma_loai_dich_vu = dich_vu.ma_loai_dich_vu
WHERE  dich_vu.ten_dich_vu NOT IN
(SELECT dich_vu.ten_dich_vu
FROM dich_vu  JOIN hop_dong  ON dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
WHERE  hop_dong.ngay_lam_hop_dong
BETWEEN "2021/01/01" AND "2021/03/31")
GROUP BY ma_dich_vu
ORDER BY chi_phi_thue DESC;