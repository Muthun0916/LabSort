import java.util.ArrayList;
import java.util.List;

public class MargeSort {
	private List<List<String[]>> list;
	private int end;
	private int i;
	private int j;
	private int k;
	
	public MargeSort(List<String[]> labs) {
		list = new ArrayList<>();
		for(String[] lab:labs) {
			List<String[]> space = new ArrayList<>();
			space.add(lab);
			list.add(space);
		}
	}
	
	public void sort(boolean or) {
		isForInFin();
		forInSort(0,list.size(),or);
		
	}
	
	private boolean isForInFin() {
		if(i<end)return true;
		else return false;
	}

	public void forInSort(int begin, int end, boolean or) {
		
	}
	
	

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
