/**
 * 	title:插值查找算法
 * 	date ：2020.3.5
 */
package search;

import java.util.Arrays;

public class InsertValueSearch {

	public static void main(String[] args) {

		int[] arr = new int[100];
		for(int i =1;i<= 100;i++) {
			arr[i-1] = i;
		}
		
		//测试
		int res = inserValueSearch(arr,0,arr.length-1,67);
		System.out.println("res="+res);

	}
	
	//编写插值查找
	//插值查找算法也要求数组是有序的
	/**
	 * 
	 * @param arr 传入数组
	 * @param left 左边索引
	 * @param right	右边索引
	 * @param findVla 查找值
	 * @return
	 */
	public static int inserValueSearch(int[] arr,int left,int right,int findVal) {
		//注意：findVal < arr[0] || findVal > arr[arr.length - 1]条件必须有，否则我们得到的mid可能越界
		if(left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
			return -1;
		}
		
		//求出mid
		int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
		int midVal = arr[mid];
		
		if(findVal > midVal) {//说明向右查找
			return inserValueSearch(arr,mid + 1,right,findVal);
		}else if(findVal < midVal) {//说明向左查找
			return inserValueSearch(arr,left,mid -1,findVal);
			
		}else {
			return mid;
		}
		
	}

}
