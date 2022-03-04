package code_gym.dsa_danh_sach.exercise.array_list;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>(MyList.DEFAULT_CAPACITY);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1,4);
    }
}
