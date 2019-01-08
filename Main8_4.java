///8.4有序表查找
public class Main8_4 {
	/**折半查找，二分查找*/
	public int binarySearch(int[] a,int key){
		int low = 0;
		int high = a.length-1;
		while(low<=high){
			int mid = (low+high)/2;
			//插值查找
//			int mid = low+(high - low)*(key -a[low])/(a[high]-a[low]);
			if(key<a[mid])
				high = mid -1;
			else if (key>a[mid])
				low = mid +1;
			else 
				return mid;
		}
		return 0;
	}
	public static void main(String[] args){
		int[] a = {0,1,16,24,35,47,59,62,73,88,99};
		int i = new Main8_4().binarySearch(a, 62);
		System.out.println(i);
	}
	
}
