package com.choice;

import java.io.*;
import java.util.Properties;

public class ProUtil  {

    public String getPro(String key) throws IOException {
        Properties prop = new Properties();
        InputStream in = new BufferedInputStream(new FileInputStream("log.properties"));
        prop.load(in);
        String name = prop.getProperty(key);
        return name;

    }


}
