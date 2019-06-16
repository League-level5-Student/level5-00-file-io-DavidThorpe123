package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	JFrame frame;
	JPanel panel;
	JButton button;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	String fileName;
	ArrayList<String> tasks;
	ToDoList() {
		frame = new JFrame();
		panel = new JPanel();
		button = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		button4 = new JButton();
		button5 = new JButton();
		tasks = new ArrayList<>();
		frame.add(panel);
		panel.add(button);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		frame.setVisible(true);
		button.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button.setText("Add Task");
		button2.setText("View Tasks");
		button3.setText("Remove Task");
		button4.setText("Save List");
		button5.setText("Load List");
		
	}
	public static void main(String[] args) {
		ToDoList tdl = new ToDoList();
	}
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 * 
	 * When add task is clicked:
	 * 		ask the user for a  task and save it to an array list
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == button) {
			String task = JOptionPane.showInputDialog("Enter a task");
			tasks.add(task);
		}
		if (e.getSource() == button2) {
			String taskss = "";
			for (int i = 0; i < tasks.size(); i++) {
				taskss += tasks.get(i);
				taskss += "\n";
			}
			JOptionPane.showMessageDialog(null, taskss);
		}
		if (e.getSource() == button3) {
			String taskss = "";
			for (int i = 0; i < tasks.size(); i++) {
				taskss += tasks.get(i);
				taskss += "\n";
			}
			JOptionPane.showMessageDialog(null, taskss);
			String num = JOptionPane.showInputDialog("Enter the number of the task you want to remove");
			int numm = Integer.parseInt(num);
			tasks.remove(numm - 1);
		}
		if (e.getSource() == button4) {
			try {
				FileWriter fw = new FileWriter("src/_03_To_Do_List/list.txt");
				String taskss = "";
				for (int i = 0; i < tasks.size(); i++) {
					taskss += tasks.get(i);
					taskss += "\n";
				}
				/*
				NOTE: To append to a file that already exists, add true as a second parameter when calling the
				      FileWriter constructor.
				      (e.g. FileWriter fw = new FileWriter("src/_00_Intro_To_File_Input_and_Output/test2.txt", true);)
				*/
				
				fw.write(taskss);
					
				fw.close();
			} catch (IOException f) {
				f.printStackTrace();
			}
		}
		if (e.getSource() == button5) {
			JFileChooser jfc = new JFileChooser();
			int returnVal = jfc.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				 fileName = jfc.getSelectedFile().getAbsolutePath();
				System.out.println(fileName);
			}
			try {
				BufferedReader br = new BufferedReader(new FileReader(fileName));
				
				String line = br.readLine();
				while(line != null){
					tasks.add(line);
					System.out.println(line);
					line = br.readLine();
				}
				
				br.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException f) {
				// TODO Auto-generated catch block
				f.printStackTrace();
			}
		}
	}
}
