class Solution {
    Node sortedMerge(Node head1, Node head2) {
        // code here
         Node dummy = new Node(-1);
        Node temp = dummy;
          Node temp1 = head1;
            Node  temp2 = head2;
            while(temp1!=null && temp2!=null ){
                if(temp1.data<=temp2.data){
                    temp.next = temp1;
                    temp1 = temp1.next;
                }
                 else{
                    temp.next = temp2;
                    temp2 = temp2.next;
                }
                temp = temp.next;
            }
            if(temp1==null) temp.next = temp2;
            else temp.next = temp1;
            return dummy.next;
    }
}

