/**
 *  title:冒泡排序
 *  date: 2020.2.26
 */
package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbkeSort {

	public static void main(String[] args) {
		
		//int arr[] = {3,9,-1,10,-2};
		
		//为了容易理解，我们展示冒泡排序的演变过程
		//第一趟排序是将最大的数排在最后
		
		//测试冒泡排序的速度O(n^2)
		//创建一个随机的80000个的数组
		int[] arr = new int[80000];
		for(int i =0;i<80000;i++) {
			arr[i] = (int)(Math.random()*8000000);//生成一个【0,800000】的随机数
		}
		
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str =simpleDateFormat.format(data1); 
		System.out.println("排序前时间="+date1Str);
		
		//测试冒泡排序
		bubblSort(arr);
		//System.out.println("~~~排序后~~~：");
		//System.out.println(Arrays.toString(arr));
		
		Date data2 = new Date();
		String date2Str =simpleDateFormat.format(data2); 
		System.out.println("排序后时间="+date2Str);
		
		
		
		
		
	}
	//将前面的冒泡算法，封装成一个方法
	public static void bubblSort(int[] arr) {
		//时间复杂度为：O(n^2)
				int temp = 0;//临时变量
				boolean flag = false;//标识变量，表示是否进行了交换
				for(int i=0;i<arr.length-1;i++) {
					for(int j = 0;j<arr.length -1-i;j++) {
						//如果前面的数大鱼后面的就交换
						if(arr[j] > arr[j+1]) {
							flag = true;
							temp = arr[j];
							arr[j] = arr[j+1];
							arr[j+1] = temp;
						}
					}
					//System.out.printf("第%d趟排序后的数组\n",i+1);
					//System.out.println(Arrays.toString(arr));
					if(!flag) {//在一趟排序中一次交换都没有发生过
						break;
					}else {
						flag = false;//重置falg，进行下一次的交换
					}
				}
	}

}
