///第9章 所有的排序算法
import java.util.Arrays;

public class Main9 {
	/**交换操作*/
	public static void swap(int[]a,int i,int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	/**简单的交换排序*/
    public static void bubbleSort0(int[] a) {
        for (int i = 0; i < a.length-1; i++) {
			for (int j = i+1; j < a.length; j++) {
				if(a[i]>a[j])
					swap(a, i, j);
			}
		}
    }
    /**冒泡排序*/
    public static void bubbleSort1(int[] a){
    	for (int i = 0; i < a.length-1; i++) {
			for (int j = a.length-2	; j >= i; j--) {
				if(a[j]>a[j+1])
					swap(a, j, j+1);
			}
		}
    }
    /**冒泡排序的改进*/
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
    /**简单选择排序*/
    public static void selectSort(int[] a){
		int min = 0;
		for (int i = 0; i < a.length-1; i++) {
			for (int j = i+1; j < a.length; j++) {
				if(a[min]>a[j])
					min = j;
			}
			if(i!=min)
				swap(a, i, min);
		}
	}
    /**直接插入排序*/
    public static void insertSort(int[] a){
    	for (int i = 1; i < a.length; i++) {
			if(a[i]<a[i-1]){
				int j = 0;
				int temp = a[i];
				for (j = i-1; j>=0&&a[j]>temp; j--) 
					a[j+1] = a[j];
				a[j+1] = temp;
			}
		}
    }
    /**希尔排序*/
    public static void shellSort(int[] a){
    	int increment = a.length;
    	do{
    		increment = increment/3+1;
    		for (int i = increment; i < a.length; i++) {
				if(a[i]<a[i-increment]){
					int temp = a[i];
					int j = 0;
					for (j = i-increment; j>=0&&temp<a[j]; j-=increment) 
						a[j+increment] = a[j];
					a[j+increment] = temp;
				}
			}
    	}
    	while(increment>1);
    }
    /**堆排序*/
    public static void heapSort(int[] a){
    	for (int i = a.length/2-1; i >=0; i--) {
			heapAdjust(a ,i,a.length-1);
		}
    	for (int j = a.length-1; j >0; j--) {
			swap(a, 0, j);
			heapAdjust(a,0,j-1);
    	}
    }
    /**调整为大顶堆*/
    public static void heapAdjust(int[] a,int s,int m){
    	int temp = a[s];
    	for (int i = 2*s+1; i <=m; i=2*i+1) {
			if(i<m&&a[i]<a[i+1])
				++i;
			if(temp>=a[i])
				break;
			a[s] = a[i];
			s = i;
		}
    	a[s] = temp;
    	
    }
    /**归并排序（递归实现）*/
    public static void mergeSort(int[]a ){
    	mSort(a,a,0,a.length-1);
    }
    public static void mSort(int[] sr,int[] tr1,int s,int t){
    	int[] tr2 = new int[tr1.length];
    	if(s == t)
    		tr1[s] = sr[s];
    	else{
    		int m = (s+t)/2;
    		mSort(sr, tr2, s, m);
    		mSort(sr, tr2, m+1, t);
    		merge(tr2,tr1,s,m,t);
    	}
    }
    public static void merge(int[] sr,int[] tr,int i,int m,int n){
    	int j = m+1;
    	int k = 0;
    	for (k = i;  i <= m && j<=n; k++) {
			if(sr[i]<sr[j])
				tr[k] = sr[i++];
			else
				tr[k] = sr[j++];
		}
    	if(i<=m){
    		for (int j2 = 0; j2 <= m-i ; j2++) {
				tr[k+j2] = sr[i+j2];
			}
    	}
    	if(j<=n){
    		for (int k2 = 0; k2 <=n-j ; k2++) {
				tr[k+k2] = sr[j+k2];
			}
    	}
    }
    /**归并排序（非递归实现）*/
    public static void mergeSort2(int[] a){
    	int[] tr = new int[a.length];
    	int k = 1;
    	while(k<a.length-1){
    		mergePass(a,tr,k,a.length-1);
    		k = 2*k;
    		mergePass(tr,a,k,a.length-1);
    		k = 2*k;
    	}
    }
    public static void mergePass(int[] sr, int[] tr, int s, int n){
    	int i = 0;
    	while(i<=n-2*s+1){
    		merge(sr, tr, i, i+s-1, i+2*s-1);
    		i = i+2*s;
    	}
    	if(i<n-s+1)
    		merge(sr, tr, i, i+s-1, n);
    	else
    		for (int j = i; j <=n ; j++) {
				tr[j] = sr[j];
			}
    }
    /**快速排序*/
    public static void quickSort(int[] a){
    	qSort(a,0,a.length-1);
    }
    public static void qSort(int[] a,int low,int high){
    	if(low<high){
    		int pivot = partition(a,low,high);
    		qSort(a, low, pivot-1);
    		qSort(a, pivot+1, high);
    	}
    }
    public static int partition(int[]a,int low,int high){
    	int pivotkey = a[low];
    	while(low<high){
    		while(low<high && a[high] >= pivotkey)
    			high--;
    		swap(a,low,high);
    		while(low<high && a[low] <= pivotkey)
    			low++;
    		swap(a, low, high);
    	}
    	
    	return low;
    }
    public static void main(String[] args) {
//    	int[] a = {9,8,7,6,5,4,3,2,1,0};
//    	int[] a = {49,38,65,97,76,13,27,49,55,4};
    	int[] a = {50,10,90,30,70,40,80,60,20};
    	quickSort(a);
    	System.out.println(Arrays.toString(a));
	}
}