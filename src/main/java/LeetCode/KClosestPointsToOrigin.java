package LeetCode;



import java.util.*;
import java.util.stream.Collectors;

/*We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)



Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)*/
public class KClosestPointsToOrigin {

    /** method 1 use hash map to store distance and linked hash map to sort by value**/
    public static int[][] kClosest(int[][] points, int K) {
        Map<int[],Integer> map = new HashMap<>();
        Map<int[],Integer> sortedMap = new LinkedHashMap<>();
        int[][] result = new int[K][2];
        for(int i = 0; i < points.length ; i++){
            int distance = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            map.put(points[i],distance);
        }

        // sort by value and take first K pairs
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(K) // save K points
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

        // iterate through the key set and save the key into grid
        List list = sortedMap.keySet().stream().collect(Collectors.toList());
        for(int j = 0 ; j < K ; j++){
            result[j] = (int[]) list.get(j);
        }
        return result;
    }

    /** method 2 **/
    public int[][] kClosest2(int[][] points, int K) {
        int[] distanceArray = new int[points.length]; // distance array record the distance of each point to
        for (int i = 0; i < points.length; ++i)
            distanceArray[i] = distanceToOrigin(points[i]);

        // find the distance of first K points
        Arrays.sort(distanceArray); // sort the distances in increasing order
        int distK = distanceArray[K-1]; // distK is the Kth distance to the origin

        int[][] ans = new int[K][2]; // initial the size of 2D array
        int t = 0;
        for (int i = 0; i < points.length; ++i)
            if (distanceToOrigin(points[i]) <= distK) // iterate through the points and only keep the points whose distance to origin is smaller to equals to distK
                ans[t++] = points[i];
        return ans;
    }

    public int distanceToOrigin(int[] point) { // give point coordinate, calculate the distance to origin
        return point[0] * point[0] + point[1] * point[1];
    }

    public static void main(String[] args) {
        int[][] points = {{0,1},{1,0}};
        int[][] result = kClosest(points,2);
        System.out.println(result[0][0]);
        System.out.println(result[1][0]);
    }
}
