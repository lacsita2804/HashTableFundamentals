import java.util.*;

class DNSEntry {
    String ip;
    long expiry;

    DNSEntry(String ip, int ttl) {
        this.ip = ip;
        this.expiry = System.currentTimeMillis() + ttl * 1000;
    }
}

public class Problem3_DNSCache {

    static HashMap<String, DNSEntry> cache = new HashMap<>();

    static String resolve(String domain) {
        if (cache.containsKey(domain) && cache.get(domain).expiry > System.currentTimeMillis()) {
            return "Cache HIT: " + cache.get(domain).ip;
        }
        String ip = "172.1.1." + new Random().nextInt(255);
        cache.put(domain, new DNSEntry(ip, 5));
        return "Cache MISS → " + ip;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(resolve("google.com"));
        System.out.println(resolve("google.com"));
    }
}