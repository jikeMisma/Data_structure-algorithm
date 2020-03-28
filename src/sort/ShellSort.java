package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {

	public static void main(String[] args) {
		//int[] arr = {8,9,1,7,2,3,5,4,6,0};
		
		//创建一个随机的80000个的数组
		int[] arr = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr[i] = (int) (Math.random() * 8000000);// 生成一个【0,800000】的随机数
		}

		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("排序前时间=" + date1Str);
				
		//shellSort(arr);
		shellSort2(arr);
		
		
		Date data2 = new Date();
		String date2Str =simpleDateFormat.format(data2); 
		System.out.println("排序后时间="+date2Str);
		
	}
	
	//使用逐步推导方式进行
	
	public static void shellSort(int[] arr) {
		int temp = 0;
		int count = 0;
		for(int gap = arr.length / 2;gap > 0;gap /= 2) {
			//希尔排序第一轮
			//因为第一轮是将数据分成了5组
			for(int i =gap;i<arr.length;i++) {
				//遍历各组中所有的元素
				for(int j = i-gap;j >= 0;j -= gap) {
					//如果当前元素大于加上步长后的那个元素，说明交换
					if(arr[j] > arr[j+gap]) {
						temp = arr[j];
						arr[j] = arr[j+gap];
						arr[j+gap] = temp;
					}
				}
			}
			//System.out.println("希尔排序"+(++count)+"轮后"+Arrays.toString(arr));
		}
	}
	
	// 对交换式的希尔排序算法进行优化 -> 移位法
	public static void shellSort2(int[] arr) {
		//增量，并逐步所系哦啊增量
		for(int gap = arr.length / 2;gap > 0;gap /= 2) {
			//从第gap个元素开始，逐个对其所在组进行直接插入排序
			for(int i =gap;i<arr.length;i++) {
				int j = i;
				int temp = arr[j];
				if(arr[j] < arr[i - gap]) {
					while(j - gap >= 0 && temp <arr[j - gap]) {
						//移动
						arr[j] = arr[j - gap];
						j -= gap;
					}
					//当退出while循环，temp找到插入位置
					arr[j] = temp;
				}
			}
		}
		
	}
}
