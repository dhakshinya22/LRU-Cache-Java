import java.util.*;

class CDLLNode{
    int key,value;
    CDLLNode prev, next;
    public CDLLNode(int k, int v){
        key = k;
        value = v;
    }
}
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
class LRUCache {
    CDLL ll;
    Map<Integer,CDLLNode> m;
    int size = 0;
    int capacity = 0;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        ll = new CDLL();
        m = new HashMap<>();
    }
    
    public int get(int key) {
        if(!m.containsKey(key))
            return -1;
        CDLLNode node = m.get(key);
        ll.moveAtFront(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(m.containsKey(key)){
            CDLLNode node  = m.get(key);
            node.value = value;
            m.put(key,node);
            ll.moveAtFront(node);
        }
        else{
            if(size<capacity){
                size++;
                CDLLNode node = ll.insB(key,value);
                m.put(key,node);
            }
            else{
                int deletedKey = ll.deleteLastNode();
                m.remove(deletedKey);
                CDLLNode node = ll.insB(key,value);
                m.put(key,node);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */



public class LRUCacheMain {
    public static void main(String[] args) {
        // Define operations
        String[] ops = {"LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"};
        
        // Define values for each operation
        int[][] vals = {
            {2},      // LRUCache(2)
            {1, 1},   // put(1,1)
            {2, 2},   // put(2,2)
            {1},      // get(1)
            {3, 3},   // put(3,3)
            {2},      // get(2)
            {4, 4},   // put(4,4)
            {1},      // get(1)
            {3},      // get(3)
            {4}       // get(4)
        };

        List<String> output = new ArrayList<>();
        LRUCache cache = null;

        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case "LRUCache":
                    cache = new LRUCache(vals[i][0]);
                    output.add("null");
                    break;
                case "put":
                    cache.put(vals[i][0], vals[i][1]);
                    output.add("null");
                    break;
                case "get":
                    int res = cache.get(vals[i][0]);
                    output.add(String.valueOf(res));
                    break;
            }
        }

        System.out.println(output);
    }
}
