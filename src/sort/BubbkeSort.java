/**
 *  title:ð������
 *  date: 2020.2.26
 */
package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbkeSort {

	public static void main(String[] args) {
		
		//int arr[] = {3,9,-1,10,-2};
		
		//Ϊ��������⣬����չʾð��������ݱ����
		//��һ�������ǽ��������������
		
		//����ð��������ٶ�O(n^2)
		//����һ�������80000��������
		int[] arr = new int[80000];
		for(int i =0;i<80000;i++) {
			arr[i] = (int)(Math.random()*8000000);//����һ����0,800000���������
		}
		
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str =simpleDateFormat.format(data1); 
		System.out.println("����ǰʱ��="+date1Str);
		
		//����ð������
		bubblSort(arr);
		//System.out.println("~~~�����~~~��");
		//System.out.println(Arrays.toString(arr));
		
		Date data2 = new Date();
		String date2Str =simpleDateFormat.format(data2); 
		System.out.println("�����ʱ��="+date2Str);
		
		
		
		
		
	}
	//��ǰ���ð���㷨����װ��һ������
	public static void bubblSort(int[] arr) {
		//ʱ�临�Ӷ�Ϊ��O(n^2)
				int temp = 0;//��ʱ����
				boolean flag = false;//��ʶ��������ʾ�Ƿ�����˽���
				for(int i=0;i<arr.length-1;i++) {
					for(int j = 0;j<arr.length -1-i;j++) {
						//���ǰ������������ľͽ���
						if(arr[j] > arr[j+1]) {
							flag = true;
							temp = arr[j];
							arr[j] = arr[j+1];
							arr[j+1] = temp;
						}
					}
					//System.out.printf("��%d������������\n",i+1);
					//System.out.println(Arrays.toString(arr));
					if(!flag) {//��һ��������һ�ν�����û�з�����
						break;
					}else {
						flag = false;//����falg��������һ�εĽ���
					}
				}
	}

}
