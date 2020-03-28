/**
 * problem: 算法与数据结构学习（18）-递归（3）八皇后问题
 * data:2020.2.25
 * address:home
 */
package recursion;

public class Queue8 {
	//定义一个max表示有多少个皇后
	int max = 8;
	//定义数组array，保存皇后放置位置的结果 例如：arr = {0 , 4, 7, 5, 2, 6, 1, 3} 
	int[] array = new int[max];
	static int count = 0;
	public static void main(String[] args) {
		
		//测试八皇后是否正确
		Queue8 queue8 = new Queue8();
		queue8.check(0);
		System.out.printf("一共有%d种解法",count);
		
	}
	
	//编写一个方法，放置第n个皇后
	//特别注意：check是每一次递归时，进入到check中都有for(int i = 0;i< max;i++)，因此会有回溯
	private void check(int n) {
		if(n == max) {// 你==8,其实前八个皇后已然放好
			print();
			return ;
		}
		
		//一次放入皇后，并判断是否冲突
		for(int i = 0;i< max;i++) {
			//先把当前这个皇后放到改行的第1列
			array[n] = i;
			//判断放置第n个皇后i列时，是否冲突
			if(judge(n)) {//不冲突
				//接着放n+1个
				check(n+1);
			}
			
			//如果冲突就会继续执行array[n] == i;即将第n个皇后放置在本行后移的一个位置
		}
	}
	
	//查看，当我们放置第n个皇后的时候就去检测该皇后是否和前面已经摆放的皇后冲突
	/**
	 * 
	 * @param n表示第n个皇后
	 * @return                                                             
	 */
	private boolean judge(int n) {
		for(int i = 0;i<n;i++) {
			//array[i] == array[n]表示判断 第n个皇后是否和前面的n-1个在同一列
			//|Math.abs(n-i) ==  Math.abs(array[n] - array[i])判断第n个皇后和第i个皇后是否在同一斜线
			if(array[i] == array[n] ||Math.abs(n-i) ==  Math.abs(array[n] - array[i])) {
				return false;
		}
			
		}
		return true;
	}
	
	//写一个方法，可以将皇后摆放的位置进行输出
	private void print() {
		count++;
		for(int i = 0;i<array.length;i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
