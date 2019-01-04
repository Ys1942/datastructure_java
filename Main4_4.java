///4.4栈的顺序存储结构
/**栈的结构定义*/
class SqStack{
	int[] data;
	int top;
}
public class Main4_4 {
	public static final int MAXSIZE = 100;
	/**插入元素e为新的栈顶元素*/
	public static void push(SqStack s,int e){
		if(s.top == MAXSIZE-1){
			System.out.println("error");
			return;
		}
		s.top++;
		s.data[s.top] = e;
	}
	/**出栈操作*/
	public static int pop(SqStack s){
		if(s.top == -1){
			System.out.println("null stack");
			return 0;
		}
		int i = s.data[s.top];
		s.top--;
		return i;
	}
	/**从栈底往上打印栈*/
	public static void printStack(SqStack s){
		for (int i = 0; i <= s.top; i++) {
			System.out.print(s.data[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] a = new int[MAXSIZE];
		SqStack s = new SqStack();
		s.data = a ;
		s.top = -1;
		push(s, 1);
		push(s,2);
		printStack(s);
		System.out.println(pop(s));
		printStack(s);
		
	}
}
