package test;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by isun3 on 2018/4/9.
 */
public class MeiTuan_3 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0; i<t; i++){
            char[] cs = scanner.next().toCharArray();
            if(cs.length%2==1){
                System.out.println("No");
                continue;
            }
            Stack<Character> stack = new Stack<>();
            int count1 = 0, count2 = 0;
            if(cs[0]==')'){
                count1++;
            }else{
                count2++;
            }
            stack.push(cs[0]);
            for(int j=1; j<cs.length; j++){
                if(cs[j] == ')' ){
                    if(stack.isEmpty()){
                        stack.push(')');
                        count1++;
                    }else{
                        char temp = stack.peek();
                        if(temp == '('){
                            stack.pop();
                            count2--;
                        }else{
                            stack.push(')');
                            count1++;
                        }
                    }
                }else if(cs[j] == '('){
                    stack.push('(');
                    count2++;
                }
            }
            if(stack.size()>2 || count1>=2 || count2>=2){
                System.out.println("No");
            }else{
                System.out.println("Yes");
            }
        }

    }
}
