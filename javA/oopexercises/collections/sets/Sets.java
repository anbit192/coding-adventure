package oopexercises.collections.sets;

import java.util.*;

public class Sets {
    public static Set<Integer> intersectionManual(Set<Integer> firstSet, Set<Integer> secondSet) {
        Set<Integer> intersectSet = new HashSet<>();

        for (int value : firstSet) {
            if (secondSet.contains(value)) {
                intersectSet.add(value);
            }
        }

        for (int value : secondSet) {
            if (firstSet.contains(value)) {
                intersectSet.add(value);
            }
        }

        return intersectSet;
    }

    public static Set<Integer> unionManual(Set<Integer> firstSet, Set<Integer> secondSet) {
        Set<Integer> unionSet = new HashSet<>();

        for (int value : firstSet) {
            unionSet.add(value);
        }

        for (int value : secondSet) {
            unionSet.add(value);
        }

        return unionSet;
    }

    public static Set<Integer> intersection(Set<Integer> firstSet, Set<Integer> secondSet) {
        Set<Integer> intersectSet = unionManual(firstSet, secondSet);

        intersectSet.retainAll(firstSet);
        intersectSet.retainAll(secondSet);

        return intersectSet;
    }

    public static Set<Integer> union(Set<Integer> firstSet, Set<Integer> secondSet) {
        Set<Integer> unionSet = new HashSet<>();

        unionSet.addAll(firstSet);
        unionSet.addAll(secondSet);

        return unionSet;
    }

    public static List<Integer> toList(Set<Integer> source) {
        List<Integer> list = new ArrayList<>();
        list.addAll(source);

        return list;
    }

    public static List<Integer> removeDupplicates(List<Integer> source) {
        Set<Integer> newSet = new HashSet<>(source);

        return toList(newSet);
    }

    public static List<Integer> removeDupplicatesManual(List<Integer> source) {
        List<Integer> list = new ArrayList<>(source);

        for (int i = 0; i < source.size(); i++) {
            for (int j = i + 1; j < source.size(); j++) {
                if (source.get(i) == source.get(j)) {
                    list.remove(j);
                }
            }
        }

        return list;
    }

    public static String firstRecurringCharacter(String str) {
        String[] strings = str.replaceAll("\\s", "").split("");

        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings.length; j++) {
                if (strings[i].equals(strings[j])) {
                    return strings[j];
                }
            }
        }

        return "";
    }

    public static Set<Character> allRecurringChars(String strings) {

        char[] charArray = strings.toCharArray();
        Set<Character> newSet = new HashSet<>();

        for (char c : charArray) {
            newSet.add(c);
        }

        return newSet;
    }

    public static Integer[] toArray(Set<Integer> source) {
        Integer[] intArray = new Integer[source.size()];
        return source.toArray(intArray);

    }

    public static int getFirst(TreeSet<Integer> source) {
        return toList(source).get(0);
    }

    public static int getLast(TreeSet<Integer> source) {
        return toList(source).get(source.size() - 1);
    }

    public static int getGreater(TreeSet<Integer> source, int value) {
        return source.higher(value);
    }


}
