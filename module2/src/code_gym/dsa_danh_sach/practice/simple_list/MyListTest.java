package code_gym.dsa_danh_sach.practice.simple_list;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        //System.out.println("element 4: "+list.get(4));
        System.out.println("element 1: "+list.get(1));
        System.out.println("element 2: "+list.get(2));

//        list.add(6);
//        System.out.println("element 6: "+list.get(6));
        list.get(-1);
        System.out.println("element -1: " + list.get(-1));
    }
}
