package code_gym.behavior.StrategyPattern;

public class Main {
    public static void main(String[] args) {
        SortedList sortedList = new SortedList();
        sortedList.add("Java");
        sortedList.add("PHP");
        sortedList.add("C#");
        sortedList.add("Python");

        sortedList.setStrategy(new QuickSort());
        sortedList.sort();

        sortedList.setStrategy(new MergeSort());
        sortedList.sort();
    }
}
