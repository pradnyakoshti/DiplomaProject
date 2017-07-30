



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.util.Scanner;

//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;


/*public class authData {
	
	public authData() {
		
		b64E = new BASE64Encoder();
		b64D = new BASE64Decoder();
		
	}*/
	
	/**
	 * 
	 * @param folderName Stores the folder name to read data from
	 * @param fName File name to read data from
	 * @return Authentication data
	 */
/*	public byte[] getDigest(String folderName, String fName) {
		
		MessageDigest md = null;
		DigestInputStream dIS = null;
		
		try {
			md = MessageDigest.getInstance("MD5");
		} 
		catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			 dIS = new DigestInputStream(new FileInputStream(folderName + "\\" + fName), md);
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		byte[] buffer = new byte[5000];
		
		try {
			while (dIS.read(buffer)!= -1);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		byte[] authString = md.digest();
		
		return authString;
		
		//System.out.println(b64E.encode(authString));
		
	}*/
	
	/**
	 * @param authString Authentication data to store
	 * @param folderName Folder name to record data to
	 * @param fName File name to record data to
	 */
/*	public void recordDigest(byte[] authString, String folderName, String fName) {
		// TODO Auto-generated method stub
		FileOutputStream op = null;
		PrintWriter pw = null;
		
		try {
			op = new FileOutputStream(folderName + "\\" + fName + ".dig");
			pw = new PrintWriter(op, true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		//System.out.println(b64E.encode(authString));
		pw.println(b64E.encode(authString));
		
		try {
			op.close();
			pw.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	/**
	 * 
	 * @param folderName Stores the folder name to read data from
	 * @param fName File name to read data from
	 * @return Authentication data
	 */
/*	public String readDigest(String folderName, String fName) {
		
		FileInputStream ip = null;
		Scanner sc = null;
		
		try {
			ip = new FileInputStream(folderName + "\\" + fName + ".dig");
			sc = new Scanner(ip);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		String authString = new String(sc.nextLine());
		//System.out.println(authString);
		return authString;
		
	}
	
	/**
	 * @param folderName Stores the folder name of the data
	 * @return True if data is authentic, else False
*	 */
/*	public boolean authentication(String folderName) {
		
		String auth1 = readDigest(folderName, "sig1Norm");
		String auth2 = readDigest(folderName, "sig2Norm");
		
		byte[] auth1New = getDigest(folderName, "sig1Norm");
		byte[] auth2New = getDigest(folderName, "sig2Norm");
		
		if ((b64E.encode(auth1New)).equals(auth1) 
			&& (b64E.encode(auth2New)).equals(auth2))
			return true;
		
		return false;
		
	}

	/**
	 * @param args Unused
	 */
/*	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new authData();
	}
	
	/**
	 * Base 64 Encoder
	 */
//	public BASE64Encoder b64E = null;
	
	/**
	 * Base 64 Decoded
	 */
//	public BASE64Decoder b64D = null;

//}
