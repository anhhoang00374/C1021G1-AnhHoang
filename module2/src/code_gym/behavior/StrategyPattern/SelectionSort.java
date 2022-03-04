package code_gym.behavior.StrategyPattern;

import java.util.List;

public class SelectionSort implements SortStrategy{
    @Override
    public <T> void sort(List<T> items) {
        System.out.println("Selection Sort");
    }
}
