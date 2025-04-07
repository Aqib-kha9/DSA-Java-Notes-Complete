import java.util.*;
import java.util.LinkedList;
public class Queues {

    // static class Node{
    //     int data;
    //     Node next;
    //     Node(int data){
    //         this.data = data;
    //         this.next = null;
    //     }
    // }
   
    // static class Queue{
    //     static Node head = null;
    //     static Node tail = null;

    //     // is Empty
    //     public static boolean isEmpty(){
    //         return head == null & tail == null;
    //     }

    //     // add
    //     public static void add(int data){
    //         Node newNode = new Node(data);
    //         if(head==null){
    //             head = tail = newNode;
    //         }

    //         tail.next = newNode;
    //         tail = newNode;
    //     }

    //     // remove
    //     public static int remove(){
    //         if(head== null & tail== null){
    //             System.out.println("Queue is empty");
    //             return -1;
    //         }
    //         if(head==tail){
    //             int data = head.data;
    //             head = tail = null;
    //             return data;
    //         }
    //         int data = head.data;
    //         head = head.next;
    //         return data;
    //     }

    //     //peek
    //     public static int peek(){
    //         return head.data;
    //     }
    // }

    // // Queue using two stack
    // static class Queue{
    //     static Stack<Integer> s1 = new Stack<>();
    //     static Stack<Integer> s2 = new Stack<>();

    //     //add
    //     public static void add(int data){
    //         while(!s1.isEmpty()){
    //             s2.push(s1.pop());
    //         }
    //         s1.push(data);
    //         while(!s2.isEmpty()){
    //             s1.push(s2.pop());
    //         }
    //     }
    //     // isEmpty
    //     public static boolean isEmpty(){
    //         return s1.isEmpty();
    //     }
    //     //remove
    //     public static int remove(){
    //         if(s1.isEmpty()){
    //             System.out.println("queue is empty");
    //             return -1;
    //         }
    //         return s1.pop();
    //     }

    //     //peek
    //     public static int peek(){
    //         if(s1.isEmpty()){
    //             System.out.println("queue is empty");
    //             return -1;
    //         }
    //         return s1.peek();
    //     }

    // }

    // Stack using two queues
    // static class Stack{
    //     static Queue<Integer> q1 = new LinkedList<>();
    //     static Queue<Integer> q2 = new LinkedList<>();

    //     // is Empty 
    //     public static boolean isEmpty(){
    //         return q1.isEmpty() && q2.isEmpty();
    //     }

    //     // add or push
    //     public static void push(int data){
    //         if(q1.isEmpty()){
    //             q1.add(data);
    //         }else{
    //             q2.add(data);
    //         }
    //     }

    //     //remove
    //     public static int pop(){
    //         if(q1.isEmpty()){
    //             System.out.println("stack is empty");
    //             return -1;
    //         }
    //         int top = -1;
    //         //case 1
    //         if(q1.isEmpty()){
    //             while(!q1.isEmpty()){
    //                 top = q1.remove();
    //                 if(q1.isEmpty()){
    //                     break;
    //                 }
    //                 q2.add(top);
    //             }
    //         }else{//case 2
    //             while(!q2.isEmpty()){
    //                 top = q2.remove();
    //                 if(q2.isEmpty()){
    //                     break;
    //                 }
    //                 q1.add(top);
    //             }
    //         }

    //         return top;
    //     }

    //     // peek 
    //     public static int peek(){
    //         if(q1.isEmpty()){
    //             System.out.println("stack is empty");
    //             return -1;
    //         }
    //         int top = -1;
    //         //case 1
    //         if(q1.isEmpty()){
    //             while(!q1.isEmpty()){
    //                 top = q1.remove();
    //                 q2.add(top);
    //             }
    //         }else{//case 2
    //             while(!q2.isEmpty()){
    //                 top = q2.remove();
    //                 q1.add(top);
    //             }
    //         }

    //         return top;
    //     }
    // } 

    // first non repeating letters in a stream of characters
    // public static void firstNonRepeating(String str){
    //     int freq[] = new int[26];
    //     Queue<Character> q = new LinkedList<>();
    //     for(int i=0; i<str.length(); i++){
    //         char ch = str.charAt(i);
    //         q.add(ch);
    //         freq[ch-'a']++;
    //         while(!q.isEmpty() && freq[q.peek()-'a']>1){
    //             q.remove();
    //         }
    //         if(q.isEmpty()){
    //             System.out.print(-1+" ");
    //         }else{
    //             System.out.print(q.peek()+" ");
    //         }
    //     }

    // }

    // interleave two halves of queue
    // public static void interLeaves(Queue<Integer> q){
    //     Queue<Integer> firstHalf = new LinkedList<>();
    //     int size = q.size();

    //     for(int i=0; i<size/2; i++){
    //         firstHalf.add(q.remove());
    //     }
    //     while(!firstHalf.isEmpty()){
    //         q.add(firstHalf.remove());
    //         q.add(q.remove());
    //     }
    // }

    //Queue reversal
    // public static void queueReversal(Queue<Integer>q){
    //     Stack<Integer> s = new Stack<>();
    //     while(!q.isEmpty()){
    //         s.push(q.remove());
    //     }
    //     while(!s.isEmpty()){
    //         q.add(s.peek());
    //         s.pop();
    //     }
    // }

    // stack using deque
    static class Stack { 
        Deque<Integer> deque = new LinkedList<>();

        public void push(int data){
            deque.addLast(data);
        }

        public int push(){
            return deque.removeLast();
        }

        public int peek(){
            return deque.getLast();
        }
    }

    //Queue using deque
    static class Queue {
        Deque<Integer> deque = new LinkedList<>();

        public void add(int data){
            deque.addLast(data);
        } 
        public int remove(){
            return deque.removeFirst();
        }
        public int peek(){
            return deque.getFirst();
        }
    }

    public static void main(String args[]){
        // Queue<Integer> q = new LinkedList<>();
        // Queue<Integer> q = new ArrayDeque<>();
        // Queue q = new Queue();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);
        // q.add(5);
        // q.add(6);
        // // interLeaves(q);
        // queueReversal(q);
        // while(!q.isEmpty()){
        //     System.out.print(q.peek());
        //     q.remove();
        // }

        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.peek());

        // while(!s.isEmpty()){
        //     System.out.println(s.peek());
        //     s.pop();
        // }
        // String str = "aabccxb";
        // firstNonRepeating(str);


        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        System.err.println(q.peek());

    }
}
