/**
 * 	title:�������ʵ��
 * 	date��2020.3.12
 */
package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class HeapSort {

	public static void main(String[] args) {
		//Ҫ�����������������
		//int arr[] = {4,6,8,5,9,-1,90,3,-45,45};
		//����һ�������80000��������
		int[] arr = new int[800000];
		for (int i = 0; i < 800000; i++) {
			arr[i] = (int) (Math.random() * 800000);// ����һ����0,800000���������
		}
		System.out.println("����ǰ~~~");


		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("����ǰʱ��=" + date1Str);
		
		heapSort(arr);
		

		Date data2 = new Date();
		String date2Str =simpleDateFormat.format(data2); 
		System.out.println("�����ʱ��="+date2Str);
	}

	//��дһ��������ķ���
	public static void heapSort(int arr[]) {
		int temp = 0;
		System.out.println("�����򣡣���");
		
		//�ֲ����
		/*
		 * adjustHeap(arr,1,arr.length);
		 * System.out.println("��һ�ε���"+Arrays.toString(arr));
		 * 
		 * adjustHeap(arr,0,arr.length);
		 * System.out.println("�ڶ��ε���"+Arrays.toString(arr));
		 */
		
		//������մ���
		for(int i = arr.length/2 -1;i>=0;i--) {
			adjustHeap(arr,i,arr.length);
		}
		
		/**
		 * 2.����ջԪ����ĩβ��Ԫ�ؽ����������Ԫ�س�������ĩ��
		 * 3.���µ����ṹ��ʹ�������ջ���壬Ȼ���������ջ��Ԫ����ĩβԪ�أ�����ִ�е���+�������裬ֱ��������������
		 */
		for(int j = arr.length-1;j>0;j--) {
			//����
			temp = arr[j];
			arr[j] = arr[0];
			arr[0] = temp;
			adjustHeap(arr,0,j);
		}
		//System.out.println("����="+Arrays.toString(arr));
	}
	
	/**
	 * ���ܣ�	��ɽ���i��Ӧ�ķ�Ҷ�ӽ����������ɴ󶥶�
	 * @param arr	������������
	 * @param i	��ʾ��Ҷ�ӽڵ��������е�����
	 * @param length	��ʾ�Զ��ٸ�Ԫ�ؽ��е�����length���𽥼���
	 */
	//��һ�����飨����������������һ���󶥶�
	public  static void adjustHeap(int arr[],int i,int length) {
		
		int temp = arr[i];//��ȡ����ǰ������ֵ��������ʱ����
		//��ʼ����
		//˵��
		// k = i*2+1��ʾk��i�������ӽڵ�
		for(int k = i*2+1;k<length;k=k*2+1) {
			if(k+1<length &&arr[k] < arr[k+1] ) {//˵�����ӽڵ��ֵС�����ӽڵ��ֵ
				k++;//k��ָ�����ӽڵ�
			}
			if(arr[k]>temp) {//����ӽڵ���ڸ��ڵ�
				arr[i] =arr[k];//�ѽϴ��ֵ������ǰ���
				i=k;//iָ��k������ѭ���Ƚ�
			}else {
				break;
			}
			
			//��forѭ�������������Ѿ�����iΪ���ڵ�����ֵ������������ֲ��ģ�
			arr[i] = temp;//��temp��ֵ���������λ��
			
			
		}
	}
}
