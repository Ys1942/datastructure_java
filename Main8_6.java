///8.6����������
/**�������Ķ���������ṹ����*/
class BiTNode{
	int data;
	BiTNode lChild;
	BiTNode rChild;
}
public class Main8_6 {
	/**�������������Ҳ���*/
	public static boolean searchBST(BiTNode root,int key){
		if(root == null){
			return false;
		}
		else if(key == root.data){
			return true;
		}
		else if (key <root.data)
			return searchBST(root.lChild, key);
		else
			return searchBST(root.rChild, key);
	}
	/**�����������������*/
	public static BiTNode insertBST(BiTNode root, int key){
		if(root == null){
			root = new BiTNode();
			root.data = key;
			return root;
		}
		else{
			if(key<root.data)
				root.lChild = insertBST(root.lChild, key);
			else
				root.rChild = insertBST(root.rChild, key);
			return root;
		}
	}
	/**ɾ������Ԫ�ؽ��*/
	public static BiTNode deleteBST(BiTNode root, int key){
		if(!searchBST(root, key))
			System.out.println("no");
		else{
			if(key == root.data)
				root = delete(root);
			else if(key < root.data)
				root.lChild = deleteBST(root.lChild, key);
			else 
				root.rChild = deleteBST(root.rChild, key);
		}
		return root;
	}
	public static BiTNode delete(BiTNode node){
		if(node.rChild == null){
			BiTNode q = node;
			node = node.lChild;
			q = null;
		}
		else if(node.lChild == null){
			BiTNode q = node;
			node = node.rChild;
			q = null;
		}
		else{
			BiTNode q = node;
			BiTNode s = node.lChild;
			while(s.rChild != null){
				q = s;
				s = s.rChild;
			}
			node.data = s.data;
			if(q != node){
				q.rChild = s.lChild;
			}
			else
				q.lChild = s.lChild;
			s = null;
		}
		return node;
	}
	/**�������*/
	public static void inOrderTraverse(BiTNode root){
		if(root == null)
			return;
		inOrderTraverse(root.lChild);
		System.out.print(root.data+" ");
		inOrderTraverse(root.rChild);
	}
	public static void main(String[] args) {
		BiTNode root = null;
		int [] a  = {62,88,58,47,35,73,51,99,37,93};
		for (int i = 0; i < a.length; i++) {
			root = insertBST(root, a[i]);
		}
		inOrderTraverse(root);
		System.out.println();
		int i = 47;
		System.out.println(searchBST(root,i));
		root = deleteBST(root,i);
		inOrderTraverse(root);
		System.out.println();
		System.out.println(searchBST(root,i));
	}
}
