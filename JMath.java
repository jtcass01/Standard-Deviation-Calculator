/////////////////////////////////////////////////////////////////////////////////////////////
//		Created By: Jacob Cassady
//		Date first created: 03/24/2016
//		Date last updated: 06/24/2016
//		Class: CECS 220-01 (Object Oriented Program Design with Java)
//		Description: Static class used to hold math functions used in Project85
////////////////////////////////////////////////////////////////////////////////////////////


public class JMath {
	private JMath(){}
	
	public static float standardDeviation(float[] dataSet){
		float mean = 0;
		Float result = new Float(0);
		mean = mean(dataSet);
		
		for (int dataSet_i=0;dataSet_i<dataSet.length;dataSet_i++){
			result += square(dataSet[dataSet_i] - mean);
		}
		
		result /= dataSet.length;
		
		result = (float) Math.sqrt(result);
		
		return result;
	}
	
	
	public static float mean(float[] dataSet){
		float result = 0, sum = 0;
		
		for(int dataSet_i=0; dataSet_i<dataSet.length; dataSet_i++){
			sum += dataSet[dataSet_i];
		}
		
		result = sum / ((float) dataSet.length);
		
		return result;
	}
	
	public static float square(float num){
		return num*num;
	}
}
