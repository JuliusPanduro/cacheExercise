package com.example.demo.services;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.concurrent.TimeUnit;

/**
 * @author Julius Panduro
 */
public class Database {

    public String getDataSlow() throws InterruptedException {
        TimeUnit.SECONDS.sleep(10);
        String generatedString = RandomStringUtils.randomAlphabetic(1000);

        return generatedString;
    }
}
