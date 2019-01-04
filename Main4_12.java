///4.12 循环队列
/**循环队列的顺序存储结构*/
class SqQueue{
	int[] data;
	int front;
	int rear;
}
public class Main4_12 {
	public static final int MAXSIZE = 10;
	/**初始化一个空队列*/
	public static void initQueue(SqQueue q){
		int[] a = new int[10];
		q.data = a;
		q.front = 0;
		q.rear = 0;
	}
	/**求队列长度*/
	public static int queueLength(SqQueue q){
		return (q.rear -q.front+MAXSIZE)%MAXSIZE;
	}
	/**入栈操作*/
	public static void enQueue(SqQueue q, int e){
		if((q.rear+1)%MAXSIZE == q.front){
			System.out.println("full queue");
			return;
		}
		q.data[q.rear] = e;
		q.rear = (q.rear+1)%MAXSIZE;
	}
	/**出栈操作*/
	public static int deQueue(SqQueue q){
		if(q.front == q.rear){
			System.out.println("null queue");
			return 0;
		}
		int i = q.data[q.front];
		q.front = (q.front +1)%MAXSIZE;
		return i;
	}
	/**打印队列*/
	public static void printQueue(SqQueue q){
		if(q.front == q.rear){
			System.out.println("null queue");
			return;
		}
		int i = q.front;
		while(i%MAXSIZE != q.rear){
			System.out.print(q.data[i++]+" ");
		}
		System.out.println();
		
	}
	public static void main(String[] args) {
		SqQueue q = new SqQueue();
		initQueue(q);
		for (int i = 0; i < 11; i++) {
			enQueue(q, i+1);
		}
		System.out.println(queueLength(q));
		printQueue(q);
		System.out.println(deQueue(q));
		System.out.println(queueLength(q));
		printQueue(q);
	}
}
