package pack1;

import java.util.Scanner;

public class ArrayQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//测试
		//创建一个队列
		
		ArrayQueue1 aq= new ArrayQueue1(4);
		char key = ' ';//接收用户输入
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		//输出一个菜单
		while(loop) {
			System.out.println("s(show):显示队列");
			System.out.println("e(exie):退出程序");
			System.out.println("a(add):添加数据到队列");
			System.out.println("g(get):从队列取出程序");
			System.out.println("h(head):查看队列头部数据");
			
			key = scanner.next().charAt(0);//接收一个字符
			switch(key){
			case 's':
				aq.showQueue();
				break;
			case 'a':
				System.out.println("请输入一个数字：");
				int value = scanner.nextInt();
				aq.addQueue(value);
				break;
			case 'g'://取出数据
				try {
					int res =aq.getQueue();
					System.out.printf("取出的数据为：%d\n",res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.printf(e.getMessage());
				}
				break;
			case 'h':
				try {
					int res = aq.headQueue();
					System.out.printf("队列头的数据为：%d\n",res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.printf(e.getMessage());
				}
				break;
			case 'e':
				scanner.close();
				loop=false;
				break;
				default:
					break;
			}
			
		}
		System.out.println("程序退出");

	}

}

//使用数组模拟队列 - 编写一个ArrayQueue类
class ArrayQueue1 {
	
	private int maxSize;//表示数组的最大容量
	private int front;//队列头
	private int rear;//队列尾
	private int[] arr;//该数组用于存放数据，模拟队列
	
	//创建队列的构造器
	public ArrayQueue1(int arrMaxSize) {
		maxSize= arrMaxSize;
		arr = new int [maxSize];
		front = -1;//指向队列头部，分析出front是指向队列头的前一个位置
		rear = -1;//指向队列的尾部，指向队列的尾部（本身就是队列尾部）
		
	}
	
	//判断队列是否满
	public boolean isFull() {
		return rear == front-1;
	}
	
	//判断队列是否为空
	public boolean isEmpty() {
		return rear == front;
	}
	
	//添加数据到队列
	public void addQueue(int n ) {
		//判断队列是否满
		if(isFull()) {
			System.out.println("队列满，不能加入数据");
			return ;
		}
		rear ++;//让rear后移动
		arr[rear] =n;
	}
	
	//出队列,取出数据
	public int getQueue() {
		//判断队列是否为空
		if(isEmpty()) {
			//抛出异常
			throw new RuntimeException("队列空，不能取数据！");
		}
		front ++;
		return arr[front];
	}
	
	//显示队列数据
	
	public void showQueue() {
		//遍历
		if(isEmpty()) {
			System.out.println("队列空，没有数据```");
			return ;
		}
		for(int i =0;i<arr.length;i++) {
			System.out.printf("arr[%d]=%d\n",i,arr[i]);
			System.out.println();
		}
	}
	
	//显示队列的头部数据是多少，注意不是取出数据
	public int headQueue() {
		//判断是否为空
		if(isEmpty()) {
			throw new RuntimeException("队列空，没有数据！");
		}
		return arr[front+1];
		
		
	}
	
	
}
