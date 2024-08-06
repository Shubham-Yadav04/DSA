

public class LinkedList{
//    here linked List has a Node reference in it so,it is an example of a HAS-A relationship of OOPS
      Node head;
    public void insert(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
        } else {
            Node n = this.head;
            while (n.next!= null) {
                n = n.next;
            }
            n.next = node;
        }
    }
        public  void show(){
            Node n=this.head;
            while(n!=null){
                System.out.println(n.data);
                n=n.next;
            }

        }
        int length(){
            Node n=this.head;
            int count=0;
            while(n!=null){
                n=n.next;
                count++;
            }
            return count;
        }
        void get(int indx){
        int count=0;
        Node n=this.head;
        while(count!=indx && n!=null){
            n=n.next;
            count++;
        }
        if(count==indx){
            System.out.println(n.data);
        }
        if(n==null){
            System.out.println("there is no such index in the list ");
        }
        }
    Node getNode(int indx) {
        int count = 0;
        Node n = this.head;
        while (count != indx && n != null) {
            n = n.next;
            count++;
        }
        if (count == indx) {
            return n;
        }
        return n;
    }
        void remove(int indx){
        if(indx==0){
            this.head=this.head.next;
        }
        else {
            int count = 0;
            Node n = this.head;
            while (count != indx && n != null) {
                n = n.next;
                count++;
            }
            if (count == indx) {
                this.getNode(count - 1).next = this.getNode(count + 1);
            }
            if (n == null) {
                this.getNode(this.length() - 1).next = null;
            }
        }}
    void delete(int value){
// remove only the All occurrence of the value in case of duplicate values ;
        Node currentNode=this.head;
        Node previousNode=null;
        while(currentNode.next!=null){
            if (currentNode.data != value) {
                previousNode=currentNode;
                currentNode=currentNode.next;
            }
            else{
                previousNode.next=currentNode.next;
                currentNode=currentNode.next;


            }

        }
}
    boolean search(int value){
        Node n= this.head;
        while(n!=null){
            if(n.data!=value){
                n=n.next;
            }
            else{
                return true;
            }
        }
    return false;
    }
    void reverseLinkedList(){
        Node currentNode=this.head;
        Node nextNode=null;
        Node previousNode=null;
        while(currentNode!=null){
            nextNode=currentNode.next;
            currentNode.next=previousNode;
            previousNode=currentNode;
            currentNode=nextNode;
        }
        this.head=previousNode;
    }
//     removes duplicate values from a sorted LinkedList
    void removeDuplicate(){
        Node currentNode=this.head.next;
        Node previousNode=this.head;
        while(currentNode.next!=null){
            if(previousNode.data== currentNode.data){
                currentNode=currentNode.next;
                previousNode.next=currentNode;
            }
            else{
                currentNode=currentNode.next;
                previousNode=previousNode.next;
            }
        }
    }
    Node nthNodeFromLast(int number){
        Node currentNode=this.head;
        Node previousNode=this.head;
        while(currentNode.next!=null){
            if(number>1){
                currentNode=currentNode.next;
                number--;
            }
           else{
                currentNode=currentNode.next;
                previousNode=previousNode.next;
            }
        }
        return previousNode;
    }
    boolean isLoop(){
        Node fstPtr=this.head;
        Node slwPtr=this.head;
        while(fstPtr!=null){
            fstPtr=fstPtr.next.next;
            slwPtr=slwPtr.next;
            if(fstPtr==slwPtr){
                return true;
            }
        }
        return false;
    }
    Node startingOfLoop(){
        Node fstPtr=this.head;
        Node slwPtr=this.head;
        while(fstPtr!=null){
            fstPtr=fstPtr.next.next;
            slwPtr=slwPtr.next;
            if(slwPtr==fstPtr) {
                break;
            }
        }
        Node tempNode=this.head;
        while(tempNode!=slwPtr){
            tempNode=tempNode.next;
            slwPtr=slwPtr.next;
        }
        return tempNode;
    }

    void removeLoop(){
        Node fstPtr=this.head;
        Node slwPtr=this.head;
        while(fstPtr!=null){
            fstPtr=fstPtr.next.next;
            slwPtr=slwPtr.next;
            if(slwPtr==fstPtr) {
                break;
            }
        }
        Node tempNode=this.head;
        while(tempNode.next!=slwPtr.next){
            tempNode=tempNode.next;
            slwPtr=slwPtr.next;
        }
        slwPtr.next=null;
    }

    static void mergeTwoSortedLinkedList(LinkedList a ,LinkedList b){
        Node ListAPtr=a.getNode(0);
        Node ListBPtr=b.getNode(0);
//         this method will create a new Linked List in a HEAP memory which will be the combination of two Sorted LinkedList cannnot be used in Case of Space Complexity constraints
        LinkedList mergeLinkedList= new LinkedList();
        while(ListAPtr!=null && ListBPtr!=null){
            if(ListAPtr.data<ListBPtr.data){
                mergeLinkedList.insert(ListAPtr.data);
                System.out.println("inserted A");
                ListAPtr=ListAPtr.next;
            }
            else{
                mergeLinkedList.insert(ListBPtr.data);
                System.out.println("inserted B");
                ListBPtr=ListBPtr.next;
            }

        }
        while(ListAPtr!=null){
            mergeLinkedList.insert(ListAPtr.data);
            ListAPtr=ListAPtr.next;
        }
        System.out.println("A completed");
        while(ListBPtr!=null){
            mergeLinkedList.insert(ListBPtr.data);
            ListBPtr=ListBPtr.next;
        }
        System.out.println("B completed");
        mergeLinkedList.show();

//         to reduce the space complexity we should not make a new Linked List in our memory inspite of that we should just use a node reference(node pointer) which will changes the value of the path or next attribute of a Node such  that rhe points to the next node in a such a way as establishig an ascending order sorted connection between the two node directly in the memory.

//         or you can say thwt we would not create any LinkedList we will just manipulate the corresponding nodes address of the two list such that they will join in ascending form inside the heap memory itself

//        Node helperNode=new Node(0);
//        Node temp=helperNode;
//        while(ListAPtr!=null && ListBPtr!= null){
//            if(ListAPtr.data<=ListBPtr.data){
//                temp.next=ListAPtr;
//
//            }
//            else{
//                temp.next=ListBPtr;
//            }
//            temp=temp.next;
//        }
//        if(ListAPtr==null){
//            temp.next=ListBPtr;
//        }
//        else{
//            temp.next=ListAPtr;
//        }
//        it will give the node next to 0 value as taken for starting Value for the helper Node we will treat the below return node as head reference to accsess  the mergeSorted Linked List in the HEAP memory;
//        return helperNode.next;
    }
    public static void main(String []args){
        LinkedList list=new LinkedList();
        list.insert(5);
        list.insert(10);
        list.insert(15);
        list.insert(23);
        list.insert(25);
        list.insert(35);


LinkedList secondList=new LinkedList();
secondList.insert(13);
        secondList.insert(22);
        secondList.insert(24);
        secondList.insert(45);

       mergeTwoSortedLinkedList(list,secondList);
//        list.delete(23);
//        list.reverseLinkedList();
//
//        System.out.println(list.length());
//        list.get(1);
//        System.out.println(list.search(15));
//        System.out.println(list.search(45));
//        System.out.println(list.nthNodeFromLast(2).data);

//        list.removeDuplicate();
//        list.show();
//        list.getNode(list.length()-1).next=list.getNode(3);
//        System.out.println(list.startingOfLoop().data);
//        list.removeLoop();
//        secondList.show();
    }

}
