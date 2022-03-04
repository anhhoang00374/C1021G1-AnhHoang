use case_study_furama;

SELECT * FROM khach_hang 
WHERE (YEAR(CURRENT_TIMESTAMP)- YEAR(ngay_sinh) BETWEEN 18 AND 50)
AND (dia_chi LIKE "%da nang" OR dia_chi LIKE "%quang tri");