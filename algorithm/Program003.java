
package algorithm;

public class Program003 {
    public static void main(String[] args) {
        Linked list = new Linked();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.print("Оригинальный список: ");
        list.printList();

        list.reverse();

        System.out.print("Развёрнутый список: ");
        list.printList();
    }
}
