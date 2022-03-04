package model;

public class Benhan {
    private String id;
    private String ngayNhapVien;
    private String ngayRaVien;

    public Benhan() {
    }

    public Benhan(String id, String ngayNhapVien, String ngayRaVien) {
        this.id = id;
        this.ngayNhapVien = ngayNhapVien;
        this.ngayRaVien = ngayRaVien;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNgayNhapVien() {
        return ngayNhapVien;
    }

    public void setNgayNhapVien(String ngayNhapVien) {
        this.ngayNhapVien = ngayNhapVien;
    }

    public String getNgayRaVien() {
        return ngayRaVien;
    }

    public void setNgayRaVien(String ngayRaVien) {
        this.ngayRaVien = ngayRaVien;
    }
}
