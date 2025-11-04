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