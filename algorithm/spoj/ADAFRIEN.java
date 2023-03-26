package spoj;

import java.util.*;

public class ADAFRIEN {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        long numberOfCelebrations = scan.nextLong();
        long k = scan.nextLong();

        List<Map.Entry<String, Long>> entryList = input(scan, numberOfCelebrations);

        if (k > entryList.size()) {
            k = entryList.size();
        }

        long totalExpense = 0L;

        for (int i = 0; i < k; i++) {
            totalExpense += entryList.get(i).getValue();
        }

        System.out.println(sb.append(totalExpense).append("\n"));


    }

    public static ArrayList<Map.Entry<String, Long>> input(Scanner scan, long numberOfCelebrations) {
        Map<String, Long> map = new LinkedHashMap<>();

        for (int i = 0; i < numberOfCelebrations; i++) {
            String name = scan.next();
            int expense = Integer.parseInt(scan.next());

            map.put(name, map.getOrDefault(name, 0L) + expense);
        }

        ArrayList<Map.Entry<String, Long>> list = new ArrayList<>(map.entrySet());
        list.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));


        return list;
    }

    public static void print(List<Map.Entry<String, Long>> list) {
        for (Map.Entry<String, Long> entry : list) {
            System.out.print(entry.getKey() + " " + entry.getValue());
            System.out.println();
        }

    }

}
