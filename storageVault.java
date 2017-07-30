


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class storageVault {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Default Constructor. Empty Implementation
	 */
	public storageVault() {
		
	}
	
	/**
	 * Used to store the data on disk
	 * @param x X-Series
	 * @param y Y-Series
	 * @param n Count 
	 * @param folderName Foldername
	 * @param fname File Name
	 * @return Returns 0 if successful, else -1
	 */
	public int storageDisk(double[] x, double[] y, int n, String folderName, String fname) {
		folderName = folderName.toLowerCase();
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
    	return 0;
	}

	/**
	 * Store data on disk
	 * @param x X-Series
	 * @param y y-Series
	 * @param n Count
	 * @param folderName Folder Name
	 * @param fname File Name
	 * @param dirFlag If true, creates a new folder. If false, uses an existing folder
	 * @return Returns 0 if successful, else -1
	 */
	public int storageDisk(double[] x, double[] y, int n, String folderName, String fname, boolean dirFlag) {
    	folderName = folderName.toLowerCase();
    	if (dirFlag == true) {
    		try {
    			File f1 = new File(folderName);
    			boolean flag = f1.mkdir();
    			if (flag == false) {
    				System.out.println("User Already Exists");
    				return -1;
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
    	return 0;
    	//new enroll(x, y, n , fname, folderName);
    }
	
	/**
	 * Store data on disk
	 * @param penUp penUp value of each signature
	 * @param folderName Folder Name
	 * @param fname File Name
	 * @return Returns 0 if successful, else -1
	 */
	public int storageDisk(int penUp, String folderName, String fname) {
		FileOutputStream op = null;
		try {
			op = new FileOutputStream(folderName+"\\"+fname);
			PrintWriter pw = new PrintWriter(op);
			pw.print(penUp);
			pw.close();
			op.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * Reads data from disk
	 * @param x X-Series
	 * @param y Y-Series
	 * @param folderName Folder Name
	 * @param fname File Name
	 * @return Returns no. of elements read
	 */
	public int readDisk(double[] x, double[] y, String folderName, String fname) {
		FileInputStream ip = null;
		Scanner sc = null;
		try {
			ip = new FileInputStream(folderName + "\\" + fname);
			sc = new Scanner(ip);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		double c = 0;
		int n=0;
		while ((c=sc.nextDouble()) != -1) {
			x[n] = c;
			y[n++] = sc.nextDouble();
		}
		try {
			ip.close();
			sc.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return n;
	}
	
	/**
	 * Reads data from disk
	 * @param folderName Folder Name
	 * @param fname File Name
	 * @return Returns the penUp value stored on disk
	 */
	public int readDisk(String folderName, String fname) {
		FileInputStream ip = null;
		Scanner sc = null;
		int penUp = 0;
		try {
			ip = new FileInputStream(folderName + "\\" + fname);
			sc = new Scanner(ip);
			penUp = sc.nextInt();
			sc.close();
			ip.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return penUp;
	}
}
