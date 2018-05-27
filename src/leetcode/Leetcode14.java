package leetcode;

public class Leetcode14{
    public static void main(String[] args){

    }
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length==0){
            return "";
        }
        if(strs.length==1){
            return strs[0];
        }
        String res = strs[0];
        for(int i=1; i<strs.length; i++){
            res = getCom(res, strs[i]);
        }
        return res;
    }

    public static String getCom(String str1, String str2){
        String res = "";
        for(int i=0; i<str1.length() && i<str2.length(); i++){
            if(str1.charAt(i)==str2.charAt(i)){
                res += str1.charAt(i);
            }else{
                break;
            }
        }
        return res;
    }
}
