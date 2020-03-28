/**
 * 	title:顺序查找
 *  date :2020.3.4
 */
package search;

public class SeqSearch {

	public static void main(String[] args) {
		
		int arr[] = {-1,34,25,15,17,33};
		
		int index = serSerch(arr,33);
		if(index == -1) {
			System.out.printf("没有找到！");
		}else {
			System.out.printf("查找到的数的下标为：%d",index);
		}
		

	}
	
	/**
	 * 这里我们的线性查找就是找到一个满足
	 * @param arr
	 * @param value
	 * @return
	 */
	public static int serSerch(int[] arr,int value) {
		//线性查找就是一一比对，发现有相同值就返回下标
		for(int i = 0;i < arr.length;i++) {
			if(arr[i] == value) {
				return i;
			}
		}
		return -1;
			
			
		}
}
