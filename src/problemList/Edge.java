package problemList;
import java.util.*;
public class Edge implements Comparable<Edge> {
        int begin;
        int end;
        int weight;
    	public static void main(String[] args) 
    	{
    	    int n = 6, e = 15;
            String[] vertex = {"v0","v1","v2","v3","v4","v5"};
            Graph graph = new Graph(n,e);
            for (String string : vertex) {
                graph.insertVertex(string);
            }
            graph.insertEdge(0, 1, 57);
            graph.insertEdge(0, 2, 168);
            graph.insertEdge(0, 3, 139);
            graph.insertEdge(0, 4, 64);
            graph.insertEdge(0, 5, 42);
            graph.insertEdge(1, 2, 181);
            graph.insertEdge(1, 3, 135);
            graph.insertEdge(1, 4, 63);
            graph.insertEdge(1, 5, 26);
            graph.insertEdge(2, 3, 114);
            graph.insertEdge(2, 4, 142);
            graph.insertEdge(2, 5, 139);
            graph.insertEdge(3, 4, 123);
            graph.insertEdge(3, 5, 131);
            graph.insertEdge(4, 5, 55);
            graph.MiniSpanTree_Kruskal(graph);
    	}
        public int getBegin() {
            return begin;
        }
        public void setBegin(int begin) {
            this.begin = begin;
        }
        public int getEnd() {
            return end;
        }
        public void setEnd(int end) {
            this.end = end;
        }
        public int getWeight() {
            return weight;
        }
        public void setWeight(int weight) {
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            // TODO Auto-generated method stub
            //按权值升序排列
            return this.weight - o.weight;
        }
}
class Graph {
    private ArrayList<Object> vertexList;       //存放顶点的数组
    Edge[] edges;                       //边集数组
    int[][] arr;                                //邻接矩阵

    public Graph(int v, int e) {
        //初始化结点数组
        vertexList = new ArrayList<>(v);
        //根据边数初始化边集数组
        edges = new Edge[e];
        //向边集数组添加空对象
        for(int i = 0; i < e; i++){
            Edge edge = new Edge();
            edges[i] = edge;
        }
        //初始化邻接矩阵
        arr = new int[v][v];
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (i == j)
                    arr[i][j] = 0;
                else {
                    arr[j][i] = 65535;
                }
            }
        }
    }

    //插入结点
    public void insertVertex(Object vertex) {
        vertexList.add(vertexList.size(),vertex);
    }

    //插入无向边以及设置权值
    public void insertEdge(int n1, int n2, int weight) {
        arr[n1][n2] = weight;
        //该图为无向图，所以矩阵关于对角线对称
        arr[n2][n1] = weight;
    }

    //获取顶点个数
    public int getNumOfVertex() {
        return vertexList.size();
    }

    //获取顶点n的值
    public Object getValueByIndex(int n) {
        return vertexList.get(n);
    }

    //邻接矩阵转换为边集数组
    public  void MatrixToEdgesArray() {
        int k = 0;
        //因为该图为无向图，所以该矩阵关于从左上到右下的对角线对称
        //因此此处遍历矩阵只需遍历右上部分即可
        for (int i = 0; i < getNumOfVertex(); i++) {
            for (int j = i ; j < getNumOfVertex(); j++) {
                if (arr[i][j] < 65535 && arr[i][j] != 0) {
                    edges[k].begin = i; // 编号较小的结点为首
                    edges[k].end = j; // 编号较大的结点为尾
                    edges[k].weight = arr[i][j];
                    k++;
                }
            }
        }
        //将edges边集数组按权值从小到大排序
        Arrays.sort(edges);
    }

    //最小生成树--克鲁斯卡尔算法
    public void MiniSpanTree_Kruskal(Graph graph) {
        int i, n, m;
        //将邻接矩阵转换为边集数组
        MatrixToEdgesArray();
        int[]  parent = new int[edges.length];
        //初始化parent数组,用于判断是否产生了环路
        for(i = 0; i < edges.length; i++) {
            parent[i] = 0;
        }
        for(i = 0;  i < edges.length; i++) {
            //按权值从小到大拿到每一条边
            Edge edge = edges[i];
            n = Find(parent,edge.begin);
            m = Find(parent,edge.end);
            //n==m时表示构成了环路，不能纳入最小生成树中
            if (n != m) {
                System.out.println("(" + edge.begin + "," + edge.end + ")-->" + edge.weight);
                parent[n] = m;
            }
        }
    }

    public int Find(int[] parent, int f) {
        /**当i=7时,parent数组为{1,5,8,7,7,8,0,0,6}
        *               对应的下标为{0,1,2,3,4,5,6,7,8}
        *parent[0] = 1表示顶点0,1已经加入生成树中
        *所以此时顶点0,1,2,5,8,6在一个边集合中;顶点3,4,7在一个边集合中
        **/
        while(parent[f] > 0) {
            f = parent[f];
        }
        return f;
    }
}