import java.util.Scanner;

class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;   
        this.next = null;
    }
}

public class DoublyLinkedListMenu {
    static Node head = null;
    static int pos;

    public static void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head != null) {
            head.prev = newNode;
            newNode.next = head;
        }
        head = newNode;
        System.out.println("Inserted at beginning");
    }

    public static void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
        System.out.println("Inserted at end");
    }

    public static void insertAtSpecific_pos(int data, int pos) {
        Node newNode = new Node(data);
        Node temp = head;

        while (pos != 1 && temp != null) {
            temp = temp.next;
            pos--;
        }

        if (temp == null || temp.next == null) {
            System.out.println("Invalid position");
            return;
        }

        Node temp1 = temp.next;
        newNode.next = temp1;
        newNode.prev = temp;
        temp1.prev = newNode;
        temp.next = newNode;

        System.out.println("Inserted at position");
    }

    public static void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        System.out.println("Deleted from beginning");
    }

    public static void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.prev.next = null;
        System.out.println("Deleted from end");
    }

    public static void deleteFromSpecific_pos() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        for (int i = 1; i < pos && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        if (temp.prev != null) {
            temp.prev.next = temp.next;
        } else {
            head = temp.next;
        }

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }

        System.out.println("Deleted from position " + pos);
    }

    public static void displayForward() {
        Node temp = head;
        System.out.print("Forward: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void displayBackward() {
        if (head == null) return;

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        System.out.print("Backward: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice, data, pos;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete from Beginning");
            System.out.println("5. Delete from End");
            System.out.println("6. Delete from Position");
            System.out.println("7. Display Forward");
            System.out.println("8. Display Backward");
            System.out.println("9. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    insertAtBeginning(data);
                    break;

                case 2:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    insertAtEnd(data);
                    break;

                case 3:
                    System.out.print("Enter data and position: ");
                    data = sc.nextInt();
                    pos = sc.nextInt();
                    insertAtSpecific_pos(data, pos);
                    break;

                case 4:
                    deleteFromBeginning();
                    break;

                case 5:
                    deleteFromEnd();
                    break;

                case 6:
                    System.out.print("Enter position: ");
                    pos = sc.nextInt();
                    DoublyLinkedListMenu.pos = pos; 
                    deleteFromSpecific_pos();
                    break;

                case 7:
                    displayForward();
                    break;

                case 8:
                    displayBackward();
                    break;

                case 9:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 9);

        sc.close();
    }
}