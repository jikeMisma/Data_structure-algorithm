package Linkdelist;

public class josepfu {

	public static void main(String[] args) {
		//���Թ��������б����ʾ�Ƿ�ok
		CircleSingleLinkedList circleSingleLinkedList=new CircleSingleLinkedList();
		circleSingleLinkedList.addBoy(5);//����5��С��
		circleSingleLinkedList.showBoy();
		System.out.println("~~~~~~~~~~~~~~~~~");
		//����С����Ȧ�Ƿ���ȷ
		circleSingleLinkedList.countBoy(1,2,5);
		//��Ȧ����Ӧ��Ϊ2-4-1-5-3

	}

}
//����һ�����εĵ�������
class CircleSingleLinkedList{
	//����һ��first��㣬��ǰû�б��
	private Boy first =null;
	//���С����㣬�����ɻ�������
	public void addBoy(int nums) {
		//nums������У��
		if(nums <1) {
			System.out.println("nums��ֵ����ȷ��");
			return ;
		}
		Boy curBoy = null;//����ָ�룬����������������
		//ʹ��һ��forѭ��������������
		for(int i =1;i<=nums;i++) {
			//���ݱ�Ŵ���С�����
			Boy boy = new Boy(i);
			//����ǵ�һ��С��
			if(i ==1) {
				first = boy;
			first.setNext(first);//���ɻ�װ
			curBoy =first;//ָ���һ��С��
			}else {
			curBoy.setNext(boy);//
			boy.setNext(first);
			curBoy = boy;	
			}
			
		}
	}
	
	//������ǰ��������
	public void showBoy() {
		//�ж������Ƿ�Ϊ��
		if(first == null) {
			System.out.println("����Ϊ�գ�");
		}
		//��Ϊfirst���ܶ�����Ȼʹ�ø���ָ����ɱ���
		Boy curBoy = first;
		while(true) {
			System.out.printf("С�����%d\n",curBoy.getNo());
			if(curBoy.getNext() ==first) {//˵�����
				break;
			}
			curBoy =curBoy.getNext();//curBoy����
		}
	}
	
	//�����û�������������Ȧ��˳��
	/**
	 * 
	 * @param startNo ��ʾ�ӵڼ���С����ʼ����
	 * @param countNo ��ʾ������
	 * @param nums ��ʾ����ɶ���С������Ȧ��
	 */
	public void countBoy(int startNo,int countNo,int nums) {
		//�ȶ����ݽ���У��
		if(first == null ||startNo < 1 || startNo >nums) {
			System.out.print("����������������������~~~");
			return ;
		}
		//��������ָ�룬����С����Ȧ
		Boy helper = first;
		//����һ��������㣨������helper������Ӧ��ָ������������һ�����
		while(true) {
			if(helper.getNext() == first) {//˵���������һ�����
				break ;
			}
			helper = helper.getNext();
		}
		//С������ǰ������first��helper�ƶ�k-1��
		for(int j =0;j < startNo -1;j++) {
			first = first.getNext();
			helper = helper.getNext();
		}
		//��С��������ʱ����first��helperͬʱ�ƶ�m-1��,�˺��Ȧ
		//������һ��ѭ��������ֱ��Ȧ��ֻ��һ����
		while(true) {
			if(helper == first) {//˵��Ȧ��ֻ��һ��
				break ;
			}
			//��first helper ͬʱ�ƶ�countNum -1��
			for(int j =0;j < countNo -1;j++) {
				first = first.getNext();
				helper = helper.getNext();
			}
			//����firstָ��Ľ����ǳ�Ȧ�Ľ��
			System.out.printf("С��%d��Ȧ\n",first.getNo());
			//��firstָ��С������Ȧ
			first = first.getNext();
			helper.setNext(first) ;//
		}
		System.out.printf("�������Ȧ��С�����Ϊ%d",first.getNo());
	}
}

//����һ��boy�࣬��ʾһ�����
class Boy{
	private int no;//���
	private Boy next;//ָ����һ����㡣Ĭ��null
	
	public Boy(int no) {
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Boy getNext() {
		return next;
	}

	public void setNext(Boy next) {
		this.next = next;
	}
	
	
	
}
