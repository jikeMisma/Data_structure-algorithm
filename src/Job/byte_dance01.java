package Job;

import java.util.Scanner;

public class byte_dance01 {
	

	public static String getStr(StringBuilder sb) {
		if(sb==null || sb.length()<2) {
			return sb.toString();
		}
		for(int i = 2;i<sb.length();i++) {//如果三个相同
			while(i<sb.length() && sb.charAt(i) == sb.charAt(i-1) && sb.charAt(i) == sb.charAt(i-2)) {
				//System.out.println(i+"-"+sb.toString());
                sb.deleteCharAt(i);
               // System.out.println(i+"-"+sb.toString());
			}
			while(sb.length()>=4&&i>=3&&i<sb.length()&&sb.charAt(i)==sb.charAt(i-1)&&sb.charAt(i-3)==sb.charAt(i-2)){ //检测是否为AABB{
				 sb.deleteCharAt(i);
			}
			
		}
		return sb.toString();
		
	}
	public static void main(String args[]) {
	
		String[] s= new String[15];
		Scanner scanner = new Scanner(System.in); 
		int num = scanner.nextInt(); 
		for(int i=0;i<num;i++) {
			String p= scanner.next();
			s[i] =p;
		}
		
		for(int i=0;i<num;i++) {
			String result=getStr(new StringBuilder(s[i]));
			System.out.println(result);
		}
		
	}
	

}
