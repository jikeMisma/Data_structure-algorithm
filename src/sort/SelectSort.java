package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {

	public static void main(String[] args) {

		//int [] arr = {101, 34, 119, 1,154,45,2,158,22,5,3,5};
		
		//创建一个随机的80000个的数组
				int[] arr = new int[80000];
				for(int i =0;i<80000;i++) {
					arr[i] = (int)(Math.random()*8000000);//生成一个【0,800000】的随机数
				}
		System.out.println("排序前~~~");
		//System.out.println(Arrays.toString(arr));
		
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str =simpleDateFormat.format(data1); 
		System.out.println("排序前时间="+date1Str);
		
		selectSort(arr);
		
		System.out.println("排序后：~~~");
		//System.out.println(Arrays.toString(arr));
		
		
		Date data2 = new Date();
		String date2Str =simpleDateFormat.format(data2); 
		System.out.println("排序后时间="+date2Str);

	}
	
	//选择排序
	public static void selectSort(int[] arr) {
		//第一轮
		//原始数组：       101, 34, 119, 1
		//第一轮排序：       1, 34, 119, 101
		
		//第1轮
		//选择排序的时间复杂度也是O(n^2)
		for(int i = 0; i<arr.length-1;i++) {
			//先确定最小的索引
			int minIndex = i;
			int min = arr[i];
			for(int j = i+1;j<arr.length;j++) {
				if(min >arr[j]) {
					min = arr[j];//重置min
					minIndex = j;//重置index
				}
			}
			
			//将最小值放在arr[0],即交换
			if(minIndex != i) {
				arr[minIndex] = arr[i];
			arr[i] = min;
			}
			
			//System.out.println("第"+(i+1)+"轮后~~~");
			//System.out.println(Arrays.toString(arr));
		}
		
	}

}
