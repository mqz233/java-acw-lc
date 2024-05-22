package bishi.hw;

import java.util.*;

public class _0417_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        scanner.nextLine();
        String[] split = scanner.nextLine().split(" ");
        List<String> stack = new ArrayList<>();
        for (int i=0; i<length; i++){
            stack.add(split[i]);
            while (stack.size()>=3&& Objects.equals(stack.get(length-1),stack.get(length-2)) && Objects.equals(stack.get(length-2),stack.get(length-3))){
                stack.remove(length-1);
                stack.remove(length-2);
                stack.remove(length-3);
            }
        }

        for (int i=0; i<stack.size(); i++){
            if (i == stack.size()-1){
                System.out.print(stack.get(i));
            }else {
                System.out.print(stack.get(i));
                System.out.print(' ');
            }
        }

        if (stack.size()==0){
            System.out.print(0);
        }



    }
}
