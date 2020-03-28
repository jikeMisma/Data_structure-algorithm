package stack;

import java.util.Scanner;

public class ArrayStackDemo {

	public static void main(String[] args) {
		
		//����
		//����һ��ArryStack�Ķ���
		ArryStack stack =new ArryStack(4);
		String key ="";
		boolean loop = true;
		
		Scanner scanner=new Scanner(System.in);
		
		while(loop) {
			System.out.println("show����ʾջ");
			System.out.println("exit���˳�ջ");
			System.out.println("push����ջ");
			System.out.println("pop����ջ");
			System.out.println("���������ѡ��");
			
			key = scanner.next();
			switch (key) {
			case "show":
				stack.list();
				break ;
			case "push":
				System.out.println("������һ������");
				int value = scanner.nextInt();
				stack.push(value);
				break ;
			case "pop":
				try {
					int res = stack.pop();
					System.out.printf("��ջ�������ǣ�%d��\n",res);
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
		
		System.out.println("�����˳���");
		
	}
}


//����һ���࣬��ʾջ�ṹ
class ArryStack{
	private int maxSize;//ջ�Ĵ�С
	private int[] stack;//���飬ģ��ջ
	private int top = -1;//��ʾջ������ʼ��Ϊ-1��
	
	//������
	public  ArryStack(int maxSize) {
		this.maxSize =maxSize;
		stack = new int [this.maxSize];
	}
	
	//�ж�ջ��
	public boolean isFull() {
		return top == maxSize - 1;
	}
	
	//�ж�ջ��
		public boolean isEmpty() {
			return top == - 1;
		}
		
	//��ջ����
		public void push(int value) {
			//���ж��Ƿ�ջ��
			if(isFull()) {
				System.out.printf("ջ����");
				return ;
			}
			
			top++;
			stack[top] = value;
		}
	
	//��ջ����,��ջ�����ݷ���
		public int pop() {
			//�ж�ջ�Ƿ��
			if(isEmpty()) {
				//�׳��쳣
				throw new RuntimeException("ջ�գ�û�����ݣ�");
			}
			int value= stack[top];
			return value;
		}
	
	//����ջ
	//����ʱ����Ҫ��ջ����ʼ��ʾ����
		
		public void list() {
			if(isEmpty()) {
				System.out.printf("ջ�գ�û�����ݣ�");
				return ;
			}
			for(int i =top;i>= 0;i--) {
				System.out.printf("stack[%d]=%d\n",i,stack[i]);
			}
		}
	
}
