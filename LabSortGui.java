import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

public class LabSortGui extends JFrame implements ActionListener {

	private JPanel contentPane;
	private BubbleSort bubbleSort;
	private JLabel leftLabLabel;
	private JLabel rightLabLabel;
	private JLabel finishLabel;
	private JLabel parcentLabel;
	private JProgressBar progressBar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LabSortGui frame = new LabSortGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LabSortGui() {
		ReadFile readFile = ReadFile.getInstance();
		bubbleSort = new BubbleSort(readFile.getSortedList());
		List<String[]> list = bubbleSort.getList();
		setTitle("研究室ソート");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton leftButton = new JButton("あっち");
		leftButton.setBounds(12, 189, 153, 45);
		leftButton.addActionListener(this);
		contentPane.add(leftButton);

		JButton rightButton = new JButton("こっち");
		rightButton.setBounds(269, 189, 153, 45);
		rightButton.addActionListener(this);
		contentPane.add(rightButton);

		JLabel whichLikeLabel = new JLabel("どっちの方が良い？");
		whichLikeLabel.setBounds(12, 10, 153, 30);
		contentPane.add(whichLikeLabel);

		leftLabLabel = new JLabel("<html>" +
				list.get(bubbleSort.getPosition())[0] + "<br>" + list.get(bubbleSort.getPosition())[1] + "<html>");
		leftLabLabel.setBounds(12, 74, 153, 74);
		contentPane.add(leftLabLabel);

		rightLabLabel = new JLabel("<html>" +
				list.get(bubbleSort.getPosition() + 1)[0] + "<br>" + list.get(bubbleSort.getPosition() + 1)[1]
				+ "<html>");
		rightLabLabel.setBounds(269, 74, 153, 74);
		contentPane.add(rightLabLabel);

		progressBar = new JProgressBar();
		progressBar.setBounds(170, 26, 190, 14);
		contentPane.add(progressBar);

		parcentLabel = new JLabel("0%");
		parcentLabel.setBounds(372, 27, 50, 13);
		contentPane.add(parcentLabel);

		JLabel howProgressLabel = new JLabel("完成率");
		howProgressLabel.setBounds(170, 10, 50, 13);
		contentPane.add(howProgressLabel);

		finishLabel = new JLabel("");
		finishLabel.setBounds(12, 238, 410, 23);
		contentPane.add(finishLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		boolean isFin = false;
		if (isFin)
			return;

		if (cmd.equals("あっち")) {
			isFin = bubbleSort.sort(false);
			update();

		} else if (cmd.equals("こっち")) {
			isFin = bubbleSort.sort(true);
			update();
		}

		if (isFin) {
			finishLabel.setText("ソートが完了しました。result.csvで結果をご覧ください。");
			DumpFile.dump(bubbleSort.getList());
		}
	}

	public void update() {
		List<String[]> list = bubbleSort.getList();
		leftLabLabel.setText("<html>" +
				list.get(bubbleSort.getPosition())[0] + "<br>" + list.get(bubbleSort.getPosition())[1] + "<html>");
		rightLabLabel.setText("<html>" +
				list.get(bubbleSort.getPosition() + 1)[0] + "<br>" + list.get(bubbleSort.getPosition() + 1)[1]
				+ "<html>");
		double progress = bubbleSort.getProgress();
		parcentLabel.setText(progress + "%");
		progressBar.setValue((int)Math.floor(progress));
	}
}
