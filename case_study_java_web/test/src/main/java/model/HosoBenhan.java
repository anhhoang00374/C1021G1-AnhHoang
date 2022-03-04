package model;

public class HosoBenhan {
    private int idHoSoBenhAn;
    private static int autoId = 0;
    private String maBenhAn;
    private String maBenhNhan;
    private String tenBenhNhan;
    private String ngayNhapVien;
    private String ngayRaVien;
    private String lyDoNhapVien;

    public String getNgayNhapVien() {
        return ngayNhapVien;
    }

    public void setNgayNhapVien(String ngayNhapVien) {
        this.ngayNhapVien = ngayNhapVien;
    }

    public HosoBenhan() {
        autoId++;
        this.idHoSoBenhAn = autoId;
    }

    public HosoBenhan(String maBenhAn, String maBenhNhan, String tenBenhNhan, String ngayRaVien, String lyDoNhapVien) {
        autoId++;
        this.idHoSoBenhAn = autoId;
        this.maBenhAn = maBenhAn;
        this.maBenhNhan = maBenhNhan;
        this.tenBenhNhan = tenBenhNhan;
        this.ngayRaVien = ngayRaVien;
        this.lyDoNhapVien = lyDoNhapVien;
    }

    public int getIdHoSoBenhAn() {
        return idHoSoBenhAn;
    }

    public void setIdHoSoBenhAn(int idHoSoBenhAn) {
        this.idHoSoBenhAn = idHoSoBenhAn;
    }

    public static int getAutoId() {
        return autoId;
    }

    public static void setAutoId(int autoId) {
        HosoBenhan.autoId = autoId;
    }

    public String getMaBenhAn() {
        return maBenhAn;
    }

    public void setMaBenhAn(String maBenhAn) {
        this.maBenhAn = maBenhAn;
    }

    public String getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(String maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public String getTenBenhNhan() {
        return tenBenhNhan;
    }

    public void setTenBenhNhan(String tenBenhNhan) {
        this.tenBenhNhan = tenBenhNhan;
    }

    public String getNgayRaVien() {
        return ngayRaVien;
    }

    public void setNgayRaVien(String ngayRaVien) {
        this.ngayRaVien = ngayRaVien;
    }

    public String getLyDoNhapVien() {
        return lyDoNhapVien;
    }

    public void setLyDoNhapVien(String lyDoNhapVien) {
        this.lyDoNhapVien = lyDoNhapVien;
    }
}
