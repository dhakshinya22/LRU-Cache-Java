interface IQueue{
    void push(int x);
    int pop();
    int top();
    int size();
    boolean isEmpty();
}
class ArrQueue implements IQueue {
    int[] a; int cap; int f;int r;
    
    public ArrQueue(){
        this.cap = 10;
        this.a = new int[this.cap];
        this.f=-1;
        this.r=-1;
    }
    public void push(int x) {
        if(f==-1 && r==-1){
            f++; r++;
            a[f]=a[r]=x;
        }
        else a[++r]=x;
    }
    public int pop(){
        int x = a[f];
        f--;
        return x;
    }
    public int top(){
        return a[r];
    }
    public int size(){
        return r+1; 
    }
    public boolean isEmpty(){
        return (f==-1 && r==-1);
    }
}
public class Queue {
    public static void main(String[] args) {
        
    
    IQueue stk = new ArrQueue();

    stk.push(5);
    stk.push(57);
    stk.push(6);

    System.out.println(stk.size());
    stk.pop();
    System.out.println(stk.isEmpty());
    System.out.println(stk.top());
    }
}
