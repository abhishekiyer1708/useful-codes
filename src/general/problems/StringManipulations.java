package general.problems;

import java.util.ArrayList;
import java.util.List;
import java.lang.*;

public class StringManipulations {

	public static void main(String[] args) {
		String shopResponse = "ShopResponse><POS><Source ChannelId=\"185\" SearchPath=\"P\" CurrencyCode=\"USD\"/>"
				+ "</POS><Success>true</Success><Warnings><Warning Code=\"HOT-HSS-B003\">"
				+ "<Message>No properties found</Message></Warning></Warnings></ShopResponse>";
		
		
		if (shopResponse.contains("No properties found")) {
			System.out.println("Success");
		}
		
		String propertyId = "1000987654";
		String accomCodeAppender = "-0-6-HIL71893$v1v$";
		String accomCode = propertyId + accomCodeAppender;
		System.out.println(accomCode);
		
		String dateAppender = "T00:00:00Z";
		/*String checkInDate = dh.getStringDateInAdvance(rh.generateNumber(0,3));
		String checkOutDate = dh.getStringDateInAdvance(rh.generateNumber(4,9));
		checkInDate = checkInDate + dateAppender;
		checkOutDate = checkOutDate + dateAppender;
		System.out.println(checkInDate);
		*/
		
		List<String> propertyIds = new ArrayList<String>();
		propertyIds.add("100098676");
		propertyIds.size();
		
		String accomCodeStartTag = "<AccommCode>";
		String accomCodeEndTag = "</AccommCode>";
		StringBuilder accomCodesString = new StringBuilder();
		
		int propertyCountInRequest = 6;
		
		for (int i=0; i<propertyCountInRequest;i++) {
			accomCode.concat(accomCodeStartTag + propertyIds.get(i) + accomCodeEndTag + "/n");
		}
		accomCode.toString();
		
		int num = Math.max(4,6);
	}
}
