package offer;

public class TwoDimensionalArray3 {
	public static void main(String[] args){
		int[][] arr = {{1,2,8,9,16},{2,4,9,12,17},{4,7,10,13,18},{6,8,11,15,19}};
		System.out.println(arr.length+"ok"+arr[0].length);		
		System.out.print(Find(7,arr));
	}
	public static boolean Find(int target, int[][] array){
		if(array==null || array.length==0 ||array[0].length == 0){
			return false;
		}
		boolean flag = false;
		int column = array[0].length-1;
		int row = 0;
		while(column>=0 && row<array.length){
			if(array[row][column] == target){
				flag = true;
				break;
			}
			else if(array[row][column] > target){
				column--;
			}
			else if(array[row][column] < target){
				row++;
			}
		}
		return flag;
	}
}
