package org.hazelcast_vs_oracledb;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;

import java.util.List;

public class hazelcastManager {
    //defining number for getter
    private int number;
    //create list and client for every method
    private HazelcastInstance hz;
    private List list;

    public long dataAppender(int number){

        this.number = number;
        //defining new client and list for attempt
        this.hz = HazelcastClient.newHazelcastClient();
        this.list = hz.getList("my-distributed-list1");
        //initial time of process
        long initialT = System.currentTimeMillis();

        for(int i = 0; i < number; i++){
            list.add(Math.random());

        }
        //end time of process
        long lastT = System.currentTimeMillis();

        hz.shutdown();
        return lastT - initialT;
    }
    public long dataGetter(int number){

        this.number = number;
        //defining new client and list for attempt
        this.hz = HazelcastClient.newHazelcastClient();
        this.list = hz.getList("my-distributed-list1");
        //initial time of process
        long initialT = System.currentTimeMillis();

        for(int i = 0; i < number; i++){
            list.get(number);

        }
        //end time of process
        long lastT = System.currentTimeMillis();

        hz.shutdown();
        return lastT - initialT;

    }
    public int getNumber(){
        return number;
    }
}
