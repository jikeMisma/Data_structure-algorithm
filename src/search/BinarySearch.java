/**
 * 	title:二分查找
 * 	date :2020.3.4
 */
package search;

import java.util.ArrayList;
import java.util.List;

//注意：使用二分查找的数组必须是有序的
public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = {1,8,11,15,18,18,18,18,18,18,26,99,10245};
		
		//int resIndex = binarySearch(arr,0,arr.length - 1,999);
		//System.out.printf("resIndex=%d\n",resIndex);
		
		List<Integer>  resIndexList = binarySearch2(arr,0,arr.length - 1,18);
		System.out.println("resIndex="+resIndexList);
		

	}
	
	//二分查找算法
	/**
	 * 
	 * @param arr	数组
	 * @param left	左边的索引
	 * @param right	右边的索引
	 * @param findVal 要查找的值
	 * @return	如果找到就返回下标，如果没有，就返回-1；
	 */
	public static int binarySearch(int[] arr,int left,int right,int findVal) {
		
		//当left > right ，说明帝国了整个数组，但是没有找到
		if(left > right ) {
			return -1;
		}
		int mid = (left + right) /2;
		int midVal = arr[mid];
		
		if(findVal > midVal) {//向右递归
			return binarySearch(arr,mid+1,right,findVal);
		}else if(findVal <midVal) {//向左递归
			return binarySearch(arr,left,mid -1 ,findVal);
		}
		else {
			return mid;
		}
	}
	
	//完成有重复数据的二分查找
	//{1,8, 10, 89, 1000, 1000，1234} 当一个有序数组中，有多个相同的数值时，如何将所有的数值都查找到，比如这里的 1000.
	
	/**
	 * 思路分析
	 * 1.在找到mid索引值时，不要马上返回
	 * 2.向mid的左边扫描，将所有满足1000的元素的下标，加入到Arrylist
	 * 3.想mid的右边扫描，将所有满足1000的下标加入到Arryllist
	 * 4.将Arrylist返回
	 */
	
	public static ArrayList<Integer>  binarySearch2(int[] arr,int left,int right,int findVal) {
		
		//当left > right ，说明帝国了整个数组，但是没有找到
		if(left > right ) {
			return new ArrayList<Integer>();
		}
		int mid = (left + right) /2;
		int midVal = arr[mid];
		
		if(findVal > midVal) {//向右递归
			return binarySearch2(arr,mid+1,right,findVal);
		}else if(findVal <midVal) {//向左递归
			return binarySearch2(arr,left,mid -1 ,findVal);
		}
		else {
//			 * 1.在找到mid索引值时，不要马上返回
//			 * 2.向mid的左边扫描，将所有满足1000的元素的下标，加入到Arrylist
//			 * 3.想mid的右边扫描，将所有满足1000的下标加入到Arryllist
//			 * 4.将Arrylist返回
			
			ArrayList<Integer> resIndexList = new ArrayList<Integer>();
			
			int  temp = mid -1;
			while(true) {
				if(temp <0 || arr[temp] != findVal) {
					break;
				}
				
				//否则就把temp放入集合中
				resIndexList.add(temp);
				temp -= 1;//temp左移动
			}
			resIndexList.add(mid);
			
			//.想mid的右边扫描，将所有满足1000的下标加入到Arryllist
			temp = mid +1;
			while(true) {
				if(temp >arr.length-1 || arr[temp] != findVal) {
					break;
				}
				
				//否则就把temp放入集合中
				resIndexList.add(temp);
				temp += 1;//temp左移动
			}
			return resIndexList;
			
		}
	}
		

}
