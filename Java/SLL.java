package SLL;

public class SLL {
    private Node head;
    private Node tail;
    private int size;

    public SLL() {
        this.size = 0;
    }

    //Creating Node
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            this.next = next;
        }
    }

    //These two blocks, Class and methods are used to create the Node in the List!

    //Function to print the LinkedList
    public void display(){
        Node temp = head;//Pointing the temp = head, to get started from the first node.
        while (temp!=null){
            System.out.printf(String.valueOf(temp.value+" -> "));
            temp = temp.next;//Updating the temp Node as temp.next
        }
        System.out.println("END");
    }

    public void insertFirst(int val){
        Node node =new Node(val);//created a node
        node.next = head;
        head = node;
        if (tail==null){
            tail =  head;
        }//If the tail points to the Null, then after addding the new node, tail should points to the old head and head should point to newly added node and new node should point to old head as it's next element.
        size+=1;//Increasing the size as we given input as one Node Value.
    }
    public void insertLast(int val){
        if (tail==null){
            insertFirst(val);
            return;
        }//Here we should keep this condition right after starting the function, because in starting the new list is empty!
        Node node = new Node(val);
        tail.next=node;
        tail=node;
        size+=1;
        //Here, we let tail to point to the new node instead towards the null. and updating the node value to point Node!
        //To insert at the Particular index!
        //We have to traverse intill the current node's next == index we want to insert the node
        //And we have to update the current node's next as new node and new node's next as the index node.
        }
    public void insert(int val, int index){
        if (index==0){
            insertFirst(val);
            return;
        }
        if (index == size){
            insertLast(val);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(val);
        temp.next=node;
        size+=1;
    }
    //Deleting the FIRST node of the list!
    public int deleteFirst(){
        if (size ==1 ){
            head = null;
        }
        head = head.next;
        size--;
        return 0;
    }
    //Deleting Last Node
    public Node get(int index){
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
    public int deleteLast(){
        if (size<=1){
            deleteFirst();
            return 0;
        }
        Node secLast = get(size-2);
        int val = tail.value;
        tail = secLast;
        tail.next=null;
        size--;
        return val;
    }
    public int delete(int index){
        if (index==0){
            return deleteFirst();
        }
        if (index==size){
            return deleteLast();
        }
        Node prev = get(index-1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        size--;
        return val;
    }

}
