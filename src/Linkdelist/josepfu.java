package Linkdelist;

public class josepfu {

	public static void main(String[] args) {
		//测试构建环形列表和显示是否ok
		CircleSingleLinkedList circleSingleLinkedList=new CircleSingleLinkedList();
		circleSingleLinkedList.addBoy(5);//加入5个小孩
		circleSingleLinkedList.showBoy();
		System.out.println("~~~~~~~~~~~~~~~~~");
		//测试小孩出圈是否正确
		circleSingleLinkedList.countBoy(1,2,5);
		//出圈队列应该为2-4-1-5-3

	}

}
//创建一个环形的单向链表
class CircleSingleLinkedList{
	//创建一个first结点，当前没有编号
	private Boy first =null;
	//添加小孩结点，构建成环形链表
	public void addBoy(int nums) {
		//nums做数据校验
		if(nums <1) {
			System.out.println("nums的值不正确！");
			return ;
		}
		Boy curBoy = null;//辅助指针，帮助构建环形链表
		//使用一个for循环创建环形链表
		for(int i =1;i<=nums;i++) {
			//根据编号创建小孩结点
			Boy boy = new Boy(i);
			//如果是第一个小孩
			if(i ==1) {
				first = boy;
			first.setNext(first);//构成环装
			curBoy =first;//指向第一个小孩
			}else {
			curBoy.setNext(boy);//
			boy.setNext(first);
			curBoy = boy;	
			}
			
		}
	}
	
	//遍历当前环形链表
	public void showBoy() {
		//判断链表是否为空
		if(first == null) {
			System.out.println("链表为空！");
		}
		//因为first不能动，仍然使用辅助指正完成遍历
		Boy curBoy = first;
		while(true) {
			System.out.printf("小孩编号%d\n",curBoy.getNo());
			if(curBoy.getNext() ==first) {//说明完成
				break;
			}
			curBoy =curBoy.getNext();//curBoy后移
		}
	}
	
	//根据用户的输入计算出出圈的顺序
	/**
	 * 
	 * @param startNo 表示从第几个小孩开始数数
	 * @param countNo 表示数几下
	 * @param nums 表示最初由多少小孩在在圈中
	 */
	public void countBoy(int startNo,int countNo,int nums) {
		//先对数据进行校验
		if(first == null ||startNo < 1 || startNo >nums) {
			System.out.print("参数输入有误，请重新输入~~~");
			return ;
		}
		//创建辅助指针，帮助小孩出圈
		Boy helper = first;
		//创建一个辅助结点（变量）helper，事先应该指向环形链表的最后一个结点
		while(true) {
			if(helper.getNext() == first) {//说明到了最后一个结点
				break ;
			}
			helper = helper.getNext();
		}
		//小孩报数前，想让first和helper移动k-1次
		for(int j =0;j < startNo -1;j++) {
			first = first.getNext();
			helper = helper.getNext();
		}
		//当小孩报数的时候，让first和helper同时移动m-1次,人后出圈
		//这里是一个循环操作，直到圈中只有一个人
		while(true) {
			if(helper == first) {//说明圈中只有一人
				break ;
			}
			//让first helper 同时移动countNum -1次
			for(int j =0;j < countNo -1;j++) {
				first = first.getNext();
				helper = helper.getNext();
			}
			//这是first指向的结点就是出圈的结点
			System.out.printf("小孩%d出圈\n",first.getNo());
			//将first指向小孩结点出圈
			first = first.getNext();
			helper.setNext(first) ;//
		}
		System.out.printf("最后留在圈中小孩编号为%d",first.getNo());
	}
}

//创建一个boy类，表示一个结点
class Boy{
	private int no;//编号
	private Boy next;//指向下一个结点。默认null
	
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
