/**
 * 
 */
package com.dino.yelp;

import java.util.Map;

/**
 * @author pmantra
 * 
 */
public class DinoUtilities {

	private DinoUtilities() {
	}

	public static String buildUrl(String baseUrl, Map<String, Object> urlMap) {
		StringBuffer sb = new StringBuffer(baseUrl);
		int counter = 0;
		if (urlMap != null) {
			for (Map.Entry<String, Object> entry : urlMap.entrySet()) {
				if (counter == 0)sb.append("?");
				 else sb.append("&");
				sb.append(entry.getKey());
				sb.append("=");
				sb.append(entry.getValue());
				counter++;
			}
		}
		return sb.toString();
	}
	
	public static String encodeUrlParameter(String parameter) {
		StringBuffer sb = new StringBuffer();
		for (Character c : parameter.toCharArray()) {
			if (c == ' ') {
				sb.append("+");
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

}
