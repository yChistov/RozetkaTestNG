package com.rozetka.core;

import au.com.bytecode.opencsv.CSVReader;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

public class CsvDataProvider {

    @DataProvider(name = "CsvDataProvider")
    public static Iterator<Object[]> provideData(Method method){
        List<Object[]> list = new ArrayList<>();
        String pathname = "test_data" + File.separator +
                method.getDeclaringClass().getSimpleName() + "." + method.getName() + ".csv";
        File file = new File(pathname);
        try {
            CSVReader reader = new CSVReader(new FileReader(file));
            String[] keys = reader.readNext();
            if (keys != null){
                String[] dataParts;
                while ((dataParts = reader.readNext()) != null){
                    Map<String, String> testData = new HashMap<>();
                    for (int i = 0; i < keys.length; i++){
                        testData.put(keys[i], dataParts[i]);
                    }
                    list.add(new Object[]{testData});
                }
            }
            reader.close();
        }catch (FileNotFoundException e){
            throw new RuntimeException("File " + pathname + " was not find.\n" + e.getStackTrace().toString());
        } catch (IOException e) {
            throw new RuntimeException("Could not read " + pathname + " file.\n" + e.getStackTrace().toString());
        }
        return list.iterator();
    }
}
