package model;

public class Benhnhan {
    private String id;
    private String tenBenhnhan;
    private String lido;
    private String maBenhnhan;

    public Benhnhan() {
    }

    public Benhnhan(String id, String tenBenhnhan, String lido, String maBenhnhan) {
        this.id = id;
        this.tenBenhnhan = tenBenhnhan;
        this.lido = lido;
        this.maBenhnhan = maBenhnhan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenBenhnhan() {
        return tenBenhnhan;
    }

    public void setTenBenhnhan(String tenBenhnhan) {
        this.tenBenhnhan = tenBenhnhan;
    }

    public String getLido() {
        return lido;
    }

    public void setLido(String lido) {
        this.lido = lido;
    }

    public String getMaBenhnhan() {
        return maBenhnhan;
    }

    public void setMaBenhnhan(String maBenhnhan) {
        this.maBenhnhan = maBenhnhan;
    }
}
