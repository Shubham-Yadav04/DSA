public class DoublyLinkedList {
    DoublyNode head;
// insert node with enterd data in the last of the DoublyLinkedList
    void insert(int data){
        DoublyNode node= new DoublyNode(data);
        if(this.head==null){
            this.head=node;
        }
        else{
            DoublyNode n=this.head;
            while(n.next!=null){
                n=n.next;
            }
            n.next=node;
            node.previous=n;
        }
    }
    void insertAtFirst(int data){
        DoublyNode node= new DoublyNode(data);
        DoublyNode n= this.head;
        n.previous=node;
        node.next=n;
        this.head=node;
    }
    int length(){
        DoublyNode n=head;
        int count=1;
        while(n.next!=null){
            n=n.next;
            count++;
        }
        return count;
    }
    void insertAtIndx(int Indx,int data){
        int count=0;
        DoublyNode node=new DoublyNode(data);
        DoublyNode n=head;
        while(count!=Indx && count<this.length()){
            n=n.next;
            count++;
        }
        if(count==Indx){
            n.previous.next=node;
            node.previous=n.previous;
            n.previous=node;
            node.next=n;
        }
        else{
            System.out.println("index out of bound NoSuch index exits in the DoublyLinkedList");
        }
    }


    void show(){
        DoublyNode n=this.head;
        while(n!=null){
            System.out.println(n.data);
            n=n.next;
        }
    }
    void removeFirst(){
        DoublyNode n=head;

        n.next.previous=null;
        head=n.next;
        n.next=null;
    }
    void removeLast(){
        DoublyNode n=head;
        while(n.next!=null){
            n=n.next;

        }
        n.previous.next=null;
        n.previous=null;

    }
    void removeAtIndx(int Indx){
        DoublyNode n= head;
        while(Indx>0 && n.next!=null){
            n=n.next;
            Indx--;
        }
        if(Indx==0){
            n.previous.next=n.next;
            n.next.previous=n.previous;
        }
        else{
            System.out.println("index out of bound No such index exists In DoublyLinkedList");
        }
    }
    public static void main(String []args){
        DoublyLinkedList list= new DoublyLinkedList();
        list.insert(23);
        list.insert(14);
        list.insert(34);
        list.insert(45);
        list.insertAtFirst(5);
        list.insertAtIndx(3,10);
////        list.show();
//        System.out.println(list.length());;
        list.removeAtIndx(3);
        list.show();

    }
}
