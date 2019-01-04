///第三章线性表中，单链表的内容3.6-3.11
/**单链表的存储结构*/
class ListNode{
	Object data;
	ListNode next;
	ListNode(){
		
	}
	ListNode(Object object){
		data = object;
	}
}
public class Main3_6 {
	/**3.7单链表的读取*/
	public static Object getElem(ListNode listNode,int i){
		Object o = new Object();
		ListNode p = listNode.next;
		int j = 1;
		while(p != null && j<i){
			p = p.next;
			j++;
		}
		if(p == null || j>i)
			return null;
		return p.data;
	}
	/**3.8.1单链表的插入*/
	public static void listInsert(ListNode listNode,int i,Object object){
		int j = 1;
		ListNode p = listNode;
		while(p != null && j<i){
			p = p.next;
			j++;
		}
		if(p == null || j>i){
			System.out.println("error");
			return;
		}
		ListNode s = new ListNode();
		s.data = object;
		s.next = p.next;
		p.next = s;
	}
	/**3.8.2单链表的删除,并返回删除值*/
	public static Object listDelete(ListNode listNode, int i){
		Object o = new Object();
		int j = 1;
		ListNode p =listNode;
		ListNode q = new ListNode();
		while(p != null &&j<i){
			p = p.next;
			j++;
		}
		if(p == null || j>i){
			System.out.println("error");
			return null;
		}
		q = p.next;
		p.next = q.next;
		o = q.data;
		return o;
	}
	///3.9整表的创建
	/**头插法创建链表*/
	public static ListNode headCreate(){
		ListNode listNode = new ListNode();
		listNode.next = null;
		for (int i = 0; i < 5; i++) {
			ListNode lN = new ListNode(i+1);
			lN.next = listNode.next;
			listNode.next = lN;
		}
		return listNode;
	}
	/**尾插法创建链表*/
	public static ListNode endCreate(){
		ListNode listNode = new ListNode();
		ListNode r = listNode;
		for (int i = 0; i < 5; i++) {
			ListNode p = new ListNode(i+1);
			r.next = p;
			r = p;
		}
		r.next = null;
		return listNode;
	}
	/**3.10单链表的整表删除 */
	public static void deleteList(ListNode listNode){
		ListNode p = listNode;
		ListNode q = null;
		while(listNode != null){
			q = listNode.next;
			listNode.next = null;
			listNode = q;
		}
		listNode = p;
	}
	/**打印链表*/
	public static void printNode(ListNode listNode){
		ListNode p = listNode.next;
		while(p != null){
			System.out.print(p.data+" ");
			p = p.next;
		}
		System.out.println();
		
	}
	public static void main(String[] args) {
		System.out.println("头插法创建链表：");
		ListNode headList = endCreate();
		printNode(headList);
		System.out.println("删除:");
		deleteList(headList);
		printNode(headList);
	}
}
