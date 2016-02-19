package general.problems;

import java.io.ObjectInputStream.GetField;

/*
12.977459,77.695886
12.97735200002402,77.69595075008358 
12.977245000032024,77.69601550011146 
12.977138000024018,77.6960802500836 
12.977031,77.696145
*/
public class TrafficFinder {

	public static void main(String[] args) {
		//midPoint(12.977245000032024, 77.69601550011146, 12.977031, 77.696145);
		//bearingFinder(12.977459, 77.695886);
		//System.out.println("=========");
		//getAllPoints(12.977459, 77.695886, 12.977031, 77.696145);
		
		Location origin = new Location(12.970705873831289, 77.71233763996793);
		Location destination = new Location(12.972625028752372, 77.71165769998265);
		
		Location[] pointsArray = new Location[5];
		pointsArray[0] = origin;
		pointsArray[4] = destination;
		pointsArray[2] = midPoint(origin.latitue, origin.longitude, destination.latitue, destination.longitude);
		pointsArray[1] = midPoint(origin.latitue, origin.longitude, pointsArray[2].latitue, pointsArray[2].longitude);
		pointsArray[3] = midPoint(pointsArray[2].latitue, pointsArray[2].longitude, destination.latitue, destination.longitude);
		
		for (int i = 0; i < 5; i ++) {
			System.out.println(pointsArray[i].latitue + " " + pointsArray[i].longitude);
			//System.out.println(pointsArray[i].toString());
		}
		
		Location midPoint = midPoint(origin.latitue, origin.longitude, destination.latitue, destination.longitude);

	}
	
	public static void recursiveMidPoint(double lat1,double lon1,double lat2,double lon2) {
		
	}
	
	public  static Location midPoint(double lat1,double lon1,double lat2,double lon2){

	    double dLon = Math.toRadians(lon2 - lon1);

	    //convert to radians
	    lat1 = Math.toRadians(lat1);
	    lat2 = Math.toRadians(lat2);
	    lon1 = Math.toRadians(lon1);

	    double Bx = Math.cos(lat2) * Math.cos(dLon);
	    double By = Math.cos(lat2) * Math.sin(dLon);
	    double lat3 = Math.atan2(Math.sin(lat1) + Math.sin(lat2), Math.sqrt((Math.cos(lat1) + Bx) * (Math.cos(lat1) + Bx) + By * By));
	    double lon3 = lon1 + Math.atan2(By, Math.cos(lat1) + Bx);

	    //print out in degrees
	    //System.out.println(Math.toDegrees(lat3) + " " + Math.toDegrees(lon3));
	    return new Location(Math.toDegrees(lat3), Math.toDegrees(lon3));
	}
	
	public static void getAllPoints(double lat1,double lon1,double lat5,double lon5){

	    double dLon = Math.toRadians(lon5 - lon1);

	    //Third point
	    lat1 = Math.toRadians(lat1);
	    lat5 = Math.toRadians(lat5);
	    lon1 = Math.toRadians(lon1);

	    double Bx = Math.cos(lat5) * Math.cos(dLon);
	    double By = Math.cos(lat5) * Math.sin(dLon);
	    double lat3 = Math.atan2(Math.sin(lat1) + Math.sin(lat5), Math.sqrt((Math.cos(lat1) + Bx) * (Math.cos(lat1) + Bx) + By * By));
	    double lon3 = lon1 + Math.atan2(By, Math.cos(lat1) + Bx);

	    //print out in degrees
	    System.out.println(Math.toDegrees(lat3) + " " + Math.toDegrees(lon3));
	    
	    //second point
	     dLon = Math.toRadians(lon3 - lon1);
	    
	    //lat1 = Math.toRadians(lat1);
	    //lat3 = Math.toRadians(lat3);
	    //lon1 = Math.toRadians(lon1);

	     Bx = Math.cos(lat3) * Math.cos(dLon);
	     By = Math.cos(lat3) * Math.sin(dLon);
	     double lat2 = Math.atan2(Math.sin(lat1) + Math.sin(lat3), Math.sqrt((Math.cos(lat1) + Bx) * (Math.cos(lat1) + Bx) + By * By));
	     double lon2 = lon1 + Math.atan2(By, Math.cos(lat1) + Bx);
	    
	     
	    
	    //4th point
	  //second point
	     dLon = Math.toRadians(Math.toRadians(lon5) - lon3);
	    
	    //lat3 = Math.toRadians(lat3);
	    //lat5 = Math.toRadians(lat5);
	    //lon3 = Math.toRadians(lon3);

	     Bx = Math.cos(lat5) * Math.cos(dLon);
	     By = Math.cos(lat5) * Math.sin(dLon);
	     double lat4 = Math.atan2(Math.sin(lat3) + Math.sin(lat5), Math.sqrt((Math.cos(lat3) + Bx) * (Math.cos(lat3) + Bx) + By * By));
	     double lon4 = lon3 + Math.atan2(By, Math.cos(lat3) + Bx);
	    
	     System.out.println(Math.toDegrees(lat1) + "," + Math.toDegrees(lon1));
	     System.out.println(Math.toDegrees(lat2) + "," + Math.toDegrees(lon2));
	     System.out.println(Math.toDegrees(lat3) + ", " + Math.toDegrees(lon3));
	     System.out.println(Math.toDegrees(lat4) + ", " + Math.toDegrees(lon4));
	     System.out.println(Math.toDegrees(lat5) + ", " + lon5);
	}
	
	public static void bearingFinder(double latInp,double lonInp) {
		double dist = 2.0/6371.0;
		double brng = Math.toRadians(45);
		double lat1 = Math.toRadians(latInp);
		double lon1 = Math.toRadians(lonInp);

		double lat2 = Math.asin( Math.sin(lat1)*Math.cos(dist) + Math.cos(lat1)*Math.sin(dist)*Math.cos(brng) );
		double a = Math.atan2(Math.sin(brng)*Math.sin(dist)*Math.cos(lat1), Math.cos(dist)-Math.sin(lat1)*Math.sin(lat2));
		System.out.println("a = " +  a);
		double lon2 = lon1 + a;

		lon2 = (lon2+ 3*Math.PI) % (2*Math.PI) - Math.PI;

		System.out.println("Latitude = "+Math.toDegrees(lat2)+"\nLongitude = "+Math.toDegrees(lon2));
	}
	
	public static class Location {
		double latitue;
		double longitude;
		
		public Location(double aLatitue, double aLongitude) {
			this.latitue = aLatitue;
			this.longitude = aLongitude;
		}
		
		public String toString() {
			return new StringBuilder(this.latitue + "," + this.longitude).toString();
		}
	}

}
