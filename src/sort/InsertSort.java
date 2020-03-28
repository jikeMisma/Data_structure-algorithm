package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {
	public static void main(String[] args) {
		//int[] arr = {101,34,119,1};
		//����һ�������80000��������
		int[] arr = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr[i] = (int) (Math.random() * 8000000);// ����һ����0,800000���������
		}
		
		//System.out.println("����ǰ~~~");
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str =simpleDateFormat.format(data1); 
		System.out.println("����ǰʱ��="+date1Str);
		//System.out.println(Arrays.toString(arr));
		insertSort(arr);
		
		Date data2 = new Date();
		String date2Str =simpleDateFormat.format(data2); 
		System.out.println("�����ʱ��="+date2Str);
	}

	//��������
	public static void insertSort(int[] arr) {
		//��һ��{101,34,119,1} =>{34,101,119,1}
		
		for(int i =1;i<arr.length;i++) {
			//������������
			int insertVal = arr[i];
			int insetIndex = i-1;//��arr[1]ǰ�������±�
			
			//��insetVal �ҵ������λ��
			//˵����
			//1.insertSort >= 0 ��֤��insetVal�Ҳ���λ�ã���Խ��
			//2.insertSort < arr[insertSort] �������������û���ҵ������λ��
			//3.����Ҫ�� arr[insertSort]����
			while(insetIndex >= 0 && insertVal <  arr[insetIndex]) {
				arr[insetIndex + 1] = arr[insetIndex];
				insetIndex--;
			}
			
			//���˳�whileѭ��ʱ�������λ���ҵ���insetIndex + 1
			
			//�ж���Ҫ�Ƿ�ֵ
			if(insetIndex +1 != i) {
				arr[insetIndex + 1] = insertVal;
			}
			
			//System.out.printf("��%d�ֺ�~~~\n",i);
			//System.out.println(Arrays.toString(arr));
		}
	}
}
