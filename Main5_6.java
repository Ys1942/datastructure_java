///5.6���ص�ģʽƥ���㷨����Ч��
public class Main5_6 {
	/**�����Ӵ�t������s�е�pos���ַ�֮���λ�ã��������ڣ��򷵻�0*/
	/*���д�1��ʼ�������0��ʼ���õ���Ч��һ��*/
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
