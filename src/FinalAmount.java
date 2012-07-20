
public class FinalAmount {
	public static void main(String[] args) {
		FinalAmount i = new FinalAmount();
		System.out.println(i.getFinalAmount(15, "LLLWLLLL"));
	}
	
	public int getFinalAmount(int initialAmount , String betResults) {
		if(initialAmount < 1) {
			return initialAmount;
		}
		int bet = 1;
		int n = 0;
		for(char c: betResults.toCharArray()) {
			switch(c) {
			case 'W': initialAmount += bet; bet = 1;
			System.out.println("Round " + (++n) + " WIN " + initialAmount);
				break;
			case 'L': initialAmount -= bet; bet *= 2; 
				if((initialAmount - bet) < 0) {
					System.out.println("Round " + (++n) + " LOSS -  NO ENOUGH MONEY FOR NEXT" + initialAmount);
					return initialAmount; 
				}
				System.out.println("Round " + (++n) + " LOSS " + initialAmount);
				break;
			}
		}
		return initialAmount;
	}
}