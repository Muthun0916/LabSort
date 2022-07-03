import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
	private static ReadFile instance = null;
	private static final String FILENAME = "labs.csv";
	private List<String[]> sortedList;

	private ReadFile(String file_name) {
		BufferedReader br = null;
		sortedList = new ArrayList<>();
		try {
			File file = new File(file_name);
			br = new BufferedReader(new FileReader(file));
			// readLineで一行ずつ読み込む
			String line; // 読み込み行
			String[] data = null; // 分割後のデータを保持する配列
			while ((line = br.readLine()) != null) {
				// lineをカンマで分割し、配列dataに設定
				// 0が研究室の先生の名前、1が研究室名
				data = line.split(",");
				sortedList.add(data);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("labs.csvを同じ階層に配置してください！");
		} finally {
			try {
				br.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static ReadFile getInstance() {
		if (instance == null) {
			instance = new ReadFile(FILENAME);
		}
		return instance;
	}

	public List<String[]> getSortedList() {
		return sortedList;
	}

	public static void main(String[] args) {
		ReadFile readFile = ReadFile.getInstance();
		List<String[]> list = readFile.getSortedList();
		for (String[] info : list) {
			System.out.println("先生名 ： " + info[0] + "    研究室内容:" + info[1]);
		}
	}

}
