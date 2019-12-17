package LeetCode;

import java.util.*;


/* Use Hash map to store the name of actors and the number of movies they have acted
* The input here will be an array of String which contains the name of actors,
* the name can be duplicated.
 */
public class FINRAQ3 {


    public static void topActors(String[] actors){

        HashMap<String,Integer> unsortedMap = new HashMap<>();

        // If the input argument is null, it means the Tracy's list is empty
        if(actors == null){
            System.out.println("Tracy's list is empty");
        }

        //check each name is the string
        for(String name : actors){

            //if the name has been saved into the map already
            // increase the count by 1
            if(unsortedMap.containsKey(name)){
                unsortedMap.put(name,unsortedMap.get(name)+1);
            } else{
                // if the name is not present in the map, save it
                unsortedMap.put(name,1);
            }
        }

        // In order to sort the map by value in descending order, use Stream for operation
        // Use LinkedHashMap to store the sorted amp since it remain the order of insertion
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();

        unsortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) // Use reverse order comparator to sort value
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));



        // Check the size of the map
        // When the number of actors is smaller than 10 , just display them all
        if(sortedMap.size() <= 10){
            for (Map.Entry<String, Integer> en : sortedMap.entrySet()) {
                System.out.println("The actor " + en.getKey() +
                        " has acted " + en.getValue() + " movies");
            }
        }
        //When the map contains more than 10 actors, a tie situation may occur and all actors who have play
        // as much the 10th actor in the map should also be displayed as well.
        else {
            //determine the value of the 10th actor in the map
            int tenth = sortedMap.entrySet()
                    .stream()
                    .skip(9)
                    .map(map -> map.getValue()).findFirst().get();

            // then every actor who has played equals or more than "tenth" movie should also be displayed
            for (Map.Entry<String, Integer> en : sortedMap.entrySet()) {
                if(en.getValue() >= tenth)
                System.out.println("The actor " + en.getKey() +
                        " has acted " + en.getValue() + " movies");
            }
        }



    }

    public static void main(String[] args) {
        String[] actors = {"a","a","a","b","b","b","b","b","c","c","d","e","f","g","h","i","j","h","i","k","l"};
        topActors(actors);

    }
}

