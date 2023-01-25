/**
 * 
 */

/**
 * @author P00082012
 *
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.*;

public class CollectionFilter {
	public static void main(String[] args) {
		
		List<Integer> a=new ArrayList<Integer>();
		a.add(0);
		a.add(50);
		a.add(16);
		a.add(55);
		a.add(89);
		a.add(25);
		a.add(10);
		a.add(35);
		a.add(40);
		a.add(45);
		System.out.println(a);
		List<Integer> b=a.stream().filter(i->-i%2==0).sorted().collect(Collectors.toList());
		List<Integer> b1=a.stream().filter(i->-i%2==0).sorted((i1,i2)->(i1<i2)?1:(i1>i2)?-1:0).collect(Collectors.toList());
		System.out.println(b);
		System.out.println(b1);
		List<Integer> c=a.stream().map(i->i+5).collect(Collectors.toList());
		System.out.println(c);
		long f=a.stream().filter(i->i<10).count();
		System.out.println(f);
		List<String> str=new ArrayList<String>();
		str.add("Keerthi");
		str.add("Ramya");
		str.add("Ravi");
		str.add("Chadrakala");
		str.add("Swaraj");
		str.add("Sravan");
		List<String> str1=str.stream().filter(s->s.startsWith("R")).collect(Collectors.toList());
		System.out.println(str1);
		List<String> str2=str.stream().sorted().collect(Collectors.toList()); // sorted((i1,i2)->i1.compareTo(i2))
		System.out.println(str2);
		List<String> str3=str.stream().sorted((i1,i2)->i2.compareTo(i1)).collect(Collectors.toList());
		System.out.println(str3);
		
		
		LocalDate today = LocalDate.now();
		System.out.println(today);   //2022-02-15
		
		
		
		LocalTime now = LocalTime.now();
		System.out.println(now);
		Calendar cal = Calendar.getInstance();
	
        Date time=cal.getTime();
        DateFormat timeFormat = new SimpleDateFormat("HH:mm");
        String formattedTime=timeFormat.format(time);
        System.out.println("Current time of the day using Calendar - 24 hour format: "+ formattedTime);
        
        Date date = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");  
        String strDate = formatter.format(date); 
        System.out.println(strDate);
        String s1=strDate.substring(8,10);
        int sint=Integer.parseInt(s1);
        System.out.println(sint);
		
	}

}