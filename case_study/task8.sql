USE case_study_furama;

SELECT ho_ten FROM khach_hang 
GROUP BY ho_ten;

SELECT DISTINCT ho_ten FROM khach_hang;

SELECT ho_ten FROM khach_hang 
UNION
SELECT ho_ten FROM khach_hang ;
