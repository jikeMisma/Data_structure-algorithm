/**
 *  title：基数排序（桶排序）
 *  date:2020.3.3
 */
package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RadixSort {

	public static void main(String[] args) {
		
		//int[] arr = {53, 3, 542, 748, 14, 214};
		
		//创建一个随机的80000个的数组
		int[] arr = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr[i] = (int) (Math.random() * 8000000);// 生成一个【0,800000】的随机数
		}

		System.out.println("基数排序时间测试");
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("排序前时间=" + date1Str);
		
		radixSort(arr);
		
		Date data2 = new Date();
		String date2Str =simpleDateFormat.format(data2); 
		System.out.println("排序后时间="+date2Str);

	}
	
	//基数排序方法
	public static void radixSort(int[] arr) {
		
		//1.得到数组中最大的位数
		int max = arr[0];//假设第一个数就是最大数
		for(int i = 1;i<arr.length;i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		//得到最大数的位数
		int maxLength = (max +"").length();
		
		//第1轮（针对元素的个位数进行处理）
		
		//定义一个二维数组，表示是个桶，每个桶就是一个一维数组
		//说明
		//1.二维数组包含10个一维数组
		//2.为了防止在放入数据的时候数据的溢出，灭个一维数组（桶）的大小定位arr.length
		//3.很明确，基数排序就是一个用空间换时间的经典算法
		
		int[][] bucket = new int[10][arr.length];
		
		//为了记录灭个桶中实际存放多多少个数据，我们定义一个一维数组来记录各个桶每次放入数据的个数
		//可以理解为
		//bucketRlemtCounts[0]记录的就是bucket[0]桶的放入的数据的个数
		int[] bucketElemtCounts = new int[10];
		
		
		//这里使用循环处理
		for(int i = 0,n = 1;i<maxLength;i++,n *= 10) {
			//针对每个元素对应的位进行排序，第一次为个位，第二次为十位，第三次为百位
			
			for(int j = 0;j < arr.length;j++) {
				//取出每个元素的个位数
				int digitofElement = arr[j] / n %10;
				//放入到对应的桶中
				bucket[digitofElement][bucketElemtCounts[digitofElement]] = arr[j];
				bucketElemtCounts[digitofElement] ++;
				
			}
			
			//按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
			int index = 0;
			//遍历每一个桶，并将桶中的数据放入到原来的数组中
			for(int k = 0;k< bucketElemtCounts.length;k++) {
				//如果桶中有数据，我们才放入原数组
				if(bucketElemtCounts[k] != 0) {
					//循环该桶，即第k个一维数组，放入
					for(int l = 0;l < bucketElemtCounts[k];l++) {
						//取出元素放入到arr
						arr[index++] = bucket[k][l];
						
					}
				}
				//第i+1轮处理后需要将每个bucketElemtCounts[k] =0！！！！
				bucketElemtCounts[k] = 0;
			}
			//System.out.println("第"+(i+1)+"轮，对个位的排序处理arr = "+ Arrays.toString(arr));
			
		}
		
	}

}
