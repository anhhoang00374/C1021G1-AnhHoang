USE case_study_furama;

SELECT khach_hang.ma_khach_hang,ho_ten FROM
khach_hang INNER JOIN hop_dong
 ON khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
 WHERE YEAR(ngay_lam_hop_dong)<2021;
 
CREATE TEMPORARY TABLE temp 
SELECT khach_hang.ma_khach_hang FROM
khach_hang INNER JOIN hop_dong
 ON khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
 WHERE YEAR(ngay_lam_hop_dong)<2021;
 
 SET FOREIGN_KEY_CHECKS=0;
 DELETE FROM khach_hang 
 WHERE khach_hang.ma_khach_hang IN(SELECT * FROM temp);
 SET FOREIGN_KEY_CHECKS=1;
 
 DROP TEMPORARY TABLE temp;