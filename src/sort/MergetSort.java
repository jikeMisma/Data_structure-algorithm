/**
 *   title���鲢����
 *   date��   2020.3.2
 */
package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MergetSort {

	public static void main(String[] args) {
		
		//int[] arr = {8,4,5,7,1,3,6,2};
		
		//����һ�������80000��������
		int[] arr = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr[i] = (int) (Math.random() * 8000000);// ����һ����0,800000���������
		}
		
		System.out.println("�鲢����ʱ�����");	
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("����ǰʱ��=" + date1Str);
				
			
		int[] temp = new int[arr.length];
		mergeSort(arr,0,arr.length - 1,temp);
		
		Date data2 = new Date();
		String date2Str =simpleDateFormat.format(data2); 
		System.out.println("�����ʱ��="+date2Str);
		
		//System.out.println("�鲢����� = "+Arrays.toString(arr));
	}
	
	
	//��+�ϵķ���
	public static void mergeSort(int[] arr,int left,int right,int[] temp) {
		if(left < right) {
			int mid = (left + right) / 2;//�м�����
			//����ݹ����
			mergeSort(arr,left,mid,temp);
			//���ҵݹ����
			mergeSort(arr,mid + 1,right,temp);
			//���˺ϲ�ʱ��ÿ�ֽ�һ�ξͺϲ�һ��
			merge(arr,left,mid,right,temp);
		}
	}
	//�ϲ��ķ���
	/**
	 * 
	 * @param arr �����ԭʼ����
	 * @param left ����������еĳ�ʼ����
	 * @param mid �м�����
	 * @param right �ұ�����
	 * @param temp ����ר����ʱ����
	 */
	public static  void merge(int[] arr,int left,int mid,int right,int[] temp) {
		int i = left;//��ʼ��i,����������еĳ�ʼ����
		int j = mid +1;//��ʼ��j,�ұ��������еĳ�ʼ����
		int t = 0;//ָ��temp����ĵ�ǰ����
		
		//��һ��
		//�Ȱ��������ߵ����ݰ��չ��򿽱���temp�У�ֱ������������һ�ߴ������
		while(i <= mid && j<= right) {
			//�������������еĵ�ǰԪ����������ұ��������еĵ�ǰԪ��
			//����ߵĵ�ǰԪ�ؿ�����temo����
			//Ȼ��t++��i++
			if(arr[i] <= arr[j]) {
				temp[t] = arr[i];
				t += 1;
				i += 1;
			}else {//��֮�����ұ��������еĵ�ǰԪ�ؿ�����temp����
				temp[t] = arr[j];
				t += 1;
				j += 1;
			}
		}
		
		//������
		//����ʣ�����ݵ�һ��������䵽temp��
		while(i <=mid) {//������л���ʣ��,ȫ����䵽temp
			temp[t] = arr[i];
			t += 1;
			i += 1;
			
		}
		
		while(j <=right) {//�ұ����л���ʣ��,ȫ����䵽temp
			temp[t] = arr[j];
			t += 1;
			j += 1;
			
		}
		//������
		//��temp��Ԫ�ؿ�����arr
		//ע�⣺������ÿ�ζ��������е�
		t = 0;
		int templeft = left;
		//System.out.println("templeft="+templeft+",right="+right);
		while(templeft <= right) {
			arr[templeft] = temp[t];
			t += 1;
			templeft += 1;
		}
		
	}

}
