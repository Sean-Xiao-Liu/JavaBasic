package LeetCode;

/* The games he should play are :
Street Fighter II
Star Wars
Mortal Kombat
Mario Bros
Speed Racer
The maximum earn from the game is $780
*/

public class FINRAQ4 {
    public static void maximizeEarn(String[] games, int[] time, int[] payment){
        int l = time.length;    //The lengths of the three array should all be 10
        int t = 120;    //The total time

        int[][] val = new int[l][t+1];
        for(int i=1;i<l;i++){
            for(int j=1;j<t+1;j++){
                if(j<time[i]){
                    val[i][j] = val[i-1][j];
                }else
                    val[i][j]=Math.max(val[i-1][j],val[i-1][j-time[i]]+payment[i]);
            }
        }

        for(int i = l-1;i>=1;i--){
            if(val[i][t] != val[i-1][t]){
                System.out.println(games[i]);   //print the best combination of games
                t -= time[i]; // then remove corresponding time of game from the total time
            }
        }

        System.out.println("The maximum earn from the game is $" + val[l-1][120]);  //In this question, Adam can earn $780 at most;
    }

    public static void main(String[] args) {
        // Input the arrays into the
        String[] games = {"Pac-man","Speed Racer","Pump it Up","Space Invaders","Mario Bros","Mortal Kombat","Atari Breakout","Super Tetris","Star Wars","Street Fighter II"};
        int[] time = {75,45,30,35,30,15,60,90,20,10};
        int[] pay = {250,280,150,120,200,100,300,350,110,90};
        maximizeEarn(games,time,pay);
    }
}
