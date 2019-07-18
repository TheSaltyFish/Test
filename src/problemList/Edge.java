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
            //��Ȩֵ��������
            return this.weight - o.weight;
        }
}
class Graph {
    private ArrayList<Object> vertexList;       //��Ŷ��������
    Edge[] edges;                       //�߼�����
    int[][] arr;                                //�ڽӾ���

    public Graph(int v, int e) {
        //��ʼ���������
        vertexList = new ArrayList<>(v);
        //���ݱ�����ʼ���߼�����
        edges = new Edge[e];
        //��߼�������ӿն���
        for(int i = 0; i < e; i++){
            Edge edge = new Edge();
            edges[i] = edge;
        }
        //��ʼ���ڽӾ���
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

    //������
    public void insertVertex(Object vertex) {
        vertexList.add(vertexList.size(),vertex);
    }

    //����������Լ�����Ȩֵ
    public void insertEdge(int n1, int n2, int weight) {
        arr[n1][n2] = weight;
        //��ͼΪ����ͼ�����Ծ�����ڶԽ��߶Գ�
        arr[n2][n1] = weight;
    }

    //��ȡ�������
    public int getNumOfVertex() {
        return vertexList.size();
    }

    //��ȡ����n��ֵ
    public Object getValueByIndex(int n) {
        return vertexList.get(n);
    }

    //�ڽӾ���ת��Ϊ�߼�����
    public  void MatrixToEdgesArray() {
        int k = 0;
        //��Ϊ��ͼΪ����ͼ�����Ըþ�����ڴ����ϵ����µĶԽ��߶Գ�
        //��˴˴���������ֻ��������ϲ��ּ���
        for (int i = 0; i < getNumOfVertex(); i++) {
            for (int j = i ; j < getNumOfVertex(); j++) {
                if (arr[i][j] < 65535 && arr[i][j] != 0) {
                    edges[k].begin = i; // ��Ž�С�Ľ��Ϊ��
                    edges[k].end = j; // ��Žϴ�Ľ��Ϊβ
                    edges[k].weight = arr[i][j];
                    k++;
                }
            }
        }
        //��edges�߼����鰴Ȩֵ��С��������
        Arrays.sort(edges);
    }

    //��С������--��³˹�����㷨
    public void MiniSpanTree_Kruskal(Graph graph) {
        int i, n, m;
        //���ڽӾ���ת��Ϊ�߼�����
        MatrixToEdgesArray();
        int[]  parent = new int[edges.length];
        //��ʼ��parent����,�����ж��Ƿ�����˻�·
        for(i = 0; i < edges.length; i++) {
            parent[i] = 0;
        }
        for(i = 0;  i < edges.length; i++) {
            //��Ȩֵ��С�����õ�ÿһ����
            Edge edge = edges[i];
            n = Find(parent,edge.begin);
            m = Find(parent,edge.end);
            //n==mʱ��ʾ�����˻�·������������С��������
            if (n != m) {
                System.out.println("(" + edge.begin + "," + edge.end + ")-->" + edge.weight);
                parent[n] = m;
            }
        }
    }

    public int Find(int[] parent, int f) {
        /**��i=7ʱ,parent����Ϊ{1,5,8,7,7,8,0,0,6}
        *               ��Ӧ���±�Ϊ{0,1,2,3,4,5,6,7,8}
        *parent[0] = 1��ʾ����0,1�Ѿ�������������
        *���Դ�ʱ����0,1,2,5,8,6��һ���߼�����;����3,4,7��һ���߼�����
        **/
        while(parent[f] > 0) {
            f = parent[f];
        }
        return f;
    }
}