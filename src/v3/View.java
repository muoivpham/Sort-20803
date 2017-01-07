package v3;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import jxl.Workbook;
import jxl.format.CellFormat;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import net.miginfocom.swing.MigLayout;

public class View extends JFrame {

	private JPanel contentPane;
	private JTextField comparationTF;
	private JTextField movesTF;
	private String[] keys;
	private Model model;
	private JTextField txtFile;
	private JButton btnSave;
	private JButton btnSort;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
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
	public View() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel lblSortingAlgorithms = new JLabel("Sorting Algorithms");
		contentPane.add(lblSortingAlgorithms, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[][][][][][grow][][]", "[][][][][][][][]"));

		JLabel lblTypes = new JLabel("Types: ");
		panel.add(lblTypes, "cell 1 0");

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(
				new String[] { "Buble Sort", "Cocktail Shaker Sort", "Shell Sort", "Quick Sort" }));
		panel.add(comboBox_1, "cell 5 0,growx");

		JLabel lblNumbers = new JLabel("Numbers:");
		panel.add(lblNumbers, "cell 1 2");

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "100", "1000", "2000", "5000" }));
		panel.add(comboBox, "cell 5 2,growx");

		JLabel lblFile = new JLabel("File:");
		panel.add(lblFile, "cell 1 3");

		txtFile = new JTextField();
		txtFile.setEditable(false);
		txtFile.setEnabled(false);
		panel.add(txtFile, "cell 5 3,growx");
		txtFile.setColumns(10);

		JLabel lblComparations = new JLabel("Comparations:");
		panel.add(lblComparations, "cell 1 4");

		comparationTF = new JTextField();
		panel.add(comparationTF, "cell 5 4,growx");
		comparationTF.setColumns(10);

		JLabel lblMoves = new JLabel("Moves:");
		panel.add(lblMoves, "cell 1 5");

		movesTF = new JTextField();

		panel.add(movesTF, "cell 5 5,growx");
		movesTF.setColumns(10);

		JButton btnFile = new JButton("File");
		btnFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				if (chooser.showOpenDialog(View.this) == JFileChooser.APPROVE_OPTION) {
					txtFile.setText(chooser.getSelectedFile().getPath());
					model = new Model();
					keys = model.loadFile(chooser.getSelectedFile());
					btnSort.setEnabled(true);
				}
			}
		});
		panel.add(btnFile, "cell 1 7");

		btnSave = new JButton("Save");
		btnSave.setEnabled(false);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(new JFrame(), "Must be .xls file");
				List<Result> results = new ArrayList<Result>();

				ISortingAlgorithm<String> sorter = new BubleSort<String>();

				sorter.sort(keys, 100);
				results.add(sorter.getResult());

				sorter.sort(keys, 1000);
				results.add(sorter.getResult());

				sorter.sort(keys, 2000);
				results.add(sorter.getResult());

				sorter.sort(keys, 5000);
				results.add(sorter.getResult());

				sorter = new CocktailShakerSort<String>();

				sorter.sort(keys, 100);
				results.add(sorter.getResult());

				sorter.sort(keys, 1000);
				results.add(sorter.getResult());

				sorter.sort(keys, 2000);
				results.add(sorter.getResult());

				sorter.sort(keys, 5000);
				results.add(sorter.getResult());

				sorter = new ShellSort<String>();

				sorter.sort(keys, 100);
				results.add(sorter.getResult());

				sorter.sort(keys, 1000);
				results.add(sorter.getResult());

				sorter.sort(keys, 2000);
				results.add(sorter.getResult());

				sorter.sort(keys, 5000);
				results.add(sorter.getResult());

				sorter = new QuickSort<String>();

				sorter.sort(keys, 100);
				results.add(sorter.getResult());

				sorter.sort(keys, 1000);
				results.add(sorter.getResult());

				sorter.sort(keys, 2000);
				results.add(sorter.getResult());

				sorter.sort(keys, 5000);
				results.add(sorter.getResult());

				JFileChooser chooser = new JFileChooser();
				if (chooser.showSaveDialog(View.this) == JFileChooser.APPROVE_OPTION) {
					File excel = chooser.getSelectedFile();
					WritableWorkbook workBook = null;
					try {
						workBook = Workbook.createWorkbook(excel);
						workBook.createSheet("Main Sheet", 0);
						WritableSheet sheet1 = workBook.getSheet(0);
						
						Label l1 = new Label(1, 0, "Comparations");
						Label l2 = new Label(2, 0, "Moves");
						Label l3 = new Label(0, 1, "Buble Sort");
						Label l4 = new Label(0, 5, "Cocktail Shaker Sort");
						Label l5 = new Label(0, 9, "Shell Sort");
						Label l6 = new Label(0, 13, "Quick Sort");
						
						sheet1.addCell(l1);
						sheet1.addCell(l2);
						sheet1.addCell(l3);
						sheet1.addCell(l4);
						sheet1.addCell(l5);
						sheet1.addCell(l6);

						int i = 1;
						for (Result result : results) {
							Number n1 = new Number(1, i, result.comparations);
							Number n2 = new Number(2, i, result.moves);
							sheet1.addCell(n1);
							sheet1.addCell(n2);
							i++;
						}
						workBook.write();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (RowsExceededException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (WriteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} finally {
						if (workBook != null)
							try {
								workBook.close();
							} catch (WriteException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					}

				}
			}
		});
		
				btnSort = new JButton("Sort");
				btnSort.setEnabled(false);
				btnSort.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String moveText = "";
						String comparationText = "";
						int numbers = Integer.parseInt(comboBox.getSelectedItem().toString());

						if (comboBox_1.getSelectedItem().equals("Buble Sort")) {
							model.bubleSort(numbers);
						} else if (comboBox_1.getSelectedItem().equals("Cocktail Shaker Sort")) {
							model.Cocktail(numbers);
						} else if (comboBox_1.getSelectedItem().equals("Shell Sort")) {
							model.shellSort(numbers);
						} else if (comboBox_1.getSelectedItem().equals("Quick Sort")) {
							model.quickSort(numbers);
						}

						moveText = String.valueOf(model.result.getMoves());
						comparationText = String.valueOf(model.result.getComparations());
						movesTF.setText(moveText);
						comparationTF.setText(comparationText);
						btnSave.setEnabled(true);
					}
				});
				panel.add(btnSort, "flowx,cell 5 7");
		panel.add(btnSave, "cell 5 7");

		JLabel lblSorted = new JLabel("Ready");
		lblSorted.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblSorted, "cell 6 7");
	}

}
