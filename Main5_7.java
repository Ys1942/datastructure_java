///5.7KMP模式匹配算法

public class Main5_7 {
	/**返回串t的next数组*/
	public static int[] get_next(String t){
		int[] next = new int[t.length()];
		int i = 1;
		int j = 0;
		next[0] = 0;
		while(i<t.length()){
			if(j == 0 || t.charAt(i-1) == t.charAt(j-1)){
				next[i++] = ++j;
			}
			else{
				j = next[j-1];
			}
		}
		return next;
	}
	public static int index_kmp(String s, String t){
		return index_kmp(s,t,1);
	}
	public static int index_kmp(String s, String t, int pos){
		int i = pos-1;
		int j = 0;
		int[] next = get_next(t);
		while(i<=s.length() && j<=t.length()){
			if(j ==0 || s.charAt(i-1)==t.charAt(j-1)){
				i++;
				j++;
			}
			else
				j = next[j-1];
		}
		if(j >= t.length())
			return i-t.length();
		else
			return 0;
	}
	public static void main(String[] args) {
		int k = index_kmp("goodgoogle", "google");
		System.out.println(k);
	}
}
