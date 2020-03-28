package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {

	public static void main(String[] args) {
		//int[] arr = {8,9,1,7,2,3,5,4,6,0};
		
		//����һ�������80000��������
		int[] arr = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr[i] = (int) (Math.random() * 8000000);// ����һ����0,800000���������
		}

		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("����ǰʱ��=" + date1Str);
				
		//shellSort(arr);
		shellSort2(arr);
		
		
		Date data2 = new Date();
		String date2Str =simpleDateFormat.format(data2); 
		System.out.println("�����ʱ��="+date2Str);
		
	}
	
	//ʹ�����Ƶ���ʽ����
	
	public static void shellSort(int[] arr) {
		int temp = 0;
		int count = 0;
		for(int gap = arr.length / 2;gap > 0;gap /= 2) {
			//ϣ�������һ��
			//��Ϊ��һ���ǽ����ݷֳ���5��
			for(int i =gap;i<arr.length;i++) {
				//�������������е�Ԫ��
				for(int j = i-gap;j >= 0;j -= gap) {
					//�����ǰԪ�ش��ڼ��ϲ�������Ǹ�Ԫ�أ�˵������
					if(arr[j] > arr[j+gap]) {
						temp = arr[j];
						arr[j] = arr[j+gap];
						arr[j+gap] = temp;
					}
				}
			}
			//System.out.println("ϣ������"+(++count)+"�ֺ�"+Arrays.toString(arr));
		}
	}
	
	// �Խ���ʽ��ϣ�������㷨�����Ż� -> ��λ��
	public static void shellSort2(int[] arr) {
		//������������ϵŶ������
		for(int gap = arr.length / 2;gap > 0;gap /= 2) {
			//�ӵ�gap��Ԫ�ؿ�ʼ������������������ֱ�Ӳ�������
			for(int i =gap;i<arr.length;i++) {
				int j = i;
				int temp = arr[j];
				if(arr[j] < arr[i - gap]) {
					while(j - gap >= 0 && temp <arr[j - gap]) {
						//�ƶ�
						arr[j] = arr[j - gap];
						j -= gap;
					}
					//���˳�whileѭ����temp�ҵ�����λ��
					arr[j] = temp;
				}
			}
		}
		
	}
}
