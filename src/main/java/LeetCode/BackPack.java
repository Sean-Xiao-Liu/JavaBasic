package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

//solve 0/1 backpack problem using backtracking
public class BackPack {

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list,new ArrayList<>(),nums,0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> temp, int[] nums,int start){
        list.add(new ArrayList<>(temp)); // no limit on the length of temp list, so just add whatever it have to the list
        for(int i = start; i < nums.length; i++){
            temp.add(nums[i]);
            backtrack(list, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void maxPayment(String[] games, int[] time, int[] payment){
        int[] nums = IntStream.range(0,games.length).toArray();
        List<List<Integer>> list = subsets(nums); // generate all possible combination of games

        int bestPayment = 0;
        int bestCombine = 0;
        List<Integer> possiblePayment = new ArrayList<>();
        for(int i = 0 ; i < list.size() ; i++){

            int tempPayment = 0;
            int timeUsed = 0;

            List<Integer> gamesNumber = list.get(i);

            for(int j = 0 ; j < gamesNumber.size(); j++){
                tempPayment += payment[gamesNumber.get(j)]; // use gamesNumber.get(j) instead of j
                timeUsed += time[gamesNumber.get(j)];
            }

            if(timeUsed <= 120){
                possiblePayment.add(tempPayment);
                if (tempPayment > bestPayment){
                    bestPayment = tempPayment;
                    bestCombine = i;
                }
            }

        }

        System.out.println("The best combine is " + bestCombine + " and the payment is " + bestPayment);
        for(Integer i : list.get(bestCombine)){
            System.out.println(games[i]);
        }

    }

    public static void main(String[] args) {
        String[] games = {"Pac-man","Speed Racer","Pump it Up","Space Invaders","Mario Bros","Mortal Kombat","Atari Breakout","Super Tetris","Star Wars","Street Fighter II","1more","2more","3more"};
        int[] time = {75,45,30,35,30,15,60,90,20,10,10,20,30};
        int[] pay = {250,280,150,120,200,100,300,350,110,90,100,110,120};

//        String[] games = {"Pac-man","Speed Racer","Pump it Up"};
//        int[] time = {75,30,30};
//        int[] pay = {250,150,200};
        maxPayment(games,time,pay);
    }

}
