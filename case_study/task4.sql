use case_study_furama;

SELECT khach_hang.ma_khach_hang,khach_hang.ho_ten,count(hop_dong.ma_hop_dong) AS so_lan_dat
FROM khach_hang 
INNER JOIN hop_dong 
ON khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
INNER JOIN loai_khach 
ON khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
WHERE loai_khach.ten_loai_khach = "diamond"
GROUP BY khach_hang.ma_khach_hang
ORDER BY so_lan_dat;
