package com.SeleniumFramework.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    Properties properties;
    public ReadConfig()
    {
        File src = new File("./configuration/config.properties");
        try {
            FileInputStream fileInputStream = new FileInputStream(src);
            properties = new Properties();
            properties.load(fileInputStream);

        }
        catch (Exception e){
            System.out.println("Exception occured"+e.getMessage());

        }
    }
public String getbaseURL()
        {
           String url=properties.getProperty("baseURL");
           return url;

        }

        public String getUserName()
        {
            return properties.getProperty("username");

        }
        public String getPassword()
        {
            return properties.getProperty("password");

        }



    }


