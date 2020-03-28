/**
 * 	title:��ֵ�����㷨
 * 	date ��2020.3.5
 */
package search;

import java.util.Arrays;

public class InsertValueSearch {

	public static void main(String[] args) {

		int[] arr = new int[100];
		for(int i =1;i<= 100;i++) {
			arr[i-1] = i;
		}
		
		//����
		int res = inserValueSearch(arr,0,arr.length-1,67);
		System.out.println("res="+res);

	}
	
	//��д��ֵ����
	//��ֵ�����㷨ҲҪ�������������
	/**
	 * 
	 * @param arr ��������
	 * @param left �������
	 * @param right	�ұ�����
	 * @param findVla ����ֵ
	 * @return
	 */
	public static int inserValueSearch(int[] arr,int left,int right,int findVal) {
		//ע�⣺findVal < arr[0] || findVal > arr[arr.length - 1]���������У��������ǵõ���mid����Խ��
		if(left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
			return -1;
		}
		
		//���mid
		int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
		int midVal = arr[mid];
		
		if(findVal > midVal) {//˵�����Ҳ���
			return inserValueSearch(arr,mid + 1,right,findVal);
		}else if(findVal < midVal) {//˵���������
			return inserValueSearch(arr,left,mid -1,findVal);
			
		}else {
			return mid;
		}
		
	}

}
