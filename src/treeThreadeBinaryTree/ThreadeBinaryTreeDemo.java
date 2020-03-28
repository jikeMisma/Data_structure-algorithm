package treeThreadeBinaryTree;

public class ThreadeBinaryTreeDemo {

	public static void main(String[] args) {
		
		//测试中序线索化二叉树
		
		HeroNode root = new HeroNode(1, "tom");
		HeroNode node2 = new HeroNode(3, "jack");
		HeroNode node3 = new HeroNode(6, "smith");
		HeroNode node4 = new HeroNode(8, "mary");
		HeroNode node5 = new HeroNode(10, "king");
		HeroNode node6 = new HeroNode(14, "dim");
		
		//二叉树后面我们要递归创建，现在手动创建
		root.setLeft(node2);
		root.setRight(node3);
		node2.setLeft(node4);
		node2.setRight(node5);
		node3.setLeft(node6);
		
		
		//测试线索化
		ThreadeBinarTree threadeBinarTree = new ThreadeBinarTree();
		threadeBinarTree.setRoot(root);
		threadeBinarTree.threadeNodes();
		
		//测试，以10号测试
		HeroNode leftNode1=node5.getLeft();
		HeroNode rightNode1=node5.getRight();
		System.out.println("10号结点的前驱结点为="+leftNode1);
		System.out.println("10号结点的后继结点为="+rightNode1);
		
		//当线索化二叉树后不能使用原来的遍历方式
		System.out.println("使用线索化的方式遍历线索二叉树");
		threadeBinarTree.threadeList();
		

	}

}

//定义ThreadeBinarTree实现了线索化功能的二叉树
class ThreadeBinarTree{
	private HeroNode root;
	
	//为了实现线索化，需要创建一个当前结点的前驱结点的指针
	//在递归进行线索化的时候，pre总是保留前一个结点
	private HeroNode pre = null;
	
	public void setRoot(HeroNode root) {
		this.root = root;
		
	}
	
	
	//重载线索化的方法
	public void threadeNodes() {
		this.threadeNodes(root);
	}
	
	//遍历线索化二叉树的一个方法
	public void threadeList() {
		//定义一个变量，存储当前遍历的结点，从root开始
		HeroNode node = root;
		while(node !=null) {
			//循环的找到leftTYpe==1的结点
			//后面随着遍历而变化,因为当lieftType==1的时候该节点是按着线索化处理后的有效结点
			while(node.getLeftType() == 0) {
				node = node.getLeft();
			}
			//打印当前结点
			System.out.println(node);
			//如果当前结点的有指针指向的是后继结点，就一直输出
			while(node.getRightType() == 1) {
				//获取当前结点的后继结点
				node = node.getRight();
				System.out.println(node);
			}
			
			//替换遍历的结点
			node = node.getRight();
		}
	}
	
	//编写对二叉树中序线索化的方法
	/**
	 * 
	 * @param node	需要线索化的结点
	 */
	public void threadeNodes(HeroNode node) {
		//如果node == null不能线索化
		if(node == null) {
			return ;
		}
		
		//（一），先线索化左子树
		threadeNodes(node.getLeft());
		//（二）线索化当前结点
		
		//处理当前结点的前驱结点
		if(node.getLeft() == null) {
			//让当前结点的左指针指向前驱结点
			node.setLeft(pre);
			//修改当前结点的左指针类型
			node.setLeftType(1);
		}
		
		//处理后继结点
		if(pre !=null && pre.getRight() == null) {
			//让前驱结点的右指针指向当前结点
			pre.setRight(node);
			pre.setRightType(1);
		}
		
		//!!!!!!重要：每次处理一个结点后，让当前结点指向下一个结点的前驱结点
		pre = node;
		//（三）线索化右子树
		threadeNodes(node.getRight());
	}
	//删除结点
	public void delNode(int no) {
		if(this.root != null) {
			//如果只有一个root，立即判断root是不是就要删除的结点
			if(root.getNo() == no) {
				root = null;
			}else {
				//递归删除
				root.delNode(no);
			}
		}else {
			System.out.println("空树无法删除");
		}
	}
	
	//前序遍历
	public void preOrder() {
		if(this.root != null) {
			this.root.preOrder();
		}else {
			System.out.println("二叉树为空，无法遍历");
		}
	}
	
	//中序遍历
	public void infixOrder() {
		if(this.root != null) {
			this.root.infixOrder();
		}else {
			System.out.println("二叉树为空，无法遍历");
		}
	}
	
	//后序遍历
	public void postOrder() {
		if(this.root != null) {
			this.root.postOrder();
		}else {
			System.out.println("二叉树为空，无法遍历");
		}
	}
	
	//调用前序遍历查找
	public HeroNode preOrdersearch(int no) {
		if(root != null) {
			return root.preOrdersearch(no);
		}else {
			return null;
		}
	}
	
	//调用中序遍历查找
	public HeroNode infixOrdersearch(int no) {
		if(root != null) {
			return root.infixOrdersearch(no);
		}else {
			return null;
		}
	}
	
	//调用后序遍历查找
		public HeroNode postOrdersearch(int no) {
			if(root != null) {
				return root.postOrdersearch(no);
			}else {
				return null;
			}
		}
}


//创建HeroNode
//先创建HeroNode结点
class HeroNode {
	private int no;
	private String name;
	private HeroNode left;// 默认null
	private HeroNode right;// 默认null
	
	//定义两个属性
	//规定：
	//1.如果leftType==0，表示指向左子树，如果为1表示指向前驱结点
	//2.如果rightType==0，表示指向右子树，如果为1表示指向后继结点
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

	// 递归删除结点
	// 规定
	// 1.如果删除的节点是叶子节点，则删除该节点
	// 2.如果删除的节点是非叶子节点，则删除该子树
	public void delNode(int no) {
		/**
		 * 思路： 1.因为我们的二叉树是单向的，所以我们是判断当前结点的子节点是否是需要删除的结点，而不能判断当前的结点是不是需要删除的结点
		 * 2.如果当前的结点的做子节点不为空，并且左子节点就是要删除的结点，就将this.left = null;并且返回（递归删除结束）
		 * 3.如果当前结点的右子节点不为空，并且右子节点就是要删除的结点，就爱那个this.right = null;并且就返回（结束递归删除）
		 * 4.如果第2步和第3步没有删除结点，那我们就需要向左子树递归删除 5.如果第4不也没有 删除结点，则应当向右子树进行递归删除。
		 */
		// 2.如果当前的结点的做子节点不为空，并且左子节点就是要删除的结点，就将this.left = null;并且返回（递归删除结束）
		if (this.left != null && this.left.no == no) {
			this.left = null;
			return;
		}
		// 3.如果当前结点的右子节点不为空，并且右子节点就是要删除的结点，就爱那个this.right = null;并且就返回（结束递归删除）
		if (this.right != null && this.right.no == no) {
			this.right = null;
			return;
		}
		// 4.如果第2步和第3步没有删除结点，那我们就需要向左子树递归删除
		if (this.left != null) {
			this.left.delNode(no);
		}

		// 5.如果第4不也没有 删除结点，则应当向右子树进行递归删除。
		if (this.right != null) {
			this.right.delNode(no);
		}
	}

	// 编写前序遍历方法
	public void preOrder() {
		System.out.println(this);// 先输出父节点
		// 递归向左子树序遍遍历
		if (this.left != null) {
			this.left.preOrder();
		}
		// 递归向右子树序遍遍历
		if (this.right != null) {
			this.right.preOrder();
		}
	}

	// 中序遍历
	public void infixOrder() {
		// 递归左子树中序遍历
		if (this.left != null) {
			this.left.infixOrder();
		}
		// 输出父节点
		System.out.println(this);
		// 递归向右子树中序遍历
		if (this.right != null) {
			this.right.infixOrder();
		}
	}

	// 后序遍历
	public void postOrder() {
		// 递归左子树后序遍历
		if (this.left != null) {
			this.left.postOrder();
		}
		// 递归向右子树后序遍历
		if (this.right != null) {
			this.right.postOrder();
		}
		// 输出父节点
		System.out.println(this);
	}

	// 前序遍历查找
	/**
	 * 
	 * @param no 要查找的no
	 * @return 如果找到就返回node，如果找不到就返回null
	 */
	public HeroNode preOrdersearch(int no) {
		System.out.println("前序遍历ing");
		// 比较当前结点是不是
		if (this.no == no) {
			return this;
		}

		// 判断当前结点的左节点是否为空，如果不为空，则递归前序查找
		// 如果左递归前序查找找到该结点，则返回
		HeroNode resNode = null;
		if (this.left != null) {
			resNode = this.left.preOrdersearch(no);
		}
		if (resNode != null) {// 说明左子树找到
			return resNode;
		}

		// 1.如果左递归前序查找找到该结点，则返回
		// 2.如果左递归前序查找找到该结点，则返回，
		// 否则继续判断当前节点的右子节点是否为空，如果不为空，则继续向右递归前序查找
		if (this.right != null) {
			resNode = this.right.preOrdersearch(no);
		}
		return resNode;
	}

	// 中序遍历查找
	public HeroNode infixOrdersearch(int no) {

		// 则判断当前结点的左节点是否为空，如果不为空，则递归中序查找
		HeroNode resNode = null;
		if (this.left != null) {
			resNode = this.left.infixOrdersearch(no);
		}
		if (resNode != null) {
			return resNode;
		}
		// 如果找到就返回，如果没有找到就和当前结点作比较，如果相等则返回当前结点，
		System.out.println("中序遍历ing");
		if (this.no == no) {
			return this;
		}

		// 否则继续右递归中序
		if (this.right != null) {
			resNode = this.right.infixOrdersearch(no);
		}

		return resNode;

	}

	// 后序遍历查找
	public HeroNode postOrdersearch(int no) {

		// .判断当前结点的左节点是否为空，如果不为空，则递归后序查找
		HeroNode resNode = null;
		if (this.left != null) {
			resNode = this.left.postOrdersearch(no);
		}
		if (resNode != null) {
			return resNode;
		}

		// 如果左子树没有找到，继续向右子树递归后序查找
		if (this.right != null) {
			resNode = this.right.postOrdersearch(no);
		}
		if (resNode != null) {
			return resNode;
		}

		// 如果左右子树都没有找到，比较当前结点是不是
		System.out.println("后序遍历ing");
		if (this.no == no) {
			return this;
		}
		return resNode;

	}

}
