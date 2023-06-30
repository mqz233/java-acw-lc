package acwing;

import java.util.HashSet;
import java.util.Set;

public class HashTableDemo {
    public static void main(String[] args) {
        Set<Integer> integerSet = new HashSet<>();
        integerSet.add(10);
        System.out.println(integerSet.contains(10));
        System.out.println(integerSet.contains(9));
    }
}
