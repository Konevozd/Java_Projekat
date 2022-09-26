package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import net.miginfocom.swing.MigLayout;
import util.Nationality;
import util.Utility;

import javax.swing.JLabel;
import javax.swing.JTextField;

import music.Musician;

import javax.swing.JSpinner;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.Dimension;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewMusician extends JDialog {
	private JPanel panelSouth;
	private JTabbedPane tabbedPane;
	private JPanel panelPhoto;
	private JPanel panelInfoo;
	private JLabel lblName;
	private JLabel lblAge;
	private JLabel lblAlive;
	private JLabel lblNationality;
	private JTextField textField;
	private JSpinner spinnerAge;
	private JComboBox comboBoxAlive;
	private JComboBox comboBoxNationality;
	private JLabel lblPhoto;
	private JComboBox comboBoxPhoto;
	private JLabel lblImage;

	private NewMusician newMusician = this; //
	
	private Musician musician;
	
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewMusician dialog = new NewMusician();
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
	public NewMusician(JFrame owner, boolean modal) { //modal = true - blokira nesto dok se ne zavrsi jedna stvar,npr kad otvorimo openfile 
		super(owner, modal);
		setTitle("Musician");
		setBounds(150, 150, 450, 300);
		getContentPane().add(getPanelSouth(), BorderLayout.SOUTH);
		getContentPane().add(getTabbedPane(), BorderLayout.CENTER);

	}
	
	public NewMusician() {
		setTitle("Musician");
		setBounds(150, 150, 450, 300);
		getContentPane().add(getPanelSouth(), BorderLayout.SOUTH);
		getContentPane().add(getTabbedPane(), BorderLayout.CENTER);

	}

	public Musician showDialog() {
		newMusician.setVisible(true);
		dispose(); //oslobodi onaj deo video memorije koji je rezervisan za prikazivanje te komponente na ekranu
		return musician;
	}
	
	private JPanel getPanelSouth() {
		if (panelSouth == null) {
			panelSouth = new JPanel();
			panelSouth.add(getBtnNewButton());
			panelSouth.add(getBtnNewButton_1());
		}
		return panelSouth;
	}
	private JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.addTab("Info", null, getPanelInfoo(), null);
			tabbedPane.addTab("Photo", null, getPanelPhoto(), null);
		}
		return tabbedPane;
	}
	private JPanel getPanelPhoto() {
		if (panelPhoto == null) {
			panelPhoto = new JPanel();
			panelPhoto.setLayout(new MigLayout("", "[][grow]", "[][grow]"));
			panelPhoto.add(getLblPhoto(), "cell 0 0,alignx trailing");
			panelPhoto.add(getComboBoxPhoto(), "cell 1 0,growx");
			panelPhoto.add(getLblImage(), "cell 1 1");
		}
		return panelPhoto;
	}
	private JPanel getPanelInfoo() {
		if (panelInfoo == null) {
			panelInfoo = new JPanel();
			panelInfoo.setLayout(new MigLayout("", "[][grow]", "[][][][]"));
			panelInfoo.add(getLblName(), "cell 0 0,alignx left");
			panelInfoo.add(getTextField(), "cell 1 0,growx");
			panelInfoo.add(getLblAge(), "cell 0 1");
			panelInfoo.add(getSpinnerAge(), "cell 1 1,alignx right");
			panelInfoo.add(getLblAlive(), "cell 0 2,alignx left");
			panelInfoo.add(getComboBoxAlive(), "cell 1 2,growx");
			panelInfoo.add(getLblNationality(), "cell 0 3,alignx trailing");
			panelInfoo.add(getComboBoxNationality(), "cell 1 3,growx");
		}
		return panelInfoo;
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Name");
		}
		return lblName;
	}
	private JLabel getLblAge() {
		if (lblAge == null) {
			lblAge = new JLabel("Age");
		}
		return lblAge;
	}
	private JLabel getLblAlive() {
		if (lblAlive == null) {
			lblAlive = new JLabel("Alive");
		}
		return lblAlive;
	}
	private JLabel getLblNationality() {
		if (lblNationality == null) {
			lblNationality = new JLabel("Nationality");
		}
		return lblNationality;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
		}
		return textField;
	}
	private JSpinner getSpinnerAge() {
		if (spinnerAge == null) {
			spinnerAge = new JSpinner();
			spinnerAge.setMinimumSize(new Dimension(50, 20));
		}
		return spinnerAge;
	}
	private JComboBox getComboBoxAlive() {
		if (comboBoxAlive == null) {
			comboBoxAlive = new JComboBox();
			comboBoxAlive.addItem("Alive");
			comboBoxAlive.addItem("Deceased");
		}
		return comboBoxAlive;
	}
	private JComboBox getComboBoxNationality() {
		if (comboBoxNationality == null) {
			comboBoxNationality = new JComboBox();
			for(Nationality n : Nationality.values()) {
				comboBoxNationality.addItem(n.name());
			}
		}
		return comboBoxNationality;
	}
	private JLabel getLblPhoto() {
		if (lblPhoto == null) {
			lblPhoto = new JLabel("Photo");
		}
		return lblPhoto;
	}
	private JComboBox getComboBoxPhoto() {
		if (comboBoxPhoto == null) {
			comboBoxPhoto = new JComboBox();
				for(String photoFileName : Utility.getPhotoFileNames()) {
					comboBoxPhoto.addItem(photoFileName);
//					lblIlustration.setIcon(new ImageIcon("C:\\Users\\neman\\Desktop\\Ostalo\\raf camora.jpg"));	
				}
				comboBoxPhoto.setSelectedIndex(0);
				comboBoxPhoto.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(e.getStateChange() == ItemEvent.SELECTED) {
						lblImage.setIcon(new ImageIcon(Utility.getResourcesDir() + (String) comboBoxPhoto.getSelectedItem()));
					}
				}
			});
		}
		return comboBoxPhoto;
	}
	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("");
		}
		return lblImage;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("OK");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					musician = null;
//					musician = new Musician();
//					musician.setName(textField.getText());
					newMusician.setVisible(false);
				}
			});
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Cancel");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					musician = null;
					newMusician.setVisible(false);
				}
			});
		}
		return btnNewButton_1;
	}
}
