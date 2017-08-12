package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Qunar2 {
	  public static void main(String[] args){
		  Scanner in = new Scanner(System.in);
		  List<String> list = new ArrayList<String>();
		  while(in.hasNextLine()){
			  String st = in.nextLine();
			  if(st.equals(""))break;
			  list.add(st);
		  }
		  in.close();
		  for(int i=0; i<list.size(); i++){
			  FromNumberSystem26(list.get(i));
		  }
	  }
	  public static void FromNumberSystem26(String s){
		    if (s == null) return; 
		    long n = 0;
		    for (int i = s.length() - 1, j = 1; i >= 0; i--, j *= 26){
		        char c = s.charAt(i);
		        if (c < 'a' || c > 'z') return;
		        n += ((int)c - 97) * j;
		    }
		    System.out.println(n);
		}
}
