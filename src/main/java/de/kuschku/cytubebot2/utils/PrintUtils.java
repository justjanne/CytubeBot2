package de.kuschku.cytubebot2.utils;

import java.io.PrintStream;
import java.util.StringJoiner;

public class PrintUtils {
    private PrintUtils() {

    }

    public static void printMultiline(PrintStream out, String str, int length) {
        String content = str.replace("\n", "\\n").replace("\r", "\\r");
        StringJoiner text = new StringJoiner("\n");
        text.add(content.substring(0, Math.min(length, content.length())));
        content = content.substring(Math.min(length, content.length()));
        while (content.length() > 0) {
            text.add("    " + content.substring(0, Math.min(length - 4, content.length())));
            content = content.substring(Math.min(length - 4, content.length()));
        }
        out.println(text);
    }
}
