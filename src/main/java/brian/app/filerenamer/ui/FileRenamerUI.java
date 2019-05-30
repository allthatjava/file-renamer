package brian.app.filerenamer.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import org.dyno.visual.swing.layouts.Bilateral;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;

import brian.app.filerenamer.FileRenamer;



//VS4E -- DO NOT REMOVE THIS LINE!
public class FileRenamerUI extends JFrame {

	JFileChooser fc;
	
	private static final long serialVersionUID = 1L;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JLabel jLabel3;
	private JLabel jLabel0;
	private JTextField textDirectory;
	private JTextField textStartWith;
	private JTextField textEndWith;
	private JButton jButton0;
	private JTextArea textAreaLog;
	private JScrollPane jScrollPane1;
	private JCheckBox checkAddCreatedDate;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JButton jButton1;
	private JPanel jPanel0;

	private JTextField textPreviewInput;

	private JPanel jPanel1;

	private JTextPane textPanePreviewResult;

	private JScrollPane jScrollPane0;

	private JTextField textReplaceWith;

	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";

	public FileRenamerUI() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getJLabel4(), new Constraints(new Leading(14, 12, 12), new Leading(240, 10, 10)));
		add(getJPanel0(), new Constraints(new Leading(9, 532, 12, 12), new Leading(9, 225, 12, 12)));
		add(getJScrollPane1(), new Constraints(new Leading(14, 527, 12, 12), new Leading(258, 153, 10, 10)));
		setSize(559, 426);
	}

	private JTextField getTextReplaceWith() {
		if (textReplaceWith == null) {
			textReplaceWith = new JTextField();
			textReplaceWith.addKeyListener(new KeyAdapter() {
	
				public void keyReleased(KeyEvent event) {
					textReplaceWithKeyKeyReleased(event);
				}
			});
		}
		return textReplaceWith;
	}

	private JTextField getJTextField2() {
		if (textReplaceWith == null) {
			textReplaceWith = new JTextField();
		}
		return textReplaceWith;
	}

	private JScrollPane getJScrollPane0() {
		if (jScrollPane0 == null) {
			jScrollPane0 = new JScrollPane();
			jScrollPane0.setViewportView(getJTextPane0());
		}
		return jScrollPane0;
	}

	private JTextPane getJTextPane0() {
		if (textPanePreviewResult == null) {
			textPanePreviewResult = new JTextPane();
			textPanePreviewResult.setBorder(null);
			textPanePreviewResult.setText("IMG000-20110101-001.jpg");
			textPanePreviewResult.setEnabled(false);
		}
		return textPanePreviewResult;
	}

	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Preview", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", Font.PLAIN,
					11), Color.black));
			jPanel1.setLayout(new GroupLayout());
			jPanel1.add(getJScrollPane0(), new Constraints(new Leading(2, 142, 10, 10), new Bilateral(23, 0, 23)));
		}
		return jPanel1;
	}

	private JTextField getJTextField4() {
		if (textPreviewInput == null) {
			textPreviewInput = new JTextField();
			textPreviewInput.setText("IMG000-20110101-001.jpg");
		}
		return textPreviewInput;
	}

	private JPanel getJPanel0() {
		if (jPanel0 == null) {
			jPanel0 = new JPanel();
			jPanel0.setBorder(BorderFactory.createTitledBorder(null, "Rename Files", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new Font("Tahoma",
					Font.PLAIN, 11), Color.black));
			jPanel0.setLayout(new GroupLayout());
			jPanel0.add(getJCheckBox0(), new Constraints(new Leading(36, 10, 10), new Leading(94, 10, 10)));
			jPanel0.add(getJLabel5(), new Constraints(new Leading(6, 12, 12), new Leading(0, 12, 12)));
			jPanel0.add(getJLabel6(), new Constraints(new Leading(6, 12, 12), new Leading(125, 12, 12)));
			jPanel0.add(getJTextField1(), new Constraints(new Leading(98, 210, 10, 10), new Leading(71, 12, 12)));
			jPanel0.add(getJTextField3(), new Constraints(new Leading(98, 291, 10, 10), new Leading(16, 12, 12)));
			jPanel0.add(getJButton1(), new Constraints(new Leading(395, 12, 12), new Leading(15, 12, 12)));
			jPanel0.add(getJButton0(), new Constraints(new Leading(6, 12, 12), new Leading(177, 12, 12)));
			jPanel0.add(getJTextField0(), new Constraints(new Leading(98, 211, 12, 12), new Leading(46, 12, 12)));
			jPanel0.add(getTextReplaceWith(), new Constraints(new Leading(98, 211, 12, 12), new Leading(46, 12, 12)));
			jPanel0.add(getJTextField4(), new Constraints(new Leading(365, 145, 12, 12), new Leading(109, 18, 12, 12)));
			jPanel0.add(getJPanel1(), new Constraints(new Leading(358, 158, 12, 12), new Leading(92, 97, 12, 12)));
			jPanel0.add(getJTextField2(), new Constraints(new Leading(98, 210, 12, 12), new Leading(142, 12, 12)));
			jPanel0.add(getJLabel3(), new Constraints(new Leading(26, 10, 10), new Leading(20, 12, 12, 12)));
			jPanel0.add(getJLabel0(), new Constraints(new Leading(26, 12, 12), new Leading(50, 12, 12, 12)));
			jPanel0.add(getJLabel1(), new Constraints(new Leading(26, 12, 12), new Leading(74, 12, 12)));
			jPanel0.add(getJLabel2(), new Constraints(new Leading(26, 12, 12), new Leading(142, 12, 12)));
		}
		return jPanel0;
	}

	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("Choose Directory");
			jButton1.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					jButton1MouseMouseClicked(event);
				}
			});
		}
		return jButton1;
	}

	private JLabel getJLabel6() {
		if (jLabel6 == null) {
			jLabel6 = new JLabel();
			jLabel6.setText("To");
		}
		return jLabel6;
	}

	private JLabel getJLabel5() {
		if (jLabel5 == null) {
			jLabel5 = new JLabel();
			jLabel5.setText("From");
		}
		return jLabel5;
	}

	private JLabel getJLabel4() {
		if (jLabel4 == null) {
			jLabel4 = new JLabel();
			jLabel4.setText("Log");
		}
		return jLabel4;
	}

	private JCheckBox getJCheckBox0() {
		if (checkAddCreatedDate == null) {
			checkAddCreatedDate = new JCheckBox();
			checkAddCreatedDate.setText("Add Created Date on beginning of the file name");
		}
		return checkAddCreatedDate;
	}

	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setViewportView(getJTextArea0());
		}
		return jScrollPane1;
	}

	private JTextArea getJTextArea0() {
		if (textAreaLog == null) {
			textAreaLog = new JTextArea();
			textAreaLog.setLineWrap(true);
			textAreaLog.setWrapStyleWord(true);
		}
		return textAreaLog;
	}

	private JButton getJButton0() {
		if (jButton0 == null) {
			jButton0 = new JButton();
			jButton0.setText("Rename them >");
			jButton0.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					jButton0MouseMouseClicked(event);
				}
			});
		}
		return jButton0;
	}

	private JTextField getJTextField1() {
		if (textEndWith == null) {
			textEndWith = new JTextField();
			textEndWith.addKeyListener(new KeyAdapter() {
	
				public void keyReleased(KeyEvent event) {
					textEndWithKeyKeyReleased(event);
				}
			});
		}
		return textEndWith;
	}

	private JTextField getJTextField0() {
		if (textStartWith == null) {
			textStartWith = new JTextField();
			textStartWith.addKeyListener(new KeyAdapter() {
	
				public void keyReleased(KeyEvent event) {
					textStartWithKeyKeyReleased(event);
				}
			});
		}
		return textStartWith;
	}

	private JTextField getJTextField3() {
		if (textDirectory == null) {
			textDirectory = new JTextField();
		}
		return textDirectory;
	}

	private JLabel getJLabel0() {
		if (jLabel0 == null) {
			jLabel0 = new JLabel();
			jLabel0.setText("Start With");
		}
		return jLabel0;
	}

	private JLabel getJLabel3() {
		if (jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setText("Directory");
		}
		return jLabel3;
	}

	private JLabel getJLabel1() {
		if (jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("End With");
		}
		return jLabel1;
	}

	private JLabel getJLabel2() {
		if (jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("Replace With");
		}
		return jLabel2;
	}

	private static void installLnF() {
		try {
			String lnfClassname = PREFERRED_LOOK_AND_FEEL;
//			if (lnfClassname == null)
//				lnfClassname = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(lnfClassname);
		} catch (Exception e) {
			System.err.println("Cannot install " + PREFERRED_LOOK_AND_FEEL
					+ " on this platform:" + e.getMessage());
		}
	}

	/**
	 * Main entry of the class.
	 * Note: This class is only created so that you can easily preview the result at runtime.
	 * It is not expected to be managed by the designer.
	 * You can modify it as you like.
	 */
	public static void main(String[] args) {
		installLnF();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				FileRenamerUI frame = new FileRenamerUI();
				frame.setDefaultCloseOperation(FileRenamerUI.EXIT_ON_CLOSE);
				frame.setTitle("FileRenamerUI");
				frame.getContentPane().setPreferredSize(frame.getSize());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

	private void jButton0MouseMouseClicked(MouseEvent event) 
	{
		FileRenamer renamer = new FileRenamer(textDirectory.getText(), 
				textStartWith.getText(), textEndWith.getText(), 
				checkAddCreatedDate.isSelected(), 
				textReplaceWith.getText(), textAreaLog);
		renamer.renamerFiles();
	}
	
	private void jButton1MouseMouseClicked(MouseEvent event) 
	{
		fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = fc.showDialog(FileRenamerUI.this, "Select directory");
		
		if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
			textDirectory.setText(file.getAbsolutePath());
        }
	}

	private void textStartWithKeyKeyReleased(KeyEvent event) 
	{
		FileRenamer renamer = new FileRenamer(textDirectory.getText(), 
				textStartWith.getText(), textEndWith.getText(), 
				checkAddCreatedDate.isSelected(), 
				textReplaceWith.getText(), textAreaLog);
		textPanePreviewResult.setText(
				renamer.getNewFileName(textPreviewInput.getText()));
	}

	private void textEndWithKeyKeyReleased(KeyEvent event) 
	{
		FileRenamer renamer = new FileRenamer(textDirectory.getText(), 
				textStartWith.getText(), textEndWith.getText(), 
				checkAddCreatedDate.isSelected(), 
				textReplaceWith.getText(), textAreaLog);
		textPanePreviewResult.setText(
				renamer.getNewFileName(textPreviewInput.getText()));
	}
	
	private void textReplaceWithKeyKeyReleased(KeyEvent event) 
	{
		FileRenamer renamer = new FileRenamer(textDirectory.getText(), 
				textStartWith.getText(), textEndWith.getText(), 
				checkAddCreatedDate.isSelected(), 
				textReplaceWith.getText(), textAreaLog);
		textPanePreviewResult.setText(
				renamer.getNewFileName(textPreviewInput.getText()));
	}

}
