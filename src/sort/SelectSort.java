package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {

	public static void main(String[] args) {

		//int [] arr = {101, 34, 119, 1,154,45,2,158,22,5,3,5};
		
		//����һ�������80000��������
				int[] arr = new int[80000];
				for(int i =0;i<80000;i++) {
					arr[i] = (int)(Math.random()*8000000);//����һ����0,800000���������
				}
		System.out.println("����ǰ~~~");
		//System.out.println(Arrays.toString(arr));
		
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str =simpleDateFormat.format(data1); 
		System.out.println("����ǰʱ��="+date1Str);
		
		selectSort(arr);
		
		System.out.println("�����~~~");
		//System.out.println(Arrays.toString(arr));
		
		
		Date data2 = new Date();
		String date2Str =simpleDateFormat.format(data2); 
		System.out.println("�����ʱ��="+date2Str);

	}
	
	//ѡ������
	public static void selectSort(int[] arr) {
		//��һ��
		//ԭʼ���飺       101, 34, 119, 1
		//��һ������       1, 34, 119, 101
		
		//��1��
		//ѡ�������ʱ�临�Ӷ�Ҳ��O(n^2)
		for(int i = 0; i<arr.length-1;i++) {
			//��ȷ����С������
			int minIndex = i;
			int min = arr[i];
			for(int j = i+1;j<arr.length;j++) {
				if(min >arr[j]) {
					min = arr[j];//����min
					minIndex = j;//����index
				}
			}
			
			//����Сֵ����arr[0],������
			if(minIndex != i) {
				arr[minIndex] = arr[i];
			arr[i] = min;
			}
			
			//System.out.println("��"+(i+1)+"�ֺ�~~~");
			//System.out.println(Arrays.toString(arr));
		}
		
	}

}
