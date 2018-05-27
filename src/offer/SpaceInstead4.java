package offer;

import java.util.Arrays;

public class SpaceInstead4 {
	public static void main(String[] args) throws Exception{
		int[] data = {1,2,7,5,10,3,8};
		
		System.out.println(Arrays.toString(data));
	}
	public String replaceSpace(StringBuffer str){
		if(str == null ){
			return null;
		}else if(str.length() == 0){
			return "";
		}
		int count=0, len=str.length();
		for(int i=0; i<len; i++){
			if(str.charAt(i) == ' '){
				count ++;
			}
		}
		String strNew = "";
		int i = len-1;
		while(i>=0 && count>0){
			if(str.charAt(i) == ' '){
				strNew +='0';
				strNew +='2';
				strNew +='%';
				count--;
				i--;
			}else{
				strNew += str.charAt(i--);
			}
		}
		return strNew;
	}
}
