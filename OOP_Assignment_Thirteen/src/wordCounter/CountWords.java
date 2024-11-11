package wordCounter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedWriter;

public class CountWords {

	public static void main(String[] args) throws IOException {
		
		if(args.length != 1) {
			System.out.println("You have not provided exactly one text file.");
		}else {
			
			File inTxt = new File(args[0]);
			Scanner in = new Scanner(inTxt);
			int numWords = 0;
			
			while(in.hasNextLine()) {
				numWords++;
				in.nextLine();
			}
			in.close();
			
			Scanner input = new Scanner(inTxt);
			String[] inWords = new String[numWords];
			for(int i = 0; i < numWords; i++) {
				inWords[i] = input.nextLine().toLowerCase();
			}
			BufferedWriter out = new BufferedWriter(new FileWriter("CounterOutput.txt"));
			int counter = 0;
			
			for(int i = 0; i < numWords; i++) {
				
				counter = 0;
				String word = inWords[i];
				if(inWords[i] == null) {
					continue;
				}else {
					
					for(int j = 0; j < numWords; j++) {
						
						if(inWords[j] != null) {
							if(inWords[j].equalsIgnoreCase(word)) {
								counter++;
								inWords[j] = null;
							}
						}
						
					}
					
					out.write(word + " " + counter + "\n");
					
				}
				
			}
			
			out.close();
			input.close();
			
		}
		
	}

}
