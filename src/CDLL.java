class CDLL{
    CDLLNode head; int size;
    public CDLL(){ head = null; size = 0;}
    CDLLNode insB(int k, int v){
        CDLLNode nn = new CDLLNode(k,v);
        nn.prev = nn; nn.next = nn;
        size++;
        if(head==null){
            head = nn; 
            return nn;
        }
        CDLLNode last = head.prev;
        nn.next = head; head.prev = nn;
        nn.prev = last; last.next = nn;
        head = nn;
        return nn;
    }
    int deleteLastNode(){
        if(head==null) return -1;
        size--;
        CDLLNode last = head.prev;
        if(head == last){
            int deleted = last.key;
            head = null;
            return deleted;
        }
        last.prev.next = head;
        head.prev = last.prev;
        return last.key;
    }
    void moveAtFront(CDLLNode node){
        if(node==head) return;

        node.prev.next = node.next;
        node.next.prev = node.prev;

        CDLLNode last = head.prev;
        head.prev = node; node.next = head;
        node.prev = last; last.next = node;
        head = node;
    }
}