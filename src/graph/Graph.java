package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {

	private ArrayList<String> vertexList;//存储点的集合
	private int[][] edges;//存储图对应的领结矩阵
	private int numOfEdges;//表示边的数目
	
	
	public static void main(String[] args) {
	
		//测试一把图是否创建
		int n = 5;//结点个数
		String VertexVal[] = {"A","B","C","D","E",};
		//创建图对象
		Graph graph = new Graph(n);
		//循环添加
		for(String value:VertexVal) {
			graph.insertVertex(value);
		}
		
		//添加边
		//A-B，A-C，B-C,B-D,B-D
		graph.insertEdge(0,1,1);
		graph.insertEdge(0,2,1);
		graph.insertEdge(1,2,1);
		graph.insertEdge(1,3,1);
		graph.insertEdge(1,4,1);
		
		//显示一把邻接矩阵
		graph.showGraph();

	}
	
	//构造器
	public Graph(int n) {
		//初始化矩阵和ArrayList
		edges = new int [n][n];
		vertexList = new ArrayList<String>(n);
		numOfEdges = 0;
	}
	
	//图中常用的方法
	//返回节点的个数
	public int getNumOfVertex() {
		return vertexList.size();
	}
	//得到变得数目
	public int getNumifEdged() {
		return numOfEdges;
	}
	
	//显示图对应的矩阵
	public void  showGraph() {
		for(int[] link:edges) {
			System.out.println(Arrays.toString(link));
		}
	}
	
	//返回结点i（下标）对应的值
	public String getValueByIndex(int i) {
		return vertexList.get(i);
	}
	
	//返回v1和v2的权值
	public int geWeight(int v1,int v2) {
		return edges[v1][v2];
	}
	
	//插入节点
	public void insertVertex(String vertex) {
		vertexList.add(vertex);
	}
	
	//添加边
	/**
	 * 
	 * @param v1	表示点的下标即是第几个顶点
	 * @param v2	表示第二个节点对应的下标
	 * @param weight	表示是否关联
	 */
	public void insertEdge(int v1,int v2,int weight) {
		//无向图，所以左右都要给
		edges[v1][v2] = weight;
		edges[v2][v1] = weight;
		numOfEdges ++;
	}

}
