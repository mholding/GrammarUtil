

package grammarutils;

import java.lang.reflect.Field;
import java.util.Date;

import java.util.Map;

/**
 *
 * @author mason
 */
public class Util {
            
       public static final long MIN_MILLIS = 1000 * 60;
       public static final long HOUR_MILLIS = MIN_MILLIS * 60;
       public static final long DAY_MILLIS = HOUR_MILLIS * 24;

    /**
     * Returns a String representing how long ago (to the nearest minutes, hours, or days)
     *
     * @param date the input
     * @return an English sentence telling how long ago, accounting for grammar
     */
    public static String howLongAgo(final Date date){
        String result;
        
        Date now = new Date();

        long diff = now.getTime() - date.getTime();
       
        if (diff < HOUR_MILLIS){
            long minutes = (diff / MIN_MILLIS);
            
            if (minutes == 1) {
                result = minutes + " minute ago";
            } else {
                result = minutes + " minutes ago";  
            }
        } else if (diff < DAY_MILLIS) {
            long hours = (diff / HOUR_MILLIS);
            
            if (hours == 1){
                result = hours + " hour ago";
            } else {
                result = hours + " hours ago";
            }
        } else {
            long days = (diff/DAY_MILLIS);
            
            if (days == 1){
                result = days + " day ago";
            } else {
                result = days + " days ago";
            }
        }
               
        return result;        
    }

    /**
     * A handy utility that uses reflection for setting any field on an Object.
     *
     * @param o The object to set fields on
     * @param fieldValues a map of String field names to object values
     */
    public static void setFields(final Object o, final Map<String, ?> fieldValues) {
        Class c = o.getClass();

        fieldValues.keySet().forEach(key -> {
            try {
                Field field = c.getDeclaredField(key);
                field.setAccessible(true);
                field.set(o, fieldValues.get(key));

            } catch (NoSuchFieldException nsfe) {
                System.err.println(key + " " + nsfe.getMessage());
            } catch (IllegalAccessException iae) {
                System.err.println(key + " " + iae.getMessage());
            }
        });
    }

    /**
     * A grammar utility for outputting correct grammar telling which place
     * a number represents.
     * e.g., 1st place, 2nd place, 3rd place, 4th place, etc...
     */
    public static String getPlace(int position){
        StringBuilder builder = new StringBuilder();

        builder.append(position);

        String place = " place";

        String strRep = ""+position;
        short lastDigits = 0;

        if (position < 10){
            lastDigits = Short.parseShort(strRep.substring(strRep.length()-1));
        } else {
            lastDigits = Short.parseShort(strRep.substring(strRep.length()-2));
        }

        // return early if greater than 3 but less than 21
        if (lastDigits > 3 && lastDigits < 21){
            return builder.append("th").append(place).toString();
        } else if ( lastDigits > 20){
            //only interested in the last digit for numbers greater than 20
            lastDigits = Short.parseShort(strRep.substring(strRep.length()-1));
        }

        if (lastDigits == 1){
            builder.append("st");
        } else if (lastDigits == 2){
            builder.append("nd");
        } else if (lastDigits == 3){
            builder.append("rd");
        } else {
            builder.append("th");
        }

        return builder.append(place).toString();
    }

}
