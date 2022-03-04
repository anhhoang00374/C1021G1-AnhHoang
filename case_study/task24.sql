use case_study_furama;

delimiter //
create procedure sp_them_moi_hop_dong (
ngay_lam_hop_dong DATETIME ,
ngay_ket_thuc DATETIME ,
tien_dat_coc DOUBLE ,
ma_nhan_vien INT,
ma_khach_hang INT,
ma_dich_vu INT
)
begin

INSERT INTO hop_dong(ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, ma_nhan_vien, ma_khach_hang, ma_dich_vu)
VALUES (ngay_lam_hop_dong,ngay_ket_thuc, tien_dat_coc,ma_nhan_vien, ma_khach_hang, ma_dich_vu);

end //
delimiter //
SET FOREIGN_KEY_CHECKS=0;
call sp_them_moi_hop_dong("2021-12-08", "2021-12-08", 0, 3, 1, 3);
SET FOREIGN_KEY_CHECKS=1;
