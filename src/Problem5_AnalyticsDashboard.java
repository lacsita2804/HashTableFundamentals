import java.util.*;

public class Problem5_AnalyticsDashboard {

    static HashMap<String, Integer> pageViews = new HashMap<>();

    public static void main(String[] args) {
        pageViews.put("/news", 5);
        pageViews.put("/sports", 3);
        pageViews.put("/tech", 10);

        pageViews.entrySet().stream()
                .sorted((a,b)->b.getValue()-a.getValue())
                .limit(3)
                .forEach(System.out::println);
    }
}