///���������Ա��У������������3.6-3.11
/**������Ĵ洢�ṹ*/
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
	/**3.7������Ķ�ȡ*/
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
	/**3.8.1������Ĳ���*/
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
	/**3.8.2�������ɾ��,������ɾ��ֵ*/
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
	///3.9����Ĵ���
	/**ͷ�巨��������*/
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
	/**β�巨��������*/
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
	/**3.10�����������ɾ�� */
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
	/**��ӡ����*/
	public static void printNode(ListNode listNode){
		ListNode p = listNode.next;
		while(p != null){
			System.out.print(p.data+" ");
			p = p.next;
		}
		System.out.println();
		
	}
	public static void main(String[] args) {
		System.out.println("ͷ�巨��������");
		ListNode headList = endCreate();
		printNode(headList);
		System.out.println("ɾ��:");
		deleteList(headList);
		printNode(headList);
	}
}
