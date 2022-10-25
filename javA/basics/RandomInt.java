package basics;
public class RandomInt { 

    public static void main(String[] args) { 
        // So nguyen duong
		int n = 3;
		int k = Integer.parseInt(args[0]);
		for(int i=0; i<k; i++){
        	System.out.println(random(n));
		}
    }
	
	/**
	* Mot ham tra ve so nguyen bat ki
	* @param n Chan tren dung cua day so nguyen ngau nhien vua duoc tao
	* @return tra ve so ngau nhien nho hon @n
	*/
	public static int random(int n){
		// so thuc ngau nhien tu 0.0 den 1.0
       	double r = Math.random(); 
		// Ep kieu tu double sang int
        // tra ve so nguyen ngau nhien tu 0 den n-1
		return (int) (r * n);
		
		/* Chung ta co the viet chung mot cach truc tiep :
			return (int) (Math.random() * n); */
	}
}
