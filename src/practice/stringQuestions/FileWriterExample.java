package practice.stringQuestions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {

	public static void main(String[] args) {
		String roomExtras = "New room";
		String productId = "897978";
		String providerId = "100";
		String updateProductQuery = "update product set room_extras = " + "\'"
				+ roomExtras + "\'" + " where product_id = " + productId + " and provider_id = "
				+ providerId + " ;";
		String updateDictionaryItemQuery = "update dictionary_item_instance set content = "
				+ "\'"
				+ roomExtras
				+ "\'"
				+ " where dictionary_item_id = (select dct_room_extras from product where product.product_id = "
				+ productId + " and provider_id = " + providerId + " );";
		System.out.println(updateDictionaryItemQuery);
		System.out.println(updateProductQuery);
		File file = new File(
				"C:/myhome/apache-jmeter-2.9/ahut/query_output.txt");
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			BufferedWriter bf = new BufferedWriter(new FileWriter(file, true));
			bf.newLine();
			bf.write(updateProductQuery + "\n" + updateDictionaryItemQuery);
			bf.close();

			System.out.println("Done");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
