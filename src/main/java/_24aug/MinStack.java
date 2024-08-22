package _24aug;
import java.util.*;

public class MinStack {

    ArrayDeque<Integer> q1;
    ArrayDeque<Integer> q2;
    public MinStack() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }

    public void push(int val) {
        q1.addLast(val);
        if(q2.isEmpty()||val <= q2.getLast()){
            q2.addLast(val);
        }
    }

    public void pop() {
        int val = q1.removeLast();
        if(val == q2.getLast()){
            q2.removeLast();
        }
    }

    public int top() {
        return q1.getLast();
    }

    public int getMin() {
        return q2.getLast();
    }
}
