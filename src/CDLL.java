public class CDLL {
    private CDLLNode head;

    public CDLL() {
        head = null;
    }

    public CDLLNode addNode(int key, int value) {
        CDLLNode newNode = new CDLLNode(key, value);
        if (head == null) {
            head = newNode;
            head.prev = head;
            head.next = head;
        } else {
            CDLLNode tail = head.prev;
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head;
            head.prev = newNode;
        }
        return newNode;
    }

    public void moveToFront(CDLLNode node) {
        if (node == head) return;
        removeNode(node);
        node.prev = head.prev;
        node.next = head;
        head.prev.next = node;
        head.prev = node;
        head = node;
    }

    public void removeNode(CDLLNode node) {
        if (node.next == node) {
            head = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            if (node == head) {
                head = node.next;
            }
        }
    }

    public CDLLNode removeLast() {
        if (head == null) return null;
        CDLLNode tail = head.prev;
        removeNode(tail);
        return tail;
    }
}
