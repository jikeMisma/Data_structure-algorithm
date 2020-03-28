package stack;

import java.util.Scanner;

public class ArrayStackDemo {

	public static void main(String[] args) {
		
		//测试
		//创建一个ArryStack的对象
		ArryStack stack =new ArryStack(4);
		String key ="";
		boolean loop = true;
		
		Scanner scanner=new Scanner(System.in);
		
		while(loop) {
			System.out.println("show：显示栈");
			System.out.println("exit：退出栈");
			System.out.println("push：入栈");
			System.out.println("pop：出栈");
			System.out.println("请输入你的选择：");
			
			key = scanner.next();
			switch (key) {
			case "show":
				stack.list();
				break ;
			case "push":
				System.out.println("请输入一个数：");
				int value = scanner.nextInt();
				stack.push(value);
				break ;
			case "pop":
				try {
					int res = stack.pop();
					System.out.printf("出栈的数据是：%d：\n",res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break ;
			case "exie":
				scanner.close();
				loop = false;
				break;

			}
		}
		
		System.out.println("程序退出！");
		
	}
}


//定义一个类，表示栈结构
class ArryStack{
	private int maxSize;//栈的大小
	private int[] stack;//数组，模拟栈
	private int top = -1;//表示栈顶，初始化为-1；
	
	//构造器
	public  ArryStack(int maxSize) {
		this.maxSize =maxSize;
		stack = new int [this.maxSize];
	}
	
	//判断栈满
	public boolean isFull() {
		return top == maxSize - 1;
	}
	
	//判断栈空
		public boolean isEmpty() {
			return top == - 1;
		}
		
	//入栈操作
		public void push(int value) {
			//先判断是否栈满
			if(isFull()) {
				System.out.printf("栈满！");
				return ;
			}
			
			top++;
			stack[top] = value;
		}
	
	//出栈操作,将栈顶数据返回
		public int pop() {
			//判断栈是否空
			if(isEmpty()) {
				//抛出异常
				throw new RuntimeException("栈空，没有数据！");
			}
			int value= stack[top];
			return value;
		}
	
	//遍历栈
	//遍历时，需要从栈顶开始显示数据
		
		public void list() {
			if(isEmpty()) {
				System.out.printf("栈空，没有数据！");
				return ;
			}
			for(int i =top;i>= 0;i--) {
				System.out.printf("stack[%d]=%d\n",i,stack[i]);
			}
		}
	
}
