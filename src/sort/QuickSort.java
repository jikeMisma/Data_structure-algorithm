package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {

	public static void main(String[] args) {
		
		//int[] arr = {-9,78,0,23,-567,70,-4,99,12658};
		
		//创建一个随机的80000个的数组
		int[] arr = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr[i] = (int) (Math.random() * 8000000);// 生成一个【0,800000】的随机数
		}
		
		System.out.println("快速排序测试80000数据：" );
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("排序前时间=" + date1Str);
		
		
		quickSort(arr,0,arr.length-1);
		//System.out.printf("arr="+Arrays.toString(arr));
		
		Date data2 = new Date();
		String date2Str =simpleDateFormat.format(data2); 
		System.out.println("排序后时间="+date2Str);

	}
	public static void quickSort(int[] arr,int left,int right) {
		int l = left;//左下标
		int r =right;//右下标
		//prvote 中轴值
		int pivot = arr[(left + right) / 2];
		int temp= 0;
		//while循环目的是让比privot小的放到他的左边，比他大的放到他的右边
		while(l<r) {
			//在prvote的左边一直找，找到大于等于pivote的值，才退出
			while(arr[l] <pivot) {
				l += 1;
			}
			//在prvote的右边一直找，找到小于等于pivote的值，才退出
			while(arr[r] > pivot) {
				r -= 1;
			}
			//了》=r成立，说明privot的左右两边的值已经按照左边全部是小于等于privot的值，
			//右边全部是大于等于privtd的值
			if(l >= r) {
				break;
			}
			
			//交换
			temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
			
			//如果交换完后发现arr[l] == piove，r--，前移
			if(arr[l]  == pivot) {
				r -= 1;
			}
			
			//如果交换完后发现arr[r] == piove,l++，后移
			if(arr[r]  == pivot) {
				l += 1;
			}
		}
		
		//如果l == r，必须让l++,r--,否则出现栈溢出
		if(l ==r) {
			l ++;
			r--;
		}
		
		//向左递归
		if(left < r) {
			quickSort(arr,left,r);
		}
		
		//向右递归
		if(right > l) {
			quickSort(arr,l,right);
		}
	}
}
