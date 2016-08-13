package com.cl.glmusic.hreflink;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherHref {
	
	public String getHrefImg(String str) {

			Pattern pattern = Pattern.compile("src=\"http://g..*\"");
	        Matcher matcher = pattern.matcher(str);
	        if (matcher.find())
	            return matcher.group(0);
	        return null;
	    }
	    
	    public String getHrefTime(String str) {
	    	Pattern pattern = Pattern.compile("class=.v-time.>............");
	        Matcher matcher = pattern.matcher(str);
	        if (matcher.find())
	            return matcher.group(0);
	        return null;
	    }
	    
	    public String getHrefLink(String str) {
	    	Pattern pattern = Pattern.compile("title=.*href=.http://v.youku.com.*\"");
	        Matcher matcher = pattern.matcher(str);
	        if (matcher.find())
	            return matcher.group(0);
	        return null;
	    }
	    
	    public String getHrefStream(String str) {
	    	System.out.println(str);
	    	Pattern pattern = Pattern.compile("value=\"http://player.youku.com/player.php/sid/.*/v.swf\"");
	    	
	        Matcher matcher = pattern.matcher(str);
	        if (matcher.find())
	            return matcher.group(0);
	        return null;
	    }
}
