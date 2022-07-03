import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DumpFile {
	private static final String FILENAME = "rom.csv";
	//カンマ
	private static final String COMMA = ",";

	public static void write(String fileName) {
		//リスト化を行う
		List<String[]> labs = new ArrayList<>();
		String TName = "";
		String labName = "";
		Scanner scanner = new Scanner(System.in);
		int counter = 0;

		while (true) {
			System.out.print((counter + 1) + "人目の先生の名前を入力してください。");
			TName = scanner.nextLine();
			System.out.print((counter + 1) + "人目の先生の研究室名を入力してください。");
			labName = scanner.nextLine();

			if (TName.equals(""))
				break;

			String[] lab = { TName, labName };
			labs.add(lab);
			counter++;
		}
		scanner.close();

		try {
			File f = new File("result.txt");
			PrintWriter p_writer = new PrintWriter(
					new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f), "SHIFT-JIS")));

			//リストの内容を順に処理
			//リストの内容を順に処理
			for (String[] lab : labs) {

				p_writer.print(lab[0]);
				p_writer.print(COMMA);
				p_writer.print(lab[1]);
				p_writer.println();

			}
			System.out.println("CSVファイル出力完了");
			p_writer.close();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	public static void dump(List<String[]> list) {

		try {
			File f = new File("result.csv");
			PrintWriter p_writer = new PrintWriter(
					new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f), "SHIFT-JIS")));

			//リストの内容を順に処理
			for (int i = 0; i < list.size(); i++) {
				String[] lab = list.get(i);
				p_writer.print("第" + (i + 1) + "希望");
				p_writer.print(COMMA);
				p_writer.print(lab[0]);
				p_writer.print(COMMA);
				p_writer.print(lab[1]);
				p_writer.println();
			}
			System.out.println("CSVファイル出力完了");
			p_writer.close();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		DumpFile.write(FILENAME);
	}

}
