/**
 *   title：归并排序
 *   date：   2020.3.2
 */
package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MergetSort {

	public static void main(String[] args) {
		
		//int[] arr = {8,4,5,7,1,3,6,2};
		
		//创建一个随机的80000个的数组
		int[] arr = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr[i] = (int) (Math.random() * 8000000);// 生成一个【0,800000】的随机数
		}
		
		System.out.println("归并排序时间测试");	
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("排序前时间=" + date1Str);
				
			
		int[] temp = new int[arr.length];
		mergeSort(arr,0,arr.length - 1,temp);
		
		Date data2 = new Date();
		String date2Str =simpleDateFormat.format(data2); 
		System.out.println("排序后时间="+date2Str);
		
		//System.out.println("归并排序后 = "+Arrays.toString(arr));
	}
	
	
	//分+合的方法
	public static void mergeSort(int[] arr,int left,int right,int[] temp) {
		if(left < right) {
			int mid = (left + right) / 2;//中间索引
			//向左递归分析
			mergeSort(arr,left,mid,temp);
			//向右递归分析
			mergeSort(arr,mid + 1,right,temp);
			//到了合并时，每分解一次就合并一次
			merge(arr,left,mid,right,temp);
		}
	}
	//合并的方法
	/**
	 * 
	 * @param arr 排序的原始数组
	 * @param left 左边有序序列的初始索引
	 * @param mid 中间索引
	 * @param right 右边索引
	 * @param temp 做中专的临时数组
	 */
	public static  void merge(int[] arr,int left,int mid,int right,int[] temp) {
		int i = left;//初始化i,左边有序数列的初始索引
		int j = mid +1;//初始化j,右边有序数列的初始索引
		int t = 0;//指向temp数组的当前索引
		
		//（一）
		//先把左右两边的数据按照规则拷贝到temp中，直到左右两边有一边处理完毕
		while(i <= mid && j<= right) {
			//如果左边有序序列的当前元素下雨等于右边有序序列的当前元素
			//将左边的当前元素拷贝到temo数组
			//然后t++，i++
			if(arr[i] <= arr[j]) {
				temp[t] = arr[i];
				t += 1;
				i += 1;
			}else {//反之，将右边有序序列的当前元素拷贝到temp数组
				temp[t] = arr[j];
				t += 1;
				j += 1;
			}
		}
		
		//（二）
		//把有剩余数据的一方依次填充到temp中
		while(i <=mid) {//左边数列还有剩余,全部填充到temp
			temp[t] = arr[i];
			t += 1;
			i += 1;
			
		}
		
		while(j <=right) {//右边数列还有剩余,全部填充到temp
			temp[t] = arr[j];
			t += 1;
			j += 1;
			
		}
		//（三）
		//将temp的元素拷贝到arr
		//注意：并不是每次都拷贝所有的
		t = 0;
		int templeft = left;
		//System.out.println("templeft="+templeft+",right="+right);
		while(templeft <= right) {
			arr[templeft] = temp[t];
			t += 1;
			templeft += 1;
		}
		
	}

}
