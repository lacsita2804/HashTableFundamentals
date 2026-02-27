import java.util.*;

public class Problem1_UsernameChecker {

    // username -> userId
    static HashMap<String, Integer> userDatabase = new HashMap<>();

    // username -> attempt frequency
    static HashMap<String, Integer> attemptFrequency = new HashMap<>();

    static boolean checkAvailability(String username) {
        attemptFrequency.put(username,
                attemptFrequency.getOrDefault(username, 0) + 1);

        return !userDatabase.containsKey(username);
    }

    static List<String> suggestAlternatives(String username) {
        List<String> suggestions = new ArrayList<>();

        suggestions.add(username + "1");
        suggestions.add(username + "2");
        suggestions.add(username.replace("_", "."));

        return suggestions;
    }

    static String getMostAttempted() {
        String maxUser = "";
        int max = 0;

        for (String key : attemptFrequency.keySet()) {
            if (attemptFrequency.get(key) > max) {
                max = attemptFrequency.get(key);
                maxUser = key;
            }
        }
        return maxUser + " (" + max + " attempts)";
    }

    public static void main(String[] args) {

        // existing users
        userDatabase.put("john_doe", 101);
        userDatabase.put("admin", 102);

        System.out.println("john_doe available? "
                + checkAvailability("john_doe"));

        System.out.println("jane_smith available? "
                + checkAvailability("jane_smith"));

        System.out.println("Suggestions for john_doe: "
                + suggestAlternatives("john_doe"));

        // simulate multiple attempts
        checkAvailability("admin");
        checkAvailability("admin");
        checkAvailability("admin");

        System.out.println("Most attempted username: "
                + getMostAttempted());
    }
}