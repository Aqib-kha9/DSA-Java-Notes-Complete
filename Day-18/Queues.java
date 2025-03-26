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
    static class Stack{
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        // is Empty 
        public static boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }

        // add or push
        public static void push(int data){
            if(q1.isEmpty()){
                q1.add(data);
            }else{
                q2.add(data);
            }
        }

        //remove
        public static int pop(){
            if(q1.isEmpty()){
                System.out.println("stack is empty");
                return -1;
            }
            int top = -1;
            //case 1
            if(q1.isEmpty()){
                while(!q1.isEmpty()){
                    top = q1.remove();
                    if(q1.isEmpty()){
                        break;
                    }
                    q2.add(top);
                }
            }else{//case 2
                while(!q2.isEmpty()){
                    top = q2.remove();
                    if(q2.isEmpty()){
                        break;
                    }
                    q1.add(top);
                }
            }

            return top;
        }

        // peek 
        public static int peek(){
            if(q1.isEmpty()){
                System.out.println("stack is empty");
                return -1;
            }
            int top = -1;
            //case 1
            if(q1.isEmpty()){
                while(!q1.isEmpty()){
                    top = q1.remove();
                    q2.add(top);
                }
            }else{//case 2
                while(!q2.isEmpty()){
                    top = q2.remove();
                    q1.add(top);
                }
            }

            return top;
        }
    } 

    public static void main(String args[]){
        // Queue<Integer> q = new LinkedList<>();
        // Queue<Integer> q = new ArrayDeque<>();
        // Queue q = new Queue();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // while(!q.isEmpty()){
        //     System.out.println(q.peek());
        //     q.remove();
        // }

        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
