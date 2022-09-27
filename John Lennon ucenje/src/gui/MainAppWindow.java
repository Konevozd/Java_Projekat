package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import net.miginfocom.swing.MigLayout;
import util.Utility;

import javax.swing.JComboBox;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import music.Musician;
import music.Song;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ItemEvent;

public class MainAppWindow {

	private JFrame frmRemember;
	private JPanel panelNorth;
	private JPanel panelWest;
	private JPanel panelEast;
	private JPanel panelSouth;
	private JPanel panelCenter;
	private JLabel lblNewLabel;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenuEdit;
	private JMenu mnNewMenuHelp;
	private JMenuItem mntmNewMenuItem;
	private JLabel lblNewLabel_1;
	private JComboBox comboBoxSong;
	private JLabel Year;
	private JLabel lblYearString;
	private JLabel lblMusician;
	private JComboBox comboBoxMusician;
	private JLabel lblNationality;
	private JLabel lblNationalityString;
	private JButton btnModifySong;
	private JButton btnSaveSong;
	private JButton btnModifyMusician;
	private JButton btnSaveMusician;
	private JSplitPane splitPane;
	private JScrollPane scrollPaneLeft;
	private JScrollPane scrollPaneRight;
	private JTextArea textAreaLyrics;
	private JLabel lblIlustration;
	private JLabel lblDetails;
	private JRadioButton rdbtnBasic;
	private JRadioButton rdbtnStandard;
	private JRadioButton rdbtnAll;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JMenuItem mntmNewMusician;
	private JMenuItem mntmNewSong;
	
	private Song song;
    private List<Song> songs = new ArrayList<Song>();
	private Musician musician = null;
	private List<Musician> musicians = new ArrayList<Musician>();
	
	private NewMusician newMusician;
	private NewSong newSong;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainAppWindow window = new MainAppWindow();
					window.frmRemember.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainAppWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRemember = new JFrame();
		frmRemember.setTitle("Remember");
		frmRemember.setBounds(100, 100, 624, 495);
		frmRemember.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRemember.getContentPane().add(getPanelNorth(), BorderLayout.NORTH);
		frmRemember.getContentPane().add(getPanelWest(), BorderLayout.WEST);
		frmRemember.getContentPane().add(getPanelEast(), BorderLayout.EAST);
		frmRemember.getContentPane().add(getPanelSouth(), BorderLayout.SOUTH);
		frmRemember.getContentPane().add(getPanelCenter(), BorderLayout.CENTER);
		frmRemember.setJMenuBar(getMenuBar());
	}

	private JPanel getPanelNorth() {
		if (panelNorth == null) {
			panelNorth = new JPanel();
			panelNorth.add(getLblNewLabel());
		}
		return panelNorth;
	}
	private JPanel getPanelWest() {
		if (panelWest == null) {
			panelWest = new JPanel();
			panelWest.setLayout(new MigLayout("", "[grow]", "[][][][][grow][][]"));
			panelWest.add(getLblNewLabel_1(), "cell 0 0");
			panelWest.add(getComboBoxSong(), "cell 0 1,growx");
			panelWest.add(getYear(), "cell 0 2");
			panelWest.add(getLblYearString(), "cell 0 3");
			panelWest.add(getBtnModifySong(), "cell 0 5,growx");
			panelWest.add(getBtnSaveSong(), "cell 0 6,growx");
		}
		return panelWest;
	}
	private JPanel getPanelEast() {
		if (panelEast == null) {
			panelEast = new JPanel();
			panelEast.setLayout(new MigLayout("", "[grow]", "[][][][][grow][][]"));
			panelEast.add(getLblMusician(), "cell 0 0");
			panelEast.add(getComboBoxMusician(), "cell 0 1,growx");
			panelEast.add(getLblNationality(), "cell 0 2");
			panelEast.add(getLblNationalityString(), "cell 0 3");
			panelEast.add(getBtnModifyMusician(), "cell 0 5,growx");
			panelEast.add(getBtnSaveMusician(), "cell 0 6,growx");
		}
		return panelEast;
	}
	private JPanel getPanelSouth() {
		if (panelSouth == null) {
			panelSouth = new JPanel();
			panelSouth.setLayout(new MigLayout("", "[grow][][][][grow]", "[][]"));
			panelSouth.add(getLblDetails(), "cell 1 0 3 1,alignx center");
			panelSouth.add(getRdbtnBasic(), "cell 1 1");
			panelSouth.add(getRdbtnStandard(), "cell 2 1");
			panelSouth.add(getRdbtnAll(), "cell 3 1");
		}
		return panelSouth;
	}
	private JPanel getPanelCenter() {
		if (panelCenter == null) {
			panelCenter = new JPanel();
			panelCenter.setLayout(new MigLayout("", "[grow]", "[grow]"));
			panelCenter.add(getSplitPane(), "cell 0 0,grow");
		}
		return panelCenter;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("John Lennon");
			lblNewLabel.setForeground(new Color(51, 153, 255));
			lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		}
		return lblNewLabel;
	}
	private JMenuBar getMenuBar() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnNewMenu());
			menuBar.add(getMnNewMenuEdit());
			menuBar.add(getMnNewMenuHelp());
		}
		return menuBar;
	}
	private JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("File");
			mnNewMenu.add(getMntmNewMusician());
			mnNewMenu.add(getMntmNewSong());
		}
		return mnNewMenu;
	}
	private JMenu getMnNewMenuEdit() {
		if (mnNewMenuEdit == null) {
			mnNewMenuEdit = new JMenu("Edit");
		}
		return mnNewMenuEdit;
	}
	private JMenu getMnNewMenuHelp() {
		if (mnNewMenuHelp == null) {
			mnNewMenuHelp = new JMenu("Help");
			mnNewMenuHelp.add(getMntmNewMenuItem());
		}
		return mnNewMenuHelp;
	}
	private JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("About");
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(frmRemember,"A simple Swing application inspired by the life and work of John Lennon");
				}
			});
		}
		return mntmNewMenuItem;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Song");
		}
		return lblNewLabel_1;
	}
	private JComboBox getComboBoxSong() {
		if (comboBoxSong == null) {
			comboBoxSong = new JComboBox();
			comboBoxSong.addItemListener(new ItemListener() {
        	    public void itemStateChanged(ItemEvent arg0) {
        	        if (arg0.getStateChange() == ItemEvent.SELECTED) {
        	            Song s = Utility.findSong(((String) comboBoxSong.getSelectedItem()), songs);
//        	            populateSongInfo(s);
//        	            matchMusicianToSong();
        	        }
        	    }
        	});
			comboBoxSong.setPreferredSize(new Dimension(120, 20));
//            songComboBox.addItem("Mother");
//            songComboBox.addItem("I Found Out");
//            songComboBox.addItem("Isolation");
        }
        return comboBoxSong;
	}
	
//	private void populateSongInfo(Song s) {
//        getLblAuthorName().setText(s.getAuthor().getName());
//        getLblYearText().setText(String.valueOf(s.getYear()));
//        getTextArea().setText(s.getLyrics());
//        getLblIllustration().setIcon(s.getAuthor().getIcon());
//    }
	
	private JLabel getYear() {
		if (Year == null) {
			Year = new JLabel("Year");
		}
		return Year;
	}
	private JLabel getLblYearString() {
		if (lblYearString == null) {
			lblYearString = new JLabel("");
			lblYearString.setForeground(new Color(153, 0, 204));
			lblYearString.setFont(new Font("Arial", Font.BOLD, 13));
		}
		return lblYearString;
	}
	private JLabel getLblMusician() {
		if (lblMusician == null) {
			lblMusician = new JLabel("Musician");
		}
		return lblMusician;
	}
	private JComboBox getComboBoxMusician() {
		if (comboBoxMusician == null) {
			comboBoxMusician = new JComboBox();
			comboBoxMusician.setPreferredSize(new Dimension(100, 22));
		}
		return comboBoxMusician;
	}
	private JLabel getLblNationality() {
		if (lblNationality == null) {
			lblNationality = new JLabel("Nationality");
		}
		return lblNationality;
	}
	private JLabel getLblNationalityString() {
		if (lblNationalityString == null) {
			lblNationalityString = new JLabel("");
			lblNationalityString.setForeground(new Color(204, 0, 102));
			lblNationalityString.setFont(new Font("Arial", Font.BOLD, 13));
		}
		return lblNationalityString;
	}
	private JButton getBtnModifySong() {
		if (btnModifySong == null) {
			btnModifySong = new JButton("Modify");
		}
		return btnModifySong;
	}
	private JButton getBtnSaveSong() {
		if (btnSaveSong == null) {
			btnSaveSong = new JButton("Save");
		}
		return btnSaveSong;
	}
	private JButton getBtnModifyMusician() {
		if (btnModifyMusician == null) {
			btnModifyMusician = new JButton("Modify");
		}
		return btnModifyMusician;
	}
	private JButton getBtnSaveMusician() {
		if (btnSaveMusician == null) {
			btnSaveMusician = new JButton("Save");
		}
		return btnSaveMusician;
	}
	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setOneTouchExpandable(true);
			splitPane.setDividerSize(8);
			splitPane.setLeftComponent(getScrollPaneLeft());
			splitPane.setRightComponent(getScrollPaneRight());
			splitPane.setDividerLocation(150);
		}
		return splitPane;
	}
	private JScrollPane getScrollPaneLeft() {
		if (scrollPaneLeft == null) {
			scrollPaneLeft = new JScrollPane();
			scrollPaneLeft.setViewportView(getTextAreaLyrics());
		}
		return scrollPaneLeft;
	}
	private JScrollPane getScrollPaneRight() {
		if (scrollPaneRight == null) {
			scrollPaneRight = new JScrollPane();
			scrollPaneRight.setViewportView(getLblIlustration());
		}
		return scrollPaneRight;
	}
	private JTextArea getTextAreaLyrics() {
		if (textAreaLyrics == null) {
			textAreaLyrics = new JTextArea();
		}
		return textAreaLyrics;
	}
	private JLabel getLblIlustration() {
		if (lblIlustration == null) {
			lblIlustration = new JLabel("");
			lblIlustration.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblIlustration;
	}
	private JLabel getLblDetails() {
		if (lblDetails == null) {
			lblDetails = new JLabel("Details");
			lblDetails.setForeground(new Color(51, 153, 51));
			lblDetails.setFont(new Font("Arial", Font.BOLD, 13));
		}
		return lblDetails;
	}
	private JRadioButton getRdbtnBasic() {
		if (rdbtnBasic == null) {
			rdbtnBasic = new JRadioButton("Basic");
			rdbtnBasic.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(e.getStateChange() == ItemEvent.SELECTED) {
						setVisibility(false, false);
					}
				}
			});
//			rdbtnBasic.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					setVisibility(false,false);
//				}
//			});
			buttonGroup.add(rdbtnBasic);
		}
		return rdbtnBasic;
	}
	private JRadioButton getRdbtnStandard() {
		if (rdbtnStandard == null) {
			rdbtnStandard = new JRadioButton("Standard");
			rdbtnStandard.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					setVisibility(true, false);
				}
			});
//			rdbtnStandard.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					setVisibility(true, false);
//				}
//			});
			rdbtnStandard.setSelected(true);
			buttonGroup.add(rdbtnStandard);
		}
		return rdbtnStandard;
	}
	private JRadioButton getRdbtnAll() {
		if (rdbtnAll == null) {
			rdbtnAll = new JRadioButton("All");
			rdbtnAll.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					setVisibility(true, true);
				}
			});
			buttonGroup.add(rdbtnAll);
		}
		return rdbtnAll;
	}

	private void setVisibility(boolean flagCenter,boolean flagEast) {
		getPanelCenter().setVisible(flagCenter); //gasi se sve u tom panelu
		getLblMusician().setVisible(flagEast);
		getComboBoxMusician().setVisible(flagEast);
		getLblNationality().setVisible(flagEast);
		getLblNationalityString().setVisible(flagEast);
		getBtnModifyMusician().setVisible(flagEast);
		getBtnSaveMusician().setVisible(flagEast);
	}
	private JMenuItem getMntmNewMusician() {
		if (mntmNewMusician == null) {
			mntmNewMusician = new JMenuItem("New Musician...");
			mntmNewMusician.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					newMusician = new NewMusician(frmRemember, true);
					musician = newMusician.showDialog();
				}
			});
		}
		return mntmNewMusician;
	}
	private JMenuItem getMntmNewSong() {
		if (mntmNewSong == null) {
			mntmNewSong = new JMenuItem("New Song");
		}
		return mntmNewSong;
	}
}
