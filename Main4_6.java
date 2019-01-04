///3.6��ջ
/**��ջ�Ľṹ*/
class stackNode{
	Object data;
	stackNode next;
}
class linkStack{
	stackNode top;
	int count;
}
public class Main4_6 {
	/**��ջ����*/
	public static void push(linkStack ls, Object data){
		stackNode s = new stackNode();
		s.data = data;
		s.next = ls.top;
		ls.top = s;
		ls.count ++;
	}
	/**��ջ����*/
	public static Object pop(linkStack ls){
		if(ls.top == null){
			System.out.println("null stack");
			return 0;
		}
		stackNode s = ls.top;
		Object i = s.data;
		ls.top = s.next;
		s = null;
		ls.count--;
		return i;
	}
	/**��ӡ����*/
	public static void printStack(linkStack ls){
		stackNode s = ls.top;
		while(s != null){
			System.out.print(s.data+" ");
			s = s.next;
		}
		System.out.print("ջ��\n");
	}
	public static void main(String[] args) {
		stackNode top = null;
		linkStack ls = new linkStack();
		ls.top = top;
		ls.count = 0;
		push(ls, 1);
		push(ls, 2);
		push(ls, 3);
		printStack(ls);
		System.out.println(pop(ls));
		printStack(ls);
	}
}
