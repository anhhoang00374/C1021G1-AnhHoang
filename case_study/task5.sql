use case_study_furama;

-- SELECT khach_hang.ma_khach_hang,khach_hang.ho_ten,loai_khach.ten_loai_khach,
-- hop_dong.ma_hop_dong,dich_vu.ten_dich_vu,hop_dong.ngay_lam_hop_dong,
-- hop_dong.ngay_ket_thuc,(dich_vu.chi_phi_thue+(hop_dong_chi_tiet.so_luong*dich_vu_di_kem.gia)) AS "tong_tien"

SELECT khach_hang.ma_khach_hang,khach_hang.ho_ten,loai_khach.ten_loai_khach,
CASE
	WHEN hop_dong.ma_hop_dong IS NULL THEN " "
    ELSE hop_dong.ma_hop_dong
    END
    AS ma_hop_dong
,
CASE
	WHEN dich_vu.ten_dich_vu IS NULL THEN " "
    ELSE dich_vu.ten_dich_vu
    END
    AS ten_dich_vu
    ,
    CASE
	WHEN hop_dong.ngay_lam_hop_dong IS NULL THEN " "
    ELSE hop_dong.ngay_lam_hop_dong
    END
    AS ngay_lam_hop_dong
    ,
    CASE
	WHEN hop_dong.ngay_ket_thuc IS NULL THEN " "
    ELSE hop_dong.ngay_ket_thuc
    END
    AS ngay_ket_thuc
    ,
CASE 
	WHEN khach_hang.ma_khach_hang NOT IN 
    (SELECT khach_hang.ma_khach_hang FROM 
    khach_hang INNER JOIN hop_dong ON khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
    )
    THEN 0
    WHEN hop_dong_chi_tiet.so_luong IS NULL THEN dich_vu.chi_phi_thue
    ELSE sum(dich_vu.chi_phi_thue+(hop_dong_chi_tiet.so_luong*dich_vu_di_kem.gia))
    END
    AS "tong_tien"
FROM 
khach_hang LEFT JOIN loai_khach ON khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
LEFT JOIN hop_dong ON hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
LEFT JOIN dich_vu ON hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
LEFT JOIN hop_dong_chi_tiet ON hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
LEFT JOIN dich_vu_di_kem ON hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
GROUP BY hop_dong.ma_hop_dong,ma_khach_hang
ORDER BY (khach_hang.ma_khach_hang) ASC, (hop_dong.ma_hop_dong) DESC;
