package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {

	private ArrayList<String> vertexList;//�洢��ļ���
	private int[][] edges;//�洢ͼ��Ӧ��������
	private int numOfEdges;//��ʾ�ߵ���Ŀ
	
	
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

	}
	
	//������
	public Graph(int n) {
		//��ʼ�������ArrayList
		edges = new int [n][n];
		vertexList = new ArrayList<String>(n);
		numOfEdges = 0;
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
