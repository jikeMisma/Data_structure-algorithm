package huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuddmanTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		int arr[] = {13,7,8,3,29,6,1};
		Node root = createHuffmanTree(arr);
		
		//����һ��
		preOrder(root);
	}
		
	//��дһ��ǰ������ķ���
	public static void preOrder(Node root) {
		if(root != null) {
			root.preOrder();
		}else {
			System.out.println("���������ܱ���");
		}
	}
	
	
	/**
	 * 	
	 * @param arr	��Ҫ�����ɺշ�����������
	 * @return	�����ú�շ������ĸ��ڵ�
	 */
	//�����շ������ķ���
	public static Node createHuffmanTree(int[] arr) {
		// TODO Auto-generated method stub
		//��һ����Ϊ�˲������㣬
		//1.����arr����
		//2.��arr��ÿ��Ԫ�ع�����һ��Node��
		//3.��node�ŵ�ArrayList�У����ڹ���
		List<Node> nodes = new ArrayList<Node>();
		for(int value:arr) {
			nodes.add(new Node(value));
		}
		
		//���������һ��ѭ���Ĺ���
		//�����ı�־��ArrayList��ֻ��һ��root���
		
		while(nodes.size() > 1) {
			//��Ҫ���򣬴�С����
			Collections.sort(nodes);
			
			//System.out.println("nodes="+nodes);
			
			//ȡ�����ڵ�Ȩֵ��С�Ķ�����
			//1.ȡ��Ȩֵ��С�Ķ�������㣨��Ϊ�Ƕ�������
			Node leftNode = nodes.get(0);
			//2.ȡ���ڶ�С�Ľ�㣨��Ϊ�Ƕ�������
			Node  rightNode= nodes.get(1);
			
			//3.����һ���µĶ�����
			Node parent = new Node(leftNode.value + rightNode.value);
			parent.left = leftNode;
			parent.right = rightNode;
			
			//4.��ArrayList��ɾ��������ö�����
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			
			//5.��parerent���뵽nodes
			nodes.add(parent);
		}
		
		//���غշ�������root���
		return nodes.get(0);
	}
}


//���������
//Ϊ����Node����֧������Collections��������
//��Nodeʵ��Comparble�ӿ�
class Node implements Comparable<Node>{
	int value;//���Ȩֵ
	Node left;//���ӽڵ�
	Node right;//���ӽڵ�
	
	//дһ��ǰ�����
	public void preOrder() {
		System.out.println(this);
		if(this.left !=null) {
			this.left.preOrder();
		}
		if(this.right !=null) {
			this.right.preOrder();
		}
	}
	
	public Node(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		// this.value-0.value��ʾ��С��������
		return this.value - o.value;
	}
	
}
