package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class PolandNotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�����׺���ʽת��Ϊ��׺���ʽ
		//˵����
		//1.1+((2+3)*4)-5ת���� 1 2 3 4 * + 5 -
		//2.��Ϊֱ�Ӷ�str�����˲����������㣬����Ȱ�����1+((2+3)*4)-5��=����׺���ʽ��Ӧ��list
		//�� ��1+((2+3)*4)-5�� =�� ArrayList[1,+,(,(,2,+,3,),*,4,),-,5]
		//���õ���List = �� ��׺���ʽ��Ӧ��List
		
		String dxpression = "1+((2+3)*4)-5";
		List<String> infixExpressionList = toInfixExpressionList(dxpression);
		System.out.println("��׺���ʽ��Ӧlist"+infixExpressionList);
		
		List<String> parseSuffixExpression = parseSuffixExpression(infixExpressionList);
		System.out.println("��׺���ʽ��Ӧlist"+parseSuffixExpression);
		
		System.out.printf("expression=%d\n",calculate(parseSuffixExpression));
		
		/*calculate
		//�ȶ���һ���沨�����ʽ
		//(3+4)x5-5 => 3 4 + 5 x 6 -
		//Ϊ�˷��㣬���ַ���֮���ÿո����
		String suffixExpression = "3 4 + 5 * 9 -";
		//˼·
		//1.�Ƚ�3 4 + 5 x 6 -�ŵ�ArrayList��
		//2.��ArrayList���ݸ�һ�����������������ջ����ɼ���
		
		List<String> rpnlist = getListString(suffixExpression);
		System.out.println("rpblist="+rpnlist);
		
		int res = calculate(rpnlist);
		System.out.println("����Ľ���ǣ�" + res);
		*/
		

	}
	
	//���������õ���List = �� ��׺���ʽ��Ӧ��List
	public static List<String> parseSuffixExpression(List<String> ls){
		//��������ջ
		Stack<String> s1 = new Stack<String>();//����ջ
		//˵������Ϊs2���ջ������ת��������û��pop�������������Ҫ�������������s2ʹ��ArrayList���s2
		//Stack<String> s2 = new Stack<String>();//����м�����ջ
		List<String> s2 = new ArrayList<String>();
		
		//����ls
		for(String item:ls) {
			//�����һ�������ͼ���s2
			if(item.matches("\\d+")) {
				s2.add(item);
			}else if(item.equals("(")) {
				s1.push(item);
			}else if(item.equals(")")) {
				// ����������š�)���������ε���s1ջ�������������ѹ��s2��ֱ������������Ϊֹ����ʱ����һ�����Ŷ���
				while(!s1.peek().equals("(")) {
					s2.add(s1.pop());
				}
				s1.pop();//!!! �����������s1���ջ
			}else {
				//��item�����ȼ�С�ڵ���ջ������������ȼ�����s1ջ������������������뵽s2�У��ٴ�ת��(4-1)��s1���µ�ջ���������Ƚϣ�
				//���⣺����ȱ��һ�����ȼ��ߵ͵ķ���
				while(s1.size() != 0 && Operation.getValue(s1.peek()) >=Operation.getValue(item) ) {
					s2.add(s1.pop());
				}
				//����Ҫ��itemѹ��ջ��
				s1.push(item);
			}
		}
		
		//��s1��ʣ�����������ε�����ѹ��s2
		while(s1.size() != 0) {
			s2.add(s1.pop());
		}
		
		return s2;//��Ϊ�Ǵ�ŵ�һ��list�У����Բ���Ҫ�������
	}
	
	
	//����������׺���ʽת�ɶ�Ӧ��list
	// s = 1+((2+3)*4)-5
	public static List<String> toInfixExpressionList(String s){
		//����һ��list�������׺���ʽ
		List<String> ls = new ArrayList<String>();
		int i = 0;//����һ��ָ�룬���ڱ�����׺���ʽ�ַ���
		String str;//�Զ�λ����ƴ��
		char c;//ÿ����һ���ַ��ͷŵ�c
		do {
			//����Ƿ����֣����뵽ls
			if((c = s.charAt(i)) <48  ||(c = s.charAt(i)) >57) {
				ls.add(""+c);
				i++;//i��Ҫ����
			}else {//�����һ���������Ƕ�λ��
				str = "";//�㽭strֵΪ��
				while(i<s.length() && (c = s.charAt(i))>= 48 &&  (c = s.charAt(i))<=57 ) {
					str += c;//ƴ��
					i++;
				}
				ls.add(str);
				
			}
		}while(i<s.length());
		return ls;
	}
	
	//��һ���Ȳ������ʽ���ν����ݺ���������뵽ArrayList��
	public static List<String> getListString(String suffixExpression){
		//��suffixExpression�ָ�
		String[] split = suffixExpression.split(" ");
		List<String> list = new ArrayList<String>();
		for(String ele:split) {
			list.add(ele);
		}
		return list;
		
	}
	//��ɶ��沨�����ʽ������
	/*
	 * ��������ɨ�裬��6��5��4��3ѹ���ջ
	����+���������˵���3��4��3Ϊջ��Ԫ�ء�4Ϊ��ջ��Ԫ�أ�������3+4��ֵ���õ�7���ٽ�7��ջ
	��������x���㣬��˵���5 �� 7������5x7 = 35���ٽ�35��ջ
	�����-������������35-6��ֵ���ɴ˵ó����ս��
	 */
	public static int calculate(List<String> ls) {
		//����һ��ջ��ֻ��Ҫһ��ջ����
		 Stack<String> stack = new Stack<String>();
		 //����ls
		 for(String item:ls) {
			 //ʹ��������ʽȡ����
			 if(item.matches("\\d")) {//ƥ���λ��
				 //��ջ
				 stack.push(item);
			 }else {
				 //pop�������������㣬����ջ
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
					 throw new RuntimeException("���������");
				 }
				 //��res��ջ
				 stack.push(res+"");
				 
			 }
		 }
		 //�������stack�е���Ϊ������
		 return Integer.parseInt(stack.pop());
	}


}

//��дһ����Operation ���Է���һ���������Ӧ�����ȼ�
class Operation{
	private static int ADD = 1;
	private static int SUB = 1;
	private static int MUL = 2;
	private static int DIV = 2;
	
	//дһ�����������ض�Ӧ�����ȼ�����
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
				System.out.println("�����ڸ������");
		}
		return result;
	}
}
