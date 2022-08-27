package com.wovenplanet.main;

import com.wovenplanet.utils.FileUtils;

/**
 * This class is mainly use for the starting class for project show the unique id's associated with X-largest values
 * first argument is pass as the location of the file
 * second argument is pass as the value of X
 */
public class MainEntryPoint {
    public static void main(String[] args) {
        try {
            if (args == null || args.length < 2) {
                throw new Exception(
                        "Please pass file location as 1st arg and value of X as 2nd arg in the command line");
            }
            int X = Integer.parseInt(args[1]);
            FileUtils.getLargestValues(args[0], X);
        } catch (Exception e) {
            System.err.println("\n<--------------------------Error------------------------------>\n");
            System.err.println(e.getMessage());
        }
        System.out.println("\n<--------------------------Done------------------------------>\n");
    }
}
