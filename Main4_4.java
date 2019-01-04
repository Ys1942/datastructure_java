///4.4ջ��˳��洢�ṹ
/**ջ�Ľṹ����*/
class SqStack{
	int[] data;
	int top;
}
public class Main4_4 {
	public static final int MAXSIZE = 100;
	/**����Ԫ��eΪ�µ�ջ��Ԫ��*/
	public static void push(SqStack s,int e){
		if(s.top == MAXSIZE-1){
			System.out.println("error");
			return;
		}
		s.top++;
		s.data[s.top] = e;
	}
	/**��ջ����*/
	public static int pop(SqStack s){
		if(s.top == -1){
			System.out.println("null stack");
			return 0;
		}
		int i = s.data[s.top];
		s.top--;
		return i;
	}
	/**��ջ�����ϴ�ӡջ*/
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
