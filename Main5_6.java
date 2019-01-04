///5.6朴素的模式匹配算法（低效）
public class Main5_6 {
	/**返回子串t在主串s中第pos个字符之后的位置，若不存在，则返回0*/
	/*书中从1开始，这里从0开始，得到的效果一样*/
	public static int index(String s, String t, int pos){
		int i = pos-1;
		int j = 0;
		while(i < s.length() && j< t.length()){
			if(s.charAt(i) == t.charAt(j)){
				i++;
				j++;
			}
			else{
				i = i-j+1;
				j = 0;
			}
		}
		if(j == t.length())
			return i - t.length()+1;
		else
			return 0;
	}
	public static void main(String[] args) {
		String s = "googlegoogle";
		String t = "google";
		System.out.println(index(s, t, 2));
	}
}
