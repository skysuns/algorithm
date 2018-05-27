package offer;

public class RepeatNumber52 {
	public static void main(String[] args){
		
	}
	public static boolean getRepeatedNumber(int[] numbers, int length, int[] duplication){
		if(numbers == null || length==0){
			return false;
		}
		for(int i=0; i<length; i++){
			while(i!=numbers[i]){
				if(numbers[i]==numbers[numbers[i]]){
					duplication[0]=numbers[i];
					return true;
				}
				int temp = numbers[i];
				numbers[i]=numbers[numbers[i]];
				numbers[numbers[i]]=temp;
			}
		}
		return false;
	}
}
