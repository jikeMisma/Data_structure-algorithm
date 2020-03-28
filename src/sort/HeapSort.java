/**
 * 	title:堆排序的实现
 * 	date：2020.3.12
 */
package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class HeapSort {

	public static void main(String[] args) {
		//要求将数组进行升序排列
		//int arr[] = {4,6,8,5,9,-1,90,3,-45,45};
		//创建一个随机的80000个的数组
		int[] arr = new int[800000];
		for (int i = 0; i < 800000; i++) {
			arr[i] = (int) (Math.random() * 800000);// 生成一个【0,800000】的随机数
		}
		System.out.println("排序前~~~");


		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("排序前时间=" + date1Str);
		
		heapSort(arr);
		

		Date data2 = new Date();
		String date2Str =simpleDateFormat.format(data2); 
		System.out.println("排序后时间="+date2Str);
	}

	//编写一个堆排序的方法
	public static void heapSort(int arr[]) {
		int temp = 0;
		System.out.println("堆排序！！！");
		
		//分布完成
		/*
		 * adjustHeap(arr,1,arr.length);
		 * System.out.println("第一次调整"+Arrays.toString(arr));
		 * 
		 * adjustHeap(arr,0,arr.length);
		 * System.out.println("第二次调整"+Arrays.toString(arr));
		 */
		
		//完成最终代码
		for(int i = arr.length/2 -1;i>=0;i--) {
			adjustHeap(arr,i,arr.length);
		}
		
		/**
		 * 2.将堆栈元素与末尾的元素交换，将最大元素沉到数组末端
		 * 3.重新调整结构，使其满足堆栈定义，然后继续交换栈顶元素与末尾元素，反复执行调整+交换步骤，直到整个序列有序
		 */
		for(int j = arr.length-1;j>0;j--) {
			//交换
			temp = arr[j];
			arr[j] = arr[0];
			arr[0] = temp;
			adjustHeap(arr,0,j);
		}
		//System.out.println("数组="+Arrays.toString(arr));
	}
	
	/**
	 * 功能：	完成将以i对应的非叶子结点的树调整成大顶堆
	 * @param arr	待调整的数组
	 * @param i	表示非叶子节点在数组中的索引
	 * @param length	表示对多少个元素进行调整，length在逐渐减少
	 */
	//将一个数组（二叉树），调整成一个大顶堆
	public  static void adjustHeap(int arr[],int i,int length) {
		
		int temp = arr[i];//先取出当前变量的值保存在临时变量
		//开始调整
		//说明
		// k = i*2+1表示k是i结点的左子节点
		for(int k = i*2+1;k<length;k=k*2+1) {
			if(k+1<length &&arr[k] < arr[k+1] ) {//说明左子节点的值小于右子节点的值
				k++;//k就指向右子节点
			}
			if(arr[k]>temp) {//如果子节点大于父节点
				arr[i] =arr[k];//把较大的值赋给当前结点
				i=k;//i指向k，继续循环比较
			}else {
				break;
			}
			
			//当for循环结束后，我们已经将以i为父节点的最大值，放在了最顶（局部的）
			arr[i] = temp;//将temp赋值到调整后的位置
			
			
		}
	}
}
