package gui;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import util.Utility;

import javax.swing.SwingConstants;

import music.Musician;
import music.Song;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewSong extends JDialog {
	private JPanel panelSouth;
	private JPanel panelCenter;
	private JLabel lblTitle;
	private JLabel lblAuthor;
	private JLabel lblYear;
	private JLabel lblLyrics;
	private JTextField textFieldTitle;
	private JTextField textFieldYear;
	private JComboBox comboBoxAuthor;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JButton btnOK;
	private JButton btnCancel;

	private NewSong newSong = this;
	private Song song;
	private List<Musician> musicians;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewSong dialog = new NewSong();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public NewSong() {
		setTitle("Song");
		setBounds(100, 100, 450, 300);
		getContentPane().add(getPanelSouth(), BorderLayout.SOUTH);
		getContentPane().add(getPanelCenter(), BorderLayout.CENTER);

	}
	
	public NewSong(JFrame frm, boolean modal) {
		super(frm,modal);
		setTitle("Song");
		setBounds(100, 100, 450, 300);
		getContentPane().add(getPanelSouth(), BorderLayout.SOUTH);
		getContentPane().add(getPanelCenter(), BorderLayout.CENTER);
	}

	 public NewSong(JFrame frm, boolean modal, List<Musician> musicians) {
	        this(frm, modal);
	        this.musicians = musicians;
	        for (Musician m : musicians) { //punimo comboBox svim muzicarima koje moze korisnik da izabere
	            getComboBoxAuthor().addItem(m.getName());
	        }
	 }
	
	public Song showNewSong() {
		newSong.setVisible(true);
		dispose();
		return song;
	}
	 
	private JPanel getPanelSouth() {
		if (panelSouth == null) {
			panelSouth = new JPanel();
			panelSouth.add(getBtnOK());
			panelSouth.add(getBtnCancel());
		}
		return panelSouth;
	}
	private JPanel getPanelCenter() {
		if (panelCenter == null) {
			panelCenter = new JPanel();
			panelCenter.setLayout(new MigLayout("", "[right][grow]", "[][][][grow]"));
			panelCenter.add(getLblTitle(), "cell 0 0,alignx trailing");
			panelCenter.add(getTextFieldTitle(), "cell 1 0,growx");
			panelCenter.add(getLblAuthor(), "cell 0 1,alignx trailing");
			panelCenter.add(getComboBoxAuthor(), "cell 1 1,growx");
			panelCenter.add(getLblYear(), "cell 0 2,alignx trailing");
			panelCenter.add(getTextFieldYear(), "cell 1 2,growx");
			panelCenter.add(getLblLyrics(), "cell 0 3,alignx trailing");
			panelCenter.add(getScrollPane(), "cell 1 3,grow");
		}
		return panelCenter;
	}
	private JLabel getLblTitle() {
		if (lblTitle == null) {
			lblTitle = new JLabel("Title");
			lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblTitle;
	}
	private JLabel getLblAuthor() {
		if (lblAuthor == null) {
			lblAuthor = new JLabel("Author");
			lblAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblAuthor;
	}
	private JLabel getLblYear() {
		if (lblYear == null) {
			lblYear = new JLabel("Year");
			lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblYear;
	}
	private JLabel getLblLyrics() {
		if (lblLyrics == null) {
			lblLyrics = new JLabel("Lyrics");
		}
		return lblLyrics;
	}
	private JTextField getTextFieldTitle() {
		if (textFieldTitle == null) {
			textFieldTitle = new JTextField();
			textFieldTitle.setColumns(10);
		}
		return textFieldTitle;
	}
	private JTextField getTextFieldYear() {
		if (textFieldYear == null) {
			textFieldYear = new JTextField();
			textFieldYear.setColumns(10);
		}
		return textFieldYear;
	}
	private JComboBox getComboBoxAuthor() {
		if (comboBoxAuthor == null) {
			comboBoxAuthor = new JComboBox();
		}
		return comboBoxAuthor;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("OK");
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					song = new Song();
					song.setTitle(textFieldTitle.getText());
					song.setYear(Integer.parseInt(textFieldYear.getText()));
					song.setAuthor(Utility.findMusician((String) comboBoxAuthor.getSelectedItem(), musicians));
					song.setLyrics(textArea.getText());
					
					newSong.setVisible(false);
				}
			});
		}
		return btnOK;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					song = null;
					newSong.setVisible(false);
				}
			});
		}
		return btnCancel;
	}
}
