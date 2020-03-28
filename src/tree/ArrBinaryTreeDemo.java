/**
 * 	title:数组中顺序存储二叉树的
 * 	date: 2020.3.10
 */
package tree;

public class ArrBinaryTreeDemo {

	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5,6,7};
		
		//创建一个ArrBinaryTree对象
		ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
		arrBinaryTree.preOrder();
	}

}
//编写一个ArrBinaryTree，实现顺序遍历二叉树
class ArrBinaryTree{
	private int[] arr ;//存储数据结点的数组

	public ArrBinaryTree(int[] arr) {
		super();
		this.arr = arr;
	}
	
	//重载preOrder方法
	public void preOrder() {
		this.preOrder(0);
	}
	
	//编写一个方法，完成顺序存储儿二叉树的前序遍历
	/**
	 * 
	 * @param index 表示数组的下标
	 */
	public void preOrder(int index) {
		//如果数组为空，或者arr.length ==0
		if(arr == null || arr.length ==0) {
			System.out.println("数组为空，不能按照二叉树的前序遍历");
		}
		//输出当前这个元素
		System.out.printf(arr[index]+"\t");
		//向左递归遍历
		if(index * 2+1 <arr.length) {
			preOrder(index * 2 +1);
		}
		
		//向右递归遍历
		if (index * 2 + 2 < arr.length) {
			preOrder(index * 2 + 2);
		}
		
	}
}
