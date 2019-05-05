package a9;

import java.util.HashSet;
import java.util.Stack;

public class Code_03_DFS {
	/***
	 * 深度优先遍历
	 * 准备：栈，set（查重）
	 * 1.将图的起始节点添加到栈中，同时加到set中
	 * 2.只要队列中有元素，就执行代码
	 * 3.弹出栈顶元素
	 * 4.遍历元素的邻居集合
	 * 5.如果邻居节点不重复（不在set中），则：
	 * 	将刚弹出的栈顶元素加入栈中，
	 * 	邻居节点加入栈中，
	 * 	邻居节点加入set中，
	 * 	打印邻居节点。
	 * @param node
	 */
	public static void dfs(Node node) {
		if (node == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		HashSet<Node> set = new HashSet<>();
		stack.add(node);
		set.add(node);
		System.out.println(node.value);
		while (!stack.isEmpty()) {
			Node cur = stack.pop();
			for (Node next : cur.nexts) {
				if (!set.contains(next)) {
					stack.push(cur);
					stack.push(next);
					set.add(next);
					System.out.println(next.value);
					break;
				}
			}
		}
	}

}
