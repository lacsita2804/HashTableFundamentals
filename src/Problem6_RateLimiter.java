import java.util.*;

public class Problem6_RateLimiter {

    static HashMap<String, Integer> limit = new HashMap<>();
    static int MAX = 3;

    static boolean allow(String client) {
        limit.put(client, limit.getOrDefault(client, 0) + 1);
        return limit.get(client) <= MAX;
    }

    public static void main(String[] args) {
        for (int i=0;i<5;i++)
            System.out.println(allow("client1"));
    }
}