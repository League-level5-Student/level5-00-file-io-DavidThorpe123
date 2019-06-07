package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	
	// Create a program that takes a message from the user.
	// Use the methods in the String and Character classes to save
	// an encrypted form of the message to a file
	public static void main(String[] args) {
		 String message = JOptionPane.showInputDialog("Enter a message");
char[] c = message.toCharArray();
for (int i = 0; i < c.length / 2; i++) {
	char temp = c[i];
	c[i] = c[c.length - i - 1];
	c[c.length - i - 1] = temp;
}
String s = "";
for (int j = 0; j < c.length; j++) {
	s += c[j];
}

	try {
		FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/t.txt");
		
		/*
		NOTE: To append to a file that already exists, add true as a second parameter when calling the
		      FileWriter constructor.
		      (e.g. FileWriter fw = new FileWriter("src/_00_Intro_To_File_Input_and_Output/test2.txt", true);)
		*/
		
		fw.write(s);
			
		fw.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
