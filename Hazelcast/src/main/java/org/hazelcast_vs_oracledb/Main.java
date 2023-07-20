package org.hazelcast_vs_oracledb;
import java.lang.*;

public class Main {


    public static void main(String[] args) {
        System.setProperty("hazelcast.logging.type","none");
        hazelcastManager dataAppender = new hazelcastManager();

        System.out.println("Append time : "+ dataAppender.dataAppender(20000)+"ms");
        System.out.println("Appended "+ dataAppender.getNumber() + " amount of numbers");
        System.out.println("Get time : "+ dataAppender.dataGetter(20000)+"ms");
        System.out.println("Got "+ dataAppender.getNumber() + " amount of numbers");
        System.out.println("Append time : "+ dataAppender.dataAppender(100000)+"ms");
        System.out.println("Appended "+ dataAppender.getNumber() + " amount of numbers");
        System.out.println("Get time : "+ dataAppender.dataGetter(100000)+"ms");
        System.out.println("Got "+ dataAppender.getNumber() + " amount of numbers");

    }


}
