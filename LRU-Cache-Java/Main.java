import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer,Integer> m = new HashMap<>();
        m.put(1,3);
        m.put(2,9);
        System.out.println(m);
        m.put(1,5);
        System.out.println(m);
    }
}
