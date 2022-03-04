package module2.utils;

import module2.model.ExportProduct;
import module2.model.ImportProduct;
import module2.model.Product;
import test.model.Person;
import test.model.Student;
import test.model.Teacher;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOFIle {

    public static void write(String path, List<Product> list) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Product product : list) {
                if (product instanceof ImportProduct) {
//                   String productCode, String name, int price, int quantity, String producer,
//                         int priceImport, String provinceImport, double taxImport)
                    bufferedWriter.write(product.getProductCode() + "," + product.getName() + "," + product.getPrice() + "," +
                            product.getQuantity() + "," + product.getProducer() + "," + ((ImportProduct) product).getPriceImport() + "," +
                            ((ImportProduct) product).getProvinceImport() + "," + ((ImportProduct) product).getTaxImport());
                    bufferedWriter.newLine();
                } else {
                    ExportProduct exportProduct = (ExportProduct) product;
                    //String productCode, String name, int price, int quantity,
                    //String producer, int priceExport, String countryExport
                    bufferedWriter.write(product.getProductCode() + "," + product.getName() + "," + product.getPrice() + "," +
                            product.getQuantity() + "," + product.getProducer() + "," + exportProduct.getPriceExport() + "," +
                            exportProduct.getCountryExport());
                    bufferedWriter.newLine();

                }

            }
            bufferedWriter.close();

        } catch (IOException e) {

        }
    }


    public static List<Product> read(String path) {
        List<Product> productList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String data = null;
            while ((data = bufferedReader.readLine()) != null) {
                String[] pro = data.split(",");
                if (data.length() == 8) {
                    ImportProduct importProduct = new ImportProduct(pro[0], pro[1], Integer.parseInt(pro[2]),
                            Integer.parseInt(pro[3]), pro[4], Integer.parseInt(pro[5]), pro[6], Double.parseDouble(pro[7]));
                    productList.add(importProduct);
                } else {
                    ExportProduct exportProduct = new ExportProduct(pro[0], pro[1], Integer.parseInt(pro[2]),
                            Integer.parseInt(pro[3]), pro[4], Integer.parseInt(pro[5]), pro[6]);
                    productList.add(exportProduct);
                }

            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  productList;
    }
}



