package offer;

public class RegularExpress53 {
	   public boolean match(char[] str, char[] pattern)
	    {
	        if(str==null || pattern==null){
	            return false;
	        }
	        return mathCore(str, 0, pattern, 0);
	        
	    }
	    public boolean mathCore(char[] str, int strIndex, char[] pattern, int patternIndex){
	        if(strIndex == str.length && patternIndex == pattern.length){
	            return true;
			}
	        if(strIndex != str.length && patternIndex == pattern.length){
	            return false;
	        }
	        if(patternIndex < pattern.length-1 && pattern[patternIndex+1] == '*'){
	            if((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex]=='.' && strIndex != str.length)){
	                return mathCore(str, strIndex+1, pattern, patternIndex+2)||mathCore(str, strIndex+1, pattern, patternIndex)||mathCore(str, strIndex, pattern, patternIndex+2);
	            }else{
	                return mathCore(str, strIndex, pattern, patternIndex+2);
	            }
	        }
	        if((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex]=='.' && strIndex != str.length)){
	            return mathCore(str, strIndex+1, pattern, patternIndex+1);
	        }
	        return false;
	    }
}
