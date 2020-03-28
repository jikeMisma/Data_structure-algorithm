package hashtable;

import java.util.Scanner;

public class HashTabDemo {

	public static void main(String[] args) {
		
		//创建哈希表
		HashTab hashtab = new HashTab(7);
		
		//写一个简单菜单
		String key = "";
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("add：添加雇员");
			System.out.println("list：显示雇员");
			System.out.println("find：查找雇员");
			System.out.println("add：退出系统");
			
			key = scanner.next();
			switch(key) {
			case "add":
				System.out.println("输入id");
				int id = scanner.nextInt();
				System.out.println("输入名字");
				String name = scanner.next();
				//创建雇员
				Emp emp = new Emp(id,name);
				hashtab.add(emp);
				break;
			case "list":
				hashtab.list();
				break;
			case "find":
				System.out.println("请输入要查找的id");
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
//创建hashtable，管理对陶链表
class HashTab{
	private EmpLinkedList[] empLinkedListArray;
	private int size;
	
	//构造器
	public HashTab(int size) {
		this.size = size;//表示有多少条链表
		//初始化empLinkedListArray
		empLinkedListArray = new EmpLinkedList[size];
		
		//！！！！！不要忘了分别初始化每个链表
		for(int i = 0;i<size;i++) {
			empLinkedListArray[i] = new EmpLinkedList();
		}
	}
	
	//遍历所有的链表，遍历hastab
	public void list() {
		for(int i = 0;i < size;i++) {
			empLinkedListArray[i].list(i);
		}
		
	}
	
	//添加雇员
	public void add(Emp emp) {
		//根据员工的id得到该员工应该加入到那条链表
		int empLinkedLisNo = hashFun(emp.id);
		//将emp添加到对应的链表中
		empLinkedListArray[empLinkedLisNo].add(emp);
		
	}
	
	//根据输入的id，查找雇员
	public void findEmpById(int id) {
		//使用散了函数确定到那里查找
		int empLinkedLisNo = hashFun(id);
		Emp emp = empLinkedListArray[empLinkedLisNo].findEmpById(id);
		if(emp !=null) {//找
			System.out.printf("在第%d条链表中找到雇员id = %d\n",empLinkedLisNo+1,id);
		}else {
			System.out.println("在哈希表中没有找到该雇员");
		}
	}
	
	//编写一个散列函数，使用简单的取模法
	public int hashFun(int id) {
		return id % size;
	}
}

//表示一个雇员
class Emp{
	public int id;
	public String name;
	public Emp next;//next默认为空
	public Emp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}

//创建一个EmpLinkedList，表示链表
class EmpLinkedList{
	//头指针，执行第一个Emp，因此我们的第一个head是直接指向Emp
	private Emp head;//默认null
	
	//添加雇员链表
	//说明
	//1.假定当添加雇员时，di是自增长的，即id的分配总是从小到大
	//因此我们只需要将挂云直接加到本链表的最后即可
	public void add(Emp emp) {
		//如果添加第一个员工
		if(head == null) {
			head = emp;
			return ;
		}
		//如果不是第一个雇员,则是使用辅助指正帮助定位到最后
		Emp curEmp = head;
		while(true) {
			if(curEmp.next == null) {//说明到链表最后
				break;
			}
			curEmp = curEmp.next;//后移
		}
		
		//退出时直接阿静emp加入到链表
		curEmp.next = emp;

	}
	
	//遍历链表
	public void list(int no) {
		if(head == null){//说明链表为空
			System.out.println("第"+(no+1)+"条链表为空");
			return ;
		}
		System.out.printf("第%d链表的信息为：",(no+1));
		Emp curEmp = head;//辅助作用
		while(true) {
			System.out.printf("  => id=%d name=%s\t",curEmp.id,curEmp.name);
			if(curEmp.next == null) {
				break;
			}
			curEmp = curEmp.next;
		}
		
		System.out.println();
	}
	
	//根据id查找雇员
	//如果找到就返回Emp，如果没有就返回null
	public Emp findEmpById(int id) {
		//判断链表是否为空
		if(head == null) {
			System.out.println("链表为空");
			return null;
		}
		//辅助指针
		Emp curEmp = head;
		while(true) {
			if(curEmp.id == id) {//找到
				break;//这时curEmp就指向要查找的雇员
			}
			//退出
			if(curEmp.next == null) {//说明遍历完链表没有找到该雇员
				curEmp = null;
				break;
			}
			curEmp = curEmp.next;//后移
		}
		return curEmp;
		
	}
	
}
