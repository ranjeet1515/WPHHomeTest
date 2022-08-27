package com.wovenplanet.logic;

import com.wovenplanet.exception.ServiceControllerException;
import  static  org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ServiceControllerTest {
    ServiceController serviceController = null;
    Map<Integer,Integer> testRecords=null;

    @Test
    public void testGetUniqueIDS_listOfIdsVerificationValues() throws ServiceControllerException {
        prepareTest();
        PriorityQueue<Map.Entry<Integer, Integer>> pq = serviceController.getUniqueIDs(testRecords, 2);
        assertEquals(1496248999, pq.peek().getKey().intValue());
    }
    @Test
    public void testGetUniqueIDS_listOfIdsVerificationSize() throws ServiceControllerException {
        prepareTest();
        PriorityQueue<Map.Entry<Integer, Integer>> pq = serviceController.getUniqueIDs(testRecords, 2);
        assertEquals (2, pq.size());
    }

    // 前提準備
    public void prepareTest() {
        serviceController = new ServiceController();
        testRecords = new HashMap<>();
        // test data setup
        testRecords.put(1426828028,46);
        testRecords.put(1426828082, 111);
        testRecords.put(1426828090, 23);
        testRecords.put(1426828092, 103);
        testRecords.put(1426828069, 88);
        testRecords.put(1496248970, 77);
        testRecords.put(1496248999, 110);
    }
}
