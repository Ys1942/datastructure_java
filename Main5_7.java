///5.7KMP模式匹配算法和改进算法

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
	/**返回子串t在主串s中第一次出现的位置。不存在则返回0*/
	public static int index_kmp(String s, String t){
		return index_kmp(s,t,1);
	}
	/**返回子串t在主串s中第pos个字符之后的位置。不存在则返回0*/
	public static int index_kmp(String s, String t, int pos){
		int i = pos-1;
		int j = 0;
//		int[] next = get_next(t);
		int[] next = get_nextval(t);
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
	/**求t的next函数修正值*/
	public static int[] get_nextval(String t){
		int[] next = new int[t.length()];
		int i = 1;
		int j = 0;
		next[0] = 0;
		while(i<t.length()){
			if(j == 0 || t.charAt(i-1) == t.charAt(j-1)){
				if(t.charAt(i++) != t.charAt(j++))
					next[i-1] = j;
				else
					next[i-1] = next[j-1];
			}
			else{
				j = next[j-1];
			}
		}
		return next;
	}
	public static void main(String[] args) {
		int k = index_kmp("goodgoogle", "google");
		System.out.println(k);
		String s1 = "ababaaaba";
		String s2 = "aaaaaaaab";
		int[] a1 = get_next(s2);
		int[] a2 = get_nextval(s2);
		for (int i = 0; i < a1.length; i++) {
			System.out.print(a1[i]+" ");
		}
		System.out.println();
		for (int i = 0; i < a2.length; i++) {
			System.out.print(a2[i]+" ");
		}
	}
}

