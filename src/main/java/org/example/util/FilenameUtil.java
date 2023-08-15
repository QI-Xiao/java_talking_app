package org.example.util;

public class FilenameUtil {
    public static String removeExtension(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            return fileName;
        }

        int lastDotIndex = fileName.lastIndexOf('.');

        if (lastDotIndex == -1 || lastDotIndex == 0 || lastDotIndex == fileName.length() - 1) {
            return fileName;
        }

        return fileName.substring(0, lastDotIndex);
    }

    public static String getExtension(String fileName) {
        // Check for null or empty string
        if (fileName == null || fileName.isEmpty()) {
            return "";
        }

        // Find the last occurrence of the dot character in the fileName
        int lastDotIndex = fileName.lastIndexOf('.');

        // If no dot is found or it's the last character, return an empty string
        if (lastDotIndex == -1 || lastDotIndex == fileName.length() - 1) {
            return "";
        }

        // Return the substring after the last dot
        return fileName.substring(lastDotIndex + 1);
    }
}
