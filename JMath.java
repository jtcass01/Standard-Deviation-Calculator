/////////////////////////////////////////////////////////////////////////////////////////////
//		Created By: Jacob Cassady
//		Date first created: 03/24/2016
//		Date last updated: 06/25/2016
//		Class: CECS 220-01 (Object Oriented Program Design with Java)
//		Description: Static class used to hold math functions used in Project85
////////////////////////////////////////////////////////////////////////////////////////////


public class JMath {
	private JMath(){}
	
	public static double mean(double[] dataSet){
		double result = 0, sum = 0;
		
		for(int dataSet_i=0; dataSet_i<dataSet.length; dataSet_i++){
			sum += dataSet[dataSet_i];
		}
		
		result = sum / ((double) dataSet.length);
		
		return result;
	}

	public static double sampleVariance(double[] dataSet){
		double result = 0;
		
		for(int dataSet_i=0;dataSet_i<dataSet.length;dataSet_i++){
			result += Math.pow((dataSet[dataSet_i]- mean(dataSet)) ,2);
		}
		
		result /= (dataSet.length - 1);
		
		return result;
	}
	
	public static double sampleStandardDeviation(double[] dataSet){
		return Math.sqrt(sampleVariance(dataSet));
	}
	
	public static double populationVariance(double[] dataSet){
		double result=0;
		
		for (int dataSet_i=0;dataSet_i<dataSet.length;dataSet_i++){
			result += Math.pow((dataSet[dataSet_i] - mean(dataSet)), 2);
		}
		
		result /= dataSet.length;
		
		return result;
	}
	
	public static double populationStandardDeviation(double[] dataSet){
		return Math.sqrt(populationVariance(dataSet));
	}
}
