package bishi.shunfeng;
import java.util.*;

public class _24_0829 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            String tmp = sc.nextLine();
            if(!Character.isLowerCase(tmp.charAt(0))){
                System.out.println("indistinct");
                continue;
            }
            int j = 0;
            StringBuilder res = new StringBuilder();
            while(j<tmp.length()){
                while(j<tmp.length() && Character.isLowerCase(tmp.charAt(j))){
                    res.append(tmp.charAt(j));
                    j++;
                }
                if(j<tmp.length() && Character.isUpperCase(tmp.charAt(j))){
                    if(!Character.isLowerCase(tmp.charAt(j+1))){
                        System.out.println("indistinct");
                        break;
                    }
                    res.append('_');
                    res.append(Character.toLowerCase(tmp.charAt(j)));
                }else if(j<tmp.length() && tmp.charAt(j) == '_'){
                    if(!Character.isLowerCase(tmp.charAt(j+1))){
                        System.out.println("indistinct");
                        break;
                    }
                    res.append('_');
                }else{
                    if(j == tmp.length()){
                        System.out.println(res);
                    }else{
                        System.out.println("indistinct");
                        break;
                    }
                }
                j++;
            }
        }

    }
}
