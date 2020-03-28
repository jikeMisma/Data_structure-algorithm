/**
 *  title����������Ͱ����
 *  date:2020.3.3
 */
package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RadixSort {

	public static void main(String[] args) {
		
		//int[] arr = {53, 3, 542, 748, 14, 214};
		
		//����һ�������80000��������
		int[] arr = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr[i] = (int) (Math.random() * 8000000);// ����һ����0,800000���������
		}

		System.out.println("��������ʱ�����");
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("����ǰʱ��=" + date1Str);
		
		radixSort(arr);
		
		Date data2 = new Date();
		String date2Str =simpleDateFormat.format(data2); 
		System.out.println("�����ʱ��="+date2Str);

	}
	
	//�������򷽷�
	public static void radixSort(int[] arr) {
		
		//1.�õ�����������λ��
		int max = arr[0];//�����һ�������������
		for(int i = 1;i<arr.length;i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		//�õ��������λ��
		int maxLength = (max +"").length();
		
		//��1�֣����Ԫ�صĸ�λ�����д���
		
		//����һ����ά���飬��ʾ�Ǹ�Ͱ��ÿ��Ͱ����һ��һά����
		//˵��
		//1.��ά�������10��һά����
		//2.Ϊ�˷�ֹ�ڷ������ݵ�ʱ�����ݵ���������һά���飨Ͱ���Ĵ�С��λarr.length
		//3.����ȷ�������������һ���ÿռ任ʱ��ľ����㷨
		
		int[][] bucket = new int[10][arr.length];
		
		//Ϊ�˼�¼���Ͱ��ʵ�ʴ�Ŷ���ٸ����ݣ����Ƕ���һ��һά��������¼����Ͱÿ�η������ݵĸ���
		//�������Ϊ
		//bucketRlemtCounts[0]��¼�ľ���bucket[0]Ͱ�ķ�������ݵĸ���
		int[] bucketElemtCounts = new int[10];
		
		
		//����ʹ��ѭ������
		for(int i = 0,n = 1;i<maxLength;i++,n *= 10) {
			//���ÿ��Ԫ�ض�Ӧ��λ�������򣬵�һ��Ϊ��λ���ڶ���Ϊʮλ��������Ϊ��λ
			
			for(int j = 0;j < arr.length;j++) {
				//ȡ��ÿ��Ԫ�صĸ�λ��
				int digitofElement = arr[j] / n %10;
				//���뵽��Ӧ��Ͱ��
				bucket[digitofElement][bucketElemtCounts[digitofElement]] = arr[j];
				bucketElemtCounts[digitofElement] ++;
				
			}
			
			//�������Ͱ��˳��(һά������±�����ȡ�����ݣ�����ԭ������)
			int index = 0;
			//����ÿһ��Ͱ������Ͱ�е����ݷ��뵽ԭ����������
			for(int k = 0;k< bucketElemtCounts.length;k++) {
				//���Ͱ�������ݣ����ǲŷ���ԭ����
				if(bucketElemtCounts[k] != 0) {
					//ѭ����Ͱ������k��һά���飬����
					for(int l = 0;l < bucketElemtCounts[k];l++) {
						//ȡ��Ԫ�ط��뵽arr
						arr[index++] = bucket[k][l];
						
					}
				}
				//��i+1�ִ������Ҫ��ÿ��bucketElemtCounts[k] =0��������
				bucketElemtCounts[k] = 0;
			}
			//System.out.println("��"+(i+1)+"�֣��Ը�λ��������arr = "+ Arrays.toString(arr));
			
		}
		
	}

}
