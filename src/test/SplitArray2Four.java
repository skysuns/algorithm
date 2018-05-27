package test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class SplitArray2Four {
	public boolean isSpliteds(int[] nums){
		boolean flag = false;
		int i = 0;
		int j = nums.length - 1;
		int m = i;
		int k = j;
		int suml = nums[i];
		int sumr = nums[j];
		int sum = 0;
		int count = 0;
		while(i<j){
			if(suml < sumr){
				suml += nums[++i];
			}
			else if(suml > sumr){
				sumr += nums[--j];
			}
			else{	
				if(count == 0){
					if(j - i < 6){
						return false;
					}
					sum = suml;
					count ++;
					m = i;
					k = j;
					i += 2;
					j -= 2;
					suml = nums[i];
					sumr = nums[j];
				}else{
					if((j - i == 2) && (sum == suml)){
						flag = true;
						break;
					}else{
						count --;
						i = m;
						j = k;
						suml = sumr = sum;
						suml += nums[++i];
						sumr += nums[--j];
						sum = 0;
					}
				}			
			}			
		}
		return flag;
	}
///////////////////////////////////////数组元素全部为正整数///////////////////////////////////////////////////
	public boolean isSplited(int[] array){
		if(array == null || array.length < 7){
			return false;
		}
		boolean flag = false;
		HashMap<Integer, Integer> ha = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> hb = new HashMap<Integer, Integer>();
		int suma = 0, sumb = 0, len = array.length;
		for(int i=0, j=len-1; i<len; i++, j--){
			if(array[i] <= 0){
				return false;
			}
			suma += array[i];
			ha.put(suma, i);
			sumb += array[j];
			hb.put(sumb, j);
		}		
		Iterator<?> iter = ha.entrySet().iterator();
		while(iter.hasNext()){
			@SuppressWarnings("rawtypes")
			Entry entry = (Entry)iter.next();
			int splitPointF = (int)entry.getValue();
			int splitSumF = (int)entry.getKey();
			if(hb.containsKey(splitSumF) && splitPointF<len-1 ){				
				int splitSumL = splitSumF;
				int splitPointL = hb.get(splitSumF);				
				int splitSumFM = 2*splitSumF + array[splitPointF+1];
				int splitSumLM = 2*splitSumL + array[splitPointL-1];
				if(ha.containsKey(splitSumFM)){
					int splitPointFM = ha.get(splitSumFM);
					if(hb.containsKey(splitSumLM)){
						int splitPointLM = hb.get(splitSumLM);
						if(splitPointLM - splitPointFM == 2){
							flag = true;
							break;
						}
					}
				}
			}
		}
		return flag;
	}
}
