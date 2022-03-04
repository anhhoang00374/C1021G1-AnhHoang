USE case_study_furama;

SELECT 
    hop_dong.ma_hop_dong,
    ngay_lam_hop_dong,
    ngay_ket_thuc,
    tien_dat_coc,
    CASE
        WHEN SUM(so_luong) > 0 THEN SUM(so_luong)
        ELSE 0
    END AS tong_so_luong_dich_vu_di_kem
FROM
    hop_dong
        LEFT JOIN
    hop_dong_chi_tiet ON hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
GROUP BY hop_dong.ma_hop_dong;

