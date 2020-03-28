package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class PolandNotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//完成中缀表达式转换为后缀表达式
		//说明：
		//1.1+((2+3)*4)-5转换成 1 2 3 4 * + 5 -
		//2.因为直接对str进行了操作，不方便，因此先阿静“1+((2+3)*4)-5”=》中缀表达式对应的list
		//即 “1+((2+3)*4)-5” =》 ArrayList[1,+,(,(,2,+,3,),*,4,),-,5]
		//将得到的List = 》 后缀表达式对应的List
		
		String dxpression = "1+((2+3)*4)-5";
		List<String> infixExpressionList = toInfixExpressionList(dxpression);
		System.out.println("中缀表达式对应list"+infixExpressionList);
		
		List<String> parseSuffixExpression = parseSuffixExpression(infixExpressionList);
		System.out.println("后缀表达式对应list"+parseSuffixExpression);
		
		System.out.printf("expression=%d\n",calculate(parseSuffixExpression));
		
		/*calculate
		//先定义一个逆波兰表达式
		//(3+4)x5-5 => 3 4 + 5 x 6 -
		//为了方便，数字符号之间用空格隔开
		String suffixExpression = "3 4 + 5 * 9 -";
		//思路
		//1.先将3 4 + 5 x 6 -放到ArrayList中
		//2.将ArrayList传递给一个方法，遍历，配合栈，完成计算
		
		List<String> rpnlist = getListString(suffixExpression);
		System.out.println("rpblist="+rpnlist);
		
		int res = calculate(rpnlist);
		System.out.println("计算的结果是：" + res);
		*/
		

	}
	
	//方法：将得到的List = 》 后缀表达式对应的List
	public static List<String> parseSuffixExpression(List<String> ls){
		//定义两个栈
		Stack<String> s1 = new Stack<String>();//符号栈
		//说明，因为s2这个栈在整个转换过程中没有pop操作，而且最后要逆序输出，所以s2使用ArrayList替代s2
		//Stack<String> s2 = new Stack<String>();//存放中间结果的栈
		List<String> s2 = new ArrayList<String>();
		
		//遍历ls
		for(String item:ls) {
			//如果是一个数，就加入s2
			if(item.matches("\\d+")) {
				s2.add(item);
			}else if(item.equals("(")) {
				s1.push(item);
			}else if(item.equals(")")) {
				// 如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
				while(!s1.peek().equals("(")) {
					s2.add(s1.pop());
				}
				s1.pop();//!!! 将这个（弹出s1这个栈
			}else {
				//当item的优先级小于等于栈顶运算符的优先级，将s1栈顶的运算符弹出并加入到s2中，再次转到(4-1)与s1中新的栈顶运算符相比较；
				//问题：我们缺少一个优先级高低的方法
				while(s1.size() != 0 && Operation.getValue(s1.peek()) >=Operation.getValue(item) ) {
					s2.add(s1.pop());
				}
				//还需要将item压入栈中
				s1.push(item);
			}
		}
		
		//将s1中剩余的运算符依次弹出并压入s2
		while(s1.size() != 0) {
			s2.add(s1.pop());
		}
		
		return s2;//因为是存放到一个list中，所以不需要逆序输出
	}
	
	
	//方法：将中缀表达式转成对应的list
	// s = 1+((2+3)*4)-5
	public static List<String> toInfixExpressionList(String s){
		//定义一个list，存放中缀表达式
		List<String> ls = new ArrayList<String>();
		int i = 0;//这是一个指针，用于遍历中缀表达式字符串
		String str;//对多位数的拼接
		char c;//每遍历一个字符就放到c
		do {
			//如果是非数字，加入到ls
			if((c = s.charAt(i)) <48  ||(c = s.charAt(i)) >57) {
				ls.add(""+c);
				i++;//i需要后移
			}else {//如果是一个数，考虑多位数
				str = "";//香江str值为空
				while(i<s.length() && (c = s.charAt(i))>= 48 &&  (c = s.charAt(i))<=57 ) {
					str += c;//拼接
					i++;
				}
				ls.add(str);
				
			}
		}while(i<s.length());
		return ls;
	}
	
	//将一个比波兰表达式依次将数据和运算符放入到ArrayList中
	public static List<String> getListString(String suffixExpression){
		//将suffixExpression分割
		String[] split = suffixExpression.split(" ");
		List<String> list = new ArrayList<String>();
		for(String ele:split) {
			list.add(ele);
		}
		return list;
		
	}
	//完成对逆波兰表达式的运算
	/*
	 * 从右至左扫描，将6、5、4、3压入堆栈
	遇到+运算符，因此弹出3、4（3为栈顶元素、4为次栈顶元素），计算3+4的值，得到7，再将7入栈
	接下来是x运算，因此弹出5 和 7，计算5x7 = 35，再将35入栈
	最后是-运算符，计算出35-6的值，由此得出最终结果
	 */
	public static int calculate(List<String> ls) {
		//创建一个栈，只需要一个栈即可
		 Stack<String> stack = new Stack<String>();
		 //遍历ls
		 for(String item:ls) {
			 //使用正则表达式取出数
			 if(item.matches("\\d")) {//匹配多位数
				 //入栈
				 stack.push(item);
			 }else {
				 //pop出两个数并运算，再入栈
				 int num2 = Integer.parseInt(stack.pop());
				 int num1 = Integer.parseInt(stack.pop());
				 int res = 0;
				 if(item.equals("+")) {
					 res = num1+num2;
				 }else if(item.equals("-")) {
					 res = num1 - num2;
				 }else if(item.equals("*")) {
					 res = num1 * num2;
				 }else if(item.equals("/")) {
					 res = num1 / num2;
				 }else {
					 throw new RuntimeException("运算符有误！");
				 }
				 //把res入栈
				 stack.push(res+"");
				 
			 }
		 }
		 //最后留在stack中的数为运算结果
		 return Integer.parseInt(stack.pop());
	}


}

//编写一个类Operation 可以返回一个运算符对应的优先级
class Operation{
	private static int ADD = 1;
	private static int SUB = 1;
	private static int MUL = 2;
	private static int DIV = 2;
	
	//写一个方法，返回对应的优先级数字
	public static int getValue(String operation) {
		int result = 0;
		switch(operation) {
		case "+":
			result = ADD;
			break;
		case "-":
			result = SUB;
			break;
		case "*":
			result = MUL;
			break;
		case "/":
			result = DIV;
			break;
			default:
				System.out.println("不存在该运算符");
		}
		return result;
	}
}
