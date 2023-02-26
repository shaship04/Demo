package com.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BasicAuth {
    Properties prop;

    public String npeUsername() throws IOException {
        if (System.getProperty("username") != null && !(System.getProperty("username").isEmpty())) {
            return System.getProperty("username");
        } else {
            prop = new Properties();
            FileInputStream objfile = new FileInputStream("/opt/config.properties");
            prop.load(objfile);
            return prop.getProperty("npe.username");
        }
    }

    public String npePassword() throws IOException {
        if (System.getProperty("password") != null && !(System.getProperty("password").isEmpty())) {
            return System.getProperty("password");
        } else {
            prop = new Properties();
            FileInputStream objfile = new FileInputStream("/opt/config.properties");
            prop.load(objfile);
            return prop.getProperty("npe.password");
        }
    }

    public String preprodUsername() throws IOException {
        if (System.getProperty("username") != null && !(System.getProperty("username").isEmpty())) {
            return System.getProperty("username");
        } else {
            prop = new Properties();
            FileInputStream objfile = new FileInputStream("/opt/config.properties");
            prop.load(objfile);
            return prop.getProperty("preprod.username");
        }
    }

    public String preprodPassword() throws IOException {
        if (System.getProperty("password") != null && !(System.getProperty("password").isEmpty())) {
            return System.getProperty("password");
        } else {
            prop = new Properties();
            FileInputStream objfile = new FileInputStream("/opt/config.properties");
            prop.load(objfile);
            return prop.getProperty("preprod.password");
        }
    }

    public String tryUsername() throws IOException {
        if (System.getProperty("username") != null && !(System.getProperty("username").isEmpty())) {
            return System.getProperty("username");
        } else {
            prop = new Properties();
            FileInputStream objfile = new FileInputStream("/opt/config.properties");
            prop.load(objfile);
            return prop.getProperty("try.username");
        }
    }

    public String tryPassword() throws IOException {
        if (System.getProperty("password") != null && !(System.getProperty("password").isEmpty())) {
            return System.getProperty("password");
        } else {
            prop = new Properties();
            FileInputStream objfile = new FileInputStream("/opt/config.properties");
            prop.load(objfile);
            return prop.getProperty("try.password");
        }
    }
}
