package Linkdelist;

import java.util.Stack;

public class SingleLInkedlistDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//测试
		//先创建结点
		HeroNode heronode1 = new HeroNode(1,"宋江","及时雨");
		HeroNode heronode2 = new HeroNode(2,"李逵","黑旋风");
		HeroNode heronode3 = new HeroNode(3,"孙二娘","母夜叉");
		HeroNode heronode4 = new HeroNode(4,"张顺","浪里白条");
		HeroNode heronode5 = new HeroNode(5,"林冲","豹子头");
		
		//创建一个链表
		SingleLInkedlist	singleLInkedlist= new SingleLInkedlist();
		
		//测试单链表的反转
		
		//加入
		singleLInkedlist.add(heronode1);
		singleLInkedlist.add(heronode2);
		singleLInkedlist.add(heronode3);
		singleLInkedlist.add(heronode4);
		singleLInkedlist.add(heronode5);
		
		System.out.print("这是原来链表的情况：\n");
		singleLInkedlist.list();
		
//		System.out.print("这是反转后链表的情况：\n");
//		reversetList(singleLInkedlist.getHead());
//		singleLInkedlist.list();
		
		//测试使用栈逆序打印单链表
		System.out.print("逆序打印单链表：\n");
		revererPrint(singleLInkedlist.getHead());
		
		
		/*
		
		//按编号加入
		singleLInkedlist.addByOrder(heronode1);
		singleLInkedlist.addByOrder(heronode2);
		singleLInkedlist.addByOrder(heronode5);
		singleLInkedlist.addByOrder(heronode3);
		singleLInkedlist.addByOrder(heronode4);
		
		//测试修改结点的代码；
		HeroNode newheronode = new HeroNode(2,"小李逵 ","小黑旋风");
		singleLInkedlist.update(newheronode);
		
		//显示
		singleLInkedlist.list();
		
		//删除一个结点
		singleLInkedlist.del(1);
		singleLInkedlist.del(2);
		System.out.printf("删除后链表为：\n");
		singleLInkedlist.list();
		
		
		//测试，求单链表结点个数
		System.out.println("单链表结点个数为"+getLength(singleLInkedlist.getHead()));
		
		//测试是否得到倒数第k个结点
		HeroNode res = findLaseIndexNode(singleLInkedlist.getHead(),2);
		System.out.println("倒数第k个结点res="+res);
	
	*/
	}
	
	//.方式二：可以利用栈这个结构，将各个节点压入到**栈**，然后利用栈的先进后出的特点，就实现了逆序打印的效果。
	public static void revererPrint(HeroNode head) {
		if(head.next == null) {//空链表不能打印
			return ;
		}
		//创建一个栈，将各个节点压入栈
		Stack<HeroNode> stack = new Stack<HeroNode>();
		
		HeroNode cur =head.next;
		//将链表的所有结点压入栈中
		while(cur != null) {
			stack.push(cur);
			cur = cur.next;//cur后移，压入下一个
		}
		//将栈中结点打印
		while(stack.size()> 0) {
			System.out.println(stack.pop());//先进后出
		}
	}
	
	//将单链表进行反转
	public static void reversetList(HeroNode head) {
		//如果链表为空或者只有一个结点，无需反转，直接返回
		if(head.next == null || head.next.next ==null) {
			return ;
		}
		//定义一个辅助指针，帮助遍历链表
		HeroNode cur = head.next;
		HeroNode next = null;//指向当前结点【cur】的下一结点
		HeroNode reverseHead = new HeroNode(0,"","");
		//遍从头到尾遍历原来的链表，每遍历一个结点取出并放在reverseHead 的**最前端**
		while(cur != null) {
			next =cur.next;//暂时保存当前结点的下一结点
			cur.next =reverseHead.next;//将cur的下一个结点指向新的链表的最前端
			reverseHead.next = cur;//将cur连接到新的结点
			cur = next;//让cur后移
		}
		//将head.next指向reverseHead.next，实现单链表的反转
		head.next =reverseHead.next;
	}
	
	//	思路：
	//	1.编写一个方法接收head结点，同时接收一个index
	//	2.index表示的是倒数第index个结点
	//	3.先把链表从头到尾遍历，得到链表的总长度getLength
	//	4.得到size后，我们从链表的第一个开始遍历（size - index）个
	//  5.如果找到则返回该结点，否则返回null
	public static HeroNode findLaseIndexNode(HeroNode head,int index) {
		//判断链表为空，返回null
		if(head.next == null) {
			return null;
		}
		//第一个遍历得到链表的长度
		int  size =getLength(head);
		//第二次遍历size -index 的位置，就是我们找的倒数k个结点
		//先做数据的校验
		if(index <=0 ||index >size) {
			return null;
		}
		//定义一个辅助变量ford循环定位到倒数index
		HeroNode cur = head.next;
		for(int i =0;i<size - index;i++) {
			cur =cur.next;
		}
		return cur;
	}
	
	
	
	//获取到单链表结点的个数，如果有头结点，不需要统计头结点
	public static int getLength(HeroNode head) {
		if(head.next == null) {
			return 0;
		}
		int length = 0;
		//定义一个辅助变量
		HeroNode cur = head.next;
		while(cur != null) {
			length ++;
			cur = cur.next;//遍历
		}
		return length;
	}

}
//定义一个SingleLinedlist来管理英雄
class SingleLInkedlist{
	//先初始化一个头结点，一般不能动
	private HeroNode head = new HeroNode(0,"","");
	
	//返回头结点
	public HeroNode getHead() {
		return head;
	}
	
	//添加结点到单向链表
	//思路：当不考虑几点的顺序时
	//1.找到当前链表的最后一个结点
	//2.将最后一个结点的next 指向新的结点
	public void add(HeroNode heronode) {
		
		//因为head结点不能动，因此需要一个辅助遍历temp
		HeroNode temp =head;
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
		temp.next = heronode;
	}
	
	//第二种添加英雄的方式，根据排名将英雄插入到指定位置
	//如果有这个排名则给出提示
	public void addByOrder(HeroNode heronode) {
		//因为头结点不能动，所以通过辅助结点temp找到添加的位置
		//因为是单链表，所以找的位置是添加位置的前一个结点
		HeroNode temp = head;
		boolean flag =false;//标识添加的结点是否存在，
		
		while(true) {//到达链表最后
			if(temp.next == null) {
				break;
			}
			if(temp.next.no>heronode.no) {//位置找到，就在temp后面插入
				break;
			}else if(temp.next.no == heronode.no) {
				flag = true;//说明编号存在
				break;
			}
			
			temp = temp.next;//后移，遍历当前链表
			
		}
		//判断flag值
		if(flag) {//不能添加，说明编号存在
			System.out.printf("准备插入的英雄的编号%d存在！,不能加入",heronode.no);
			System.out.println();
		}else {
			//插入到链表，temp后面
			heronode.next = temp.next;
			temp.next = heronode;
		}
		
	}
	
	//修改结点信息，根据no编号来修改，即no不变
	//说明
	//1.根据newHeroNode的 no修改就可以
	public void update(HeroNode newHeroNode) {
		//判断链表是否为空
		if(head.next == null) {
			System.out.println("链表为空！");
			return ;
		}
		//找到需要修改的结点,根据no编号
		//定义一个辅助变量
		HeroNode temp = head.next;
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
	
	//修改结点
	//思路
	//1.head不能动，需要一个辅助结点temp，遍历找到删除结点的前一个结点
	public void del(int no) {
		HeroNode temp = head;
		boolean flag = false;//标志是否找到哦啊删除结点
		while(true) {
			if(temp.next == null) {
				break;
			}
			if(temp.next.no == no) {
				//找到待删除结点的前一结点
				flag =true;
				break;
			}
			temp =temp.next;//temp后移
			
		}
		//判断flae
		if(flag) {//找到待删除结点
			//可以删除
			temp.next = temp.next.next;
		}else {
			System.out.printf("要删除的结点%d不存在\n",no);
		}
	}
	
	
	//显示链表（遍历）
	public void list() {
		//判断链表是否为空
		if(head.next == null) {
			System.out.println("链表为空！");
			return ;
		}
		//因为头结点不能动，所以需要一个辅助变量来辅助遍历
		HeroNode temp = head.next;
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
}

//首先定义一个HeroNode，每个HeroNode对象是一个结点
class HeroNode{
	public int no;
	public String name;
	public String nikenmae;
	public HeroNode next;//指向 下一个结点
	//构造器
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
