/**
 * 瓜子二手车面试题：
 * 
 * 对于一个字符串，请设计一个算法，只在字符串的单词间做逆序调整，
 * 也就是说，字符串由一些由空格分隔的部分组成，你需要将这些部分逆序。
       给定一个原字符串A，请返回逆序后的字符串。例，输入"I am a boy!", 
       输出"boy! a am I"
 */
package Job;

import java.util.Scanner;

public class zhuawa {
	    public static void main(String[] args) {
	    	main();
	    }
	    public static void main() {
	    	int[] s= new int[10];
	    	int[] s1= new int[10];
	        Scanner scanner = new Scanner(System.in);
	        int n = scanner.nextInt();
	        int num1=0;
	        int num11=0;
	        int num2=0;
	        int num12=0;
	       for(int i=0;i<n;i++) {
	    	   int p =scanner.nextInt();
	    	   s[i] = p;
	    	   num1 +=i;
	    	   for(int m=0;m<n-3;m++) {
			    	  
		    	    num11 += s[m];
		        }
	    	   
	        }
	       
	       
	       
	       for(int j=0;j<n;j++) {
	    	   int q =scanner.nextInt();
	    	   s[j] = j;
	    	   num1 +=j;
	    	   for(int k=0;k<n-3;k++) {
		    	  
	    	    num12 += s1[k];
	        }
	        }
	       
	       if(num1-num11>num2-num12) {
	    	   System.out.println(num11);
	       }else {
	    	   System.out.println(num12);
	       }
	    }


}
