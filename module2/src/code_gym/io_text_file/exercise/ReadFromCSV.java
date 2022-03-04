package code_gym.io_text_file.exercise;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFromCSV {

    public static final String CSV = "/Users/nguyenhoang/Desktop/codegym/C1021G1/module2/src/code_gym/io_text_file/exercise/output.csv";

    public static void main(String[] args){
            try {
                String data = "";
                File file = new File(CSV);
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                while (((data = bufferedReader.readLine())!=null)){
                    String[] countryStr = data.split(",");
                    Country country = new Country(Integer.parseInt(countryStr[0]),countryStr[1],countryStr[2]);
                    System.out.println(country.getCountry());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
