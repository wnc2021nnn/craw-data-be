package com.craw_data.utils;

public class ImageChecker {
    public static boolean isHTTPSLink(String imageURL) {
        return imageURL.startsWith("https://");
    }
}
