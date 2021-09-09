package control;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeNumberUtils {
	    
	private static int sequence = 0;
	private static int length = 6;

	public  synchronized String BOID(String cid) {
	    sequence = sequence >= 999999 ? 1 : sequence + 1;
	    String datetime = new SimpleDateFormat("yyyyMMddHHmmss")
	            .format(new Date());
	    String s = Integer.toString(sequence);
	    return "B"+datetime +addLeftZero(s, length)+cid;
	    }
	
	public  synchronized String OID(String cid) {
	    sequence = sequence >= 999999 ? 1 : sequence + 1;
	    String datetime = new SimpleDateFormat("yyyyMMddHHmmss")
	            .format(new Date());
	    String s = Integer.toString(sequence);
	    return "O"+datetime +addLeftZero(s, length)+cid;
	    }

	public static String addLeftZero(String s, int length) {
	        // StringBuilder sb=new StringBuilder();
	        int old = s.length();
	        if (length > old) {
	            char[] c = new char[length];
	            char[] x = s.toCharArray();
	            if (x.length > length) {
	                throw new IllegalArgumentException(
	                        "Numeric value is larger than intended length: " + s
	                                + " LEN " + length);
	            }
	            int lim = c.length - x.length;
	            for (int i = 0; i < lim; i++) {
	                c[i] = '0';
	            }
	            System.arraycopy(x, 0, c, lim, x.length);
	            return new String(c);
	        }
	        return s.substring(0, length);
	    }
}
