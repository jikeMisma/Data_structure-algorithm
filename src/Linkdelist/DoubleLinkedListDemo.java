package Linkdelist;

public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		
		//���Դ���
		System.out.println("˫������Ĳ��ԣ�");
		//�ȴ������
		HeroNode2 heronode1 = new HeroNode2(1,"�ν�","��ʱ��");
		HeroNode2 heronode2 = new HeroNode2(2,"����","������");
		HeroNode2 heronode3 = new HeroNode2(3,"�����","ĸҹ��");
		HeroNode2 heronode4 = new HeroNode2(4,"��˳","�������");
		HeroNode2 heronode5 = new HeroNode2(5,"�ֳ�","����ͷ");
		
		//����һ��˫���������
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
		doubleLinkedList.add(heronode1);
		doubleLinkedList.add(heronode2);
		doubleLinkedList.add(heronode3);
		doubleLinkedList.add(heronode4);
		doubleLinkedList.add(heronode5);
		
		doubleLinkedList.list();
		
		//�޸Ĳ���
		System.out.println("�޸Ĳ���");
		HeroNode2 newHeroNode = new HeroNode2(5,"����ʤ","������ͷ");
		doubleLinkedList.update(newHeroNode);
		doubleLinkedList.list();
		
		//ɾ��
		System.out.println("ɾ������");
		doubleLinkedList.del(4);
		doubleLinkedList.list();

	}

}

//����һ��˫���������
class DoubleLinkedList{
	//�ȳ�ʼ��һ��ͷ��㣬һ�㲻�ܶ�
	private HeroNode2 head = new HeroNode2(0,"","");
	
	//����ͷ���
	public HeroNode2 getHead() {
		return head;
	}
	
	//����˫������ķ���
	public void list() {
		//�ж������Ƿ�Ϊ��
		if(head.next == null) {
			System.out.println("����Ϊ�գ�");
			return ;
		}
		//��Ϊͷ��㲻�ܶ���������Ҫһ��������������������
		HeroNode2 temp = head.next;
		while(true) {
			//�ж��Ƿ����
			if(temp == null) {
				break;
			}
			//��������Ϣ
			System.out.println(temp);
			//��next����
			temp=temp.next;
		}
	}
	//���һ����㵽˫����������
	public void add(HeroNode2 heronode) {
			
			//��Ϊhead��㲻�ܶ��������Ҫһ����������temp
			HeroNode2 temp =head;
			//���������ҵ����
			while(true) {
				//�ҵ��������
				if(temp.next == null) {
					break;
				}
				//���û���ҵ�����temp����
				temp=temp.next;
				
			}
			//���˳�ѭ����ʱ��temp��ָ������������
			//����˫������
			temp.next = heronode;
			heronode.pre =temp;
		}
	
	//�޸�һ����������
	//˫������Ľڵ���Ͳ���޸ĺ͵�������һ����ֻ�ǽ�����͸ĳ���HeroNode2
	public void update(HeroNode2 newHeroNode) {
		//�ж������Ƿ�Ϊ��
		if(head.next == null) {
			System.out.println("����Ϊ�գ�");
			return ;
		}
		//�ҵ���Ҫ�޸ĵĽ��,����no���
		//����һ����������
		HeroNode2 temp = head.next;
		boolean flag = false;//��ʾ�Ƿ��ҵ��ý��
		while(true) {
			if(temp == null) {
				break;//��������������
				
			}
			if(temp.no == newHeroNode.no) {
				//�ҵ�
				flag = true;
				break;
			}
			temp =temp.next;
		}
		//����flag�ж��Ƿ��ҵ��޸Ľ��
		
		if(flag) {
			temp.name = newHeroNode.name;
			temp.nikenmae = newHeroNode.nikenmae;
			
		}else {
			//û���ҵ�
			System.out.printf("û���ҵ����Ϊ%d�Ľ�㣬�����޸�\n",newHeroNode.no);
		}	
	}
	
	//��˫��������ɾ�����
	//˵����
	//1.����˫���������ֱ���ҵ�ɾ����������
	//2.�ҵ���ֱ��ɾ������
	public void del(int no) {
		
		//�жϵ�ǰ�����Ƿ�Ϊ��
		if(head.next == null) {
			System.out.println("����Ϊ�գ��޷�ɾ��");
			return ;
		}
		
		HeroNode2 temp = head.next;
		boolean flag = false;//��־�Ƿ��ҵ�Ŷ��ɾ�����
		while(true) {
			if(temp == null) {
				break;
			}
			if(temp.no == no) {
				//�ҵ���ɾ������ǰһ���
				flag =true;
				break;
			}
			temp =temp.next;//temp����
			
		}
		//�ж�flae
		if(flag) {//�ҵ���ɾ�����
			//����ɾ��
			//temp.next = temp.next.next;��������
			temp.pre.next = temp.next;
			//�������������
			//��������һ�����Ͳ�ִ��������仰���������ֿ�ָ���쳣
			if(temp.next != null) {
				temp.next.pre = temp.pre;
			}
			
		}else {
			System.out.printf("Ҫɾ���Ľ��%d������\n",no);
		}
	}
	
	
}

//���ȶ���һ��HeroNode��ÿ��HeroNode������һ�����
class HeroNode2{
	public int no;
	public String name;
	public String nikenmae;
	public HeroNode2 next;//ָ�� ��һ�����
	public HeroNode2 pre;//ָ��ǰһ�����
	//������
	public  HeroNode2(int no,String name,String nikenmae){
		this.no=no;
		this.name=name;
		this.nikenmae=nikenmae;
		
	}
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nikenmae=" + nikenmae + "]";
	}
	
}