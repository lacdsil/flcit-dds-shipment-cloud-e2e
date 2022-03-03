package common;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class RegexUtils {
    public static String removeIncompareFields(String str){
        Pattern eventId = Pattern.compile("\"eventId\":\"[A-Za-z0-9-]*\",");
        Pattern timeStamp = Pattern.compile("\"timestamp\":\"\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}.\\d{3}\"},");
        String finalResult = eventId.matcher(str).replaceAll("");
        finalResult = timeStamp.matcher(finalResult).replaceAll("");
        return finalResult;
    }

    public static String getStartDate(String record) {
        return StringUtils.substringBetween(record,"startDate\":\"","\",\"endDate\":\"");

    }
}
