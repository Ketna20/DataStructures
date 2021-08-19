package intervwPrep;
/*
 * ketnakhalasi created on 8/18/21
 * */

public class BasicMapMain {
    public static void main(String[] args) {
        BasicMap<String, Integer> map = new BasicMap<>();

        map.put("Alex", 1);
        map.put("Tomy", 2);
        map.put("Anna", 3);
        map.put("Nina", 4);
        map.put("Meena", 5);

        System.out.println("Alex value is: " + map.get("Alex"));
        map.remove("Alex");
        System.out.println(map);
    }
}
