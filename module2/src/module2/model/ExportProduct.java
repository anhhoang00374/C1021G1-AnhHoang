package module2.model;

public class ExportProduct extends Product{
    private int priceExport;
    private String countryExport;

    public ExportProduct() {
    }

    public ExportProduct(String productCode, String name, int price, int quantity,
                         String producer, int priceExport, String countryExport) {
        super(productCode, name, price, quantity, producer);
        this.priceExport = priceExport;
        this.countryExport = countryExport;
    }

    public int getPriceExport() {
        return priceExport;
    }

    public void setPriceExport(int priceExport) {
        this.priceExport = priceExport;
    }

    public String getCountryExport() {
        return countryExport;
    }

    public void setCountryExport(String countryExport) {
        this.countryExport = countryExport;
    }

    @Override
    public String toString() {
        return "ExportProduct{" +
                super.toString()+
                ", priceExport=" + priceExport +
                ", countryExport='" + countryExport + '\'' +
                '}';
    }
}
