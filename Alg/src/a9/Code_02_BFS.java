package a9;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Code_02_BFS {
	/***
	 * 广（宽）度优先遍历
	 * 准备：队列、set：查重
	 * 1.将图的起始节点添加到队列中，同时加到set中
	 * 2.只要队列中有元素，就执行代码
	 * 3.弹出队列中的元素，并打印，
	 * 4，将该元素的邻居节点集合全部加入到队列中（重复的不加）
	 * @param node
	 */
	public static void bfs(Node node) {
		if (node == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		HashSet<Node> map = new HashSet<>();
		queue.add(node);
		map.add(node);
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			System.out.println(cur.value);
			for (Node next : cur.nexts) {
				if (!map.contains(next)) {
					map.add(next);
					queue.add(next);
				}
			}
		}
	}

}
