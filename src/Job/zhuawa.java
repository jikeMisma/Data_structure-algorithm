/**
 * ���Ӷ��ֳ������⣺
 * 
 * ����һ���ַ����������һ���㷨��ֻ���ַ����ĵ��ʼ������������
 * Ҳ����˵���ַ�����һЩ�ɿո�ָ��Ĳ�����ɣ�����Ҫ����Щ��������
       ����һ��ԭ�ַ���A���뷵���������ַ�������������"I am a boy!", 
       ���"boy! a am I"
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
