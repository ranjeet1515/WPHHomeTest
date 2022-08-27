package com.wovenplanet.utils;

import com.wovenplanet.exception.FileParserException;
import com.wovenplanet.exception.ServiceControllerException;
import com.wovenplanet.logic.ServiceController;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FileUtils {
    /**
     * To load data from file into a list of records
     */
    public static Map<Integer, Integer> readFile(String filePath) throws FileParserException, IOException {
        if (StringUtils.isEmpty(filePath)) {
            throw new FileParserException("invalid Path");
        }
        BufferedReader br = null;
        String line;
        String rowSplitBy = " ";
        Map<Integer, Integer> fileMeta = new HashMap<>();
        try {
            File file = new File(filePath);
            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                String[] record = line.split(rowSplitBy);
                fileMeta.put(Integer.parseInt(record[0]), Integer.parseInt(record[1]));
            }
        } catch (FileNotFoundException exception) {
            System.err.println("Wrong File Location");
            throw exception;
        } catch (IOException exception) {
            System.out.println("Problem occurred during reading file ");
            throw exception;
        } finally {
            if (br != null) {
                br.close();
            }
        }
        return fileMeta;
    }

    /**
     * list of unique id's associated with the X-largest values
     *
     * @param filePath : location of the file
     * @param X        : the value of X
     */
    public static void getLargestValues(String filePath, Integer X) {

        try {
            if (filePath == null || X == null) {
                throw new Exception(
                        "Please pass file location as first argument and value of X as second argument in the command line");
            }
            Map<Integer, Integer> records = readFile(filePath);
            System.out.println("\n<--------Unique ids associated with " + X + "-largest values--------->\n");
            getUniqueIDS(records, X);

        } catch (Exception exception) {
            System.err.println("\n<--------------------------Error------------------------------>\n");
            System.err.println(exception.getMessage());
        }
        System.out.println("\n<--------------------------File Done------------------------------>\n");
    }

    private static void getUniqueIDS(Map<Integer, Integer> records, int x) throws ServiceControllerException {
        ServiceController serviceController = new ServiceController();
        // list of unique id's associated with the X-largest values
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = serviceController.getUniqueIDs(records, x);
        while (!priorityQueue.isEmpty()) {
            Map.Entry<Integer, Integer> entry = priorityQueue.poll();
            System.out.println(entry.getKey());
        }
    }
}

