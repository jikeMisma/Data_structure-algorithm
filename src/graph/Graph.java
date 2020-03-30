package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {

	private ArrayList<String> vertexList;//存储点的集合
	private int[][] edges;//存储图对应的领结矩阵
	private int numOfEdges;//表示边的数目
	//定义一个数组boolean[] 表示结点是否被访问过
	private boolean[] isVisited ;
	
	
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
		
		//测试一把，我们的dfs遍历是否ok
		System.out.println("深度遍历");
		graph.dfs();

	}
	
	//构造器
	public Graph(int n) {
		//初始化矩阵和ArrayList
		edges = new int [n][n];
		vertexList = new ArrayList<String>(n);
		numOfEdges = 0;
		isVisited = new boolean[5];
	}
	//写一个方法得到一个邻接接地那的下标w
	/**
	 * 
	 * @param index
	 * @return	如果存在就返回对应下标，否则返回-1；
	 */
	public int  getFirstNeigbor(int index) {
		for(int j=0;j<vertexList.size();j++) {
			if(edges[index][j] > 0) {
				return j;
			}
		}
		return -1;
	}
	
	//根据前一个邻接结点的下标来获取下一个邻接结点
	public int getNextNeigbor(int v1,int v2) {
		for(int j=v2+1;j<vertexList.size();j++) {
			if(edges[v1][j] > 0) {
				return j;
			}
		}
		return -1;
	}
	
	//深度优先遍历算法
	//i第一次为0
	private void dfs(boolean[] isVisit,int i) {
		//首先我们先访问该结点，输出
		System.out.printf(getValueByIndex(i)+"->");
		//将这个结点设置为已经被访问
		isVisited[i] = true;
		//查找i的第一个邻结点w
		int w = getFirstNeigbor(i);
		while(w != -1) {//说明有
			if(!isVisited[w]) {
				dfs(isVisited,w);
			}
			//如果w已经被访问过
			w = getNextNeigbor(i,w);
		}
	}
	
	
	//对dfs进行重载，遍历所有的结点并进行dfs
	public void dfs() {
		//遍历所有的结点，进行dfs【回溯】
		for(int  i = 0;i < getNumOfVertex();i++) {
			if(!isVisited[i]) {
				dfs(isVisited,i);
			}
			
		}
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
