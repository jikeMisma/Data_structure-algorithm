/**
 * problem: �㷨�����ݽṹѧϰ��18��-�ݹ飨3���˻ʺ�����
 * data:2020.2.25
 * address:home
 */
package recursion;

public class Queue8 {
	//����һ��max��ʾ�ж��ٸ��ʺ�
	int max = 8;
	//��������array������ʺ����λ�õĽ�� ���磺arr = {0 , 4, 7, 5, 2, 6, 1, 3} 
	int[] array = new int[max];
	static int count = 0;
	public static void main(String[] args) {
		
		//���԰˻ʺ��Ƿ���ȷ
		Queue8 queue8 = new Queue8();
		queue8.check(0);
		System.out.printf("һ����%d�ֽⷨ",count);
		
	}
	
	//��дһ�����������õ�n���ʺ�
	//�ر�ע�⣺check��ÿһ�εݹ�ʱ�����뵽check�ж���for(int i = 0;i< max;i++)����˻��л���
	private void check(int n) {
		if(n == max) {// ��==8,��ʵǰ�˸��ʺ���Ȼ�ź�
			print();
			return ;
		}
		
		//һ�η���ʺ󣬲��ж��Ƿ��ͻ
		for(int i = 0;i< max;i++) {
			//�Ȱѵ�ǰ����ʺ�ŵ����еĵ�1��
			array[n] = i;
			//�жϷ��õ�n���ʺ�i��ʱ���Ƿ��ͻ
			if(judge(n)) {//����ͻ
				//���ŷ�n+1��
				check(n+1);
			}
			
			//�����ͻ�ͻ����ִ��array[n] == i;������n���ʺ�����ڱ��к��Ƶ�һ��λ��
		}
	}
	
	//�鿴�������Ƿ��õ�n���ʺ��ʱ���ȥ���ûʺ��Ƿ��ǰ���Ѿ��ڷŵĻʺ��ͻ
	/**
	 * 
	 * @param n��ʾ��n���ʺ�
	 * @return                                                             
	 */
	private boolean judge(int n) {
		for(int i = 0;i<n;i++) {
			//array[i] == array[n]��ʾ�ж� ��n���ʺ��Ƿ��ǰ���n-1����ͬһ��
			//|Math.abs(n-i) ==  Math.abs(array[n] - array[i])�жϵ�n���ʺ�͵�i���ʺ��Ƿ���ͬһб��
			if(array[i] == array[n] ||Math.abs(n-i) ==  Math.abs(array[n] - array[i])) {
				return false;
		}
			
		}
		return true;
	}
	
	//дһ�����������Խ��ʺ�ڷŵ�λ�ý������
	private void print() {
		count++;
		for(int i = 0;i<array.length;i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
