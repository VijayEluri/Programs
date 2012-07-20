import java.util.Arrays;
import java.util.HashMap;

public class LineFittingMaximumPoints {
 	public static double[] output1;

	public static void DrawLine(int[][] input1) {
		if(input1 != null && input1.length > 0) {
			final int numPoints = input1.length;
			HashMap<Double, HashMap<Double, Integer> > slope_InterceptToCount = new HashMap<Double, HashMap<Double,Integer> >();
			for(int i=0; i<numPoints-1; ++i) {
				for(int j=i+1; j<numPoints; ++j) {
					 final double x1 = input1[i][0], x2 = input1[j][0];
					 final double y1 = input1[i][1], y2 = input1[j][1];
					 final double slope, intercept;					 
					 if((x2 - x1) != 0) {
						  slope = (y2 - y1) / (x2 - x1);
						  intercept = y2 - x2 * slope;
					 } else {
						 slope = Double.MAX_VALUE;
						 intercept = x1;
					 }	
					 if(!slope_InterceptToCount.containsKey(slope)) {
						 slope_InterceptToCount.put(slope, new HashMap<Double, Integer>());
						 slope_InterceptToCount.get(slope).put(intercept, 1);
					 } else {
						 final HashMap<Double, Integer> temp = slope_InterceptToCount.get(slope);
						 if(!temp.containsKey(intercept)) {
							 temp.put(intercept, 1);
						 } else {
							 temp.put(intercept, temp.get(intercept) + 1);
						 }
					 }
				}			
			}
			int count = 0;
			output1 = new double[2];
			for(double d : slope_InterceptToCount.keySet()) {
				 final HashMap<Double, Integer> temp = slope_InterceptToCount.get(d);
				 for(double b : temp.keySet()) {
					 if(temp.get(b) > count) {
						 output1[0] = d;
						 output1[1] = b;
						 count = temp.get(b);
					 }
				 }
			}
		}		
	}

	public static void main(String[] args) {
		DrawLine(new int[][]{new int[]{1,1}, new int[]{3,5}, new int[]{5,9}});
		System.out.println(Arrays.toString(output1));
	}
}
