package test;

import java.util.*;

public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            if (!Character.isLowerCase(s.charAt(0))) {
                System.out.println("indistinct");
                continue;
            }
            if(!Character.isLowerCase(s.charAt(s.length()-1))){
                System.out.println("indistinct");
                continue;
            }
            StringBuilder sb = new StringBuilder();
            int index = 0;
            while (index < s.length()) {
                while (index < s.length() && Character.isLowerCase(s.charAt(index))) {
                    sb.append(s.charAt(index));
                    index++;
                }
                if (index < s.length() && Character.isUpperCase(s.charAt(index))) {
                    if (index + 1 < s.length()) {
                        if (!Character.isLowerCase(s.charAt(index + 1))) {
                            System.out.println("indistinct");
                            break;
                        } else {
                            sb.append('_');
                            sb.append(Character.toLowerCase(s.charAt(index)));
                            index++;
                        }
                    } else {
                        System.out.println("indistinct");
                        break;
                    }
                } else if (index < s.length() && s.charAt(index) == '_') {
                    if (index + 1 < s.length()) {
                        if (!Character.isLowerCase(s.charAt(index + 1))) {
                            System.out.println("indistinct");
                            break;
                        } else {
                            sb.append(s.charAt(index));
                            index++;
                        }
                    } else {
                        System.out.println("indistinct");
                        break;
                    }
                } else {
                    if (index == s.length()) {
                        System.out.println(sb);
                    } else {
                        System.out.println("indistinct");
                        break;
                    }
                }
            }

        }

    }
}
