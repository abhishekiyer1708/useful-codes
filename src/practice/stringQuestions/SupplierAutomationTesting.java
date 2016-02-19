package practice.stringQuestions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SupplierAutomationTesting {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("C:/myhome/supplier_data.csv"));
		String line = reader.readLine();
		String supplierId = null;
		while (line!=null) {
			int index = line.indexOf("FX");
			if (index!=-1) {
				String[] elementArray = line.split(",");
				String rowId = elementArray[0];
				if (supplierId==null || !supplierId.equals(rowId)) {
					supplierId = rowId;
					System.out.println(line);
				}
			}
			line = reader.readLine();
		}
	}

}
