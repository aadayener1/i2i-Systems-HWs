import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class Main {
        private static Logger logger = Logger.getLogger(Main.class);
    static void myTimeLogging() {

        DOMConfigurator.configure("log4j.xml");
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                LocalTime now = LocalTime.now();
                if(now.getSecond() != 0){
                    logger.debug(now);

                } else if (now.getSecond() == 0 && now.getMinute() == 0) {
                    logger.error(now);

                }else if(now.getSecond() == 0){
                    logger.info(now);
                }
            }
        },0 ,1000);
    }

    public static void main(String[] args) throws InterruptedException {

    myTimeLogging();


    }
}