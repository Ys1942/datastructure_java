///4.5两栈共享空间
/**两栈共享空间结构*/
class SqDoubleStack{
	int[] data;
	int top1;
	int top2;  
}
public class Main4_5 {
	public static final int MAXSIZE = 100;
	/**插入元素e为新的栈顶元素*/
	public static void push(SqDoubleStack s, int e, int stackNumber){
		if(s.top1 +1 == s.top2){
			System.out.println("full stack");
			return;
		}
		if(stackNumber == 1){
			s.top1 ++;
			s.data[s.top1] = e;
		}
		else if(stackNumber == 2){
			s.top2 --;
			s.data[s.top2] = e;
		}
	}
	/**弹出操作*/
	public static int pop(SqDoubleStack s,int stackNumber){
		if(stackNumber == 1){
			if(s.top1 == -1){
				System.out.println("null stack");
				return 0;
			}
			int e = s.data[s.top1];
			s.top1--;
			return e;
		}
		else if(stackNumber == 2){
			if(s.top2 == MAXSIZE){
				System.out.println("null stack");
				return 0;
			}
			return s.data[s.top2++];
		}
		System.out.println("error");
		return 0;
	}
	/**从两端分别打印两栈*/
	public static void printSqDoubleStack(SqDoubleStack s){
		for (int i = 0; i <= s.top1; i++) {
			System.out.print(s.data[i]+" ");
		}
		System.out.println();
		for (int i = MAXSIZE-1 ; i >= s.top2; i--) {
			System.out.print(s.data[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] a = new int[MAXSIZE];
		SqDoubleStack sds = new SqDoubleStack();
		sds.data = a;
		sds.top1 = -1;
		sds.top2 = MAXSIZE;
		push(sds, 1, 1);
		push(sds, 2, 1);
		push(sds, 3, 1);
		push(sds, 4, 2);
		push(sds, 5, 2);
		push(sds, 6, 2);
		printSqDoubleStack(sds);
		System.out.println(pop(sds, 1));
		System.out.println(pop(sds, 2));
		printSqDoubleStack(sds);
	}
}
