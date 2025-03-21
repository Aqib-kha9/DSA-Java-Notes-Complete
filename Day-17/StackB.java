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

    // reverse a stack using recurrsion 
    public static void revStack(Stack<Integer>s){
        if(s.empty()){
            return;
        }
        int top = s.pop();
        revStack(s);
        pushAtBottom(s, top);
    }

    // print stack
    public static void print(Stack<Integer>s){
        while(!s.empty()){
            System.out.println(s.peek());
            s.pop();
        }
    }

    // stock span problem
    public static void stockSpan(int stocks[], int span[]){
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);
        for(int i=1; i<stocks.length; i++){
            int currPrice = stocks[i];
            while(!s.isEmpty() && currPrice > stocks[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i] = i+1;
            }else{
                int prevHigh = s.peek();
                span[i] = i-prevHigh;
            }
            s.push(i);
        }
    }

    // next greater element
    public static void nextGreater(int arr[],int nxtGreater[]){
        Stack<Integer> s = new Stack<>();
        
        for(int i=arr.length-1; i>=0; i--){

            //1 while
            while(!s.empty() && arr[s.peek()] <= arr[i]){
                s.pop();
            }

            //2 if-else
            if(s.isEmpty()){
                nxtGreater[i] = -1;
            }else{
                nxtGreater[i] = arr[s.peek()];
            }

            //3 push in s
            s.push(i);
        }
    }


    public static void main(String args[]){
        Stack<Integer> s = new Stack<>();
        // Stack s = new Stack();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // pushAtBottom(s, 4);
        // while(!s.isEmpty()){
        //     System.out.println(s.peek());
        //     s.pop();
        // }

        // String str = "abc";
        // String result = revString(str);
        // System.out.println(result);
        // revStack(s);
        // print(s);

        // int stocks[] = {100,80,60,70,60,85,100};
        // int span[] = new int[stocks.length];
        // stockSpan(stocks,span);
        // for(int i=0; i<span.length; i++){
        //     System.out.println(span[i]);
        // }

        int arr[] = {6,8,0,1,3};
        int nxtGreater[] = new int[arr.length];
        nextGreater(arr,nxtGreater);
        for(int i=0; i<nxtGreater.length; i++){
            System.out.print("["+ nxtGreater[i]+"] ");
        }
    }   
}
