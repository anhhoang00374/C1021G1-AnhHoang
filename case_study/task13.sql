USE case_study_furama;

SELECT dich_vu_di_kem.ma_dich_vu_di_kem,ten_dich_vu_di_kem,SUM(so_luong) AS so_luong
FROM
dich_vu_di_kem JOIN hop_dong_chi_tiet
ON hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
GROUP BY dich_vu_di_kem.ma_dich_vu_di_kem
HAVING SUM(so_luong) = (
SELECT SUM(so_luong) FROM
hop_dong_chi_tiet JOIN dich_vu_di_kem
ON hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
GROUP BY dich_vu_di_kem.ma_dich_vu_di_kem
ORDER BY SUM(so_luong) DESC
LIMIT 1);