import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class BankBazaarBoxerForce {
	private static final BufferedReader STDIN = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new BankBazaarBoxerForce().execute();
    }
    
    // Write your entire logic in here
    private void execute() throws Exception {
    	final ArrayList<Integer> weightsList = new ArrayList<Integer>();
    	final ArrayList<Integer> punchList = new ArrayList<Integer>();
    	for (String[] lineComponents = readLine(); lineComponents != null; lineComponents = readLine()) {
        	weightsList.add(Integer.parseInt(lineComponents[0]));
        	punchList.add(Integer.parseInt(lineComponents[1]));        	
    	}
    	final int N = weightsList.size();
    	final Integer[] ids = new Integer[N];
    	for(int i=0; i<N; ++i) {
    		ids[i] = i;	
    	}
    	final Integer[] weight = new Integer[N];
    	weightsList.toArray(weight);
    	final Integer[] punch = new Integer[N];
    	punchList.toArray(punch);
    	// Sort by weights
    	Arrays.sort(ids, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				final int diff = weight[(int)o1] - weight[(int)o2];
				if(diff > 0) return 1;
				if(diff < 0) return -1;
				return 0;
			}    		
		});
    	for(int i=0; i<N; ++i) {
    		System.out.println(ids[i] + " " + weight[ids[i]] + " " + punch[ids[i]]);
    	}
//    	 int num=i;
//    	   /* for(j=0;j<i;j++)
//    	   printf("%d %d\n",weight[j],punch[j]);*/
//    	    for(i=0;i<num;i++)
//    	        for(j=0;j<num-1;j++){
//    	            if(weight[j]>weight[j+1]){
//    	                
//    	               tmp=weight[j+1];
//    	    weight[j+1]=weight[j];
//    	    weight[j]=tmp;
//    	    tmp=punch[j+1];
//    	    punch[j+1]=punch[j];
//    	    punch[j]=tmp;
//    	            }
//    	            else if(weight[j]==weight[j+1]){
//    	                if(punch[j]<punch[j+1]){
//    	                    tmp=weight[j+1];
//    	    weight[j+1]=weight[j];
//    	    weight[j]=tmp;
//    	    tmp=punch[j+1];
//    	    punch[j+1]=punch[j];
//    	    punch[j]=tmp;
//    	            }
//    	            }
//    	        }
//    	 //  for(j=0;j<num;j++)
//    	 //  printf("%d %d\n",weight[j],punch[j]);   
//    	    int look[num],k,c=0,count[num];
//    	for(i=0;i<num;i++)
//    	    look[i]=1;
//    	int max=0;
//    	for(i=0;i<num;i++){
//    	    max=0;k=0;c=0;
//    	    for(j=0;j<i;j++){
//    	        if(look[j]>=max && weight[j]<weight[i] && punch[j]>punch[i]){
//    	            max=look[j];
//    	            
//    	        }
//    	        
//    	        
//    	    }
//    	    for(k=0;k<i;k++)
//    	            if(max==look[k] && weight[k]<weight[i] && punch[k]>punch[i]){
//    	                c++;
//    	                
//    	            }
//    	    count[i]=c;
//    	    look[i]=max+1;
//    	}
//    	max=0;
//    	for(j=0;j<num;j++){
//    	    if(look[j]>max)
//    	        max=look[j];
//    	    
//    	}
//    	c=0;
//    	for(j=0;j<num;j++){
//    	    if(max==look[j])
//    	            c+=count[j];
//    	}
    	    
//    	    printf("%d %d",max,c);
//    		return 0;
//    	}
    	
    	
    	
    }

    private String[] readLine() throws IOException {
        String line = STDIN.readLine();
        return line != null ? line.split(" ") : null;
    }

    private int toInteger(String str) {
        return Integer.parseInt(str);
    }

    private long toLong(String str) {
        return Long.parseLong(str);
    }

    private void println(String str) {
        System.out.println(str);
    }

    private void print(String str) {
        System.out.print(str);
    }
}
