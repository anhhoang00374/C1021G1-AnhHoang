package code_gym.dsa_danh_sach.practice.linked_list;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MylinkedList list = new MylinkedList(10);
        list.addFirst(11);
        list.addFirst(12);
        list.addFirst(13);

        list.add(4,9);
        list.add(4,9);
        list.printList();
    }


}
