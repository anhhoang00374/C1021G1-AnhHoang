-- use quan_ly_vat_tu;
-- create table nha_cung_cap(
-- ma_ncc varchar(255) primary key,
-- ten_ncc varchar(255),
-- dia_chi varchar(255)
-- );

-- create table so_dien_thoai(
-- stt int primary key auto_increment,
-- ma_ncc varchar(255),
-- sdt varchar(20),
-- foreign key (ma_ncc) references nha_cung_cap(ma_ncc)
-- );

-- CREATE TABLE don_dat_hang(
-- so_dat_hang INT AUTO_INCREMENT PRIMARY KEY,
-- ngay_dat_hang DATE,
-- ma_ncc VARCHAR(255),
-- FOREIGN KEY (ma_ncc) REFERENCES nha_cung_cap(ma_ncc)
-- );

-- CREATE TABLE vat_tu(
-- ma_vat_tu INT AUTO_INCREMENT PRIMARY KEY,
-- ten_vat_tu VARCHAR(255)
-- );

-- CREATE TABLE quan_ly_dat_hang(
-- stUNIQUE,
-- so_dat_hang INT,
-- ma_vat_tu INT,
-- PRIMARY KEY (so_dat_hang,ma_vat_tu),
-- FOREIGN KEY (so_dat_hang) REFERENCES don_dat_hang(so_dat_hang),
-- FOREIGN KEY (ma_vat_tu) REFERENCES vat_tu(ma_vat_tu)
-- );

-- CREATE TABLE phieu_nhap(
-- so_phieu_nhap INT AUTO_INCREMENT PRIMARY KEY,
-- ngay_nhap DATE
-- );

-- CREATE TABLE quan_li_nhap_vat_tu(
-- ma_vat_tu int,
-- so_phieu_nhap int,
-- don_gia_nhap int,
-- so_luong_nhap int,
-- PRIMARY KEY (ma_vat_tu,so_phieu_nhap),
-- FOREIGN KEY (ma_vat_tu) REFERENCES vat_tu (ma_vat_tu),
-- FOREIGN KEY (so_phieu_nhap) REFERENCES phieu_nhap (so_phieu_nhap)
-- );

-- CREATE TABLE phieu_xuat(
-- so_phieu_xuat INT AUTO_INCREMENT PRIMARY KEY,
-- ngay_xuat DATE
-- );

CREATE TABLE quan_li_xuat_vat_tu(
don_gia_xuat int,
so_luong_xuat int,
so_phieu_xuat int,
ma_vat_tu int,
PRIMARY KEY (so_phieu_xuat,ma_vat_tu),
 FOREIGN KEY (ma_vat_tu) REFERENCES vat_tu (ma_vat_tu),
 FOREIGN KEY (so_phieu_xuat) REFERENCES phieu_xuat (so_phieu_xuat)
);

