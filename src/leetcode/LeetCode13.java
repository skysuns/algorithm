package leetcode;

import java.util.HashMap;
import java.util.Scanner;

public class LeetCode13 {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("IV",4);
        hm.put("IX",9);
        hm.put("XL",40);
        hm.put("XC",90);
        hm.put("CD",400);
        hm.put("CM",900);

        hm.put("I",1);
        hm.put("V",5);
        hm.put("X",10);
        hm.put("L",50);
        hm.put("C",100);
        hm.put("D",500);
        hm.put("M",1000);

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        in.close();

        int res = 0;
        String pre = "";
        boolean flag = false;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(flag == true){
                if(hm.containsKey(pre+ch)){
                    res+= hm.get(pre+ch);
                    flag = false;
                }else if(ch == 'I' || ch == 'X' || ch == 'C'){
                    res += hm.get(pre);
                    pre = ""+ch;
                }else{
                    res += hm.get(pre) + hm.get(""+ch);
                }

            }else if(ch == 'I' || ch == 'X' || ch == 'C'){
                pre = ""+ch;
                flag = true;
            }else{
                res += hm.get(ch+"");
            }
        }
        if(flag == true){
            res += hm.get(pre);
        }
        System.out.println(res);
    }
}
