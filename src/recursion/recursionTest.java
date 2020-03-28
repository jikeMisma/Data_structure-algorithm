package recursion;

public class recursionTest {
	public static void main(String[] args) {
		
		test(10);
	}
	public static void test(int n) {
		if(n>=2) {
			test(n-1);
		}
		System.out.printf("n=%d\t",n);
	}

}
