///4.8栈的应用：递归
public class Main4_8 {
	/**迭代*/
	public static void fibonacci(){
		int[] a = new int[40];
		a[0] = 0;
		a[1] = 1;
		System.out.println(a[0]);
		System.out.println(a[1]);
		for (int i = 2; i < a.length; i++) {
			a[i] = a[i-1] +a[i-2];
			System.out.println(a[i]);
		}
	}
	/**递归*/
	public static int Fbi(int i){
		if(i<2){
			return i == 0? 0:1;
		}
		return Fbi(i-1)+Fbi(i-2);
	}
	public static void main(String[] args) {
		fibonacci();
		for (int i = 0; i < 40; i++) {
			System.out.println(Fbi(i));
		}
	}
}
