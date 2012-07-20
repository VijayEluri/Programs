package topcoder;

public class KingXMagicSpells
{
	public double expectedNumber(int[] ducks, int[] spellOne, int[] spellTwo, int K)
	{
		return expect(0, ducks[0], spellOne, spellTwo, K);
	}
	
	public double expect(int day, int numDucks, int[] spellOne, int[] spellTwo, int K) {
		if(day > K-1) {
			return numDucks;
		} else {
			double spell1 = expect(day + 1, numDucks ^ spellOne[day], spellOne, spellTwo, K);
			double spell2 = expect(day + 1, numDucks ^ spellTwo[day], spellOne, spellTwo, K);
			return (spell1 + spell2) / 2;
		}
	}
	
	
}
//Powered by [KawigiEdit] 2.0!