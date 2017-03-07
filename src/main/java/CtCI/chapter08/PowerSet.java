package CtCI.chapter08;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sonnguyen on 3/7/17.
 */
public class PowerSet {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        List<List<Integer>> subsets = getSubsets(list, 0);
        for (List<Integer> set : subsets) {
            for (Integer element : set) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        System.out.println(subsets.size());
    }

    public static List<List<Integer>> getSubsets(List<Integer> set, int index) {
        List<List<Integer>> allSubsets = null;

        if (set.size() == index) {
            allSubsets = new ArrayList<>();
            allSubsets.add(new ArrayList<>());
        } else {
            allSubsets = getSubsets(set, index + 1);
            int item = set.get(index);

            List<List<Integer>> moreSubsets = new ArrayList<>();
            for (List<Integer> subset : allSubsets) {
                List<Integer> newSubset = new ArrayList<>();
                newSubset.addAll(subset);
                newSubset.add(item);
                moreSubsets.add(newSubset);
            }
            allSubsets.addAll(moreSubsets);
        }
        return allSubsets;
    }
}
