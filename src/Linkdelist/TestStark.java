package Linkdelist;

import java.util.Stack;

//��ʾջ��stark�Ļ���ʹ��
public class TestStark {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack<String> stack= new Stack();
		//��ջ
		stack.add("jack");
		stack.add("tom");
		stack.add("mack");
		stack.add("smith");
		
		//ȡ��
		while(stack.size() >0) {
			System.out.println(stack.pop());//pop��ջ������ȡ��
		}
		

	}

}
