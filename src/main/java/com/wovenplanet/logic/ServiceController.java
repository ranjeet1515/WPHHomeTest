package com.wovenplanet.logic;

import com.wovenplanet.exception.ServiceControllerException;

import java.util.Map;
import java.util.PriorityQueue;

/**
 * Class containing the functionality to return statistic computation done on records passed in the file
 */
public class ServiceController {
    /**
     * This function returns list of the unique ids associated with the
     * X-largest values in the rightmost column, where X is specified by an
     * input parameter
     */
    public PriorityQueue<Map.Entry<Integer, Integer>> getUniqueIDs(Map<Integer, Integer> records, int n) throws ServiceControllerException {
        if (records == null || records.isEmpty()) {
            throw new ServiceControllerException("Empty File");
        }
        // column value in the record
        PriorityQueue<Map.Entry<Integer, Integer>> topValuesPriorityQueue = new PriorityQueue<>(n, (Map.Entry<Integer, Integer> record1, Map.Entry<Integer, Integer> record2) -> record1.getValue() >= record2.getValue() ? 1 : -1);
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : records.entrySet()) {
            if (i >= n) {
                topValuesPriorityQueue.add(entry);
                // Remove the latest priority record
                topValuesPriorityQueue.poll();
            } else {
                topValuesPriorityQueue.add(entry);
                i++;
            }
        }
        return topValuesPriorityQueue;
    }
}
