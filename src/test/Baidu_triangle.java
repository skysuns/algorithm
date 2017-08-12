package test;

import java.util.Scanner;


public class Baidu_triangle {
	static class Node{
		public char color;
		public int x;
		public int y;
		public int z;
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		Node[] nodes = new Node[N];
		
		for(int i=0; i<N+1; i++){
			String lin = in.nextLine();
			String[] str = lin.split(" +");
			if(str.length>1){
				nodes[i-1] = new Node();
				nodes[i-1].color = (char)str[0].charAt(0);
				nodes[i-1].x = Integer.parseInt(str[1]);
				nodes[i-1].y = Integer.parseInt(str[2]);
				nodes[i-1].z = Integer.parseInt(str[3]);
			}
			
		}
		in.close();
		double max = 0;
		boolean flag = false;
		for(int i=0; i<N; i++){
			for(int j=0; j<N;j++){
				for(int k=0; k<N; k++){
					if(i!=j && i!=k && k!=j){
						if(isColored(nodes[i], nodes[j], nodes[k])){
							double d1 = getDis(nodes[i], nodes[j]); 
							double d2 = getDis(nodes[i], nodes[k]); 
							double d3 = getDis(nodes[k], nodes[j]);
							if(valid(d1,d2,d3)){								
								flag = true;
								if(max < getArea(d1,d2,d3)){
									
									max = getArea(d1,d2,d3);
									
								}
							}
						}
					}
				}
			}
		}
		if(flag == true){
			System.out.println(String.format("%.6f", max));
		}
		
	}
	public static boolean isColored(Node t1, Node t2, Node t3){
		if(t1.color == t2.color && t1.color == t3.color){
			return true;
		}else if(t1.color != t2.color && t1.color != t3.color && t2.color != t3.color){
			return true;
		}
		return false;
	}

	public static double getDis(Node t1, Node t2){
		double res = 0;
		double tem = (t1.x-t2.x)*(t1.x-t2.x)+(t1.y-t2.y)*(t1.y-t2.y)+(t1.z-t2.z)*(t1.z-t2.z);
		if(tem > 0.0001){
			res = Math.sqrt(tem);
		}
		
		return res;
	}
	public static boolean valid(double a,double b,double c){
        if(a+b>c&&a+c>b&&b+c>a){
        return true;}
        else{
        return false;}
    }
	public static double getArea(double a,double b,double c){
		double rea = 0;
		double s = (a+b+c)/2;		
		rea = Math.sqrt(s*(s-a)*(s-b)*(s-c));
		return rea;
	}
}
