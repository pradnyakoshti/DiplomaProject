


import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class settingsFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** Creates new form NewJFrame */
	public settingsFrame() {
        initComponents();
	}

	public void initComponents() {
		// TODO Auto-generated method stub
		masterPasswordLabel = new JLabel();
        masterPasswordButton = new JButton();
        masterPasswordField = new JPasswordField();
        settingsPanel = new JPanel();
        thresholdIndicatorLabel = new JLabel();
        thresholdLabel = new JLabel();
        thresholdSlider = new JSlider();
        lNFLabel = new JLabel();
        lNFJavaRadioButton = new JRadioButton("Java");
        lNFWinRadioButton = new JRadioButton("Windows");
        lNFButtonGroup = new ButtonGroup();
        deleteLabel = new JLabel();
        deleteButton = new JButton();
        commitButton = new JButton();
        quitButton = new JButton();
        setIcon = new ImageIcon("Images\\173.gif");

        setLayout(null);

        setMaximizedBounds(new Rectangle(0, 0, 400, 400));
        setPreferredSize(new Dimension(400, 400));
        setBounds(new Rectangle(0, 0 ,400, 200));
        setSize(new Dimension(400, 400));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(true);
        setMinimumSize(new Dimension(400, 400));
        setIconImage(setIcon.getImage());
        setTitle("Settings");
        
        Toolkit tk = getToolkit();
        Dimension sSize = tk.getScreenSize();
        setLocation(sSize.width/4, sSize.height/4);
                
        masterPasswordLabel.setText("Provide Master Password to modify the settings below");
        add(masterPasswordLabel);
        masterPasswordLabel.setBounds(20, 30, 320, 14);

        masterPasswordButton.setText("Sign In");
        add(masterPasswordButton);
        masterPasswordButton.setBounds(230, 60, 90, 25);
        masterPasswordButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evt) {
        		String pass = new String(masterPasswordField.getPassword());
        		//System.out.println(pass);
        		if (pass.equals("root")) {
        			displaySettingsPanel(true);
        			masterPasswordField.setEnabled(false);
        			masterPasswordButton.setEnabled(false);
        		}
        		else {
        			JOptionPane.showMessageDialog(new JFrame(), "Invalid Password.\n", "Error", JOptionPane.ERROR_MESSAGE);
        		}
        	}
        });

        add(masterPasswordField);
        masterPasswordField.setBounds(60, 60, 150, 23);

        settingsPanel.setLayout(null);

        settingsPanel.setBorder(BorderFactory.createTitledBorder("Settings"));
        thresholdIndicatorLabel.setBorder(BorderFactory.createTitledBorder(""));
        thresholdIndicatorLabel.addComponentListener(new ComponentAdapter() {
            public void componentShown(ComponentEvent evt) {
                thresholdIndicatorLabelComponentShown(evt);
            }
        });

        settingsPanel.add(thresholdIndicatorLabel);
        thresholdIndicatorLabel.setBounds(270, 40, 40, 30);

        thresholdLabel.setText("Threshold Value for Verification");
        settingsPanel.add(thresholdLabel);
        thresholdLabel.setBounds(20, 20, 250, 14);

        thresholdSlider.setMinimum(80);
        thresholdSlider.setMinorTickSpacing(2);
        thresholdSlider.setPaintLabels(true);
        thresholdSlider.setPaintTicks(true);
        thresholdSlider.setSnapToTicks(true);
        thresholdSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                thresholdSliderStateChanged(evt);
            }
        });

        settingsPanel.add(thresholdSlider);
        thresholdSlider.setBounds(20, 40, 220, 30);

        lNFLabel.setText("Select the Default Look and Feel");
        settingsPanel.add(lNFLabel);
        lNFLabel.setBounds(20, 80, 200, 14);
        
        lNFButtonGroup.add(lNFJavaRadioButton);
        lNFButtonGroup.add(lNFWinRadioButton);
        
        settingsPanel.add(lNFJavaRadioButton);
        lNFJavaRadioButton.setBounds(20, 100, 80, 33);
        settingsPanel.add(lNFWinRadioButton);
        lNFWinRadioButton.setBounds(100, 100, 100, 33);

        /*
        mouseSensitivitySlider.setMaximum(10);
        mouseSensitivitySlider.setMinimum(1);
        mouseSensitivitySlider.setMinorTickSpacing(1);
        mouseSensitivitySlider.setPaintLabels(true);
        mouseSensitivitySlider.setPaintTicks(true);
        mouseSensitivitySlider.setSnapToTicks(true);
        mouseSensitivitySlider.setValue(1);
        settingsPanel.add(mouseSensitivitySlider);
        mouseSensitivitySlider.setBounds(20, 100, 220, 33);
        mouseSensitivitySlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                mouseSensitivitySliderStateChanged(evt);
            }
        });

        mouseSensitivityIndicatorLabel.setBorder(BorderFactory.createTitledBorder(""));
        mouseSensitivityIndicatorLabel.addComponentListener(new ComponentAdapter() {
            public void componentShown(ComponentEvent evt) {
                mouseSensitivityIndicatorLabelComponentShown(evt);
            }
        });

        settingsPanel.add(mouseSensitivityIndicatorLabel);
        mouseSensitivityIndicatorLabel.setBounds(270, 100, 40, 30);
        */
        
        deleteLabel.setText("Delete Client's Database");
        settingsPanel.add(deleteLabel);
        deleteLabel.setBounds(20, 135, 150, 40);
        
        deleteButton.setText("Delete");
        settingsPanel.add(deleteButton);
        deleteButton.setBounds(200, 147, 80, 23);
        deleteButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evt) {
        		deleteButtonActionPerformed(evt);
        	}
        });

        commitButton.setText("Commit");
        settingsPanel.add(commitButton);
        commitButton.setBounds(140, 185, 80, 23);
        commitButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evt) {
        		FileOutputStream op = null;
        		PrintWriter pw = null;
        		try {
					op = new FileOutputStream(".settings\\settings.cfg");
					pw = new PrintWriter(op);
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(new JFrame(), "No Settings File Found. Cannot Continue.\nPlease contact Developers for further help.", "Error", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
					dispose();
				}
				
				threshold = thresholdSlider.getValue();
				
				if (lNFJavaRadioButton.isSelected())
					lNF = 1.0;
				else
					lNF = 2.0;
				pw.print((threshold/100) + "\n" + lNF);
				try {
					pw.close();
					op.close();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				displaySettingsPanel(false);
        	}
        });

        add(settingsPanel);
        
        quitButton.setText("Quit");
        add(quitButton);
        quitButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evt) {
        		dispose();
        	}
        });
        quitButton.setBounds(160, 330, 80, 30);
        
        settingsPanel.setBounds(20, 110, 360, 220);
        
        performBackend();
	}
	
	public void thresholdSliderStateChanged(ChangeEvent evt) {
		thresholdIndicatorLabel.setText(thresholdSlider.getValue() + "");
    	//System.out.println(thresholdSlider.getValue());
    }
    
	public void thresholdIndicatorLabelComponentShown(ComponentEvent evt) {
		thresholdIndicatorLabel.setText(thresholdSlider.getValue() + "");
	}
	
	/**
	 * 
	 * @param evt Event Performed over the delete Button
	 */
	public void deleteButtonActionPerformed(ActionEvent evt) {
		setVisible(false);
		delFrame = new JFrame();
		infoPanel = new JPanel();
        fnameLabel = new JLabel();
        lnameLabel = new JLabel();
        usnLabel = new JLabel();
        fnameField = new JTextField();
        lnameField = new JTextField();
        usnField = new JTextField();
        deleteConfirmButton = new JButton();

        delFrame.setLayout(null);
        delFrame.setAlwaysOnTop(true);
        delFrame.setMaximizedBounds(new Rectangle(0, 0, 290, 200));
        delFrame.setPreferredSize(new Dimension(290, 200));
        delFrame.setBounds(new Rectangle(0, 0 ,290, 200));
        delFrame.setSize(new Dimension(290, 200));
        delFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        delFrame.setResizable(true);
        delFrame.setMinimumSize(new Dimension(290, 200));
        delFrame.setTitle("Delete User");

        infoPanel.setLayout(null);

        infoPanel.setBorder(BorderFactory.createTitledBorder("User Information"));
        fnameLabel.setText("First Name");
        infoPanel.add(fnameLabel);
        fnameLabel.setBounds(20, 20, 70, 14);

        lnameLabel.setText("Last Name");
        infoPanel.add(lnameLabel);
        lnameLabel.setBounds(20, 50, 70, 14);

        usnLabel.setText("USN");
        infoPanel.add(usnLabel);
        usnLabel.setBounds(20, 80, 50, 14);

        infoPanel.add(fnameField);
        fnameField.setBounds(100, 20, 130, 19);

        infoPanel.add(lnameField);
        lnameField.setBounds(100, 50, 130, 19);

        infoPanel.add(usnField);
        usnField.setBounds(100, 80, 130, 19);

        deleteConfirmButton.setText("Delete");
        deleteConfirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	if (fnameField.getText().length()==0 || lnameField.getText().length()==0 || usnField.getText().length()==0) {
            		JOptionPane.showMessageDialog(new JFrame(), "All fields are mandatory.\n", "Error", JOptionPane.ERROR_MESSAGE);
            		delFrame.dispose();
            		setVisible(true);
            		return;
            	}
                int option = JOptionPane.showConfirmDialog(new JFrame(), "Do you really want to delete the user?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.NO_OPTION) {
                	delFrame.dispose();
                	setVisible(true);
                	return;
                }
                if (option == JOptionPane.YES_OPTION) {
                	String folderName = new String(fnameField.getText() + lnameField.getText() + usnField.getText());
                	//System.out.println(folderName);
                	deleteUser(folderName);
                }
                setVisible(true);
            }
        });

        infoPanel.add(deleteConfirmButton);
        deleteConfirmButton.setBounds(90, 110, 73, 23);

        delFrame.add(infoPanel);
        infoPanel.setBounds(10, 0, 260, 150);
        delFrame.setVisible(true);
	}
	
	/**
	 * 
	 * @param folderName The user database to be deleted
	 */
	public void deleteUser(String folderName) {
		folderName = folderName.toLowerCase();
		if (folderName.equals("signatureRecognition") 
				|| folderName.equals(".settings")
				|| folderName.equals("media")
				|| folderName.equals("images")
				|| folderName.equals("doc")) {
			JOptionPane.showMessageDialog(new JFrame(), "Not Allowed!!! ", "Error", JOptionPane.ERROR_MESSAGE);
			delFrame.dispose();
			return;
		}
		try {
			File f1 = new File(folderName);
			if (!f1.exists() || !f1.isDirectory()) {
				JOptionPane.showMessageDialog(new JFrame(), "User Database Does Not Exist.\n", "Error", JOptionPane.ERROR_MESSAGE);
				delFrame.dispose();
				return;
			}
			else {
				File[] files = f1.listFiles();
				for (int i=0; i<files.length; i++) {
					files[i].delete();
				}
				f1.delete();
				delFrame.dispose();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param value Display the Settings Panel based on the argument
	 */
	public void displaySettingsPanel(boolean value) {
		thresholdSlider.setEnabled(value);
		lNFJavaRadioButton.setEnabled(value);
		lNFWinRadioButton.setEnabled(value);
		//mouseSensitivitySlider.setEnabled(value);
		commitButton.setEnabled(value);
		deleteButton.setEnabled(value);
	}
	
    public void performBackend() {
		// TODO Auto-generated method stub
		addWindowListener(new WindowAdapter() {

			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				FileInputStream ip = null;
				Scanner sc = null;
				try {
					ip = new FileInputStream(".settings\\settings.cfg");
					sc = new Scanner(ip);
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(new JFrame(), "No Settings File Found. Cannot Continue.\n", "Error", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
					dispose();
				}
				
				threshold = sc.nextDouble();
				thresholdSlider.setValue((int)(threshold*100));
				thresholdIndicatorLabel.setText((int)(threshold*100) + "");
				//mouseSensitivity = sc.nextDouble();
				//mouseSensitivitySlider.setValue((int)(mouseSensitivity*100));
				//mouseSensitivityIndicatorLabel.setText((int)(mouseSensitivity*100) + "");
				
				lNF = sc.nextDouble();
				if (lNF == 1.0) {
					lNFJavaRadioButton.setSelected(true);
				}
				else 
					lNFWinRadioButton.setSelected(true);
				
				try {
					sc.close();
					ip.close();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				displaySettingsPanel(false);
			}
			
		});
	}

	/**
	 * @param args Unused
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public JButton commitButton;
    public JButton masterPasswordButton;
    public JPasswordField masterPasswordField;
    public JLabel masterPasswordLabel;
    public JLabel lNFLabel;
    public JRadioButton lNFJavaRadioButton;
    public JRadioButton lNFWinRadioButton;
    public ButtonGroup lNFButtonGroup;
    public JPanel settingsPanel;
    public JLabel thresholdIndicatorLabel;
    public JLabel thresholdLabel;
    public JSlider thresholdSlider;
    public JLabel deleteLabel;
    public JButton deleteButton; 
    public JButton quitButton;
    public ImageIcon setIcon;
    
    private JFrame delFrame;
    private JButton deleteConfirmButton;
    private JTextField fnameField;
    private JLabel fnameLabel;
    private JPanel infoPanel;
    private JTextField lnameField;
    private JLabel lnameLabel;
    private JTextField usnField;
    private JLabel usnLabel;
    
    /**
     * Threshold used for verification
     */
    public double threshold = 0.90;
    
    /**
     * Look and Feel
     */
    public double lNF = 1.0;
  
}
