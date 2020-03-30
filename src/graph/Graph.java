package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {

	private ArrayList<String> vertexList;//�洢��ļ���
	private int[][] edges;//�洢ͼ��Ӧ��������
	private int numOfEdges;//��ʾ�ߵ���Ŀ
	//����һ������boolean[] ��ʾ����Ƿ񱻷��ʹ�
	private boolean[] isVisited ;
	
	
	public static void main(String[] args) {
	
		//����һ��ͼ�Ƿ񴴽�
		int n = 5;//������
		String VertexVal[] = {"A","B","C","D","E",};
		//����ͼ����
		Graph graph = new Graph(n);
		//ѭ�����
		for(String value:VertexVal) {
			graph.insertVertex(value);
		}
		
		//��ӱ�
		//A-B��A-C��B-C,B-D,B-D
		graph.insertEdge(0,1,1);
		graph.insertEdge(0,2,1);
		graph.insertEdge(1,2,1);
		graph.insertEdge(1,3,1);
		graph.insertEdge(1,4,1);
		
		//��ʾһ���ڽӾ���
		graph.showGraph();
		
		//����һ�ѣ����ǵ�dfs�����Ƿ�ok
		System.out.println("��ȱ���");
		graph.dfs();

	}
	
	//������
	public Graph(int n) {
		//��ʼ�������ArrayList
		edges = new int [n][n];
		vertexList = new ArrayList<String>(n);
		numOfEdges = 0;
		isVisited = new boolean[5];
	}
	//дһ�������õ�һ���ڽӽӵ��ǵ��±�w
	/**
	 * 
	 * @param index
	 * @return	������ھͷ��ض�Ӧ�±꣬���򷵻�-1��
	 */
	public int  getFirstNeigbor(int index) {
		for(int j=0;j<vertexList.size();j++) {
			if(edges[index][j] > 0) {
				return j;
			}
		}
		return -1;
	}
	
	//����ǰһ���ڽӽ����±�����ȡ��һ���ڽӽ��
	public int getNextNeigbor(int v1,int v2) {
		for(int j=v2+1;j<vertexList.size();j++) {
			if(edges[v1][j] > 0) {
				return j;
			}
		}
		return -1;
	}
	
	//������ȱ����㷨
	//i��һ��Ϊ0
	private void dfs(boolean[] isVisit,int i) {
		//���������ȷ��ʸý�㣬���
		System.out.printf(getValueByIndex(i)+"->");
		//������������Ϊ�Ѿ�������
		isVisited[i] = true;
		//����i�ĵ�һ���ڽ��w
		int w = getFirstNeigbor(i);
		while(w != -1) {//˵����
			if(!isVisited[w]) {
				dfs(isVisited,w);
			}
			//���w�Ѿ������ʹ�
			w = getNextNeigbor(i,w);
		}
	}
	
	
	//��dfs�������أ��������еĽ�㲢����dfs
	public void dfs() {
		//�������еĽ�㣬����dfs�����ݡ�
		for(int  i = 0;i < getNumOfVertex();i++) {
			if(!isVisited[i]) {
				dfs(isVisited,i);
			}
			
		}
	}
	
	
	//ͼ�г��õķ���
	//���ؽڵ�ĸ���
	public int getNumOfVertex() {
		return vertexList.size();
	}
	//�õ������Ŀ
	public int getNumifEdged() {
		return numOfEdges;
	}
	
	//��ʾͼ��Ӧ�ľ���
	public void  showGraph() {
		for(int[] link:edges) {
			System.out.println(Arrays.toString(link));
		}
	}
	
	//���ؽ��i���±꣩��Ӧ��ֵ
	public String getValueByIndex(int i) {
		return vertexList.get(i);
	}
	
	//����v1��v2��Ȩֵ
	public int geWeight(int v1,int v2) {
		return edges[v1][v2];
	}
	
	//����ڵ�
	public void insertVertex(String vertex) {
		vertexList.add(vertex);
	}
	
	//��ӱ�
	/**
	 * 
	 * @param v1	��ʾ����±꼴�ǵڼ�������
	 * @param v2	��ʾ�ڶ����ڵ��Ӧ���±�
	 * @param weight	��ʾ�Ƿ����
	 */
	public void insertEdge(int v1,int v2,int weight) {
		//����ͼ���������Ҷ�Ҫ��
		edges[v1][v2] = weight;
		edges[v2][v1] = weight;
		numOfEdges ++;
	}

}
