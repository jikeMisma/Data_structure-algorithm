package Linkdelist;

public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		
		//测试代码
		System.out.println("双向链表的测试：");
		//先创建结点
		HeroNode2 heronode1 = new HeroNode2(1,"宋江","及时雨");
		HeroNode2 heronode2 = new HeroNode2(2,"李逵","黑旋风");
		HeroNode2 heronode3 = new HeroNode2(3,"孙二娘","母夜叉");
		HeroNode2 heronode4 = new HeroNode2(4,"张顺","浪里白条");
		HeroNode2 heronode5 = new HeroNode2(5,"林冲","豹子头");
		
		//创建一个双向链表对象
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
		doubleLinkedList.add(heronode1);
		doubleLinkedList.add(heronode2);
		doubleLinkedList.add(heronode3);
		doubleLinkedList.add(heronode4);
		doubleLinkedList.add(heronode5);
		
		doubleLinkedList.list();
		
		//修改测试
		System.out.println("修改测试");
		HeroNode2 newHeroNode = new HeroNode2(5,"公孙胜","入云龙头");
		doubleLinkedList.update(newHeroNode);
		doubleLinkedList.list();
		
		//删除
		System.out.println("删除测试");
		doubleLinkedList.del(4);
		doubleLinkedList.list();

	}

}

//创建一个双向链表的类
class DoubleLinkedList{
	//先初始化一个头结点，一般不能动
	private HeroNode2 head = new HeroNode2(0,"","");
	
	//返回头结点
	public HeroNode2 getHead() {
		return head;
	}
	
	//遍历双向链表的方法
	public void list() {
		//判断链表是否为空
		if(head.next == null) {
			System.out.println("链表为空！");
			return ;
		}
		//因为头结点不能动，所以需要一个辅助变量来辅助遍历
		HeroNode2 temp = head.next;
		while(true) {
			//判断是否到最后
			if(temp == null) {
				break;
			}
			//输出结点信息
			System.out.println(temp);
			//将next后移
			temp=temp.next;
		}
	}
	//添加一个结点到双向链表的最后
	public void add(HeroNode2 heronode) {
			
			//因为head结点不能动，因此需要一个辅助遍历temp
			HeroNode2 temp =head;
			//遍历链表，找到最后
			while(true) {
				//找到链表最后
				if(temp.next == null) {
					break;
				}
				//如果没有找到，将temp后移
				temp=temp.next;
				
			}
			//当退出循环的时候，temp就指向了链表的最后
			//构成双向链表
			temp.next = heronode;
			heronode.pre =temp;
		}
	
	//修改一个结点的内容
	//双向链表的节点内筒的修改和单向链表一样，只是结点类型改成了HeroNode2
	public void update(HeroNode2 newHeroNode) {
		//判断链表是否为空
		if(head.next == null) {
			System.out.println("链表为空！");
			return ;
		}
		//找到需要修改的结点,根据no编号
		//定义一个辅助变量
		HeroNode2 temp = head.next;
		boolean flag = false;//表示是否找到该结点
		while(true) {
			if(temp == null) {
				break;//遍历完整个链表
				
			}
			if(temp.no == newHeroNode.no) {
				//找到
				flag = true;
				break;
			}
			temp =temp.next;
		}
		//根据flag判断是否找到修改结点
		
		if(flag) {
			temp.name = newHeroNode.name;
			temp.nikenmae = newHeroNode.nikenmae;
			
		}else {
			//没有找到
			System.out.printf("没有找到编号为%d的结点，不能修改\n",newHeroNode.no);
		}	
	}
	
	//从双向链表中删除结点
	//说明：
	//1.对于双向链表可以直接找到删除的这个结点
	//2.找到后直接删除即可
	public void del(int no) {
		
		//判断当前链表是否为空
		if(head.next == null) {
			System.out.println("链表为空，无法删除");
			return ;
		}
		
		HeroNode2 temp = head.next;
		boolean flag = false;//标志是否找到哦啊删除结点
		while(true) {
			if(temp == null) {
				break;
			}
			if(temp.no == no) {
				//找到待删除结点的前一结点
				flag =true;
				break;
			}
			temp =temp.next;//temp后移
			
		}
		//判断flae
		if(flag) {//找到待删除结点
			//可以删除
			//temp.next = temp.next.next;单向链表
			temp.pre.next = temp.next;
			//这里代码有问题
			//如果是最后一个结点就不执行下面这句话，否则会出现空指针异常
			if(temp.next != null) {
				temp.next.pre = temp.pre;
			}
			
		}else {
			System.out.printf("要删除的结点%d不存在\n",no);
		}
	}
	
	
}

//首先定义一个HeroNode，每个HeroNode对象是一个结点
class HeroNode2{
	public int no;
	public String name;
	public String nikenmae;
	public HeroNode2 next;//指向 下一个结点
	public HeroNode2 pre;//指向前一个结点
	//构造器
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