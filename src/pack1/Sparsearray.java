package pack1;

public class Sparsearray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//����һ��ԭʼ�Ķ�ά����
		//0��ʾû�����ӣ�1��ʾ���ӣ�2��ʾ����
		int chessArr1[][] = new int[11][11];
		chessArr1[1][2] =1;
		chessArr1[2][3] =2;
		
		//���ԭʼ��ά����
		System.out.println("ԭʼ�Ķ�ά���飺");
		for(int[] row:chessArr1) {
			for(int data:row) {
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}
		
		//����ά����תΪϡ�������˼·
		//1.�ȱ�����ά���飬�õ���0���ݵĸ���
		int sum = 0;
		for(int i =0;i<11;i++) {
			for(int j= 0;j<11;j++) {
				if(chessArr1[i][j] !=0) {
					sum++;
				}
			}
		}
		System.out.println("sum = "+sum);
		
		//2.������Ӧ��ϡ������
		int sparseArr [][] = new int [sum+1][3];
		//��ϡ�����鸳ֵ
		sparseArr [0][0] =11;
		sparseArr [0][1] =11;
		sparseArr [0][2] = sum;
		
		//������ά���飬����0��ֵ�Ͷ�Ӧ�������±�洢��ϡ������
		int count =0;//���ڼ�¼�ǵڼ�����������
		for(int i =0;i<11;i++) {
			for(int j= 0;j<11;j++) {
				if(chessArr1[i][j] !=0) {
					count ++;
					sparseArr[count][0] =i;
					sparseArr[count][1] =j;
					sparseArr[count][2] =chessArr1[i][j];
					
				}
			}
		}
		
		//���ϡ���������ʽ
		System.out.println();
		System.out.println("ϡ������Ϊ��");
		for(int i=0;i<sparseArr.length;i++) {
			System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
		}
		
		System.out.println();
		
		
		//��ϡ������ָ���ԭʼ����
		/*
		 * 1.�ȶ�ȡϡ������ĵ�һ�У�����ϡ������ĵ�һ�д���ԭʼ����
		 * 2.��ȡϡ��������е����ݲ���ֵ��ԭʼ�Ķ�ά���ݡ�
		 */
		// 1.�ȶ�ȡϡ������ĵ�һ�У�����ϡ������ĵ�һ�д���ԭʼ����
		
		int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
		
		//2.��ȡϡ��������е����ݲ���ֵ��ԭʼ�Ķ�ά���ݡ�
		for(int i=1;i<sparseArr.length;i++) {
			chessArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
		}
		//�ָ���Ķ�ά����
		System.out.println();
		System.out.println("�ָ���Ķ�ά����");
		for(int[] row:chessArr2) {
			for(int data:row) {
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}
		
	}

}
