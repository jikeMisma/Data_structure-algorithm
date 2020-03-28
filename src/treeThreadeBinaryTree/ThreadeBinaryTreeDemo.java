package treeThreadeBinaryTree;

public class ThreadeBinaryTreeDemo {

	public static void main(String[] args) {
		
		//��������������������
		
		HeroNode root = new HeroNode(1, "tom");
		HeroNode node2 = new HeroNode(3, "jack");
		HeroNode node3 = new HeroNode(6, "smith");
		HeroNode node4 = new HeroNode(8, "mary");
		HeroNode node5 = new HeroNode(10, "king");
		HeroNode node6 = new HeroNode(14, "dim");
		
		//��������������Ҫ�ݹ鴴���������ֶ�����
		root.setLeft(node2);
		root.setRight(node3);
		node2.setLeft(node4);
		node2.setRight(node5);
		node3.setLeft(node6);
		
		
		//����������
		ThreadeBinarTree threadeBinarTree = new ThreadeBinarTree();
		threadeBinarTree.setRoot(root);
		threadeBinarTree.threadeNodes();
		
		//���ԣ���10�Ų���
		HeroNode leftNode1=node5.getLeft();
		HeroNode rightNode1=node5.getRight();
		System.out.println("10�Ž���ǰ�����Ϊ="+leftNode1);
		System.out.println("10�Ž��ĺ�̽��Ϊ="+rightNode1);
		
		//������������������ʹ��ԭ���ı�����ʽ
		System.out.println("ʹ���������ķ�ʽ��������������");
		threadeBinarTree.threadeList();
		

	}

}

//����ThreadeBinarTreeʵ�������������ܵĶ�����
class ThreadeBinarTree{
	private HeroNode root;
	
	//Ϊ��ʵ������������Ҫ����һ����ǰ����ǰ������ָ��
	//�ڵݹ������������ʱ��pre���Ǳ���ǰһ�����
	private HeroNode pre = null;
	
	public void setRoot(HeroNode root) {
		this.root = root;
		
	}
	
	
	//�����������ķ���
	public void threadeNodes() {
		this.threadeNodes(root);
	}
	
	//������������������һ������
	public void threadeList() {
		//����һ���������洢��ǰ�����Ľ�㣬��root��ʼ
		HeroNode node = root;
		while(node !=null) {
			//ѭ�����ҵ�leftTYpe==1�Ľ��
			//�������ű������仯,��Ϊ��lieftType==1��ʱ��ýڵ��ǰ�����������������Ч���
			while(node.getLeftType() == 0) {
				node = node.getLeft();
			}
			//��ӡ��ǰ���
			System.out.println(node);
			//�����ǰ������ָ��ָ����Ǻ�̽�㣬��һֱ���
			while(node.getRightType() == 1) {
				//��ȡ��ǰ���ĺ�̽��
				node = node.getRight();
				System.out.println(node);
			}
			
			//�滻�����Ľ��
			node = node.getRight();
		}
	}
	
	//��д�Զ����������������ķ���
	/**
	 * 
	 * @param node	��Ҫ�������Ľ��
	 */
	public void threadeNodes(HeroNode node) {
		//���node == null����������
		if(node == null) {
			return ;
		}
		
		//��һ������������������
		threadeNodes(node.getLeft());
		//��������������ǰ���
		
		//����ǰ����ǰ�����
		if(node.getLeft() == null) {
			//�õ�ǰ������ָ��ָ��ǰ�����
			node.setLeft(pre);
			//�޸ĵ�ǰ������ָ������
			node.setLeftType(1);
		}
		
		//�����̽��
		if(pre !=null && pre.getRight() == null) {
			//��ǰ��������ָ��ָ��ǰ���
			pre.setRight(node);
			pre.setRightType(1);
		}
		
		//!!!!!!��Ҫ��ÿ�δ���һ�������õ�ǰ���ָ����һ������ǰ�����
		pre = node;
		//������������������
		threadeNodes(node.getRight());
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


//����HeroNode
//�ȴ���HeroNode���
class HeroNode {
	private int no;
	private String name;
	private HeroNode left;// Ĭ��null
	private HeroNode right;// Ĭ��null
	
	//������������
	//�涨��
	//1.���leftType==0����ʾָ�������������Ϊ1��ʾָ��ǰ�����
	//2.���rightType==0����ʾָ�������������Ϊ1��ʾָ���̽��
	private int leftType;
	private int rightType;
	
	

	public int getLeftType() {
		return leftType;
	}

	public void setLeftType(int leftType) {
		this.leftType = leftType;
	}

	public int getRightType() {
		return rightType;
	}

	public void setRightType(int rightType) {
		this.rightType = rightType;
	}

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

	// �ݹ�ɾ�����
	// �涨
	// 1.���ɾ���Ľڵ���Ҷ�ӽڵ㣬��ɾ���ýڵ�
	// 2.���ɾ���Ľڵ��Ƿ�Ҷ�ӽڵ㣬��ɾ��������
	public void delNode(int no) {
		/**
		 * ˼·�� 1.��Ϊ���ǵĶ������ǵ���ģ������������жϵ�ǰ�����ӽڵ��Ƿ�����Ҫɾ���Ľ�㣬�������жϵ�ǰ�Ľ���ǲ�����Ҫɾ���Ľ��
		 * 2.�����ǰ�Ľ������ӽڵ㲻Ϊ�գ��������ӽڵ����Ҫɾ���Ľ�㣬�ͽ�this.left = null;���ҷ��أ��ݹ�ɾ��������
		 * 3.�����ǰ�������ӽڵ㲻Ϊ�գ��������ӽڵ����Ҫɾ���Ľ�㣬�Ͱ��Ǹ�this.right = null;���Ҿͷ��أ������ݹ�ɾ����
		 * 4.�����2���͵�3��û��ɾ����㣬�����Ǿ���Ҫ���������ݹ�ɾ�� 5.�����4��Ҳû�� ɾ����㣬��Ӧ�������������еݹ�ɾ����
		 */
		// 2.�����ǰ�Ľ������ӽڵ㲻Ϊ�գ��������ӽڵ����Ҫɾ���Ľ�㣬�ͽ�this.left = null;���ҷ��أ��ݹ�ɾ��������
		if (this.left != null && this.left.no == no) {
			this.left = null;
			return;
		}
		// 3.�����ǰ�������ӽڵ㲻Ϊ�գ��������ӽڵ����Ҫɾ���Ľ�㣬�Ͱ��Ǹ�this.right = null;���Ҿͷ��أ������ݹ�ɾ����
		if (this.right != null && this.right.no == no) {
			this.right = null;
			return;
		}
		// 4.�����2���͵�3��û��ɾ����㣬�����Ǿ���Ҫ���������ݹ�ɾ��
		if (this.left != null) {
			this.left.delNode(no);
		}

		// 5.�����4��Ҳû�� ɾ����㣬��Ӧ�������������еݹ�ɾ����
		if (this.right != null) {
			this.right.delNode(no);
		}
	}

	// ��дǰ���������
	public void preOrder() {
		System.out.println(this);// ��������ڵ�
		// �ݹ���������������
		if (this.left != null) {
			this.left.preOrder();
		}
		// �ݹ���������������
		if (this.right != null) {
			this.right.preOrder();
		}
	}

	// �������
	public void infixOrder() {
		// �ݹ��������������
		if (this.left != null) {
			this.left.infixOrder();
		}
		// ������ڵ�
		System.out.println(this);
		// �ݹ����������������
		if (this.right != null) {
			this.right.infixOrder();
		}
	}

	// �������
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

	// ǰ���������
	/**
	 * 
	 * @param no Ҫ���ҵ�no
	 * @return ����ҵ��ͷ���node������Ҳ����ͷ���null
	 */
	public HeroNode preOrdersearch(int no) {
		System.out.println("ǰ�����ing");
		// �Ƚϵ�ǰ����ǲ���
		if (this.no == no) {
			return this;
		}

		// �жϵ�ǰ������ڵ��Ƿ�Ϊ�գ������Ϊ�գ���ݹ�ǰ�����
		// �����ݹ�ǰ������ҵ��ý�㣬�򷵻�
		HeroNode resNode = null;
		if (this.left != null) {
			resNode = this.left.preOrdersearch(no);
		}
		if (resNode != null) {// ˵���������ҵ�
			return resNode;
		}

		// 1.�����ݹ�ǰ������ҵ��ý�㣬�򷵻�
		// 2.�����ݹ�ǰ������ҵ��ý�㣬�򷵻أ�
		// ��������жϵ�ǰ�ڵ�����ӽڵ��Ƿ�Ϊ�գ������Ϊ�գ���������ҵݹ�ǰ�����
		if (this.right != null) {
			resNode = this.right.preOrdersearch(no);
		}
		return resNode;
	}

	// �����������
	public HeroNode infixOrdersearch(int no) {

		// ���жϵ�ǰ������ڵ��Ƿ�Ϊ�գ������Ϊ�գ���ݹ��������
		HeroNode resNode = null;
		if (this.left != null) {
			resNode = this.left.infixOrdersearch(no);
		}
		if (resNode != null) {
			return resNode;
		}
		// ����ҵ��ͷ��أ����û���ҵ��ͺ͵�ǰ������Ƚϣ��������򷵻ص�ǰ��㣬
		System.out.println("�������ing");
		if (this.no == no) {
			return this;
		}

		// ��������ҵݹ�����
		if (this.right != null) {
			resNode = this.right.infixOrdersearch(no);
		}

		return resNode;

	}

	// �����������
	public HeroNode postOrdersearch(int no) {

		// .�жϵ�ǰ������ڵ��Ƿ�Ϊ�գ������Ϊ�գ���ݹ�������
		HeroNode resNode = null;
		if (this.left != null) {
			resNode = this.left.postOrdersearch(no);
		}
		if (resNode != null) {
			return resNode;
		}

		// ���������û���ҵ����������������ݹ�������
		if (this.right != null) {
			resNode = this.right.postOrdersearch(no);
		}
		if (resNode != null) {
			return resNode;
		}

		// �������������û���ҵ����Ƚϵ�ǰ����ǲ���
		System.out.println("�������ing");
		if (this.no == no) {
			return this;
		}
		return resNode;

	}

}
