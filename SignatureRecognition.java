import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.Arrays;

import java.awt.image.*;
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
//import signatureRecognition.*;
import javax.swing.JFileChooser;
import java.io.*;
import java.sql.*;
import javax.imageio.*;




//////////////////
class ImagePanel extends JPanel implements Serializable {
    Image image = null;

    public ImagePanel() {
    }

    public ImagePanel(Image image) {
        this.image = image;
    }


    public void setImage(Image image){
        this.image = image;
    }

    public Image getImage(Image image){
        return image;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); //paint background
        if (image != null) { //there is a picture: draw it
            int height = this.getSize().height;
            int width = this.getSize().width;
            g.drawImage(image,0,0, width, height, this);
            //g.drawImage(image, 0, 0, this); //original image size
         }  //end if
    } //end paint
} //end class



////////////////





public class SignatureRecognition
{
public static void main(String[] args) {
		// TODO Auto-generated method stub
		if ((new splashScreen().start()) == 0) {
			java.awt.EventQueue.invokeLater(new Runnable() {
				public void run() {
					new mainFrame().setVisible(true);
		        }
	        });
		}

	}
}


class splashScreen extends JFrame {

    /**
	 *
	 */
	public static final long serialVersionUID = 1L;

	/** Creates new form splashScreen */
    public splashScreen() {
    	//initComponents();
    	try {
    		setLNF();
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    
}
    public int start() {
    	return initComponents();
    }

    public int initComponents() {

        splashProgressBar = new JProgressBar();
        loadingLabel = new JLabel();
        componentLabel = new JLabel();
        splashPanel = new JPanel();
        splashIcon = new ImageIcon("Images\\splash.jpg");
        splashLabel = new JLabel(splashIcon);

        setLayout(null);
        setSize(new Dimension(520, 350));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMaximizedBounds(new Rectangle(0, 0, 520, 350));
        setPreferredSize(new Dimension(520, 350));
        setUndecorated(true);

        Toolkit tk = getToolkit();
        Dimension sSize = tk.getScreenSize();
        setLocation(sSize.width/4, sSize.height/4);

        splashPanel.setLayout(null);

        splashPanel.setBorder(BorderFactory.createTitledBorder(""));
        splashPanel.add(splashLabel);
        splashLabel.setBounds(0, 0, 500, 300);

        add(splashPanel);
        splashPanel.setBounds(10, 5, 500, 300);

        addWindowListener(new WindowListener() {

			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				java.awt.EventQueue.invokeLater(new Runnable() {
					public void run() {
						playVid();
					}

					private void playVid() {
						// TODO Auto-generated method stub
						try {
							//File url = new File("Media\\credits.avi");
							File url = new File("Media\\Splash.mpg");
						

							

							
								splashPanel.setLayout(null);
								
								
								repaint();
							
						}
						catch (Exception e) {
							e.printStackTrace();
						}




					}
				});
			}

        });

        add(splashProgressBar);
        splashProgressBar.setBounds(10, 305, 500, 15);

        loadingLabel.setText("Loading.......");
        add(loadingLabel);
        loadingLabel.setBounds(160, 325, 70, 14);

        add(componentLabel);
        componentLabel.setBounds(230, 325, 150, 14);

        setVisible(true);

        validateProject();

        return 0;

    }

    public void validateProject() {
    	int progress = -3;

    	String[] file = {"signatureRecognition\\dynamicTimeWarping.class",
    			"signatureRecognition\\ER2.class",
    			"signatureRecognition\\enroll.class",
    			"signatureRecognition\\storageVault.class",
    			"signatureRecognition\\verify.class",
    			".settings\\settings.cfg",
    			"signatureRecognition\\authData.class",
    			"signatureRecognition\\mainFrame.class"
    	};
    	String[] details = {"DTW Module", "Regression Class", "Enrollment", "Access Layer", "Verification Module", "Program Settings", "Authentication Module", "Main Classes" };

    	File ip = null;

    	for (int i=0; i<8; i++) {
    		ip = new File(file[i]);
    	/*	if (!ip.exists()) {
    			JOptionPane.showMessageDialog(new JFrame(), "Error Loading "+details[i]+".\n", "Error", JOptionPane.ERROR_MESSAGE);
    			System.exit(0);
    		}*/
    		progress += 5 + ((i-2)*(i-3));
    		splashProgressBar.setValue(progress);
    		componentLabel.setText(details[i]);
    		try {
				Thread.sleep(1500);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}

    	componentLabel.setText("Graphical UI ");
    	try {
    		Thread.sleep(5000);
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    	splashProgressBar.setValue(100);

    	dispose();
    }

    public void setLNF() throws Exception {
    	FileInputStream ip = new FileInputStream(".settings\\settings.cfg");
    	Scanner sc = new Scanner(ip);
    	double lnf = 0;
    	sc.nextDouble();
    	lnf = sc.nextDouble();
    	switch ((int)lnf) {
    	case 2 : {
    		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    		break;
    	}
    	default : {
    		UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    	}
    	}
    }

    /**
     * @param args Unused
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new splashScreen().setVisible(true);
            }
        });
    }

    public JLabel componentLabel;
    public JPanel splashPanel;
    public JLabel loadingLabel;
    public JLabel splashLabel;
    public JProgressBar splashProgressBar;
    public ImageIcon splashIcon;


    public URL mediaURL;
}



class mainFrame extends JFrame {

    /**
	 *
	 */
	public static final long serialVersionUID = 1L;

	/**
	 * Creates a mainFrame window
	 */
    public mainFrame() {
    	try {
    		setLNF();
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
        initComponents();
    }

    public void setLNF() throws Exception {
    	FileInputStream ip = new FileInputStream(".settings\\settings.cfg");
    	Scanner sc = new Scanner(ip);
    	double lnf = 0;
    	sc.nextDouble();
    	lnf = sc.nextDouble();
    	switch ((int)lnf) {
    	case 2 : {
    		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    		break;
    	}
    	default : {
    		UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    	}
    	}
    }

    public void initComponents() {
        startTrainingLabel = new JLabel();
        trainingGoButton = new JButton();
        startRecogLabel = new JLabel();
        recogGoButton = new JButton();
        menuBar = new JMenuBar();
        fileMenu = new JMenu();
        settingsMenuItem = new JMenuItem();
        quitMenuItem = new JMenuItem();
        helpMenu = new JMenu();
        aboutMenuItem = new JMenuItem();
        docMenuItem = new JMenuItem();
        eulaMenuItem = new JMenuItem();
        titleImage = new ImageIcon("Images\\Title.jpg");
        titleImageLabel = new JLabel(titleImage);
        mainIcon = new ImageIcon("Images\\1.gif");

        setLayout(null);

        add(titleImageLabel);
        titleImageLabel.setBounds(0, 0, 400, 200);

        setMaximizedBounds(new Rectangle(0, 0, 400, 400));
        setPreferredSize(new Dimension(400, 400));
        setBounds(new Rectangle(0, 0 ,400, 200));
        setSize(new Dimension(400, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(true);
        setMinimumSize(new Dimension(400, 400));
        setTitle("Signature Verification");
        setIconImage(mainIcon.getImage());

        Toolkit tk = getToolkit();
        Dimension sSize = tk.getScreenSize();
        setLocation(sSize.width/4, sSize.height/4);

        startTrainingLabel.setText("Click here to Store Signature In DB");
        getContentPane().add(startTrainingLabel);
        startTrainingLabel.setBounds(20, 225, 306, 15);

        trainingGoButton.setText("Go");
        trainingGoButton.setToolTipText("Start Training Module");
        trainingGoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                trainingGoButtonActionPerformed(evt);
            }
        });

        getContentPane().add(trainingGoButton);
        trainingGoButton.setBounds(300, 220, 50, 23);

        startRecogLabel.setText("Click here to start the Verification Window");
        getContentPane().add(startRecogLabel);
        startRecogLabel.setBounds(20, 265, 300, 15);

        recogGoButton.setText("Go");
        recogGoButton.setToolTipText("Start Verification Module");
        recogGoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                recogGoButtonActionPerformed(evt);
            }
        });

        getContentPane().add(recogGoButton);
        recogGoButton.setBounds(300, 260, 50, 23);

        fileMenu.setText("File");

        settingsMenuItem.setText("Settings");
        settingsMenuItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evt) {
        		EventQueue.invokeLater(new Runnable() {
        			public void run() {
        				//new settingsFrame().setVisible(true);
        			}
        		});
        	}
        });

        quitMenuItem.setText("Quit");
        quitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                quitMenuItemActionPerformed(evt);
            }
        });

        fileMenu.add(settingsMenuItem);
        fileMenu.add(quitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText("Help");

        docMenuItem.setText("Documentation");
        docMenuItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg) {
        		Runtime r = Runtime.getRuntime();
        		File f = new File("doc\\index.html");
        		if (!f.exists()) {
        			JOptionPane.showMessageDialog(new JFrame(), "Could Not Invoke Documentation.\n", "Error", JOptionPane.ERROR_MESSAGE);
        			return;
        		}
        		try {
            		String path = f.getCanonicalPath();
            		//System.out.println(path);
        			//String cmd[] = {"C:/Program Files/Internet Explorer/iexplore.exe ", path};
            		String cmd[] = {"%System%/../../Program Files/Internet Explorer/iexplore.exe", path};
        			r.exec(cmd);
        		}
        		catch (Exception e) {
        			JOptionPane.showMessageDialog(new JFrame(), "Could Not Invoke Documentation.\nPlease contact Developers for further help.", "Error", JOptionPane.ERROR_MESSAGE);
        		}
        	}
        });

        eulaMenuItem.setText("Eula");
        eulaMenuItem.addActionListener(new ActionListener() {
        	public void actionPerformed(final ActionEvent evt) {
           		Runtime r = Runtime.getRuntime();
        		File f = new File("eula.html");
        		if (!f.exists()) {
        			JOptionPane.showMessageDialog(new JFrame(), "Could Not Invoke EULA.\nPlease contact Developers for further help.", "Error", JOptionPane.ERROR_MESSAGE);
        			return;
        		}
        		try {
            		String path = f.getCanonicalPath();
        			//String cmd[] = {"C:/Program Files/Internet Explorer/iexplore.exe ", path};
            		String cmd[] = {"%System%/../../Program Files/Internet Explorer/iexplore.exe", path};
        			r.exec(cmd);
        		}
        		catch (Exception e) {
        			JOptionPane.showMessageDialog(new JFrame(), "Could Not Invoke EULA.\n", "Error", JOptionPane.ERROR_MESSAGE);
        		}
        	}
        });

        aboutMenuItem.setText("About Us");
        aboutMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                //aboutMenuItemActionPerformed(evt);
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        aboutMenuItemActionPerformed(evt);
                    }
                });
            }
        });

        helpMenu.add(docMenuItem);
        helpMenu.add(eulaMenuItem);
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        pack();
    }

    public void recogGoButtonActionPerformed(ActionEvent evt) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new verifyFrame().setVisible(true);
            }
        });
    }

    public void trainingGoButtonActionPerformed(ActionEvent evt) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new trainingFrame().setVisible(true);
            }
        });
    }

    /*
	public void eulaMenuItemActionPerformed(ActionEvent evt) {
    	JFrame eulaDisplay = new JFrame();
    	JTextArea eula = new JTextArea();
    	FileInputStream eulaIp = null;
    	JButton okButton = new JButton("Ok");

    	eulaDisplay.setLayout(null);
    	eulaDisplay.setPreferredSize(new Dimension(400, 400));
    	eulaDisplay.setMaximizedBounds(new Rectangle(0, 0, 400, 399));
    	eulaDisplay.setMaximumSize(new Dimension(400, 400));
    	eulaDisplay.setAlwaysOnTop(true);

    	eula.setRows(20);
    	eula.setColumns(50);
    	eula.setAutoscrolls(true);

    	try {
    		eulaIp = new FileInputStream("eula.txt");
    	}
    	catch (Exception e) {
    		JOptionPane.showMessageDialog(new JFrame(), new String("Could Not Open End-User Licence Agreement.\n"), "Error", JOptionPane.ERROR_MESSAGE);
    		eulaDisplay.dispose();
    	}
    	while (true) {
    		int ch = 0;
    		try {
    			if ((ch = eulaIp.read()) == -1)
    				break;
    		}
    		catch (Exception e) {
    			e.printStackTrace();
    		}
    		eula.setText(eula.getText() + ch);
    	}
    	eula.setBounds(0, 0, 300, 300);

    	eulaDisplay.add(eula);

    	okButton.setBounds(370, 370, 390, 390);
    	okButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent evt) {
    			dispose();
    		}
    	});

    	eulaDisplay.add(okButton);

    	eulaDisplay.setVisible(true);
    }
    */

    /*
    public void aboutMenuItemActionPerformed(ActionEvent evt) {
        final JFrame about = new JFrame();
        about.setLayout(new FlowLayout());
        about.setMaximizedBounds(new Rectangle(0, 0, 200, 200));
        about.setPreferredSize(new Dimension(200, 200));
        about.setSize(new Dimension(200, 200));
        about.setAlwaysOnTop(true);
        about.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JTextArea aboutText = new JTextArea("Signature Verification Tool\n");
        aboutText.setFont(new Font("Helvetica", Font.BOLD, 12));
        aboutText.setRows(5);


        JButton ok = new JButton("Wokey! Cool!");
        ok.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		about.dispose();
        	}
        });

        about.add(aboutText);
        about.add(ok);
        about.setVisible(true);
    }
    */

    public void aboutMenuItemActionPerformed(ActionEvent evt) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new aboutFrame().setVisible(true);
            }
        });
    }

    public void quitMenuItemActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    /**
     * @param args Unused
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainFrame().setVisible(true);
            }
        });
    }

    public JMenuItem aboutMenuItem;
    public JMenuItem docMenuItem;
    public JMenuItem eulaMenuItem;
    public JMenuItem settingsMenuItem;
    public JMenu fileMenu;
    public JMenu helpMenu;
    public JButton trainingGoButton;
    public JButton recogGoButton;
    public JMenuBar menuBar;
    public JMenuItem quitMenuItem;
    public JLabel startRecogLabel;
    public JLabel startTrainingLabel;

    public ImageIcon mainIcon = null;
    public ImageIcon titleImage = null;
    public JLabel titleImageLabel = null;
    

}

class trainingFrame extends JFrame
{


	private static final long serialVersionUID = 1L;
	private String path=null;
	int c=0;

		/**
		 * Creates new JFrame
		 */
	    public trainingFrame()
	    {

	        initComponents();

	    }

	    public void initComponents()
	    {
	        instructionPanel = new JPanel();
	        instructionPane = new JScrollPane();
	        instructionTextArea = new JTextArea();
	        informationPanel = new JPanel();
	        firstNameLabel = new JLabel();
	        firstNameField = new JTextField();
	        lastNameLabel = new JLabel();
	        lastNameField = new JTextField();
	        usnLabel = new JLabel();
	        usnField = new JTextField();
	        sigTopPanel = new JPanel();
	        sig1Panel = new ImagePanel();
	        clearButton = new JButton();
	        quitButton = new JButton();
	        sig1SaveButton = new JButton();
	        process = new JButton("Process");
	        acceptButton = new JButton("Save");
	        trainIcon = new ImageIcon("Images\\48.gif");
	        setLayout(null);
	        setSize(new Dimension(800, 600));
	        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	        setTitle("Training Module");
	        setCursor(new java.awt.Cursor(Cursor.DEFAULT_CURSOR));
	        setMaximizedBounds(new Rectangle(0, 0, 800, 590));
	        setPreferredSize(new Dimension(800, 590));
	        setIconImage(trainIcon.getImage());

	        instructionPanel.setBorder(BorderFactory.createTitledBorder("Instructions"));
	        instructionPanel.setPreferredSize(new Dimension(600, 82));
	        instructionPane.setAutoscrolls(false);
	        instructionPane.setPreferredSize(new Dimension(580, 150));
	        instructionTextArea.setColumns(20);
	        instructionTextArea.setLineWrap(true);
	        instructionTextArea.setRows(5);
	        instructionTextArea.setText("Welcome to the training module. This module will help the software\nrecognize your signatures with a greater accuracy. Please enter\nyour personal details along with multiple copies of your signature,\nso that we can analyse the same and use it during verification.\nNote: Please sign in a sequential manner.\n\n");
	        instructionTextArea.setDoubleBuffered(true);
	        instructionTextArea.setPreferredSize(new Dimension(580, 150));
	        instructionTextArea.setEditable(false);
	        instructionTextArea.setToolTipText("General Instructions");
	        instructionPane.setViewportView(instructionTextArea);

	        instructionPanel.add(instructionPane);
	        add(instructionPanel);
	        instructionPanel.setBounds(39, 5, 620, 190);

	        informationPanel.setLayout(new GridLayout(4, 2));
	        informationPanel.setBorder(BorderFactory.createTitledBorder("Personal Information"));
	        informationPanel.setPreferredSize(new Dimension(300, 115));
	        firstNameLabel.setText("First Name");
	        firstNameField.setToolTipText("Enter your first name");
	        informationPanel.add(firstNameLabel);
	        informationPanel.add(firstNameField);
	        lastNameLabel.setText("Last Name");
	        lastNameField.setToolTipText("Enter your last name");
	        informationPanel.add(lastNameLabel);
	        informationPanel.add(lastNameField);
	        usnLabel.setText("A/C Number");
	        usnField.setToolTipText("Enter your A/C number");
	        informationPanel.add(usnLabel);
	        informationPanel.add(usnField);
	        informationPanel.add(new JLabel("Click to Save"));
	        acceptButton.setToolTipText("Click to save input");
	        informationPanel.add(acceptButton);

	        acceptButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e)
	        	{
					try
					{
	        		if (firstNameField.getText().length() == 0 || lastNameField.getText().length() == 0 || usnField.getText().length() ==0) {
	           			JOptionPane.showMessageDialog(new JFrame(), "All fields are mandatory.\n", "Error", JOptionPane.ERROR_MESSAGE);
	        			return;
	        		}
	        		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

	        		Connection con = DriverManager.getConnection("jdbc:odbc:signdsn", "","");
	        		Statement stm=con.createStatement();
	        		ResultSet rs=stm.executeQuery("select * from usertable");
	        		while(rs.next())
	        		{
						c++;
					}



	        		//////////Copy File
	        		Saveimg si =new Saveimg();
	        		Image imc=si.imp();
	        		File sourceFile=new File(path);
					BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile), 4096);
					File targetFile = new File("c:\\SignatureDB\\"+firstNameField.getText()+(c+1) +".jpeg");
					BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(targetFile), 4096);
					int theChar;
					

			    
					while ((theChar = bis.read()) != -1)
					{
					    bos.write(theChar);
					 }
					    bos.close();
       					 bis.close();

       					 PreparedStatement pstmt=con.prepareStatement("insert into usertable values(?,?,?,?,?)");
						 	        		pstmt.setInt(1,c+1);
						 	        		pstmt.setString(2,  firstNameField.getText());
						 	        		pstmt.setString(3,  lastNameField.getText());
						 	        		pstmt.setString(4,  usnField.getText());
						 	        		path="c:\\SignatureDB\\"+firstNameField.getText()+(c+1) +".jpeg";
						 	        		//System.out.println("c:\\SignatureDB\\"+firstNameField.getText()+(c+1) +".jpeg");
						 	        		pstmt.setString(5,  path);
	        		int i=pstmt.executeUpdate();
	        		c=0;

	        		/////////
	        		if(i==1)
	        		JOptionPane.showMessageDialog(new JFrame(),"User Info Saved...");
	        		if(i==0)
	        		JOptionPane.showMessageDialog(new JFrame(),"User Info Not Saved ...");
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
				finally
				{
					//if (pstmt != null)
					//pstmt.close();

				}



	        		//folderName = new String(firstNameField.getText() + lastNameField.getText() + usnField.getText());
	        		//checkUser();
	        		//acceptButton.setEnabled(false);
	        		//clearButton.setEnabled(false);
	        		//sig1SaveButton.setEnabled(true);
	        		//n1 = 1;
	        		//penUp = 0;
	        		//sig1Panel.setBackground(Color.WHITE);
	        	}

	        	public void checkUser() {
	        		File f = new File(folderName);
	        		if (f.exists()) {
	           			JOptionPane.showMessageDialog(new JFrame(), "User Already Exists.\n", "Error", JOptionPane.ERROR_MESSAGE);
	        			dispose();
	        		}
	        	}
	        });

	        add(informationPanel);
	        informationPanel.setBounds(390, 240, 250, 110);

	        sigTopPanel.setBorder(BorderFactory.createTitledBorder("Sign Here"));
	        sig1Panel.setBackground(new Color(255, 255, 255));
	        sig1Panel.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
	        sig1Panel.setPreferredSize(new Dimension(300, 100));
	        //sig1Panel.setBackground(Color.BLACK);



	        //sigTopPanel.add(sig1Panel);

	        //sig2SaveButton.setEnabled(false);
	        sig1SaveButton.setEnabled(true);
	        sig1SaveButton.setText("Browse Signature");
	        sig1SaveButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e)
	        	{
					JFileChooser chooser = new JFileChooser();
					int returnVal = chooser.showOpenDialog(new trainingFrame());
					if(returnVal == chooser.APPROVE_OPTION)
					{

						String filename = chooser.getSelectedFile().getAbsolutePath();
						path=filename;
						Image image = Toolkit.getDefaultToolkit().getImage(filename);
						imm=image;
						sig1Panel.setImage(image);
        				show();
						//this.getContentPane().add(sig1Panel);

				       //System.out.println("You chose to open this file: " +
           			 //	   chooser.getSelectedFile().getName());
				 	}
				 	repaint();

	        		//sV.storageDisk(xr1, yr1, n1, folderName, "sig1", true);
	        		//sV.storageDisk(penUp, folderName, "pen1");
	        		//new enroll(xr1, yr1, n1, folderName, "sig1");
	        		//recordSig(xr1, yr1, n1, folderName, "sig1", true);

	        		//byte[] dig = auth.getDigest(folderName, "sig1Norm");
	        		//auth.recordDigest(dig, folderName, "sig1Norm");

	        		sig1SaveButton.setEnabled(false);
	        		//sig2SaveButton.setEnabled(true);
	        		n2 = 1;
	        		penUp = 0;
	        	}
	        });
	        process.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e)
	        	{
	        		ProcessSample ps=new ProcessSample(imm,path);
				}
				 	
	        	}
	        );
			 sigTopPanel.add(sig1Panel);
	        sigTopPanel.add(sig1SaveButton);
				sigTopPanel.add(process);
	        add(sigTopPanel);
	        sigTopPanel.setBounds(40, 240, 330, 300);

	        clearButton.setText("Clear");
	        clearButton.setToolTipText("Clear the fields");
	        clearButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                firstNameField.setText("");
	                lastNameField.setText("");
	                usnField.setText("");
	                acceptButton.setEnabled(true);
	                sig1SaveButton.setEnabled(false);
	                repaint();
	            }
	        });

	        getContentPane().add(clearButton);
	        clearButton.setBounds(390, 450, 117, 28);

	        quitButton.setText("Quit");
	        quitButton.setToolTipText("Click to quit to main window");
	        quitButton.setToolTipText("This step is irreversible. Please confirm twice before pressing the quit button.");
	        getContentPane().add(quitButton);
	        quitButton.setBounds(520, 450, 120, 30);

	        quitButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		//sig2SaveButton.setEnabled(false);
	        		//acceptButton.setEnabled(true);
	        		dispose();
	        	}

	        });

	    }

	    public void paint(Graphics g) {
	    	if (paintBool) {
	    		g.drawLine(prevPoint.x - getX(),prevPoint.y - getY(),curPoint.x - getX(),curPoint.y - getY());
	    		paintBool = false;
	    	}
	    	else
	    		super.paint(g);
	    	//g.drawLine(drawPrevPoint.x, drawPrevPoint.y, drawCurPoint.x, drawCurPoint.y);
	    }

	    /*
	    public void recordSig(double[] x, double[] y, int n, String folderName, String fname, boolean dirFlag) {
	    	folderName = folderName.toLowerCase();
	    	if (dirFlag == true) {
	    		try {
	    			File f1 = new File(folderName);
	    			boolean flag = f1.mkdir();
	    			if (flag == false) {
	    				System.out.println("User Already Exists");
	    				return;
	    			}
	    		}
	    		catch (Exception e) {
	    			e.printStackTrace();
	    		}
	    	}
	    	try {
	    		FileOutputStream op = new FileOutputStream(folderName+"\\"+fname);
	    		PrintWriter pw = new PrintWriter(op, true);
	    		for (int i=1; i<n ; i++)
	    			pw.println(x[i] + " " + y[i]);
	    		pw.print("-1 -1");
	    		pw.close();
	    		op.close();
	    	}
	    	catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    	new enroll(x, y, n , folderName, fname);
	    }
	    */

	    public boolean withinBounds(Point curPoint, JPanel sigPanel) {
			// TODO Auto-generated method stub
			Point topLeft = sigPanel.getLocationOnScreen();
			Point bottomRight = new Point((topLeft.x + sigPanel.getWidth()), (topLeft.y + sigPanel.getHeight()));
			if (curPoint.x >= topLeft.x
					&& curPoint.x <= bottomRight.x
					&& curPoint.y >= topLeft.y
					&& curPoint.y <= bottomRight.y)
				return true;
			return false;
		}

	    /**
	     * @param args Unused
	     */
	    public static void main(String args[]) {
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new trainingFrame().setVisible(true);
	            }
	        });
	    }

	    public Point curPoint;
	    public Point prevPoint;
	    public Point panelBound;
	    public Boolean newClick = true;
	    public String folderName = null;
	    public boolean paintBool = false;

		public JButton clearButton,process;
	    public JButton quitButton;
	    public JButton acceptButton;
	    public JLabel firstNameLabel;
	    public JLabel lastNameLabel;
	    Image imm;
	    public JLabel usnLabel;
	    public JPanel instructionPanel;
	    public JPanel sigTopPanel;
	    //public JPanel sig1Panel;
	    public ImagePanel sig1Panel=null;
	    public JPanel informationPanel;
	 //   public JPanel sig2Panel;
	    public JScrollPane instructionPane;
	    public JTextArea instructionTextArea;
	    public JTextField firstNameField;
	    public JTextField lastNameField;
	    public JTextField usnField;
	    public JButton sig1SaveButton;
	    //public JButton sig2SaveButton;

	    public double xr1[] = new double[2000];
	    public double yr1[] = new double[2000];
	    public double xr2[] = new double[2000];
	    public double yr2[] = new double[2000];
	    public int n1 = 1;
	    public int n2 = 1;
	    public int penUp = 0;

//	    public storageVault sV = null;
//	    public authData auth = null;
	    public ImageIcon trainIcon;
}

class verifyFrame extends JFrame implements ActionListener
{
	verifyFrame()
	{
		initComponents();
	}

	public void initComponents()
	{
		//instructionPanel = new JPanel();
	    //instructionPane = new JScrollPane();
	    informationPanel = new JPanel();
		firstNameLabel = new JLabel();
		firstNameField = new JTextField();
		lastNameLabel = new JLabel();
		lastNameField = new JTextField();
	    usnLabel = new JLabel();
	    usnField = new JTextField();
	    search=new JButton("Search");
		trainIcon = new ImageIcon("Images\\48.gif");
	    setLayout(null);
		setSize(new Dimension(500, 400));
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Verify Signature");
	    setCursor(new java.awt.Cursor(Cursor.DEFAULT_CURSOR));
		setMaximizedBounds(new Rectangle(0, 0, 800, 590));
		setPreferredSize(new Dimension(800, 590));
	    setIconImage(trainIcon.getImage());

	    //////////////////
	    informationPanel.setLayout(new GridLayout(4, 2));
		informationPanel.setBorder(BorderFactory.createTitledBorder("Personal Information"));
		informationPanel.setPreferredSize(new Dimension(300, 115));

		usnLabel.setText("A/C Number:");
		usnField.setToolTipText("Enter your A/C number");
		informationPanel.add(usnLabel);
		informationPanel.add(usnField);
		
		search.setBounds(20,20,100,20);
		firstNameLabel.setText("First Name");
		firstNameField.setToolTipText("Enter your first name");
		informationPanel.add(firstNameLabel);
		informationPanel.add(firstNameField);
		lastNameLabel.setText("Last Name");
		lastNameField.setToolTipText("Enter your last name");
		informationPanel.add(lastNameLabel);
		informationPanel.add(lastNameField);
		add(informationPanel);
	    informationPanel.setBounds (20, 20, 250, 110);
	    informationPanel.add(search);
	    search.addActionListener(this);
		//informationPanel.add(new JLabel("Click to Save"));
		//acceptButton.setToolTipText("Click to save input");
	   // informationPanel.add(acceptButton);
	    //////////////////


	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==search)
		{
			try
			{
					System.out.println("in search");
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

	        		Connection con = DriverManager.getConnection("jdbc:odbc:signdsn", "","");
	        		Statement stm=con.createStatement();
	        	 
	        		ResultSet rs=stm.executeQuery("select * from usertable where usn='"+usnField.getText()+"'");
	        		if(rs.next())
	        		{
	        			System.out.println("verify");
	        			JOptionPane.showMessageDialog(this,"User Info verified...");
	        			ProcessSampleScan pss=new ProcessSampleScan();
		
						}
						else
						{
							JOptionPane.showMessageDialog(this,"User Info not verified...");
						}
		}
		catch(Exception es){System.out.println(es);}
			
		}
	}

	 public JLabel firstNameLabel;
	 public JLabel lastNameLabel;
	 public JLabel usnLabel;
	 public JPanel informationPanel;
	 public JTextField firstNameField;
	 public JTextField lastNameField;
	 public JTextField usnField;
	 public ImageIcon trainIcon;
	 public JButton search;

}

class Saveimg
{
	Image im=null;
	public void save(Image i)
	{
		im=i;
	}
	public Image imp()
	{
		return im;
	}
	
	
	
}





class ProcessSample extends JFrame implements WindowListener,ActionListener
{
	ImagePanel img;
	JButton bcol;
	Image imgc=null;
	String pps;
	private static final long serialVersionUID = 1L;
	public ProcessSample(Image im,String pp)
	{
		imgc=im;
		pps=pp;
		img=new ImagePanel();
		setLayout(new BorderLayout());
		img.setImage(im);
		add(img,BorderLayout.CENTER);
		bcol=new JButton("Color Normalize");
		bcol.addActionListener(this);
		add(bcol,BorderLayout.PAGE_END);
		setLocation(500,10);
		setSize(300,200);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==bcol)
		{
			try
			{
			BufferedImage image = new BufferedImage(imgc.getWidth(null),imgc.getHeight(null),BufferedImage.TYPE_BYTE_GRAY);
			Graphics g = image.getGraphics();
			g.drawImage(imgc, 0, 0, null);
			File outputfile = new File("c:\\gray.jpeg");
			ImageIO.write(image, "jpeg", outputfile);
			imgc= Toolkit.getDefaultToolkit().getImage("c:\\gray.jpeg");
			ScaleSample ss=new ScaleSample(imgc,pps);
			g.dispose();
		}
		catch(Exception ex)
		{
		}
		}
	}
	public void windowActivated(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
	public void windowOpened(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowClosing(WindowEvent e){}
}




class ProcessSampleScan extends JFrame implements WindowListener,ActionListener
{
	ImagePanel img;
	JButton bcol,browse;
	Image imgc=null;
	String pps;
	private static final long serialVersionUID = 1L;
	public ProcessSampleScan()
	{

		//pps=pp;
		img=new ImagePanel();
		setLayout(new BorderLayout());

		add(img,BorderLayout.CENTER);
		bcol=new JButton("Color Normalize");
		browse=new JButton("Browse Sign");
		bcol.addActionListener(this);
		browse.addActionListener(this);
		add(bcol,BorderLayout.PAGE_END);
		add(browse,BorderLayout.PAGE_START);
		setLocation(500,10);
		setSize(300,200);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==bcol)
		{
			try
			{
			BufferedImage image = new BufferedImage(imgc.getWidth(null),imgc.getHeight(null),BufferedImage.TYPE_BYTE_GRAY);
			Graphics g = image.getGraphics();
			g.drawImage(imgc, 0, 0, null);
			File outputfile = new File("c:\\gray.jpeg");
			ImageIO.write(image, "jpeg", outputfile);
			imgc= Toolkit.getDefaultToolkit().getImage("c:\\gray.jpeg");
			ScaleSampleScan ss=new ScaleSampleScan(imgc);
			g.dispose();
		}

		catch(Exception ex)
		{
		}
		}

		if(e.getSource()==browse)
		{
			JFileChooser chooser = new JFileChooser();
			int returnVal = chooser.showOpenDialog(this);
			if(returnVal == chooser.APPROVE_OPTION)
			{
				String filename = chooser.getSelectedFile().getAbsolutePath();
				Image image = Toolkit.getDefaultToolkit().getImage(filename);
				imgc=image;
				img.setImage(image);
				repaint();
			}

		}
	}
	public void windowActivated(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
	public void windowOpened(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowClosing(WindowEvent e){}
}



class ScaleSampleScan extends JFrame implements WindowListener,ActionListener
{
	ImagePanel img;
	JButton bcol;
	Image imgc=null,img2=null;
	String pps;
	private static final long serialVersionUID = 1L;
	public ScaleSampleScan(Image im)
	{
		//pps=pp;
		imgc=im;
		img=new ImagePanel();
		setLayout(new BorderLayout());
		img.setImage(im);
		add(img,BorderLayout.CENTER);
		bcol=new JButton("Scale And Smooth Image");
		bcol.addActionListener(this);
		add(bcol,BorderLayout.PAGE_END);
		setLocation(500,10);
		setSize(300,200);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		try
		{
		if(e.getSource()==bcol)
		{
			img2 =imgc.getScaledInstance(300, 200, Image.SCALE_SMOOTH);

			SkeletonSampleScan ss=new SkeletonSampleScan(img2);
			//BufferedImage image = new BufferedImage(300, 200,BufferedImage.TYPE_BYTE_GRAY);
			//Graphics g = image.getGraphics();
			//	g.drawImage(imgc, 0, 0, null);

			//	g.dispose();
		}
	}
	catch(Exception ex)
	{
	}
	}
	public void windowActivated(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
	public void windowOpened(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowClosing(WindowEvent e){}
}

class SkeletonSampleScan extends JFrame implements WindowListener,ActionListener
{
	ImagePanel img;
	JButton bcol;
	Image imgc=null;
	String pps;
	private static final long serialVersionUID = 1L;
	public SkeletonSampleScan(Image im)
	{
		//pps=pp;
		imgc=im;
		img=new ImagePanel();
		setLayout(new BorderLayout());
		img.setImage(imgc);
		add(img,BorderLayout.CENTER);
		bcol=new JButton("Create Skeleton");
		bcol.addActionListener(this);
		add(bcol,BorderLayout.PAGE_END);
		setLocation(500,10);
		setSize(300,200);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==bcol)
		{
			CannyEdgeDetector detector = new CannyEdgeDetector();

			//adjust its parameters as desired
			detector.setLowThreshold(0.5f);
			detector.setHighThreshold(1f);

			////Image To Bufffered Image
			BufferedImage bufferedImage=new BufferedImage(imgc.getWidth(null),imgc.getHeight(null) ,BufferedImage.TYPE_INT_ARGB);
			Graphics2D bufImageGraphics = bufferedImage.createGraphics();
			bufImageGraphics.drawImage(imgc, 0, 0, null);
			//apply it to an image
			detector.setSourceImage(bufferedImage);
			detector.process();
			BufferedImage edges = detector.getEdgesImage();
			Graphics g = edges.getGraphics();
			g.drawImage(imgc, 0, 0, null);
			g.dispose();
			SaveSampleScan ss=new SaveSampleScan(imgc);



		}
	}



	public void windowActivated(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
	public void windowOpened(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowClosing(WindowEvent e){}
}


class CannyEdgeDetector {

	// statics

	private final static float GAUSSIAN_CUT_OFF = 0.005f;
	private final static float MAGNITUDE_SCALE = 100F;
	private final static float MAGNITUDE_LIMIT = 1000F;
	private final static int MAGNITUDE_MAX = (int) (MAGNITUDE_SCALE * MAGNITUDE_LIMIT);

	// fields

	private int height;
	private int width;
	private int picsize;
	private int[] data;
	private int[] magnitude;
	private BufferedImage sourceImage;
	private BufferedImage edgesImage;

	private float gaussianKernelRadius;
	private float lowThreshold;
	private float highThreshold;
	private int gaussianKernelWidth;
	private boolean contrastNormalized;

	private float[] xConv;
	private float[] yConv;
	private float[] xGradient;
	private float[] yGradient;

	// constructors

	/**
	 * Constructs a new detector with default parameters.
	 */

	public CannyEdgeDetector() {
		lowThreshold = 2.5f;
		highThreshold = 7.5f;
		gaussianKernelRadius = 2f;
		gaussianKernelWidth = 16;
		contrastNormalized = false;
	}

	// accessors

	/**
	 * The image that provides the luminance data used by this detector to
	 * generate edges.
	 *
	 * @return the source image, or null
	 */

	public BufferedImage getSourceImage() {
		return sourceImage;
	}

	/**
	 * Specifies the image that will provide the luminance data in which edges
	 * will be detected. A source image must be set before the process method
	 * is called.
	 *
	 * @param image a source of luminance data
	 */

	public void setSourceImage(BufferedImage image) {
		sourceImage = image;
	}

	/**
	 * Obtains an image containing the edges detected during the last call to
	 * the process method. The buffered image is an opaque image of type
	 * BufferedImage.TYPE_INT_ARGB in which edge pixels are white and all other
	 * pixels are black.
	 *
	 * @return an image containing the detected edges, or null if the process
	 * method has not yet been called.
	 */

	public BufferedImage getEdgesImage() {
		return edgesImage;
	}

	/**
	 * Sets the edges image. Calling this method will not change the operation
	 * of the edge detector in any way. It is intended to provide a means by
	 * which the memory referenced by the detector object may be reduced.
	 *
	 * @param edgesImage expected (though not required) to be null
	 */

	public void setEdgesImage(BufferedImage edgesImage) {
		this.edgesImage = edgesImage;
	}

	/**
	 * The low threshold for hysteresis. The default value is 2.5.
	 *
	 * @return the low hysteresis threshold
	 */

	public float getLowThreshold() {
		return lowThreshold;
	}

	/**
	 * Sets the low threshold for hysteresis. Suitable values for this parameter
	 * must be determined experimentally for each application. It is nonsensical
	 * (though not prohibited) for this value to exceed the high threshold value.
	 *
	 * @param threshold a low hysteresis threshold
	 */

	public void setLowThreshold(float threshold) {
		if (threshold < 0) throw new IllegalArgumentException();
		lowThreshold = threshold;
	}

	/**
	 * The high threshold for hysteresis. The default value is 7.5.
	 *
	 * @return the high hysteresis threshold
	 */

	public float getHighThreshold() {
		return highThreshold;
	}

	/**
	 * Sets the high threshold for hysteresis. Suitable values for this
	 * parameter must be determined experimentally for each application. It is
	 * nonsensical (though not prohibited) for this value to be less than the
	 * low threshold value.
	 *
	 * @param threshold a high hysteresis threshold
	 */

	public void setHighThreshold(float threshold) {
		if (threshold < 0) throw new IllegalArgumentException();
		highThreshold = threshold;
	}

	/**
	 * The number of pixels across which the Gaussian kernel is applied.
	 * The default value is 16.
	 *
	 * @return the radius of the convolution operation in pixels
	 */

	public int getGaussianKernelWidth() {
		return gaussianKernelWidth;
	}

	/**
	 * The number of pixels across which the Gaussian kernel is applied.
	 * This implementation will reduce the radius if the contribution of pixel
	 * values is deemed negligable, so this is actually a maximum radius.
	 *
	 * @param gaussianKernelWidth a radius for the convolution operation in
	 * pixels, at least 2.
	 */

	public void setGaussianKernelWidth(int gaussianKernelWidth) {
		if (gaussianKernelWidth < 2) throw new IllegalArgumentException();
		this.gaussianKernelWidth = gaussianKernelWidth;
	}

	/**
	 * The radius of the Gaussian convolution kernel used to smooth the source
	 * image prior to gradient calculation. The default value is 16.
	 *
	 * @return the Gaussian kernel radius in pixels
	 */

	public float getGaussianKernelRadius() {
		return gaussianKernelRadius;
	}

	/**
	 * Sets the radius of the Gaussian convolution kernel used to smooth the
	 * source image prior to gradient calculation.
	 *
	 * @return a Gaussian kernel radius in pixels, must exceed 0.1f.
	 */

	public void setGaussianKernelRadius(float gaussianKernelRadius) {
		if (gaussianKernelRadius < 0.1f) throw new IllegalArgumentException();
		this.gaussianKernelRadius = gaussianKernelRadius;
	}

	/**
	 * Whether the luminance data extracted from the source image is normalized
	 * by linearizing its histogram prior to edge extraction. The default value
	 * is false.
	 *
	 * @return whether the contrast is normalized
	 */

	public boolean isContrastNormalized() {
		return contrastNormalized;
	}

	/**
	 * Sets whether the contrast is normalized
	 * @param contrastNormalized true if the contrast should be normalized,
	 * false otherwise
	 */

	public void setContrastNormalized(boolean contrastNormalized) {
		this.contrastNormalized = contrastNormalized;
	}

	// methods

	public void process() {
		width = sourceImage.getWidth();
		height = sourceImage.getHeight();
		picsize = width * height;
		initArrays();
		readLuminance();
		if (contrastNormalized) normalizeContrast();
		computeGradients(gaussianKernelRadius, gaussianKernelWidth);
		int low = Math.round(lowThreshold * MAGNITUDE_SCALE);
		int high = Math.round( highThreshold * MAGNITUDE_SCALE);
		performHysteresis(low, high);
		thresholdEdges();
		writeEdges(data);
	}

	// private utility methods

	private void initArrays() {
		if (data == null || picsize != data.length) {
			data = new int[picsize];
			magnitude = new int[picsize];

			xConv = new float[picsize];
			yConv = new float[picsize];
			xGradient = new float[picsize];
			yGradient = new float[picsize];
		}
	}

	//NOTE: The elements of the method below (specifically the technique for
	//non-maximal suppression and the technique for gradient computation)
	//are derived from an implementation posted in the following forum (with the
	//clear intent of others using the code):
	//  http://forum.java.sun.com/thread.jspa?threadID=546211&start=45&tstart=0
	//My code effectively mimics the algorithm exhibited above.
	//Since I don't know the providence of the code that was posted it is a
	//possibility (though I think a very remote one) that this code violates
	//someone's intellectual property rights. If this concerns you feel free to
	//contact me for an alternative, though less efficient, implementation.

	private void computeGradients(float kernelRadius, int kernelWidth) {

		//generate the gaussian convolution masks
		float kernel[] = new float[kernelWidth];
		float diffKernel[] = new float[kernelWidth];
		int kwidth;
		for (kwidth = 0; kwidth < kernelWidth; kwidth++) {
			float g1 = gaussian(kwidth, kernelRadius);
			if (g1 <= GAUSSIAN_CUT_OFF && kwidth >= 2) break;
			float g2 = gaussian(kwidth - 0.5f, kernelRadius);
			float g3 = gaussian(kwidth + 0.5f, kernelRadius);
			kernel[kwidth] = (g1 + g2 + g3) / 3f / (2f * (float) Math.PI * kernelRadius * kernelRadius);
			diffKernel[kwidth] = g3 - g2;
		}

		int initX = kwidth - 1;
		int maxX = width - (kwidth - 1);
		int initY = width * (kwidth - 1);
		int maxY = width * (height - (kwidth - 1));

		//perform convolution in x and y directions
		for (int x = initX; x < maxX; x++) {
			for (int y = initY; y < maxY; y += width) {
				int index = x + y;
				float sumX = data[index] * kernel[0];
				float sumY = sumX;
				int xOffset = 1;
				int yOffset = width;
				for(; xOffset < kwidth ;) {
					sumY += kernel[xOffset] * (data[index - yOffset] + data[index + yOffset]);
					sumX += kernel[xOffset] * (data[index - xOffset] + data[index + xOffset]);
					yOffset += width;
					xOffset++;
				}

				yConv[index] = sumY;
				xConv[index] = sumX;
			}

		}

		for (int x = initX; x < maxX; x++) {
			for (int y = initY; y < maxY; y += width) {
				float sum = 0f;
				int index = x + y;
				for (int i = 1; i < kwidth; i++)
					sum += diffKernel[i] * (yConv[index - i] - yConv[index + i]);

				xGradient[index] = sum;
			}

		}

		for (int x = kwidth; x < width - kwidth; x++) {
			for (int y = initY; y < maxY; y += width) {
				float sum = 0.0f;
				int index = x + y;
				int yOffset = width;
				for (int i = 1; i < kwidth; i++) {
					sum += diffKernel[i] * (xConv[index - yOffset] - xConv[index + yOffset]);
					yOffset += width;
				}

				yGradient[index] = sum;
			}

		}

		initX = kwidth;
		maxX = width - kwidth;
		initY = width * kwidth;
		maxY = width * (height - kwidth);
		for (int x = initX; x < maxX; x++) {
			for (int y = initY; y < maxY; y += width) {
				int index = x + y;
				int indexN = index - width;
				int indexS = index + width;
				int indexW = index - 1;
				int indexE = index + 1;
				int indexNW = indexN - 1;
				int indexNE = indexN + 1;
				int indexSW = indexS - 1;
				int indexSE = indexS + 1;

				float xGrad = xGradient[index];
				float yGrad = yGradient[index];
				float gradMag = hypot(xGrad, yGrad);

				//perform non-maximal supression
				float nMag = hypot(xGradient[indexN], yGradient[indexN]);
				float sMag = hypot(xGradient[indexS], yGradient[indexS]);
				float wMag = hypot(xGradient[indexW], yGradient[indexW]);
				float eMag = hypot(xGradient[indexE], yGradient[indexE]);
				float neMag = hypot(xGradient[indexNE], yGradient[indexNE]);
				float seMag = hypot(xGradient[indexSE], yGradient[indexSE]);
				float swMag = hypot(xGradient[indexSW], yGradient[indexSW]);
				float nwMag = hypot(xGradient[indexNW], yGradient[indexNW]);
				float tmp;
				/*
				 * An explanation of what's happening here, for those who want
				 * to understand the source: This performs the "non-maximal
				 * supression" phase of the Canny edge detection in which we
				 * need to compare the gradient magnitude to that in the
				 * direction of the gradient; only if the value is a local
				 * maximum do we consider the point as an edge candidate.
				 *
				 * We need to break the comparison into a number of different
				 * cases depending on the gradient direction so that the
				 * appropriate values can be used. To avoid computing the
				 * gradient direction, we use two simple comparisons: first we
				 * check that the partial derivatives have the same sign (1)
				 * and then we check which is larger (2). As a consequence, we
				 * have reduced the problem to one of four identical cases that
				 * each test the central gradient magnitude against the values at
				 * two points with 'identical support'; what this means is that
				 * the geometry required to accurately interpolate the magnitude
				 * of gradient function at those points has an identical
				 * geometry (upto right-angled-rotation/reflection).
				 *
				 * When comparing the central gradient to the two interpolated
				 * values, we avoid performing any divisions by multiplying both
				 * sides of each inequality by the greater of the two partial
				 * derivatives. The common comparand is stored in a temporary
				 * variable (3) and reused in the mirror case (4).
				 *
				 */
				if (xGrad * yGrad <= (float) 0 /*(1)*/
					? Math.abs(xGrad) >= Math.abs(yGrad) /*(2)*/
						? (tmp = Math.abs(xGrad * gradMag)) >= Math.abs(yGrad * neMag - (xGrad + yGrad) * eMag) /*(3)*/
							&& tmp > Math.abs(yGrad * swMag - (xGrad + yGrad) * wMag) /*(4)*/
						: (tmp = Math.abs(yGrad * gradMag)) >= Math.abs(xGrad * neMag - (yGrad + xGrad) * nMag) /*(3)*/
							&& tmp > Math.abs(xGrad * swMag - (yGrad + xGrad) * sMag) /*(4)*/
					: Math.abs(xGrad) >= Math.abs(yGrad) /*(2)*/
						? (tmp = Math.abs(xGrad * gradMag)) >= Math.abs(yGrad * seMag + (xGrad - yGrad) * eMag) /*(3)*/
							&& tmp > Math.abs(yGrad * nwMag + (xGrad - yGrad) * wMag) /*(4)*/
						: (tmp = Math.abs(yGrad * gradMag)) >= Math.abs(xGrad * seMag + (yGrad - xGrad) * sMag) /*(3)*/
							&& tmp > Math.abs(xGrad * nwMag + (yGrad - xGrad) * nMag) /*(4)*/
					) {
					magnitude[index] = gradMag >= MAGNITUDE_LIMIT ? MAGNITUDE_MAX : (int) (MAGNITUDE_SCALE * gradMag);
					//NOTE: The orientation of the edge is not employed by this
					//implementation. It is a simple matter to compute it at
					//this point as: Math.atan2(yGrad, xGrad);
				} else {
					magnitude[index] = 0;
				}
			}
		}
	}

	//NOTE: It is quite feasible to replace the implementation of this method
	//with one which only loosely approximates the hypot function. I've tested
	//simple approximations such as Math.abs(x) + Math.abs(y) and they work fine.
	private float hypot(float x, float y) {
		return (float) Math.hypot(x, y);
	}

	private float gaussian(float x, float sigma) {
		return (float) Math.exp(-(x * x) / (2f * sigma * sigma));
	}

	private void performHysteresis(int low, int high) {
		//NOTE: this implementation reuses the data array to store both
		//luminance data from the image, and edge intensity from the processing.
		//This is done for memory efficiency, other implementations may wish
		//to separate these functions.
		Arrays.fill(data, 0);

		int offset = 0;
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if (data[offset] == 0 && magnitude[offset] >= high) {
					follow(x, y, offset, low);
				}
				offset++;
			}
		}
 	}

	private void follow(int x1, int y1, int i1, int threshold) {
		int x0 = x1 == 0 ? x1 : x1 - 1;
		int x2 = x1 == width - 1 ? x1 : x1 + 1;
		int y0 = y1 == 0 ? y1 : y1 - 1;
		int y2 = y1 == height -1 ? y1 : y1 + 1;

		data[i1] = magnitude[i1];
		for (int x = x0; x <= x2; x++) {
			for (int y = y0; y <= y2; y++) {
				int i2 = x + y * width;
				if ((y != y1 || x != x1)
					&& data[i2] == 0
					&& magnitude[i2] >= threshold) {
					follow(x, y, i2, threshold);
					return;
				}
			}
		}
	}

	private void thresholdEdges() {
		for (int i = 0; i < picsize; i++) {
			data[i] = data[i] > 0 ? -1 : 0xff000000;
		}
	}

	private int luminance(float r, float g, float b) {
		return Math.round(0.299f * r + 0.587f * g + 0.114f * b);
	}

	private void readLuminance() {
		int type = sourceImage.getType();
		if (type == BufferedImage.TYPE_INT_RGB || type == BufferedImage.TYPE_INT_ARGB) {
			int[] pixels = (int[]) sourceImage.getData().getDataElements(0, 0, width, height, null);
			for (int i = 0; i < picsize; i++) {
				int p = pixels[i];
				int r = (p & 0xff0000) >> 16;
				int g = (p & 0xff00) >> 8;
				int b = p & 0xff;
				data[i] = luminance(r, g, b);
			}
		} else if (type == BufferedImage.TYPE_BYTE_GRAY) {
			byte[] pixels = (byte[]) sourceImage.getData().getDataElements(0, 0, width, height, null);
			for (int i = 0; i < picsize; i++) {
				data[i] = (pixels[i] & 0xff);
			}
		} else if (type == BufferedImage.TYPE_USHORT_GRAY) {
			short[] pixels = (short[]) sourceImage.getData().getDataElements(0, 0, width, height, null);
			for (int i = 0; i < picsize; i++) {
				data[i] = (pixels[i] & 0xffff) / 256;
			}
		} else if (type == BufferedImage.TYPE_3BYTE_BGR) {
            byte[] pixels = (byte[]) sourceImage.getData().getDataElements(0, 0, width, height, null);
            int offset = 0;
            for (int i = 0; i < picsize; i++) {
                int b = pixels[offset++] & 0xff;
                int g = pixels[offset++] & 0xff;
                int r = pixels[offset++] & 0xff;
                data[i] = luminance(r, g, b);
            }
        } else {
			throw new IllegalArgumentException("Unsupported image type: " + type);
		}
	}

	private void normalizeContrast() {
		int[] histogram = new int[256];
		for (int i = 0; i < data.length; i++) {
			histogram[data[i]]++;
		}
		int[] remap = new int[256];
		int sum = 0;
		int j = 0;
		for (int i = 0; i < histogram.length; i++) {
			sum += histogram[i];
			int target = sum*255/picsize;
			for (int k = j+1; k <=target; k++) {
				remap[k] = i;
			}
			j = target;
		}

		for (int i = 0; i < data.length; i++) {
			data[i] = remap[data[i]];
		}
	}

	private void writeEdges(int pixels[]) {
		//NOTE: There is currently no mechanism for obtaining the edge data
		//in any other format other than an INT_ARGB type BufferedImage.
		//This may be easily remedied by providing alternative accessors.
		if (edgesImage == null) {
			edgesImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		}
		edgesImage.getWritableTile(0, 0).setDataElements(0, 0, width, height, pixels);
	}

}















class ScaleSample extends JFrame implements WindowListener,ActionListener
{
	ImagePanel img;
	JButton bcol;
	Image imgc=null,img2=null;
	String pps;
	private static final long serialVersionUID = 1L;
	public ScaleSample(Image im,String pp)
	{
		pps=pp;
		imgc=im;
		img=new ImagePanel();
		setLayout(new BorderLayout());
		img.setImage(im);
		add(img,BorderLayout.CENTER);
		bcol=new JButton("Scale And Smooth Image");
		bcol.addActionListener(this);
		add(bcol,BorderLayout.PAGE_END);
		setLocation(500,10);
		setSize(300,200);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==bcol)
		{
			img2 = imgc.getScaledInstance(300, 200, Image.SCALE_SMOOTH);

			SkeletonSample ss=new SkeletonSample(img2,pps);
			//BufferedImage image = new BufferedImage(300, 200,BufferedImage.TYPE_BYTE_GRAY);
			//Graphics g = image.getGraphics();
			//	g.drawImage(imgc, 0, 0, null);

			//	g.dispose();
		}
	}
	public void windowActivated(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
	public void windowOpened(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowClosing(WindowEvent e){}
}

class SkeletonSample extends JFrame implements WindowListener,ActionListener
{
	ImagePanel img;
	JButton bcol;
	Image imgc=null;
	String pps;
	private static final long serialVersionUID = 1L;
	public SkeletonSample(Image im,String pp)
	{
		pps=pp;
		imgc=im;
		img=new ImagePanel();
		setLayout(new BorderLayout());
		img.setImage(im);
		add(img,BorderLayout.CENTER);
		bcol=new JButton("Create Skeleton");
		bcol.addActionListener(this);
		add(bcol,BorderLayout.PAGE_END);
		setLocation(500,10);
		setSize(300,200);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==bcol)
		{
			CannyEdgeDetector detector = new CannyEdgeDetector();

			//adjust its parameters as desired
			detector.setLowThreshold(0.5f);
			detector.setHighThreshold(1f);

			////Image To Bufffered Image
			BufferedImage bufferedImage=new BufferedImage(imgc.getWidth(null),imgc.getHeight(null) ,BufferedImage.TYPE_INT_ARGB);
			Graphics2D bufImageGraphics = bufferedImage.createGraphics();
			bufImageGraphics.drawImage(imgc, 0, 0, null);
			//apply it to an image
			detector.setSourceImage(bufferedImage);
			detector.process();
			BufferedImage edges = detector.getEdgesImage();

						Graphics g = edges.getGraphics();
							g.drawImage(imgc, 0, 0, null);

				g.dispose();

			SaveSample ss=new SaveSample(imgc,pps);



		}
	}



	public void windowActivated(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
	public void windowOpened(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowClosing(WindowEvent e){}
}




class SaveSampleScan extends JFrame implements WindowListener,ActionListener
{
	ImagePanel img;
	JButton bcol,r1,l1;
	Image imgc=null,img2=null;
	Panel p1,p2;
	String pps;
	private static final long serialVersionUID = 1L;
	public SaveSampleScan(Image im)
	{
		//pps=pp;
		imgc=im;
		img=new ImagePanel();
		setLayout(new BorderLayout());
		img.setImage(im);
		add(img,BorderLayout.CENTER);
		bcol=new JButton("Start Compare");
		r1=new JButton("");
		l1=new JButton("");
		p1=new Panel();
		p2=new Panel();
		p1.add(l1);
		p2.add(r1);
		bcol.addActionListener(this);
		r1.addActionListener(this);
	l1.addActionListener(this);
		add(bcol,BorderLayout.NORTH);
		add(p2,BorderLayout.EAST);
		r1.setBackground(Color.DARK_GRAY);
		
		add(p1,BorderLayout.WEST);
		setLocation(500,10);
		setSize(300,200);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource()==bcol)
		{
			/*try
			{
				BufferedImage image = new BufferedImage(300, 200,BufferedImage.TYPE_BYTE_GRAY);
				Graphics g = image.getGraphics();
				g.drawImage(imgc, 0, 0, null);

			    File outputfile = new File("c:\\ProcessDB\\"+pps);
			    ImageIO.write(image, "jpeg", outputfile);
			    JOptionPane.showMessageDialog(null,"Image Saved");
			}
			catch (IOException ee)
			{

			}*/
		}
		if(e.getSource()==r1)
		{
			JOptionPane.showMessageDialog(this,"User signature is verified ");
		}
		if(e.getSource()==l1)
		{
			JOptionPane.showMessageDialog(this,"User signature is not verified ");
		}
		
	}
	public void windowActivated(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
	public void windowOpened(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowClosing(WindowEvent e){}
}

class SaveSample extends JFrame implements WindowListener,ActionListener
{
	ImagePanel img;
	//JButton bcol;
	Image imgc=null,img2=null;
	String pps;
	private static final long serialVersionUID = 1L;
	public SaveSample(Image im,String pp)
	{
		pps=pp;
		imgc=im;
		img=new ImagePanel();
		setLayout(new BorderLayout());
		img.setImage(im);
		add(img,BorderLayout.CENTER);
		//bcol=new JButton("Save Image");
		//bcol.addActionListener(this);
		//add(bcol,BorderLayout.PAGE_END);
		Saveimg si= new Saveimg();
		si.save(imgc); 
		setLocation(500,10);
		setSize(300,200);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		/*if(e.getSource()==bcol)
		{
			try
			{
				BufferedImage image = new BufferedImage(300, 200,BufferedImage.TYPE_BYTE_GRAY);
				Graphics g = image.getGraphics();
				g.drawImage(imgc, 0, 0, null);

			    File outputfile = new File("c:\\ProcessDB\\"+pps);
			    ImageIO.write(image, "jpeg", outputfile);
			    JOptionPane.showMessageDialog(null,"Image Saved");
			}
			catch (IOException ee)
			{

			}
		}*/
	}
	public void windowActivated(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
	public void windowOpened(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowClosing(WindowEvent e){}
}


