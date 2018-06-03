package com.zhaoxuyan.utils;
import java.io.*;

public class RWCount {
    public static int read(String path) throws IOException {
        int count = 0;
        BufferedReader in = new BufferedReader(new FileReader(path + "count.txt"));
        String s = in.readLine();
        if (s != null) {
            count = Integer.parseInt(s);
        }
        in.close();
        return count;
    }

    public static void write(String path, String content) throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter(path + "count.txt"));
        out.write(content);
        out.flush();
        out.close();
    }
}
