package hashtable;

import java.util.Scanner;

public class HashTabDemo {

	public static void main(String[] args) {
		
		//������ϣ��
		HashTab hashtab = new HashTab(7);
		
		//дһ���򵥲˵�
		String key = "";
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("add����ӹ�Ա");
			System.out.println("list����ʾ��Ա");
			System.out.println("find�����ҹ�Ա");
			System.out.println("add���˳�ϵͳ");
			
			key = scanner.next();
			switch(key) {
			case "add":
				System.out.println("����id");
				int id = scanner.nextInt();
				System.out.println("��������");
				String name = scanner.next();
				//������Ա
				Emp emp = new Emp(id,name);
				hashtab.add(emp);
				break;
			case "list":
				hashtab.list();
				break;
			case "find":
				System.out.println("������Ҫ���ҵ�id");
				 id = scanner.nextInt();
				 hashtab.findEmpById(id);
				 break;
			case "exit":
				scanner.close();
			System.exit(0);
			default:
				break;
			
			}
			
		}
	}

}
//����hashtable�������������
class HashTab{
	private EmpLinkedList[] empLinkedListArray;
	private int size;
	
	//������
	public HashTab(int size) {
		this.size = size;//��ʾ�ж���������
		//��ʼ��empLinkedListArray
		empLinkedListArray = new EmpLinkedList[size];
		
		//������������Ҫ���˷ֱ��ʼ��ÿ������
		for(int i = 0;i<size;i++) {
			empLinkedListArray[i] = new EmpLinkedList();
		}
	}
	
	//�������е���������hastab
	public void list() {
		for(int i = 0;i < size;i++) {
			empLinkedListArray[i].list(i);
		}
		
	}
	
	//��ӹ�Ա
	public void add(Emp emp) {
		//����Ա����id�õ���Ա��Ӧ�ü��뵽��������
		int empLinkedLisNo = hashFun(emp.id);
		//��emp��ӵ���Ӧ��������
		empLinkedListArray[empLinkedLisNo].add(emp);
		
	}
	
	//���������id�����ҹ�Ա
	public void findEmpById(int id) {
		//ʹ��ɢ�˺���ȷ�����������
		int empLinkedLisNo = hashFun(id);
		Emp emp = empLinkedListArray[empLinkedLisNo].findEmpById(id);
		if(emp !=null) {//��
			System.out.printf("�ڵ�%d���������ҵ���Աid = %d\n",empLinkedLisNo+1,id);
		}else {
			System.out.println("�ڹ�ϣ����û���ҵ��ù�Ա");
		}
	}
	
	//��дһ��ɢ�к�����ʹ�ü򵥵�ȡģ��
	public int hashFun(int id) {
		return id % size;
	}
}

//��ʾһ����Ա
class Emp{
	public int id;
	public String name;
	public Emp next;//nextĬ��Ϊ��
	public Emp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}

//����һ��EmpLinkedList����ʾ����
class EmpLinkedList{
	//ͷָ�룬ִ�е�һ��Emp��������ǵĵ�һ��head��ֱ��ָ��Emp
	private Emp head;//Ĭ��null
	
	//��ӹ�Ա����
	//˵��
	//1.�ٶ�����ӹ�Աʱ��di���������ģ���id�ķ������Ǵ�С����
	//�������ֻ��Ҫ������ֱ�Ӽӵ����������󼴿�
	public void add(Emp emp) {
		//�����ӵ�һ��Ա��
		if(head == null) {
			head = emp;
			return ;
		}
		//������ǵ�һ����Ա,����ʹ�ø���ָ��������λ�����
		Emp curEmp = head;
		while(true) {
			if(curEmp.next == null) {//˵�����������
				break;
			}
			curEmp = curEmp.next;//����
		}
		
		//�˳�ʱֱ�Ӱ���emp���뵽����
		curEmp.next = emp;

	}
	
	//��������
	public void list(int no) {
		if(head == null){//˵������Ϊ��
			System.out.println("��"+(no+1)+"������Ϊ��");
			return ;
		}
		System.out.printf("��%d�������ϢΪ��",(no+1));
		Emp curEmp = head;//��������
		while(true) {
			System.out.printf("  => id=%d name=%s\t",curEmp.id,curEmp.name);
			if(curEmp.next == null) {
				break;
			}
			curEmp = curEmp.next;
		}
		
		System.out.println();
	}
	
	//����id���ҹ�Ա
	//����ҵ��ͷ���Emp�����û�оͷ���null
	public Emp findEmpById(int id) {
		//�ж������Ƿ�Ϊ��
		if(head == null) {
			System.out.println("����Ϊ��");
			return null;
		}
		//����ָ��
		Emp curEmp = head;
		while(true) {
			if(curEmp.id == id) {//�ҵ�
				break;//��ʱcurEmp��ָ��Ҫ���ҵĹ�Ա
			}
			//�˳�
			if(curEmp.next == null) {//˵������������û���ҵ��ù�Ա
				curEmp = null;
				break;
			}
			curEmp = curEmp.next;//����
		}
		return curEmp;
		
	}
	
}
