/**
 * 	title:˳�����
 *  date :2020.3.4
 */
package search;

public class SeqSearch {

	public static void main(String[] args) {
		
		int arr[] = {-1,34,25,15,17,33};
		
		int index = serSerch(arr,33);
		if(index == -1) {
			System.out.printf("û���ҵ���");
		}else {
			System.out.printf("���ҵ��������±�Ϊ��%d",index);
		}
		

	}
	
	/**
	 * �������ǵ����Բ��Ҿ����ҵ�һ������
	 * @param arr
	 * @param value
	 * @return
	 */
	public static int serSerch(int[] arr,int value) {
		//���Բ��Ҿ���һһ�ȶԣ���������ֵͬ�ͷ����±�
		for(int i = 0;i < arr.length;i++) {
			if(arr[i] == value) {
				return i;
			}
		}
		return -1;
			
			
		}
}
