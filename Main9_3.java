///9.3Ã°ÅÝÅÅÐò
import java.util.Arrays;

public class Main9_3 {
	/**½»»»²Ù×÷*/
	public static void swap(int[]a,int i,int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	/**¼òµ¥µÄ½»»»ÅÅÐò*/
    public static void bubbleSort0(int[] a) {
        for (int i = 0; i < a.length-1; i++) {
			for (int j = i+1; j < a.length; j++) {
				if(a[i]>a[j])
					swap(a, i, j);
			}
		}
    }
    /**Ã°ÅÝÅÅÐò*/
    public static void bubbleSort1(int[] a){
    	for (int i = 0; i < a.length-1; i++) {
			for (int j = a.length-2	; j >= i; j--) {
				if(a[j]>a[j+1])
					swap(a, j, j+1);
			}
		}
    }
    /**Ã°ÅÝÅÅÐòµÄ¸Ä½ø*/
    public static void bubbleSort2(int[] a){
    	boolean flag = true;
    	for (int i = 0; i < a.length-1 && flag; i++) {
    		flag = false;
			for (int j = a.length-2; j >=i; j--) {
				if(a[j]>a[j+1]){
					swap(a, j, j+1);
					flag = true;
				}
			}
		}
    }
    public static void main(String[] args) {
    	int[] a = {9,8,7,6,5,4,3,2,1,0};
    	bubbleSort2(a);
    	System.out.println(Arrays.toString(a));
	}
}