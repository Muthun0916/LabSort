import java.util.List;

public class BubbleSort {

	private List<String[]> labs;
	private int n;
	private int k;
	private int i = 0;
	private int counter;
	private boolean isProgress;

	public BubbleSort(List<String[]> labs) {
		this.labs = labs;
		this.n = labs.size();
		this.k = 1;
		this.isProgress = false;
		this.counter = 0;
	}

	public boolean sort(boolean or) {
		forInSort(or);
		return isProgress;
	}

	private void forInSort(boolean or) {
		if (!isForFin()) {
			forInforInSort(or);
		}
		if (isForFin())
			isProgress = true;
	}

	private void forInforInSort(boolean or) {
		if (!isForInForFin()) {
			if (or)
				swap(labs, i, i + 1);
			i++;
		}
		if (isForInForFin()) {
			resetI();
			k++;
		}
		counter++;
	}

	private void swap(List<String[]> labs, int i, int j) {
		String[] temp = labs.get(i);
		labs.set(i, labs.get(j));
		labs.set(j, temp);
	}

	private boolean isForInForFin() {
		if (i < n - k)
			return false;
		else
			return true;
	}

	private boolean isForFin() {
		if (k < n)
			return false;
		else
			return true;
	}

	public int getPosition() {
		return i;
	}

	private void resetI() {
		this.i = 0;
	}

	public double getProgress() {
		return (counter * 100) / (n*n);
	}

	public List<String[]> getList() {
		return labs;
	}

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
