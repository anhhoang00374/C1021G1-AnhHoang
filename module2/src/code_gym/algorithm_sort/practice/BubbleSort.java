package code_gym.algorithm_sort.practice;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arrInt = {5,3,2,6,5,8,9,5};
        bubbleSort(arrInt);
        for(int value : arrInt){
            System.out.print( value + " ");
        }
    }

//    static void bubbleSort(int[] arr){
//        for(int i = 0;i<arr.length;i++){
//            for(int j = arr.length-1;j>i;j--){
//                if(arr[j]<arr[j-1]){
//                    int temp = arr[j];
//                    arr[j] = arr[j-1];
//                    arr[j-1] = temp;
//                }
//            }
//        }
//    }
    static void bubbleSort(int[] arr){
        for(int i = 0;i<arr.length-1;i++){
            for(int j = 0;j<arr.length-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
