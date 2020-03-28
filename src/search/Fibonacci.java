package search;

import java.util.Arrays;

public class Fibonacci {

	public static int maxSize = 20;
	public static void main(String[] args) {
		
		int[] arr = {1,8,10,89,1000,1234};
		System.out.println("index = "+fibSerch(arr,1234));

	}
	
	//因为后面我们mid=low+F(k-1)+1，需要使用到斐波那契数列
	//因此需要先获取到一个斐波那契数列
	
	//非递归方法得到一个斐波那契数列
	public static int[] fib() {
		int[] f = new int[maxSize];
		f[0] = 1;
		f[1] = 1;
		for(int i =2;i<maxSize;i++) {
			f[i] = f[i-1]+f[i-2];
		}
		
		return f;
	}
	
	//斐波那契查找算法
	//使用非递归方式
	/**
	 * 
	 * @param arr	数组
	 * @param key	我们需要找的关键码
	 * @return 	找到返回相应的下标，没有就返回-1
	 */
	public static int fibSerch(int[] arr,int key) {
		int low= 0;
		int heigh = arr.length-1;
		int k = 0;//便是斐波那契分割数值对应下标
		int mid = 0;//存放mid
		int f[] =fib();//获取到斐波那契数列
		
		//获取到斐波那契分割数值对应下标
		while(heigh >f[k] - 1) {
			k++;
		}
		
		//因为f[k]的值可能大于数组长度，因此需要使用Arrays类，构造一个新的数组，并且指向a[];
		//不足的部分使用0填充
		int[] temp = Arrays.copyOf(arr,f[k]);
		
		for(int i = heigh +1;i<temp.length;i++) {
			temp[i] = arr[heigh];
		}
		
		//使用while循环处理找到我们的key
		while(low<=heigh) {//只要这个条件满足，就可以一直找
			mid = low+f[k - 1] - 1;
			if(key < temp[mid]) {//说明需要继续向数组前部分（左边）查找
				heigh = mid -1;
				k--;
			}else if(key > temp[mid]){//向右查找
				low = mid +1;
				//为什么k-2？
				//因为后面后f[k - 2]个元素，所以可以基础拆分f[k -1] = f[k -3]+f[k - 4]
				k-=2;
			}else {//找到
				//需要确定返回哪个下标
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
