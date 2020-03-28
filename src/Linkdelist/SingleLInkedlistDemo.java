package Linkdelist;

import java.util.Stack;

public class SingleLInkedlistDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����
		//�ȴ������
		HeroNode heronode1 = new HeroNode(1,"�ν�","��ʱ��");
		HeroNode heronode2 = new HeroNode(2,"����","������");
		HeroNode heronode3 = new HeroNode(3,"�����","ĸҹ��");
		HeroNode heronode4 = new HeroNode(4,"��˳","�������");
		HeroNode heronode5 = new HeroNode(5,"�ֳ�","����ͷ");
		
		//����һ������
		SingleLInkedlist	singleLInkedlist= new SingleLInkedlist();
		
		//���Ե�����ķ�ת
		
		//����
		singleLInkedlist.add(heronode1);
		singleLInkedlist.add(heronode2);
		singleLInkedlist.add(heronode3);
		singleLInkedlist.add(heronode4);
		singleLInkedlist.add(heronode5);
		
		System.out.print("����ԭ������������\n");
		singleLInkedlist.list();
		
//		System.out.print("���Ƿ�ת������������\n");
//		reversetList(singleLInkedlist.getHead());
//		singleLInkedlist.list();
		
		//����ʹ��ջ�����ӡ������
		System.out.print("�����ӡ������\n");
		revererPrint(singleLInkedlist.getHead());
		
		
		/*
		
		//����ż���
		singleLInkedlist.addByOrder(heronode1);
		singleLInkedlist.addByOrder(heronode2);
		singleLInkedlist.addByOrder(heronode5);
		singleLInkedlist.addByOrder(heronode3);
		singleLInkedlist.addByOrder(heronode4);
		
		//�����޸Ľ��Ĵ��룻
		HeroNode newheronode = new HeroNode(2,"С���� ","С������");
		singleLInkedlist.update(newheronode);
		
		//��ʾ
		singleLInkedlist.list();
		
		//ɾ��һ�����
		singleLInkedlist.del(1);
		singleLInkedlist.del(2);
		System.out.printf("ɾ��������Ϊ��\n");
		singleLInkedlist.list();
		
		
		//���ԣ������������
		System.out.println("�����������Ϊ"+getLength(singleLInkedlist.getHead()));
		
		//�����Ƿ�õ�������k�����
		HeroNode res = findLaseIndexNode(singleLInkedlist.getHead(),2);
		System.out.println("������k�����res="+res);
	
	*/
	}
	
	//.��ʽ������������ջ����ṹ���������ڵ�ѹ�뵽**ջ**��Ȼ������ջ���Ƚ�������ص㣬��ʵ���������ӡ��Ч����
	public static void revererPrint(HeroNode head) {
		if(head.next == null) {//�������ܴ�ӡ
			return ;
		}
		//����һ��ջ���������ڵ�ѹ��ջ
		Stack<HeroNode> stack = new Stack<HeroNode>();
		
		HeroNode cur =head.next;
		//����������н��ѹ��ջ��
		while(cur != null) {
			stack.push(cur);
			cur = cur.next;//cur���ƣ�ѹ����һ��
		}
		//��ջ�н���ӡ
		while(stack.size()> 0) {
			System.out.println(stack.pop());//�Ƚ����
		}
	}
	
	//����������з�ת
	public static void reversetList(HeroNode head) {
		//�������Ϊ�ջ���ֻ��һ����㣬���跴ת��ֱ�ӷ���
		if(head.next == null || head.next.next ==null) {
			return ;
		}
		//����һ������ָ�룬������������
		HeroNode cur = head.next;
		HeroNode next = null;//ָ��ǰ��㡾cur������һ���
		HeroNode reverseHead = new HeroNode(0,"","");
		//���ͷ��β����ԭ��������ÿ����һ�����ȡ��������reverseHead ��**��ǰ��**
		while(cur != null) {
			next =cur.next;//��ʱ���浱ǰ������һ���
			cur.next =reverseHead.next;//��cur����һ�����ָ���µ��������ǰ��
			reverseHead.next = cur;//��cur���ӵ��µĽ��
			cur = next;//��cur����
		}
		//��head.nextָ��reverseHead.next��ʵ�ֵ�����ķ�ת
		head.next =reverseHead.next;
	}
	
	//	˼·��
	//	1.��дһ����������head��㣬ͬʱ����һ��index
	//	2.index��ʾ���ǵ�����index�����
	//	3.�Ȱ������ͷ��β�������õ�������ܳ���getLength
	//	4.�õ�size�����Ǵ�����ĵ�һ����ʼ������size - index����
	//  5.����ҵ��򷵻ظý�㣬���򷵻�null
	public static HeroNode findLaseIndexNode(HeroNode head,int index) {
		//�ж�����Ϊ�գ�����null
		if(head.next == null) {
			return null;
		}
		//��һ�������õ�����ĳ���
		int  size =getLength(head);
		//�ڶ��α���size -index ��λ�ã����������ҵĵ���k�����
		//�������ݵ�У��
		if(index <=0 ||index >size) {
			return null;
		}
		//����һ����������fordѭ����λ������index
		HeroNode cur = head.next;
		for(int i =0;i<size - index;i++) {
			cur =cur.next;
		}
		return cur;
	}
	
	
	
	//��ȡ����������ĸ����������ͷ��㣬����Ҫͳ��ͷ���
	public static int getLength(HeroNode head) {
		if(head.next == null) {
			return 0;
		}
		int length = 0;
		//����һ����������
		HeroNode cur = head.next;
		while(cur != null) {
			length ++;
			cur = cur.next;//����
		}
		return length;
	}

}
//����һ��SingleLinedlist������Ӣ��
class SingleLInkedlist{
	//�ȳ�ʼ��һ��ͷ��㣬һ�㲻�ܶ�
	private HeroNode head = new HeroNode(0,"","");
	
	//����ͷ���
	public HeroNode getHead() {
		return head;
	}
	
	//��ӽ�㵽��������
	//˼·���������Ǽ����˳��ʱ
	//1.�ҵ���ǰ��������һ�����
	//2.�����һ������next ָ���µĽ��
	public void add(HeroNode heronode) {
		
		//��Ϊhead��㲻�ܶ��������Ҫһ����������temp
		HeroNode temp =head;
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
		temp.next = heronode;
	}
	
	//�ڶ������Ӣ�۵ķ�ʽ������������Ӣ�۲��뵽ָ��λ��
	//�������������������ʾ
	public void addByOrder(HeroNode heronode) {
		//��Ϊͷ��㲻�ܶ�������ͨ���������temp�ҵ���ӵ�λ��
		//��Ϊ�ǵ����������ҵ�λ�������λ�õ�ǰһ�����
		HeroNode temp = head;
		boolean flag =false;//��ʶ��ӵĽ���Ƿ���ڣ�
		
		while(true) {//�����������
			if(temp.next == null) {
				break;
			}
			if(temp.next.no>heronode.no) {//λ���ҵ�������temp�������
				break;
			}else if(temp.next.no == heronode.no) {
				flag = true;//˵����Ŵ���
				break;
			}
			
			temp = temp.next;//���ƣ�������ǰ����
			
		}
		//�ж�flagֵ
		if(flag) {//������ӣ�˵����Ŵ���
			System.out.printf("׼�������Ӣ�۵ı��%d���ڣ�,���ܼ���",heronode.no);
			System.out.println();
		}else {
			//���뵽����temp����
			heronode.next = temp.next;
			temp.next = heronode;
		}
		
	}
	
	//�޸Ľ����Ϣ������no������޸ģ���no����
	//˵��
	//1.����newHeroNode�� no�޸ľͿ���
	public void update(HeroNode newHeroNode) {
		//�ж������Ƿ�Ϊ��
		if(head.next == null) {
			System.out.println("����Ϊ�գ�");
			return ;
		}
		//�ҵ���Ҫ�޸ĵĽ��,����no���
		//����һ����������
		HeroNode temp = head.next;
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
	
	//�޸Ľ��
	//˼·
	//1.head���ܶ�����Ҫһ���������temp�������ҵ�ɾ������ǰһ�����
	public void del(int no) {
		HeroNode temp = head;
		boolean flag = false;//��־�Ƿ��ҵ�Ŷ��ɾ�����
		while(true) {
			if(temp.next == null) {
				break;
			}
			if(temp.next.no == no) {
				//�ҵ���ɾ������ǰһ���
				flag =true;
				break;
			}
			temp =temp.next;//temp����
			
		}
		//�ж�flae
		if(flag) {//�ҵ���ɾ�����
			//����ɾ��
			temp.next = temp.next.next;
		}else {
			System.out.printf("Ҫɾ���Ľ��%d������\n",no);
		}
	}
	
	
	//��ʾ����������
	public void list() {
		//�ж������Ƿ�Ϊ��
		if(head.next == null) {
			System.out.println("����Ϊ�գ�");
			return ;
		}
		//��Ϊͷ��㲻�ܶ���������Ҫһ��������������������
		HeroNode temp = head.next;
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
}

//���ȶ���һ��HeroNode��ÿ��HeroNode������һ�����
class HeroNode{
	public int no;
	public String name;
	public String nikenmae;
	public HeroNode next;//ָ�� ��һ�����
	//������
	public  HeroNode(int no,String name,String nikenmae){
		this.no=no;
		this.name=name;
		this.nikenmae=nikenmae;
		
	}
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nikenmae=" + nikenmae + "]";
	}
	
}
