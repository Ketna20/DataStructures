package leetcode75.HashMapSet;

import java.util.*;
import java.util.stream.Collectors;

public class EqualRowPairs_2352 {
    public static void main(String[] args) {
        int[][] grid = new int[3][3];
        List<List<Integer>> gridList = new ArrayList<>();

        int[] l1 = {3,2,1};
        int[] l2 = {1,7,6};
        int[] l3 = {2,7,7};

        List<Integer> list1 = Arrays.stream(l1).boxed().collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(l2).boxed().collect(Collectors.toList());
        List<Integer> list3 = Arrays.stream(l3).boxed().collect(Collectors.toList());

        gridList.add(list1);
        gridList.add(list2);
        gridList.add(list3);


        // Fill the grid with values
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = gridList.get(i).get(j);
            }
        }

        // Print the grid to verify the values
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();  // New line after each row
        }

        int res = equalPairs(grid);
    }


    public static int equalPairs(int[][] grid) {
        int n = grid.length;
        int res = 0;
        Map<List<Integer>, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(grid[i][j]);
            }
            map.put(list, 1);
        }

        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(grid[j][i]);
            }
            if(map.containsKey(list)) {
                map.put(list, map.get(list) + 1);
            } else {
                map.put(list, 1);
            }

        }

        // print map
        for(Map.Entry<List<Integer>, Integer> entry : map.entrySet()) {
            List<Integer> key = entry.getKey();
            int value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
        }

        res = (int) map.values().stream().filter(value -> value > 1).count();
        return res;
    }
}
