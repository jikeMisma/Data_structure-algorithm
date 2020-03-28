/**
 * 	title:���ֲ���
 * 	date :2020.3.4
 */
package search;

import java.util.ArrayList;
import java.util.List;

//ע�⣺ʹ�ö��ֲ��ҵ���������������
public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = {1,8,11,15,18,18,18,18,18,18,26,99,10245};
		
		//int resIndex = binarySearch(arr,0,arr.length - 1,999);
		//System.out.printf("resIndex=%d\n",resIndex);
		
		List<Integer>  resIndexList = binarySearch2(arr,0,arr.length - 1,18);
		System.out.println("resIndex="+resIndexList);
		

	}
	
	//���ֲ����㷨
	/**
	 * 
	 * @param arr	����
	 * @param left	��ߵ�����
	 * @param right	�ұߵ�����
	 * @param findVal Ҫ���ҵ�ֵ
	 * @return	����ҵ��ͷ����±꣬���û�У��ͷ���-1��
	 */
	public static int binarySearch(int[] arr,int left,int right,int findVal) {
		
		//��left > right ��˵���۹����������飬����û���ҵ�
		if(left > right ) {
			return -1;
		}
		int mid = (left + right) /2;
		int midVal = arr[mid];
		
		if(findVal > midVal) {//���ҵݹ�
			return binarySearch(arr,mid+1,right,findVal);
		}else if(findVal <midVal) {//����ݹ�
			return binarySearch(arr,left,mid -1 ,findVal);
		}
		else {
			return mid;
		}
	}
	
	//������ظ����ݵĶ��ֲ���
	//{1,8, 10, 89, 1000, 1000��1234} ��һ�����������У��ж����ͬ����ֵʱ����ν����е���ֵ�����ҵ������������ 1000.
	
	/**
	 * ˼·����
	 * 1.���ҵ�mid����ֵʱ����Ҫ���Ϸ���
	 * 2.��mid�����ɨ�裬����������1000��Ԫ�ص��±꣬���뵽Arrylist
	 * 3.��mid���ұ�ɨ�裬����������1000���±���뵽Arryllist
	 * 4.��Arrylist����
	 */
	
	public static ArrayList<Integer>  binarySearch2(int[] arr,int left,int right,int findVal) {
		
		//��left > right ��˵���۹����������飬����û���ҵ�
		if(left > right ) {
			return new ArrayList<Integer>();
		}
		int mid = (left + right) /2;
		int midVal = arr[mid];
		
		if(findVal > midVal) {//���ҵݹ�
			return binarySearch2(arr,mid+1,right,findVal);
		}else if(findVal <midVal) {//����ݹ�
			return binarySearch2(arr,left,mid -1 ,findVal);
		}
		else {
//			 * 1.���ҵ�mid����ֵʱ����Ҫ���Ϸ���
//			 * 2.��mid�����ɨ�裬����������1000��Ԫ�ص��±꣬���뵽Arrylist
//			 * 3.��mid���ұ�ɨ�裬����������1000���±���뵽Arryllist
//			 * 4.��Arrylist����
			
			ArrayList<Integer> resIndexList = new ArrayList<Integer>();
			
			int  temp = mid -1;
			while(true) {
				if(temp <0 || arr[temp] != findVal) {
					break;
				}
				
				//����Ͱ�temp���뼯����
				resIndexList.add(temp);
				temp -= 1;//temp���ƶ�
			}
			resIndexList.add(mid);
			
			//.��mid���ұ�ɨ�裬����������1000���±���뵽Arryllist
			temp = mid +1;
			while(true) {
				if(temp >arr.length-1 || arr[temp] != findVal) {
					break;
				}
				
				//����Ͱ�temp���뼯����
				resIndexList.add(temp);
				temp += 1;//temp���ƶ�
			}
			return resIndexList;
			
		}
	}
		

}
