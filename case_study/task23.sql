use case_study_furama;
delimiter //
create Procedure  sp_them_moi_hop_dong (ma_k_h int)
begin
delete from khach_hang 
where ma_khach_hang = ma_k_h;
end //
delimiter ;

call sp_them_moi_hop_dong (1);