package general.problems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileOperations {

	public static void main(String[] args) {
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 
			String input;
	 
			while((input=br.readLine())!=null){
				System.out.println(input);
			}
	 
		}catch(IOException io){
			io.printStackTrace();
		}	

	}
	
	public static void writeToFile(String data) {
		File file = new File(
				"C:/myhome/apache-jmeter-2.9/ahut/query_output.txt");
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			BufferedWriter bf = new BufferedWriter(new FileWriter(file, true));
			bf.newLine();
			bf.write(data);
			bf.newLine();
			bf.close();

			System.out.println("Done");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readFromFile() {
		FileInputStream fis = null;
        BufferedReader reader = null;
      
        try {
            fis = new FileInputStream("C:/sample.txt");
            reader = new BufferedReader(new InputStreamReader(fis));
          
            System.out.println("Reading File line by line using BufferedReader");
          
            String line = reader.readLine();
            while(line != null){
                System.out.println(line);
                line = reader.readLine();
            }           
          
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
          
        } finally {
            try {
                reader.close();
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
	}
	
	public static void readUsingScanner() {
		Scanner in = new Scanner(System.in); 
	       System.out.printf("Enter i Value:  ");
	       int i = in.nextInt();
	       System.out.printf("Enter j Value:  ");
	}

}
