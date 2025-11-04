interface IStack{
    void push(int x);
    int pop();
    int top();
    int size();
    boolean isEmpty();
}
class ArrStack implements IStack {
    int[] a; int cap; int tp;
    
    public ArrStack(){
        this.cap = 10;
        this.a = new int[this.cap];
        this.tp=-1;
    }
    public void push(int x) {
        a[++tp]=x;
    }
    public int pop(){
        int x = a[tp];
        tp--;
        return x;
    }
    public int top(){
        return a[tp];
    }
    public int size(){
        return tp+1;
    }
    public boolean isEmpty(){
        return tp==-1;
    }
}
public class stack {
    public static void main(String[] args) {
        
    
    IStack stk = new ArrStack();

    stk.push(5);
    stk.push(57);
    stk.push(6);

    System.out.println(stk.size());
    stk.pop();
    System.out.println(stk.isEmpty());
    System.out.println(stk.top());
    }
}