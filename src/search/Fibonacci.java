package search;

import java.util.Arrays;

public class Fibonacci {

	public static int maxSize = 20;
	public static void main(String[] args) {
		
		int[] arr = {1,8,10,89,1000,1234};
		System.out.println("index = "+fibSerch(arr,1234));

	}
	
	//��Ϊ��������mid=low+F(k-1)+1����Ҫʹ�õ�쳲���������
	//�����Ҫ�Ȼ�ȡ��һ��쳲���������
	
	//�ǵݹ鷽���õ�һ��쳲���������
	public static int[] fib() {
		int[] f = new int[maxSize];
		f[0] = 1;
		f[1] = 1;
		for(int i =2;i<maxSize;i++) {
			f[i] = f[i-1]+f[i-2];
		}
		
		return f;
	}
	
	//쳲����������㷨
	//ʹ�÷ǵݹ鷽ʽ
	/**
	 * 
	 * @param arr	����
	 * @param key	������Ҫ�ҵĹؼ���
	 * @return 	�ҵ�������Ӧ���±꣬û�оͷ���-1
	 */
	public static int fibSerch(int[] arr,int key) {
		int low= 0;
		int heigh = arr.length-1;
		int k = 0;//����쳲������ָ���ֵ��Ӧ�±�
		int mid = 0;//���mid
		int f[] =fib();//��ȡ��쳲���������
		
		//��ȡ��쳲������ָ���ֵ��Ӧ�±�
		while(heigh >f[k] - 1) {
			k++;
		}
		
		//��Ϊf[k]��ֵ���ܴ������鳤�ȣ������Ҫʹ��Arrays�࣬����һ���µ����飬����ָ��a[];
		//����Ĳ���ʹ��0���
		int[] temp = Arrays.copyOf(arr,f[k]);
		
		for(int i = heigh +1;i<temp.length;i++) {
			temp[i] = arr[heigh];
		}
		
		//ʹ��whileѭ�������ҵ����ǵ�key
		while(low<=heigh) {//ֻҪ����������㣬�Ϳ���һֱ��
			mid = low+f[k - 1] - 1;
			if(key < temp[mid]) {//˵����Ҫ����������ǰ���֣���ߣ�����
				heigh = mid -1;
				k--;
			}else if(key > temp[mid]){//���Ҳ���
				low = mid +1;
				//Ϊʲôk-2��
				//��Ϊ�����f[k - 2]��Ԫ�أ����Կ��Ի������f[k -1] = f[k -3]+f[k - 4]
				k-=2;
			}else {//�ҵ�
				//��Ҫȷ�������ĸ��±�
				if(mid <= heigh) {
					return mid;
				}else {
					return heigh;
				}
			}
		}
		return -1;
	}

}
