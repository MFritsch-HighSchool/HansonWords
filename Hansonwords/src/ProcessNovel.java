import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class ProcessNovel {
/*
 * Since each class wrote different String-int classes, I purposely wrote the Process
 * Novel class Objects in a vague fashion.  I tried to keep everything as generic as
 * possible...  I have extra comments around the places where I used specifics
 */
	
	int period = 3;	
	WordFreqList words = new WordFreqList();
	String t;
	File book;
	JFrame j = new JFrame();
	public static void main(String[] args) {
		new ProcessNovel().start();

	}

	protected void start() {
//		
//		String s = "Hello!";
//		
//		s=s.toUpperCase();
//		System.out.println(s);
//		s=s.substring(1, 6);
//		System.out.println(s);
//		s=s.substring(1);
//		System.out.println(s);
		
		promptForTextFile();
		readInContentsOfFile();
		displayResults();

	}

	void displayResults() {
		// prompt the user for their choice of display
		String[] opts = {"Alpha", "Freq", "Length"};
		//		int choice = JOptionPane.showOptionDialog(null, "Msg", "Title", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION,
		//				                         null,opts , opts[0]);

		int choice = JOptionPane.showOptionDialog(null, "Choose your option", "Display Results", 
												JOptionPane.YES_NO_CANCEL_OPTION, 
												JOptionPane.DEFAULT_OPTION,
												null,opts , opts[0]);
		
	
		if(choice == 0) {// alpha
			for(int l = 0; l < words.size()-1; l++){
				System.out.println(words.get(l));
				
			}
		}
		else if(choice == 1) {// freq
			
		}
		else {// by length
			
		}

		// would be nice to add the option to repeat process for other attributes
	}

	void readInContentsOfFile() {
		Scanner s;
		try{
				s = new Scanner(book);
				while(s.hasNext()){
					t = s.next();
					t = t.toLowerCase();
					boolean stTru = true;
					char c;
					while(stTru){
						c = t.charAt(0);
						if(!Character.isLetter(c) && t.length() == 1){
							t = "null";
							stTru = false;
						}
						else{
							
							if(!Character.isLetter(c)){
								System.out.println("First Letter");
								t = t.substring(1, t.length());
							}
							else{
								c = t.charAt(t.length()-1);
								if(!Character.isLetter(c)){
									System.out.println("Last Letter");
									t = t.substring(0, t.length()-1);
								}	
								else
									stTru = false;
							}
						}
					}
					if(!t.equals("null")){
						WordFreq w = new WordFreq(t);
						System.out.println("Adding "+t);
						words.add(w);
					}
					
				}
		}
		catch(FileNotFoundException f){
			System.out.println(f.getMessage());
		}
	}

	private void promptForTextFile() {
		JFileChooser jfc = new JFileChooser();
		jfc.showOpenDialog(null);
		book = jfc.getSelectedFile();
		System.out.println(book);

	}

}
