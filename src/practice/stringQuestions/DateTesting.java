package practice.stringQuestions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTesting {

       public static void main(String[] args) {
              System.out.println("Current day:" + new Date());
              System.out.println("Previous day:" + subtractDay(new Date()));
       }

       public static String subtractDay(Date date) {
           SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
           Calendar cal = Calendar.getInstance();
           cal.setTime(date);
           cal.add(Calendar.DAY_OF_MONTH, -1);
           return formatter.format(cal.getTime());
       }
}

