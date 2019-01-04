///3.12静态链表
class staticList{
	Object data;
	int cur;

}

public class Main3_12 {
	public static final int MAXSIZE = 100;
	/**将一维数组space中各分量链成一备用链表*/
	public static void initList(staticList[] space){
		for (int i = 0; i < MAXSIZE-1; i++) {
			space[i] = new staticList();
			space[i].cur = i+1;
		}
		space[MAXSIZE-1].cur = 0;
	}
	/**若备用空间链表非空，返回分配的结点下标，否则返回0*/
	public static int malloc_sll(staticList[] space){
		int i = space[0].cur;
		if(space[0].cur != 0){
			space[0].cur = space[i].cur;
		}
		return i;
	}
	/**在L中第i个元素之前插入新的数据元素*/
	public static void listInsert(staticList[] space, int i,Object object){
		int k = MAXSIZE-1;
		if(i<1||i>space.length+1){
			System.out.println("error");
			return;
		}
		int j = malloc_sll(space);
		if(j != 0){
			space[j].data = object;
			for (int j2 = 0; j2 < i-1; j2++) {
				k = space[k].cur;
			}
			space[j].cur = space[k].cur;
			space[k].cur = j;
		}
	}
	/**将下标为k的空闲结点回收到备用链表*/
	public static void free_sll(staticList[] space, int k){
		space[k].cur = space[0].cur;
		space[0].cur = k;
	}
	/**删除L中第i个元素数据元素e*/
	public static void listDelete(staticList[] L, int i){
		int k = MAXSIZE-1;
		if(i<1 || i>L.length){
			System.out.println("error");
			return;
		}
		int j;
		for (j = 0; j < i-1; j++) {
			k = L[k].cur;
		}
		j = L[k].cur;
		L[k].cur = L[j].cur;
		free_sll(L, j);
	}
	/**返回L中数据元素的个数*/
	public static int listlength(staticList[] L){
		int j = 0;
		int i = L[MAXSIZE-1].cur;
		while(i != 0){
			i = L[i].cur;
			j++;
		}
		return j;
	}
	public static void main(String[] args) {
		staticList[] space = new staticList[MAXSIZE];
		initList(space);
		System.out.println(space[1].cur);
	}
}
