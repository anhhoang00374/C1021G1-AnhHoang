package code_gym.algorithm_sort.exercise;

public class Sort {
    public static void insertSort(int[] arr){
        for(int i = 1;i<arr.length;i++){
            int position = i;
            int value = arr[position];
            while(position>0&&value<arr[position-1]){
                int temp = arr[position];
                arr[position] = arr[position-1];
                position--;
            }
             arr[position] = value;
        }
    }
}
