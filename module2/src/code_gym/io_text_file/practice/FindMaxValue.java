package code_gym.io_text_file.practice;

import java.util.List;

public class FindMaxValue {
    public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (max < numbers.get(i)) {
                max = numbers.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("/Users/nguyenhoang/Desktop/codegym/C1021G1/module2/src/code_gym/io_text_file/practice/number.txt");
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("/Users/nguyenhoang/Desktop/codegym/C1021G1/module2/src/code_gym/io_text_file/practice/result.txt", maxValue);
    }
}
