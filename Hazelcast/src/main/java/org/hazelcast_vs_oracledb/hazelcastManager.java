package org.hazelcast_vs_oracledb;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.collection.IList;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import java.util.concurrent.ThreadLocalRandom;
import java.util.List;
import java.util.Random;

public class hazelcastManager {
    //defining number for getter
    private int number;
    //create list and Instance for every method
    private HazelcastInstance hz;
    private IList<Object> list;

    private Random random = new Random();

    public long dataAppender(int number){

        this.number = number;
        //defining new Instance and list for attempt
        this.hz = Hazelcast.newHazelcastInstance();
        this.list = hz.getList("my-distributed-list1");
        //initial time of process
        long initialT = System.currentTimeMillis();

        for(int i = 0; i < number; i++){
            list.add(Math.random());

        }
        //end time of process
        long lastT = System.currentTimeMillis();



        return lastT - initialT;
    }
    public long dataGetter(int number){

        this.number = number;
        //defining new Instance and list for attempt
        this.hz = Hazelcast.newHazelcastInstance();
        this.list = hz.getList("my-distributed-list1");
        //initial time of process
        long initialT = System.currentTimeMillis();

        for(int i = 0; i < number; i++){
            list.get(number-1);

        }
        //end time of process
        long lastT = System.currentTimeMillis();


        return lastT - initialT;

    }
    public int getNumber(){
        return number;
    }
}
