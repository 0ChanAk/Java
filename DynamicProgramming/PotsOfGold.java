class PotsOfGold
{
	// Recursive function to maximize the number of coins collected by a player,
	// assuming that opponent also plays optimally
	public static int optimalStrategy(int[] coin, int i, int j)
	{
		// base case: one pot left, only one choice possible
		if (i == j) {
			return coin[i];
		}

		// if we're left with only two pots, choose one with maximum coins
		if (i + 1 == j) {
			return Integer.max(coin[i], coin[j]);
		}

		// if player chooses front pot i, opponent is left to choose
		// from [i+1, j].
		// 1. if opponent chooses front pot i+1, recur for [i+2, j]
		// 2. if opponent chooses rear pot j, recur for [i+1, j-1]

		int start = coin[i] + Integer.min(optimalStrategy(coin, i + 2, j),
										optimalStrategy(coin, i + 1, j - 1));

		// if player chooses rear pot j, opponent is left to choose
		// from [i, j-1].
		// 1. if opponent chooses front pot i, recur for [i+1, j-1]
		// 2. if opponent chooses rear pot j-1, recur for [i, j-2]

		int end = coin[j] + Integer.min(optimalStrategy(coin, i + 1, j - 1),
										optimalStrategy(coin, i, j - 2));

		// return maximum of two choices
		return Integer.max(start, end);
	}

	// Pots of Gold Game using Dynamic Programming
	public static void main(String[] args)
	{
		// pots of gold (even number) arranged in a line
		int[] coin = { 4, 6, 2, 3 };

		System.out.print("Maximum coins collected by player is "
						+ optimalStrategy(coin, 0, coin.length - 1));
	}
}
