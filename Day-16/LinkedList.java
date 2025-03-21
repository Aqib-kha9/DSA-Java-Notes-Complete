public class LinkedList {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        // step 1 => create new node
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
        }
        // step 2 => newNode next = node
        newNode.next=head; // Link

        // step 3 => head = newNode
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
    }

    public void print(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data + "-> ");
            temp=temp.next;
        }
        System.out.println("null");
    }

    // add in middle
    public void add(int idx, int data){
        if(idx==0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i=0;
        while(i<idx-1){
            temp=temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    //Remove first element of a linked list
    public int removeFirst(){
        if(head==null){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        } else if(size==1){
            int val = head.data;
            head=tail=null;
            size=0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    //Remove last element of a linked list
    public int removeLast(){
        if(head==null){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val = head.data;
            head=tail=null;
            size=0;
            return val;
        }
        Node prev = head;
        for(int i=0; i<size-2; i++){
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    // iterative search 
    public int itvSearch(int key){
        Node temp = head;
        int i=0;
        while(temp!=null){
            if(temp.data==key){
                return i;
            }
            i++;
            temp=temp.next;
        }
        return -1;
    }

    public int helper(Node head, int key){
        if(head==null){
            return -1;
        }
        if(head.data==key){
            return 0;
        }
        int idx = helper(head.next, key);;
        if(idx==-1){
            return -1;
        }
        return idx+1;
    }

    // search recursive
    public int recSearch(int key){
        return helper(head,key);
    }

    // reverse a linked list
    public void reverse(){
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // remove from end nth term
    public void remove(int n){
        // calculate size
        Node temp = head;
        int sz = 0;
        while(temp!=null){
            temp = temp.next;
            sz++;
        }

        // corner case
        if(sz==n){
            head = head.next;
            return;
        }

        int i=1;
        int iToFind = sz-n;
        Node prev = head;
        while(i<iToFind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    // find mid
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // check palindrome 
    public boolean checkPalindrome(){
        if(head==null||head.next==null){
            return true;
        }
        //step 1 find mid
        Node mid = findMid(head);

        //step 2 reverse half linked list
        Node prev = null;
        Node curr = mid;
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;

        //step 3 compare both 
        while(right!=null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    // Detecting cycle/loop in a linked list
    public boolean isCycle(){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next; //+1
            fast = fast.next.next; //+2
            if(slow==fast){
                return true; // cycle exits
            }
        }
        return false; // cycle dosn't exits
    }

    // remove cycle in a linked list
    public void removeCycle(){
        // step1 detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast!=null && fast.next != null){
            slow = slow.next;//+1
            fast = fast.next.next;//+2
            if(slow == fast){
                cycle = true;
                break;
            }
        }
        if(cycle==false){
            return;
        }
        // step2 find last node

        slow = head;
        Node prev = null;
        while(slow!=fast){
            prev = fast;
            slow = slow.next;//+1
            fast = fast.next;//+1
        }
        // step3 point last node to null
        prev.next = null;
    }
    // Get mid function
    private Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;//+1
            fast = fast.next.next;//+2
        }
        return slow;
    }

    //merge function
    public Node merge(Node leftNode,Node rightNode){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;
        while(leftNode!=null && rightNode!=null){
            if(leftNode.data<=rightNode.data){
                temp.next = leftNode;
                leftNode = leftNode.next;
                temp = temp.next;
            }else{
                temp.next = rightNode;
                rightNode = rightNode.next;
                temp = temp.next;
            }
        }
        while(leftNode!=null){
            temp.next = leftNode;
            leftNode = leftNode.next;
            temp = temp.next;
        }
        while(rightNode!=null){
            temp.next = rightNode;
            rightNode = rightNode.next;
            temp = temp.next;
        }
        return mergedLL.next;
    }

    public Node mergeSort(Node head){
        //base Case
        if(head==null||head.next==null){
            return head;
        }
        //get mid
        Node midNode = getMid(head);

        //divide 
        Node rightHead = midNode.next;
        midNode.next = null;
        Node rightNode = mergeSort(rightHead);
        Node leftNode = mergeSort(head);

        //call merge
        return merge(leftNode,rightNode);
    }

    // zig zag linked list
    public void zigZag(){
        // find mid
        Node slow = head;
        Node fast = head.next;
        while(fast!=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;
        // reverse second half
        Node prev = null;
        Node curr = mid.next;
        mid.next = null;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev;
        Node nextL = null;
        Node nextR = null;
        // convert zig zag formate
        while(left!=null && right !=null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
    }



    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(5);
        ll.addLast(3);
        ll.addLast(9);
        ll.addLast(1);
        ll.addLast(8);
        ll.print();
        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = temp;
        // // ll.print();
        // System.out.println(ll.isCycle());
        // ll.removeCycle();
        // System.out.println(ll.isCycle());
        // ll.mergeSort(ll.head);
        ll.zigZag();
        ll.print();
        
    }
}
