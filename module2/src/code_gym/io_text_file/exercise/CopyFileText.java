package code_gym.io_text_file.exercise;

import java.io.*;

public class CopyFileText {


    public static void main(String[] args) {
        File fileRead = new File("/Users/nguyenhoang/Desktop/codegym/C1021G1/module2/src/code_gym/io_text_file/exercise/input.txt");
        File fileWrite = new File("/Users/nguyenhoang/Desktop/codegym/C1021G1/module2/src/code_gym/io_text_file/exercise/output.txt");
        if(!fileRead.exists()||!fileWrite.exists()){
            try {
                throw new IOException("file not exist");
            } catch (IOException e) {
                System.out.println("file error or not exist");
            }
        }
        try {
            FileReader fileR = new FileReader(fileRead);
            BufferedReader bufferedReader = new BufferedReader(fileR);
            FileWriter fileW = new FileWriter(fileWrite);
            BufferedWriter bufferedWriter = new BufferedWriter(fileW);
            String data = "";
            while((data = bufferedReader.readLine())!=null){
                bufferedWriter.write(data);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
