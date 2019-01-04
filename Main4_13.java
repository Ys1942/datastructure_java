///4.13���е���ʽ�洢�ṹ
/**�����еĽṹ*/
class qNode{
	Object data;
	qNode next;
}
class linkQueue{
	qNode front;
	qNode rear;
}
public class Main4_13 {
	/**��ʼ��������*/
	public static void initLinkQueue(linkQueue lq){
		qNode q = new qNode();
		q.next = null;
		lq.front = q;
		lq.rear = q;
	}
	/**��Ӳ���*/
	public static void enLinkQueue(linkQueue lq,Object e){
		qNode q = new qNode();
		q.data = e;
		q.next = null;
		lq.rear.next = q;
		lq.rear = q;
	}
	/**���Ӳ���*/
	public static Object deLinkQueue(linkQueue lq){
		if(lq.front == lq.rear){
			System.out.println("null linkqQueue");
			return null;
		}
		qNode q = lq.front.next;
		lq.front.next = q.next;
		Object o = q.data;
		if(lq.rear == q)
			lq.rear = lq.front;
		q = null;
		return o;
	}
	/**��ӡ������*/
	public static void printLinkQueue(linkQueue lq){
		if(lq.front == lq.rear){
			System.out.println("null linkQueue");
			return;
		}
		qNode q = lq.front.next;
		while(q != null){
			System.out.print(q.data+" ");
			q = q.next;
		}
		System.out.println();
		
	}
	public static void main(String[] args) {
		linkQueue lq = new linkQueue();
		initLinkQueue(lq);
		enLinkQueue(lq, 4);
		enLinkQueue(lq, 5);
		enLinkQueue(lq, 6);
		printLinkQueue(lq);
		System.out.println(deLinkQueue(lq));
		printLinkQueue(lq);
		System.out.println(deLinkQueue(lq));
		printLinkQueue(lq);
		System.out.println(deLinkQueue(lq));
		printLinkQueue(lq);

	}
}
