package pack1;

import java.util.Scanner;

public class CircleArrarQueue {
	public static void main (String[] args) {
		
		//��������ģ�⻷�ζ��еİ���
		System.out.println("��������ģ�⻷�ζ��еİ���");
		
		
		//����һ�����ζ���
		CircleArrar aq= new CircleArrar(4);
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

class CircleArrar{
	private int maxSize;//��ʾ������������
	//front��ָ����еĵ�һ��Ԫ�أ�Ҳ����˵arr[front]���Ƕ��еĵ�һ��Ԫ�ء�front�ĳ�ʼֵ=0
	private int front;
	//rear�����ĺ�����һ��������rearָ��������һ��Ԫ�صĺ�һ��λ�ã���Ϊϣ���ճ�һ���ռ���ΪԼ����
	private int rear;
	private int[] arr;//���������ڴ�����ݣ�ģ�����
	
	public CircleArrar(int arrMaxSize) {
		maxSize= arrMaxSize;
		arr = new int [maxSize];
		
	}
	
	//�ж϶����Ƿ���
		public boolean isFull() {
			return (rear + 1 )%maxSize == front;
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
			//ֱ�ӽ����ݼ���
			arr[rear] =n;
			//rear���ƣ�����Ϊ�˷�ֹ����Խ�磬ʹ��ȡģ��ʽ��һ
			rear = (rear +1 )% maxSize;
		}
		
		//������,ȡ������
		public int getQueue() {
			//�ж϶����Ƿ�Ϊ��
			if(isEmpty()) {
				//�׳��쳣
				throw new RuntimeException("���пգ�����ȡ���ݣ�");
			}
			//������Ҫ������front��ָ����еĵ�һ��Ԫ��
			//1.�Ȱ�front��Ӧ��ֵ������һ����ʱ����
			//2.��front����
			//3.����ʱ����ı�������
			int value = arr[front];
			front =( front+1) % maxSize;
			return value;
		}
		
		//��ʾ��������
		
		public void showQueue() {
			//����
			if(isEmpty()) {
				System.out.println("���пգ�û������```");
				return ;
			}
			//˼·����front��ʼ����������������е�����Ԫ��
			for(int i = front;i<front+size();i++) {
				System.out.printf("arr[%d]=%d\n",i % maxSize,arr[i % maxSize]);
				System.out.println();
			}
		}
		
		//���������Ч���ݵĸ���
		public int size() {
			return (rear + maxSize-front) % maxSize;
		}
		
		//��ʾ���е�ͷ�������Ƕ��٣�ע�ⲻ��ȡ������
		public int headQueue() {
			//�ж��Ƿ�Ϊ��
			if(isEmpty()) {
				throw new RuntimeException("���пգ�û�����ݣ�");
			}
			return arr[front];
			
			
		}
}