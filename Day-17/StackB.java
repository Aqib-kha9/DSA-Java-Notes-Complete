import java.util.Stack;

public class StackB {
    // static class Stack {
        
    //     ArrayList<Integer> list = new ArrayList<>();
    //     // is Empty
    //     public boolean isEmpty(){
    //         if(list.size()==0){
    //             return true;
    //         }
    //         return false;
    //     }

    //     // push
    //     public void push(int data){
    //         list.add(data);
    //     }

    //     // pop
    //     public int pop(){
    //         if(isEmpty()){
    //             return -1;
    //         }
    //         int top = list.get(list.size()-1);
    //         list.remove(list.size()-1);
    //         return top;
    //     }

    //     //peek
    //     public int peek(){
    //         if(isEmpty()){
    //             return -1;
    //         }
    //         return list.get(list.size()-1);
    //     }
    // }

    // static class Node{
    //     int data;
    //     Node next;
    //     public Node(int data){
    //         this.data = data;
    //         this.next = null;
    //     }
    // }
    

    // static class Stack{
    //     static Node head = null;
    //     // isEmpty
    //     public boolean isEmpty(){
    //         return head == null;
    //     }

    //     //push
    //     public void push(int data){
    //         Node newNode = new Node(data);
    //         if(isEmpty()){
    //             head = newNode;
    //             return;
    //         }
    //         newNode.next = head;
    //         head = newNode;
    //     }

    //     // pop
    //     public int pop(){
    //         if(isEmpty()){
    //             return -1;
    //         }
    //         int top = head.data;
    //         head = head.next;
    //         return top;
    //     }

    //     //peek
    //     public int peek(){
    //         if(isEmpty()){
    //             return -1;
    //         }
    //         return head.data;
    //     }
    // }

    //push at bottom of stack
    public static void pushAtBottom(Stack<Integer>s,int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    // reverse a string using stack
    public static String revString(String str){
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while(idx!=str.length()){
            s.push(str.charAt(idx));
            idx++;
        }

        StringBuilder result = new StringBuilder("");
        while(!s.isEmpty()){
            char curr = s.pop();
            result.append(curr);
        }
        return result.toString();
    }

    public static void main(String args[]){
        // Stack<Integer> s = new Stack<>();
        // // Stack s = new Stack();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // pushAtBottom(s, 4);
        // while(!s.isEmpty()){
        //     System.out.println(s.peek());
        //     s.pop();
        // }

        String str = "abc";
        String result = revString(str);
        System.out.println(result);
    }   
}
