package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {

	public static void main(String[] args) {
		
		//int[] arr = {-9,78,0,23,-567,70,-4,99,12658};
		
		//����һ�������80000��������
		int[] arr = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr[i] = (int) (Math.random() * 8000000);// ����һ����0,800000���������
		}
		
		System.out.println("�����������80000���ݣ�" );
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("����ǰʱ��=" + date1Str);
		
		
		quickSort(arr,0,arr.length-1);
		//System.out.printf("arr="+Arrays.toString(arr));
		
		Date data2 = new Date();
		String date2Str =simpleDateFormat.format(data2); 
		System.out.println("�����ʱ��="+date2Str);

	}
	public static void quickSort(int[] arr,int left,int right) {
		int l = left;//���±�
		int r =right;//���±�
		//prvote ����ֵ
		int pivot = arr[(left + right) / 2];
		int temp= 0;
		//whileѭ��Ŀ�����ñ�privotС�ķŵ�������ߣ�������ķŵ������ұ�
		while(l<r) {
			//��prvote�����һֱ�ң��ҵ����ڵ���pivote��ֵ�����˳�
			while(arr[l] <pivot) {
				l += 1;
			}
			//��prvote���ұ�һֱ�ң��ҵ�С�ڵ���pivote��ֵ�����˳�
			while(arr[r] > pivot) {
				r -= 1;
			}
			//�ˡ�=r������˵��privot���������ߵ�ֵ�Ѿ��������ȫ����С�ڵ���privot��ֵ��
			//�ұ�ȫ���Ǵ��ڵ���privtd��ֵ
			if(l >= r) {
				break;
			}
			
			//����
			temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
			
			//������������arr[l] == piove��r--��ǰ��
			if(arr[l]  == pivot) {
				r -= 1;
			}
			
			//������������arr[r] == piove,l++������
			if(arr[r]  == pivot) {
				l += 1;
			}
		}
		
		//���l == r��������l++,r--,�������ջ���
		if(l ==r) {
			l ++;
			r--;
		}
		
		//����ݹ�
		if(left < r) {
			quickSort(arr,left,r);
		}
		
		//���ҵݹ�
		if(right > l) {
			quickSort(arr,l,right);
		}
	}
}
