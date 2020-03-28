package pack1;

import java.util.Scanner;

public class ArrayQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//����
		//����һ������
		
		ArrayQueue1 aq= new ArrayQueue1(4);
		char key = ' ';//�����û�����
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		//���һ���˵�
		while(loop) {
			System.out.println("s(show):��ʾ����");
			System.out.println("e(exie):�˳�����");
			System.out.println("a(add):������ݵ�����");
			System.out.println("g(get):�Ӷ���ȡ������");
			System.out.println("h(head):�鿴����ͷ������");
			
			key = scanner.next().charAt(0);//����һ���ַ�
			switch(key){
			case 's':
				aq.showQueue();
				break;
			case 'a':
				System.out.println("������һ�����֣�");
				int value = scanner.nextInt();
				aq.addQueue(value);
				break;
			case 'g'://ȡ������
				try {
					int res =aq.getQueue();
					System.out.printf("ȡ��������Ϊ��%d\n",res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.printf(e.getMessage());
				}
				break;
			case 'h':
				try {
					int res = aq.headQueue();
					System.out.printf("����ͷ������Ϊ��%d\n",res);
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
		System.out.println("�����˳�");

	}

}

//ʹ������ģ����� - ��дһ��ArrayQueue��
class ArrayQueue1 {
	
	private int maxSize;//��ʾ������������
	private int front;//����ͷ
	private int rear;//����β
	private int[] arr;//���������ڴ�����ݣ�ģ�����
	
	//�������еĹ�����
	public ArrayQueue1(int arrMaxSize) {
		maxSize= arrMaxSize;
		arr = new int [maxSize];
		front = -1;//ָ�����ͷ����������front��ָ�����ͷ��ǰһ��λ��
		rear = -1;//ָ����е�β����ָ����е�β����������Ƕ���β����
		
	}
	
	//�ж϶����Ƿ���
	public boolean isFull() {
		return rear == front-1;
	}
	
	//�ж϶����Ƿ�Ϊ��
	public boolean isEmpty() {
		return rear == front;
	}
	
	//������ݵ�����
	public void addQueue(int n ) {
		//�ж϶����Ƿ���
		if(isFull()) {
			System.out.println("�����������ܼ�������");
			return ;
		}
		rear ++;//��rear���ƶ�
		arr[rear] =n;
	}
	
	//������,ȡ������
	public int getQueue() {
		//�ж϶����Ƿ�Ϊ��
		if(isEmpty()) {
			//�׳��쳣
			throw new RuntimeException("���пգ�����ȡ���ݣ�");
		}
		front ++;
		return arr[front];
	}
	
	//��ʾ��������
	
	public void showQueue() {
		//����
		if(isEmpty()) {
			System.out.println("���пգ�û������```");
			return ;
		}
		for(int i =0;i<arr.length;i++) {
			System.out.printf("arr[%d]=%d\n",i,arr[i]);
			System.out.println();
		}
	}
	
	//��ʾ���е�ͷ�������Ƕ��٣�ע�ⲻ��ȡ������
	public int headQueue() {
		//�ж��Ƿ�Ϊ��
		if(isEmpty()) {
			throw new RuntimeException("���пգ�û�����ݣ�");
		}
		return arr[front+1];
		
		
	}
	
	
}
