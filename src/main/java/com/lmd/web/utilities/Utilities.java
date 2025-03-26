package com.lmd.web.utilities;

import java.nio.charset.StandardCharsets;

public class Utilities {
	public static String convertToUnicode(String input, String sourceEncoding) {
        try {
            byte[] bytes = input.getBytes(sourceEncoding);
            return new String(bytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
