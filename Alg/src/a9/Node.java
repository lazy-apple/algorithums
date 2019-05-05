package a9;



import java.util.ArrayList;
/***
 *图中节点
 */
public class Node {
	public int value;
	public int in;//入（多少节点指向我）
	public int out;//出
	public ArrayList<Node> nexts;//邻居节点s（从我出发能到达的节点）
	public ArrayList<Edge> edges;//（从我出发的边）

	public Node(int value) {
		this.value = value;
		in = 0;
		out = 0;
		nexts = new ArrayList<>();
		edges = new ArrayList<>();
	}
}
