
/*
 * Complete the 'pageCount' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. INTEGER p
 */

int pageCount(int n, int p) {
	
	if (n == p || p == 1 || (n == p + 1 && p%2 == 0)) {
		return 0;
	}
	
	int min_flip = 0;
	
	if (n - p <= p - 1) {
		min_flip = (n-p)/2;
	} else {
		min_flip = p / 2;
	}
	if (min_flip == 0) {
		min_flip = 1;
	}
	return min_flip;
}