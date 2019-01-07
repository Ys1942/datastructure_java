///6.7-6.9二叉链表
import java.util.Scanner;
/**二叉链表结点结构*/
class Node{
	Node lChild;
    Node rChild;
    Object data;
}
public class Main6_7 {
	/**前序遍历*/
	public static void preOrderTraverse(Node root){
		if(root == null){
			return;
		}
		System.out.print(root.data+" ");
		preOrderTraverse(root.lChild);
		preOrderTraverse(root.rChild);
	}
	/**中序遍历*/
	public static void inOrderTraverse(Node root){
		if(root == null)
			return;
		inOrderTraverse(root.lChild);
		System.out.print(root.data+" ");
		inOrderTraverse(root.rChild);
	}
	/**后序遍历*/
	public static void postOrderTraverse(Node root){
		if(root == null)
			return;
		inOrderTraverse(root.lChild);
		inOrderTraverse(root.rChild);
		System.out.print(root.data+" ");
	}
	/**构造二叉链表表示二叉树t,#表示空树*/
	public static void createBiTree(Node node){
		Scanner input = new Scanner(System.in);
		char c = input.nextLine().split("\\s+")[0].charAt(0);
		if(c == '#'){
			node = null;
			return;
		}
		else{
			node.data = c;
			createBiTree(node.lChild = new Node());
			createBiTree(node.rChild = new Node());
		}
	}
	public static void main(String[] args) {
		Node root = new Node();
		createBiTree(root);
		preOrderTraverse(root);
		System.out.println();
		inOrderTraverse(root);
		System.out.println();
		postOrderTraverse(root);
		System.out.println();	
	}
}
