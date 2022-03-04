use case_study_furama;

SELECT ma_nhan_vien,ho_ten 
from nhan_vien
where ma_nhan_vien in
(select nhan_vien.ma_nhan_vien
from nhan_vien left join hop_dong
on nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
group by nhan_vien.ma_nhan_vien
 having count(hop_dong.ma_hop_dong)<1
);

CREATE TEMPORARY TABLE temp 
SELECT nhan_vien.ma_nhan_vien
from nhan_vien left join hop_dong
on nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
group by nhan_vien.ma_nhan_vien
 having count(hop_dong.ma_hop_dong)<1;
 SELECT * from temp;
 
DELETE from nhan_vien 
where ma_nhan_vien in
(select * from temp);

DROP TEMPORARY TABLE temp;