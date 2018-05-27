package offer;

public class Power11 {
    public double Power(double base, int exponent) {
    	
        if(equal0(base) && exponent<0){
        	return 0;
        }
        
        int absExponent = exponent;
        if(exponent < 0){
        	absExponent = -exponent;
        }
        
        double res = powerWithAbsExponent(base,absExponent);
        
        if(exponent<0){
        	res = 1.0/res;
        }
        
        return res;
    }
    
    public double powerWithAbsExponent(double base, int exponent){
    	double res = 1.0;
    	for(int i=0; i<exponent; i++){
    		res *= base;
    	}
    	return res;
    }
    
    public double powerWithAbsExponents(double base, int exponent){
    	if(exponent == 0){
    		return 1.0;
    	}
    	if(exponent == 1){
    		return base;
    	}
    	double res = powerWithAbsExponents(base, exponent);
    	res *= res;
    	if((exponent&1) ==1){
    		res *= base;
    	}
    	return res;
    }
    public boolean equal0(double base){
    	if(base < 0.0000001 && base > -0.0000001){
    		return true;
    	}else{
    		return false;
    	}
    }
}
