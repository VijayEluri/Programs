import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Match {
	String makeMatch(String[] namesWomen, String[] answersWomen, String[] namesMen, String[] answersMen, String queryWoman) {
		assert namesWomen.length == answersWomen.length;
		assert namesMen.length == answersMen.length;
		
		final HashMap<String, String> womToAns = new HashMap<String, String>();
		final HashMap<String, String> manToAns = new HashMap<String, String>();
		final int len = namesWomen.length;
		for (int idx = 0; idx < len; ++idx) {
			womToAns.put(namesWomen[idx], answersWomen[idx]);
			manToAns.put(namesMen[idx], answersMen[idx]);
		}

		Arrays.sort(namesWomen);
		Arrays.sort(namesMen);
//		System.out.println(Arrays.toString(namesWomen));
//		System.out.println(Arrays.toString(namesMen));
		final ArrayList<String> men = new ArrayList<String>(Arrays.asList(namesMen));
	
		for(String womanName : namesWomen) {
			final char[] womanAns = womToAns.get(womanName).toCharArray();
			int max = -1; 
			String presentBest = new String();
			for(String man : men) {
				final char[] manAns = manToAns.get(man).toCharArray();
				int presentManCount = 0;
				for(int i=0, n=manAns.length; i<n; ++i) {
					if(manAns[i] == womanAns[i]) {
						++presentManCount;
					}					
				}
				if(presentManCount > max) {
					max = presentManCount;
					presentBest = man;
				}
			}
			if(queryWoman.compareTo(womanName) == 0) {
				return presentBest;
			}
//			System.out.println(womanName + "\t" + presentBest);
			men.remove(presentBest);
		}
		return null;
	}

	public static void main(String args[]) throws java.util.ConcurrentModificationException {
		Match M = new Match();
		String w[] = { "Constance", "Bertha", "Alice", "L1", "L2"};
		String aW[] = { "aaaa", "baab", "aaaa", "aaba", "baaa" };
		String m[] = { "Chip", "Biff", "Abe", "M1", "M2" };
		String aM[] = { "bbbb", "bbbb", "bbbb", "bbbb", "bbbb" };
		String qw = "Constance";
		System.out.println(M.makeMatch(w, aW, m, aM, qw));
		int a[] = new int[3];
		for(int i=0; i<a.length; ++i) {
			a[i] = i;
		}
		while(M.my_next_permutation(a)) {
			System.out.println(Arrays.toString(a));
		}

	}
	
	public boolean my_next_permutation(int[] a) {
		int n=a.length;
		int i,j,k,temp;
		i=n-2;
		while (i>=0 && a[i]>=a[i+1]) --i;
		if (i<0) {
			for (j=0,k=n-1; j<k; j++,k--) {
				temp=a[j];
				a[j]=a[k];
				a[k]=temp;
			}
			return false;
		}
		j=n-1;
		while (a[i]>=a[j]) --j;
		temp=a[i];
		a[i]=a[j];
		a[j]=temp;
		for (j=i+1,k=n-1; j<k; j++,k--) {
			temp=a[j];
			a[j]=a[k];
			a[k]=temp;
		}
		return true;
	}
}
