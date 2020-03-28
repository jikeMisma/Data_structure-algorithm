package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {
	public static void main(String[] args) {
		//int[] arr = {101,34,119,1};
		//创建一个随机的80000个的数组
		int[] arr = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr[i] = (int) (Math.random() * 8000000);// 生成一个【0,800000】的随机数
		}
		
		//System.out.println("排序前~~~");
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str =simpleDateFormat.format(data1); 
		System.out.println("排序前时间="+date1Str);
		//System.out.println(Arrays.toString(arr));
		insertSort(arr);
		
		Date data2 = new Date();
		String date2Str =simpleDateFormat.format(data2); 
		System.out.println("排序后时间="+date2Str);
	}

	//插入排序
	public static void insertSort(int[] arr) {
		//第一轮{101,34,119,1} =>{34,101,119,1}
		
		for(int i =1;i<arr.length;i++) {
			//定义待插入的数
			int insertVal = arr[i];
			int insetIndex = i-1;//级arr[1]前面数的下标
			
			//给insetVal 找到插入的位置
			//说明：
			//1.insertSort >= 0 保证给insetVal找插入位置，不越界
			//2.insertSort < arr[insertSort] 待插入的数，还没有找到插入的位置
			//3.就需要将 arr[insertSort]后移
			while(insetIndex >= 0 && insertVal <  arr[insetIndex]) {
				arr[insetIndex + 1] = arr[insetIndex];
				insetIndex--;
			}
			
			//当退出while循环时，插入的位置找到，insetIndex + 1
			
			//判断需要是否赋值
			if(insetIndex +1 != i) {
				arr[insetIndex + 1] = insertVal;
			}
			
			//System.out.printf("第%d轮后~~~\n",i);
			//System.out.println(Arrays.toString(arr));
		}
	}
}
