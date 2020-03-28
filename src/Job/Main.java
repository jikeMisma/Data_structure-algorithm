package Job;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
	public static void main(String arg[]) {

		Scanner in = new Scanner(System.in);
		int y = in.nextInt();
		int n = in.nextInt();
		Main main = new Main();
		float i = Main.test(y,n);
		String p =new DecimalFormat("0.0000").format(i);
		System.out.println(p);
	}
	public static float test(int y,int n ) {
		float s;
		if(y==1) {
			s=(float)(n-1)/(y+n);
		}
		else {
			s=(float)n/(n+y);
		}
		return s;
	}

}
