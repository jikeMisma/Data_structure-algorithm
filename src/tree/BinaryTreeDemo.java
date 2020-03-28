package tree;

public class BinaryTreeDemo {

	public static void main(String[] args) {
		
		//��Ҫ����һ�ƶ�����
		BinartTree binartTree = new BinartTree();
		//������Ҫ�Ľ��
		HeroNode root = new HeroNode(1,"�ν�");
		HeroNode node2 = new HeroNode(2,"����");
		HeroNode node3 = new HeroNode(3,"¬����");
		HeroNode node4 = new HeroNode(4,"�ֳ�");
		HeroNode node5 = new HeroNode(5,"��ʤ");
		
		
		
		//�������ֶ�����������
		root.setLeft(node2);
		root.setRight(node3);
		node3.setRight(node4);
		node3.setLeft(node5);
		binartTree.setRoot(root);
		/*
		 
		//���ԣ�
		System.out.println("ǰ�����");
		binartTree.preOrder();
		
		System.out.println("�������");
		binartTree.infixOrder();
		
		System.out.println("�������");
		binartTree.postOrder();
		
		//ǰ�����
//		System.out.println("ǰ�������ʽ����");
//		HeroNode resNode = binartTree.preOrdersearch(5);
//		if(resNode !=null) {
//			System.out.printf("�ҵ�����ϢΪ no = %d name = %s",resNode.getNo(),resNode.getName());
//		}else {
//			System.out.printf("û���ҵ����no = %d��Ӣ��",5);
//		}
		
		//�������
//		System.out.println("ǰ�������ʽ����");
//		HeroNode resNode = binartTree.infixOrdersearch(5);
//		if (resNode != null) {
//			System.out.printf("�ҵ�����ϢΪ no = %d name = %s", resNode.getNo(), resNode.getName());
//		} else {
//			System.out.printf("û���ҵ����no = %d��Ӣ��", 5);
//		}
		
		//�������
		System.out.println("���������ʽ����");
		HeroNode resNode = binartTree.postOrdersearch(5);
		if (resNode != null) {
			System.out.printf("�ҵ�����ϢΪ no = %d name = %s", resNode.getNo(), resNode.getName());
		} else {
			System.out.printf("û���ҵ����no = %d��Ӣ��", 5);
		}
		
		*/
		
		//����һ��ɾ�����
		System.out.println("ɾ��ǰ��ǰ�����");
		binartTree.preOrder();
		binartTree.delNode(3);
		System.out.println("ɾ����ǰ�����");
		binartTree.preOrder();

	}

}

//����һ��������
class BinartTree{
	private HeroNode root;
	
	public void setRoot(HeroNode root) {
		this.root = root;
	}
	
	//ɾ�����
	public void delNode(int no) {
		if(this.root != null) {
			//���ֻ��һ��root�������ж�root�ǲ��Ǿ�Ҫɾ���Ľ��
			if(root.getNo() == no) {
				root = null;
			}else {
				//�ݹ�ɾ��
				root.delNode(no);
			}
		}else {
			System.out.println("�����޷�ɾ��");
		}
	}
	
	//ǰ�����
	public void preOrder() {
		if(this.root != null) {
			this.root.preOrder();
		}else {
			System.out.println("������Ϊ�գ��޷�����");
		}
	}
	
	//�������
	public void infixOrder() {
		if(this.root != null) {
			this.root.infixOrder();
		}else {
			System.out.println("������Ϊ�գ��޷�����");
		}
	}
	
	//�������
	public void postOrder() {
		if(this.root != null) {
			this.root.postOrder();
		}else {
			System.out.println("������Ϊ�գ��޷�����");
		}
	}
	
	//����ǰ���������
	public HeroNode preOrdersearch(int no) {
		if(root != null) {
			return root.preOrdersearch(no);
		}else {
			return null;
		}
	}
	
	//���������������
	public HeroNode infixOrdersearch(int no) {
		if(root != null) {
			return root.infixOrdersearch(no);
		}else {
			return null;
		}
	}
	
	//���ú����������
		public HeroNode postOrdersearch(int no) {
			if(root != null) {
				return root.postOrdersearch(no);
			}else {
				return null;
			}
		}
}

//�ȴ���HeroNode���
class HeroNode{
	private int no;
	private String name;
	private HeroNode left;//Ĭ��null
	private HeroNode right;//Ĭ��null
	
	public HeroNode(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HeroNode getLeft() {
		return left;
	}

	public void setLeft(HeroNode left) {
		this.left = left;
	}

	public HeroNode getRight() {
		return right;
	}

	public void setRight(HeroNode right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + "]";
	}
	
	//�ݹ�ɾ�����
	//�涨
	//1.���ɾ���Ľڵ���Ҷ�ӽڵ㣬��ɾ���ýڵ�
	//2.���ɾ���Ľڵ��Ƿ�Ҷ�ӽڵ㣬��ɾ��������
	public void delNode(int no) {
		/**
		 * ˼·��
		 *  1.��Ϊ���ǵĶ������ǵ���ģ������������жϵ�ǰ�����ӽڵ��Ƿ�����Ҫɾ���Ľ�㣬�������жϵ�ǰ�Ľ���ǲ�����Ҫɾ���Ľ��
			2.�����ǰ�Ľ������ӽڵ㲻Ϊ�գ��������ӽڵ����Ҫɾ���Ľ�㣬�ͽ�this.left = null;���ҷ��أ��ݹ�ɾ��������
			3.�����ǰ�������ӽڵ㲻Ϊ�գ��������ӽڵ����Ҫɾ���Ľ�㣬�Ͱ��Ǹ�this.right = null;���Ҿͷ��أ������ݹ�ɾ����
			4.�����2���͵�3��û��ɾ����㣬�����Ǿ���Ҫ���������ݹ�ɾ��
			5.�����4��Ҳû�� ɾ����㣬��Ӧ�������������еݹ�ɾ����
		 */
		//2.�����ǰ�Ľ������ӽڵ㲻Ϊ�գ��������ӽڵ����Ҫɾ���Ľ�㣬�ͽ�this.left = null;���ҷ��أ��ݹ�ɾ��������
		if(this.left !=null && this.left.no == no) {
			this.left = null;
			return ;
		}
		//3.�����ǰ�������ӽڵ㲻Ϊ�գ��������ӽڵ����Ҫɾ���Ľ�㣬�Ͱ��Ǹ�this.right = null;���Ҿͷ��أ������ݹ�ɾ����
		if(this.right != null && this.right.no == no) {
			this.right = null;
			return ;
		}
		//4.�����2���͵�3��û��ɾ����㣬�����Ǿ���Ҫ���������ݹ�ɾ��
		if(this.left !=null) {
			this.left.delNode(no);
		}
		
		//5.�����4��Ҳû�� ɾ����㣬��Ӧ�������������еݹ�ɾ����
		if(this.right !=null) {
			this.right.delNode(no);
		}
	}
	
	//��дǰ���������
	public void preOrder() {
		System.out.println(this);//��������ڵ�
		//�ݹ���������������
		if(this.left !=null) {
			this.left.preOrder();
		}
		//�ݹ���������������
		if(this.right !=null) {
			this.right.preOrder();
		}
	}
	
	//�������
	public void infixOrder() {
		//�ݹ��������������
		if(this.left !=null) {
			this.left.infixOrder();
		}
		//������ڵ�
		System.out.println(this);
		//�ݹ����������������
		if(this.right !=null) {
			this.right.infixOrder();
		}
	}
	
	//�������
	public void postOrder() {
		// �ݹ��������������
		if (this.left != null) {
			this.left.postOrder();
		}
		// �ݹ����������������
		if (this.right != null) {
			this.right.postOrder();
		}
		// ������ڵ�
		System.out.println(this);
	}
	
	//ǰ���������
	/**
	 * 
	 * @param no	Ҫ���ҵ�no
	 * @return	����ҵ��ͷ���node������Ҳ����ͷ���null
	 */
	public HeroNode preOrdersearch(int no) {
		System.out.println("ǰ�����ing");
		//�Ƚϵ�ǰ����ǲ���
		if(this.no == no) {
			return this;
		}
		
		//�жϵ�ǰ������ڵ��Ƿ�Ϊ�գ������Ϊ�գ���ݹ�ǰ�����
		//�����ݹ�ǰ������ҵ��ý�㣬�򷵻�
		HeroNode resNode = null;
		if(this.left != null) {
			resNode = this.left.preOrdersearch(no);
		}
		if(resNode !=null) {//˵���������ҵ�
			return resNode;
		}
		
		//1.�����ݹ�ǰ������ҵ��ý�㣬�򷵻�
		//2.�����ݹ�ǰ������ҵ��ý�㣬�򷵻أ�
		//��������жϵ�ǰ�ڵ�����ӽڵ��Ƿ�Ϊ�գ������Ϊ�գ���������ҵݹ�ǰ�����
		if(this.right != null) {
			resNode = this.right.preOrdersearch(no);
		}
		return resNode;
	}
	
	//�����������
	public HeroNode infixOrdersearch(int no) {
		
		//���жϵ�ǰ������ڵ��Ƿ�Ϊ�գ������Ϊ�գ���ݹ��������
		HeroNode resNode = null;
		if(this.left !=null) {
			resNode = this.left.infixOrdersearch(no);
		}
		if(resNode != null) {
			return resNode;
		}
		//����ҵ��ͷ��أ����û���ҵ��ͺ͵�ǰ������Ƚϣ��������򷵻ص�ǰ��㣬
		System.out.println("�������ing");
		if(this.no == no) {
			return this;
		}
		
		//��������ҵݹ�����
		if(this.right !=null) {
			resNode = this.right.infixOrdersearch(no);
		}
		
		return resNode;
		
	}
	
	//�����������
	public HeroNode postOrdersearch(int no) {
		
		//.�жϵ�ǰ������ڵ��Ƿ�Ϊ�գ������Ϊ�գ���ݹ�������
		HeroNode resNode = null;
		if(this.left != null) {
			resNode = this.left.postOrdersearch(no);
		}
		if(resNode != null) {
			return resNode ;
		}
		
		//���������û���ҵ����������������ݹ�������
		if(this.right != null) {
			resNode = this.right.postOrdersearch(no);
		}
		if(resNode != null) {
			return resNode ;
		}
		
		//�������������û���ҵ����Ƚϵ�ǰ����ǲ���
		System.out.println("�������ing");
		if(this.no == no) {
			return this;
		}
		return resNode;

	}
	
}
