package a9;

/***
 * 生成图
 */
public class GraphGenerator {
	/***
	 * 从数组获取两节点，和权重
	 * 将两个点添加到图中
	 * 从图中获取两个点
	 * 起始点的邻居添加结束点
	 * 起始点的出度增加1
	 * 结束点的入度增加1
	 * 起始点的边添加一条新的边
	 * 图的边添加一条新的边
	 * @param matrix
	 * @return
	 */
	public static Graph createGraph(Integer[][] matrix) {
		Graph graph = new Graph();
		for (int i = 0; i < matrix.length; i++) {
			Integer from = matrix[i][0];
			Integer to = matrix[i][1];
			Integer weight = matrix[i][2];
			if (!graph.nodes.containsKey(from)) {
				graph.nodes.put(from, new Node(from));
			}
			if (!graph.nodes.containsKey(to)) {
				graph.nodes.put(to, new Node(to));
			}
			Node fromNode = graph.nodes.get(from);
			Node toNode = graph.nodes.get(to);
			Edge newEdge = new Edge(weight, fromNode, toNode);
			fromNode.nexts.add(toNode);
			fromNode.out++;
			toNode.in++;
			fromNode.edges.add(newEdge);
			graph.edges.add(newEdge);
		}
		return graph;
	}

}
