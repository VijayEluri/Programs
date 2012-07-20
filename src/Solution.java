import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Solution {
    private static final BufferedReader STDIN = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Solution().execute();
    }

    // Write your entire logic in here
    private void execute() throws Exception {
    	final HashMap<String, HashMap<String, Integer> > friendToFriendHF = new HashMap<String, HashMap<String, Integer> >();
    	final HashMap<String, Integer> girlToPF = new HashMap<String, Integer>();
    	final HashSet<String> friends = new HashSet<String>();
    	final HashSet<String> girls = new HashSet<String>();
    	int lineNo = 0; 
    	int numFriends = 0, numGirls = 0; 
    	
        for (String[] lineComponents = readLine(); lineComponents != null; lineComponents = readLine()) {
        	if(lineNo == 0) {
        		numFriends = Integer.parseInt(lineComponents[0]);
        		numGirls = Integer.parseInt(lineComponents[1]);
//        		System.out.println(numFriends + " " + numGirls);
        		++lineNo;
        	} else {
        		if(lineNo++ <= numGirls) {
        			girlToPF.put(lineComponents[0], Integer.parseInt(lineComponents[1]));
        			girls.add(lineComponents[0]);
        			friends.add(lineComponents[0]);
        		} else {
        			final String from = lineComponents[0];  final String to = lineComponents[1];
        			friends.add(from); friends.add(to);
        			final Integer HF = Integer.parseInt(lineComponents[2]);
        			if(friendToFriendHF.containsKey(from)) {
        				friendToFriendHF.get(from).put(to, HF);
        			} else {
        				final HashMap<String, Integer> temp = new HashMap<String, Integer>();
        				temp.put(to, HF);
        				friendToFriendHF.put(from, temp);
        			}
        		}
        	}
        }

//        System.out.println(girls.toString());
        
        // Remove directly connected girls
        if(friendToFriendHF.containsKey("Molleti")) {
        	for(String directFriend: friendToFriendHF.get("Molleti").keySet()) {
        		girls.remove(directFriend);
        		girlToPF.remove(directFriend);
        	}       	
        }
          
        boolean flag = false;
        // Handle not reachable case
       for(HashMap<String, Integer> hf : friendToFriendHF.values()) {
    	   for(String possGirl : girls) {
    		   if(hf.containsKey(possGirl)) {
    			   flag = true;
    		   }
    	   }
        }
        
       if(!flag) {
    	   System.out.println("GAONWALLO SUICIDE");
       } else {
    	   int num = girlToPF.size();
    	   for(String s: girls){
    		   System.out.print(s);
    		   if(num > 0) {
    			   System.out.print(" ");
    		   } else {
    			   System.out.print("\n");
    		   }
    	   }        	
        }
//        final HashMap<String, Double> girlToProb = new HashMap<String, Double>();  
//        final HashSet<String> used = new HashSet<String>();
//        final HashSet<String> usedPath = new HashSet<String>();
//        boolean flag = false;
//        for(String possibleGf: girls) {
//        	flag = false;
//        	double prob = 1d * girlToPF.get(possibleGf) / 100d;
//        	used.clear();
//        	used.add(possibleGf);
//        	// Find all 2, 3 level relations
//        	for(String friend: friends) {
//        		// 1 st level
//        		if(!used.contains(friend)) {
//        			// 2nd level
//        			if(friendToFriendHF.containsKey(friend)) {
//        				
//        			} else {
//        				
//        			}
//        		} 
//        	}
//        }
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
