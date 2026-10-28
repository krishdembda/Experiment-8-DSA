import java.util.Scanner;

public class Practical8 {
    static class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
        }
    }

    Node head = null;

    void insert(int data) {
        Node n = new Node(data);

        if (head == null) {
            head = n;
            n.next = n;
            n.prev = n;
        } else {
            Node last = head.prev;

            n.next = head;
            n.prev = last;
            last.next = n;
            head.prev = n;
        }

        System.out.println("Node inserted: " + data);
    }

    void delete(int data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;

        do {
            if (temp.data == data) {
                if (temp.next == temp) {
                    head = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;

                    if (temp == head)
                        head = temp.next;
                }

                System.out.println("Node deleted: " + data);
                return;
            }

            temp = temp.next;
        } while (temp != head);

        System.out.println("Node not found");
    }

    void displayForward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        System.out.print("Forward: ");

        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(back to head)");
    }

    void displayBackward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head.prev;
        Node last = temp;

        System.out.print("Backward: ");

        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        } while (temp != last);

        System.out.println("(back to last)");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Practical8 list = new Practical8();

        while (true) {
            System.out.println("\n1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Display Forward");
            System.out.println("4. Display Backward");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter value: ");
                    list.insert(sc.nextInt());
                    break;

                case 2:
                    System.out.print("Enter value to delete: ");
                    list.delete(sc.nextInt());
                    break;

                case 3:
                    list.displayForward();
                    break;

                case 4:
                    list.displayBackward();
                    break;

                case 5:
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}

