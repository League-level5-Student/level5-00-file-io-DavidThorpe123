package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileDecryptor {
	// Create a program that opens the file created by FileEncryptor and display
	// the decrypted message to the user in a JOptionPane.
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_02_File_Encrypt_Decrypt/t.txt"));
			
			String line = br.readLine();
			char[] c = line.toCharArray();
			for (int i = 0; i < c.length / 2; i++) {
				char temp = c[i];
				c[i] = c[c.length - i - 1];
				c[c.length - i - 1] = temp;
			}
			String s = "";
			for (int j = 0; j < c.length; j++) {
				s += c[j];
			}
			JOptionPane.showMessageDialog(null, s );
			
			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
