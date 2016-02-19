package practice.stringQuestions;

import java.util.ArrayList;
import java.util.List;

public class CreateDBQuery {

	public static void main(String[] args) {
		List<String> query = new ArrayList<String>();
		String roomExtras = "New room";
		String productId = "897978";
		String updateProductQuery = "update product set room_extras = "
		+ "\'" + roomExtras + "\'" + " where product_id = " + productId;
		String updateDictionaryItemQuery = "update dictionary_item_instance set content = "
		+ "\'" + roomExtras + "\'" + " where dictionary_item_id = (select dct_room_extras from product where product.product_id = "
				+ productId + ");";
		System.out.println(updateDictionaryItemQuery);
		System.out.println(updateProductQuery);
		
		query.add(updateProductQuery);
		query.add(updateDictionaryItemQuery);

	}

}
