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

	public static String buildUrl(String baseUrl, Map<String, String> urlMap) {
		StringBuffer sb = new StringBuffer(baseUrl);
		int counter = 0;
		if (urlMap != null) {
			for (Map.Entry<String, String> entry : urlMap.entrySet()) {
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

}
