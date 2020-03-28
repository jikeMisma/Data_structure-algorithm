package Linkdelist;

import java.util.Stack;

//演示栈的stark的基本使用
public class TestStark {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack<String> stack= new Stack();
		//入栈
		stack.add("jack");
		stack.add("tom");
		stack.add("mack");
		stack.add("smith");
		
		//取出
		while(stack.size() >0) {
			System.out.println(stack.pop());//pop是栈顶数据取出
		}
		

	}

}
