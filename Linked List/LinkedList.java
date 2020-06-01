class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.pushFront(5);
        list.pushFront(8);
        list.pushFront(2);
        list.pushBack(6);

        System.out.print("List Elements: ");
        list.printList();
    }
}

class LinkedList {
    Node head; // Head of the list
    int listSize = 0;

    // A single node of the list
    static class Node {
        int data; // Content of the node
        Node next; // Next pointer of the node

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public void printList() {
        if (this.listSize > 0) { // Check if list is empty
            Node currNode = this.head;

            while (currNode != null) {
                System.out.printf("%d ", currNode.data);
                currNode = currNode.next;
            }

            System.out.println();
        } else {
            System.out.println("List is empty.");
        }
    }

    public void pushFront(int data) {
        Node newNode = new Node(data);
        newNode.next = this.head;
        this.head = newNode;
        listSize++;
    }

    public void pushBack(int data) {
        Node newNode = new Node(data);

        if (this.listSize > 0) { // Check if list is empty
            Node currNode = this.head;

            while (currNode.next != null) {
                currNode = currNode.next;
            }

            currNode.next = newNode;
        } else { // If list is empty just insert node at the front
            newNode.next = this.head;
            this.head = newNode;
        }

        listSize++;
    }

    public void pushAfter(Node targetNode, int data) {
        Node newNode = new Node(data);
        newNode.next = targetNode.next;
        targetNode.next = newNode;
        listSize++;
    }

    public int popFront() {
        Node poppedNode = this.head;
        this.head = this.head.next;
        listSize--;

        return poppedNode.data;
    }

    public int popAfter(Node targetNode) {
        // Check if list is too small and
        // deleting node is after the tail node (which is non-existent)
        if (listSize > 1 && targetNode.next != null) {
            int poppedData = targetNode.next.data;
            Node currNode = this.head;

            while (currNode != targetNode) {
                currNode = currNode.next;
            }

            currNode.next = currNode.next.next;
            listSize--;

            return poppedData;
        } else { // Node deletion is not possible
            return -1;
        }
    }

    public int popBack() {
        Node poppedNode;
        Node currNode = this.head;

        while (currNode.next.next != null) {
            currNode = currNode.next;
        }

        poppedNode = currNode.next;
        currNode.next = null;
        listSize--;

        return poppedNode.data;
    }
}
