import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = this;     }
}


public class CircularLinkedList {
    Node head = null;

    void insertAtBeginning(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
            head = newNode;
        }
        System.out.println("Inserted at beginning");
    }

        void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
        System.out.println("Inserted at end");
    }

        void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == head) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            head = head.next;
            temp.next = head;
        }
        System.out.println("Deleted from beginning");
    }

        void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == head) {
            head = null;
        } else {
            Node temp = head;
            Node prev = null;

            while (temp.next != head) {
                prev = temp;
                temp = temp.next;
            }
            prev.next = head;
        }
        System.out.println("Deleted from end");
    }

    
    void deleteByValue(int value) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        Node prev = null;

        
        if (head.data == value) {
            deleteFromBeginning();
            return;
        }

        do {
            prev = temp;
            temp = temp.next;

            if (temp.data == value) {
                prev.next = temp.next;
                System.out.println("Deleted value: " + value);
                return;
            }

        } while (temp != head);

        System.out.println("Value not found");
    }

        void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(Back to Head)");
    }

        public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        Scanner sc = new Scanner(System.in);
        int choice, value;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Delete from Beginning");
            System.out.println("4. Delete from End");
            System.out.println("5. Delete by Value");
            System.out.println("6. Display");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    value = sc.nextInt();
                    cll.insertAtBeginning(value);
                    break;

                case 2:
                    System.out.print("Enter value: ");
                    value = sc.nextInt();
                    cll.insertAtEnd(value);
                    break;

                case 3:
                    cll.deleteFromBeginning();
                    break;

                case 4:
                    cll.deleteFromEnd();
                    break;

                case 5:
                    System.out.print("Enter value to delete: ");
                    value = sc.nextInt();
                    cll.deleteByValue(value);
                    break;

                case 6:
                    cll.display();
                    break;

                case 7:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 7);

        sc.close();
    }
}