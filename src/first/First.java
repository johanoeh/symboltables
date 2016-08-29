
package first;

import java.util.Iterator;
import java.util.Scanner;

public class First {
     
    public static class Node<T>{
        Node next, prev; 
        T value;
        public Node(){
                 
        }
       public Node(T value){
           this.value=value;
           next=null;
           prev=null;
       }
    }
    
    public static class List<T>{
        
       Node<T> head;
       Node<T> tail;
       private int size;
       public List(){
           this.size=0;
       }
       void insert(T value){
            size++;
            Node<T> node = new Node<>(value);
            if(head==null) tail = head= node;
            else
                insertR(head,node);
       }
       
        void insertR(Node trNode, Node node) {
            if (trNode.next == null) {
                trNode.next = node;
                node.prev = trNode;
                tail = node;
                return;
            }
            insertR(trNode.next, node);
        }
        
        void removeValue(T value) {
            Node<T> rmNode = find(value);
            removeNode(rmNode);
        }
        
        void removeNode(Node<T> rmNode){
            if (rmNode != null) {
                if (rmNode.next == null) {
                    popBack();
                } else
                if (rmNode.prev == null) {
                    popFront();
                }else{
                    Node<T> tmpNext = rmNode.next;
                    Node<T> tmpPrev = rmNode.prev;
                    tmpPrev.next = tmpNext;
                    tmpNext.prev = tmpPrev;
                    size--;
                }
            }
        }      
        Node<T> find(T value) {
            Node<T> temp = head;
            while (temp != null) {
                if (temp.value == value) {
                    return temp;
                }
                temp = temp.next;
            }
            return null;
        }
        void remove(int pos){
        Node<T> rmNode = at(pos) ;
        if(rmNode==null) return;
            removeNode(rmNode);
        }
        Node<T> at(int pos) {
            Node<T> temp = head;
            for(int i=0;temp != null && i <= pos;i++) {
                if (i == pos) {
                    return temp;
                }
                temp = temp.next;
            }
            return null;
        }
       T popBack(){
       if(tail==null) return null;
        size--;
         T value= tail.value;
         tail=tail.prev;
         if(tail!=null)
             tail.next=null;
         return value;
       }
       T popFront(){
         if(head==null) return null;
         size--;
         T value =  head.value;
         head = head.next;
         if(head!=null)
             head.prev = null;
         return value;
       }

        /**
         * @return the size
         */
        public int getSize() {
            return size;
        }
    } 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Integer> list = new List<>();
        
        for (int i = 0; i < 10; i++) {
            list.insert(i);
        }
        System.out.println( list.size+list.find(4).value);
        list.remove(10);
        Integer k;
        while((k=list.popBack())!=null){
        System.out.println(k);        
        }
      
    }
    
}
