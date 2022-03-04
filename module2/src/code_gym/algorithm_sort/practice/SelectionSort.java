package code_gym.algorithm_sort.practice;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arrInt = {2,1,3,6,4,9,5};
        System.out.println("mảng trước khi sắp xếp");
        for (int i = 0; i < arrInt.length; i++){
            System.out.print(arrInt[i] + " ");
        }
        System.out.println();
        selectionSort(arrInt);
        System.out.println("mảng sau khi săp xếp");
        for (int i = 0; i < arrInt.length; i++){
            System.out.print(arrInt[i] + " ");
        }

    }

    static void selectionSort(int[] arr){
        for(int i = 0;i<arr.length-1;i++){
            for(int j = i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
