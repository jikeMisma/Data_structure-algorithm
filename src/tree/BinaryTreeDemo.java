package tree;

public class BinaryTreeDemo {

	public static void main(String[] args) {
		
		//需要创建一科二叉树
		BinartTree binartTree = new BinartTree();
		//创建需要的结点
		HeroNode root = new HeroNode(1,"宋江");
		HeroNode node2 = new HeroNode(2,"吴用");
		HeroNode node3 = new HeroNode(3,"卢俊义");
		HeroNode node4 = new HeroNode(4,"林冲");
		HeroNode node5 = new HeroNode(5,"关胜");
		
		
		
		//我们先手动创建二叉树
		root.setLeft(node2);
		root.setRight(node3);
		node3.setRight(node4);
		node3.setLeft(node5);
		binartTree.setRoot(root);
		/*
		 
		//测试：
		System.out.println("前序遍历");
		binartTree.preOrder();
		
		System.out.println("中序遍历");
		binartTree.infixOrder();
		
		System.out.println("后序遍历");
		binartTree.postOrder();
		
		//前序遍历
//		System.out.println("前序遍历方式查找");
//		HeroNode resNode = binartTree.preOrdersearch(5);
//		if(resNode !=null) {
//			System.out.printf("找到，信息为 no = %d name = %s",resNode.getNo(),resNode.getName());
//		}else {
//			System.out.printf("没有找到编号no = %d的英雄",5);
//		}
		
		//中序遍历
//		System.out.println("前序遍历方式查找");
//		HeroNode resNode = binartTree.infixOrdersearch(5);
//		if (resNode != null) {
//			System.out.printf("找到，信息为 no = %d name = %s", resNode.getNo(), resNode.getName());
//		} else {
//			System.out.printf("没有找到编号no = %d的英雄", 5);
//		}
		
		//后序遍历
		System.out.println("后序遍历方式查找");
		HeroNode resNode = binartTree.postOrdersearch(5);
		if (resNode != null) {
			System.out.printf("找到，信息为 no = %d name = %s", resNode.getNo(), resNode.getName());
		} else {
			System.out.printf("没有找到编号no = %d的英雄", 5);
		}
		
		*/
		
		//测试一把删除结点
		System.out.println("删除前，前序遍历");
		binartTree.preOrder();
		binartTree.delNode(3);
		System.out.println("删除后，前序遍历");
		binartTree.preOrder();

	}

}

//定义一个二叉树
class BinartTree{
	private HeroNode root;
	
	public void setRoot(HeroNode root) {
		this.root = root;
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

//先创建HeroNode结点
class HeroNode{
	private int no;
	private String name;
	private HeroNode left;//默认null
	private HeroNode right;//默认null
	
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
	
	//递归删除结点
	//规定
	//1.如果删除的节点是叶子节点，则删除该节点
	//2.如果删除的节点是非叶子节点，则删除该子树
	public void delNode(int no) {
		/**
		 * 思路：
		 *  1.因为我们的二叉树是单向的，所以我们是判断当前结点的子节点是否是需要删除的结点，而不能判断当前的结点是不是需要删除的结点
			2.如果当前的结点的做子节点不为空，并且左子节点就是要删除的结点，就将this.left = null;并且返回（递归删除结束）
			3.如果当前结点的右子节点不为空，并且右子节点就是要删除的结点，就爱那个this.right = null;并且就返回（结束递归删除）
			4.如果第2步和第3步没有删除结点，那我们就需要向左子树递归删除
			5.如果第4不也没有 删除结点，则应当向右子树进行递归删除。
		 */
		//2.如果当前的结点的做子节点不为空，并且左子节点就是要删除的结点，就将this.left = null;并且返回（递归删除结束）
		if(this.left !=null && this.left.no == no) {
			this.left = null;
			return ;
		}
		//3.如果当前结点的右子节点不为空，并且右子节点就是要删除的结点，就爱那个this.right = null;并且就返回（结束递归删除）
		if(this.right != null && this.right.no == no) {
			this.right = null;
			return ;
		}
		//4.如果第2步和第3步没有删除结点，那我们就需要向左子树递归删除
		if(this.left !=null) {
			this.left.delNode(no);
		}
		
		//5.如果第4不也没有 删除结点，则应当向右子树进行递归删除。
		if(this.right !=null) {
			this.right.delNode(no);
		}
	}
	
	//编写前序遍历方法
	public void preOrder() {
		System.out.println(this);//先输出父节点
		//递归向左子树序遍遍历
		if(this.left !=null) {
			this.left.preOrder();
		}
		//递归向右子树序遍遍历
		if(this.right !=null) {
			this.right.preOrder();
		}
	}
	
	//中序遍历
	public void infixOrder() {
		//递归左子树中序遍历
		if(this.left !=null) {
			this.left.infixOrder();
		}
		//输出父节点
		System.out.println(this);
		//递归向右子树中序遍历
		if(this.right !=null) {
			this.right.infixOrder();
		}
	}
	
	//后序遍历
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
	
	//前序遍历查找
	/**
	 * 
	 * @param no	要查找的no
	 * @return	如果找到就返回node，如果找不到就返回null
	 */
	public HeroNode preOrdersearch(int no) {
		System.out.println("前序遍历ing");
		//比较当前结点是不是
		if(this.no == no) {
			return this;
		}
		
		//判断当前结点的左节点是否为空，如果不为空，则递归前序查找
		//如果左递归前序查找找到该结点，则返回
		HeroNode resNode = null;
		if(this.left != null) {
			resNode = this.left.preOrdersearch(no);
		}
		if(resNode !=null) {//说明左子树找到
			return resNode;
		}
		
		//1.如果左递归前序查找找到该结点，则返回
		//2.如果左递归前序查找找到该结点，则返回，
		//否则继续判断当前节点的右子节点是否为空，如果不为空，则继续向右递归前序查找
		if(this.right != null) {
			resNode = this.right.preOrdersearch(no);
		}
		return resNode;
	}
	
	//中序遍历查找
	public HeroNode infixOrdersearch(int no) {
		
		//则判断当前结点的左节点是否为空，如果不为空，则递归中序查找
		HeroNode resNode = null;
		if(this.left !=null) {
			resNode = this.left.infixOrdersearch(no);
		}
		if(resNode != null) {
			return resNode;
		}
		//如果找到就返回，如果没有找到就和当前结点作比较，如果相等则返回当前结点，
		System.out.println("中序遍历ing");
		if(this.no == no) {
			return this;
		}
		
		//否则继续右递归中序
		if(this.right !=null) {
			resNode = this.right.infixOrdersearch(no);
		}
		
		return resNode;
		
	}
	
	//后序遍历查找
	public HeroNode postOrdersearch(int no) {
		
		//.判断当前结点的左节点是否为空，如果不为空，则递归后序查找
		HeroNode resNode = null;
		if(this.left != null) {
			resNode = this.left.postOrdersearch(no);
		}
		if(resNode != null) {
			return resNode ;
		}
		
		//如果左子树没有找到，继续向右子树递归后序查找
		if(this.right != null) {
			resNode = this.right.postOrdersearch(no);
		}
		if(resNode != null) {
			return resNode ;
		}
		
		//如果左右子树都没有找到，比较当前结点是不是
		System.out.println("后序遍历ing");
		if(this.no == no) {
			return this;
		}
		return resNode;

	}
	
}
