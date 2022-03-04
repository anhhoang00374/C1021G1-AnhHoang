package module2.model;

public class ImportProduct extends Product{
    private int priceImport ;
    private String provinceImport;
    private double taxImport;

    public ImportProduct() {
    }

    public ImportProduct(String productCode, String name, int price, int quantity, String producer,
                         int priceImport, String provinceImport, double taxImport) {
        super(productCode, name, price, quantity, producer);
        this.priceImport = priceImport;
        this.provinceImport = provinceImport;
        this.taxImport = taxImport;
    }

    public int getPriceImport() {
        return priceImport;
    }

    public void setPriceImport(int priceImport) {
        this.priceImport = priceImport;
    }

    public String getProvinceImport() {
        return provinceImport;
    }

    public void setProvinceImport(String provinceImport) {
        this.provinceImport = provinceImport;
    }

    public double getTaxImport() {
        return taxImport;
    }

    public void setTaxImport(double taxImport) {
        this.taxImport = taxImport;
    }

    @Override
    public String toString() {
        return "ImportProduct{" +
                super.toString()+
                ", priceImport=" + priceImport +
                ", provinceImport='" + provinceImport + '\'' +
                ", taxImport=" + taxImport +
                '}';
    }
}
