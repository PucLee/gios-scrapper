import client.GiosClient;

import java.util.Timer;

public class Application {

    public static void main(String[] args) {
        Timer t = new Timer();

        GiosClient giosClient = new GiosClient();

        t.scheduleAtFixedRate(giosClient, 0, 10000);
    }
}
