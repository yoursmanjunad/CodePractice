package SLL;

public class Main {
    public static void main(String[] args) {
        SLL list = new SLL();
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertLast(234);
        list.insertFirst(4);
        list.insertFirst(5);
        list.display();
        System.out.println("Printing the Second LL");
        SLL list2 = new SLL();
        list2.insertLast(1);
        list2.insertLast(2);
        list2.insertLast(3);
        list2.insertLast(4);
        list2.insertLast(5);
        list2.display();
        list2.deleteFirst();
        list2.display();
        list2.deleteLast();
        list2.display();
        list.display();
        System.out.println(list.delete(2));
        list.display();


    }
}
