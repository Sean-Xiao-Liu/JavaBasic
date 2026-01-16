package LeetCode.Array;

import java.util.Arrays;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 // current position is empty
                    && (i == 0 || flowerbed[i - 1] == 0) // previous position is empty or the first position
                    && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) // next position is empty or the last position
            ) {
                flowerbed[i] = 1;
                n--;
                if (n == 0) {
                    return true;
                }
            }
        }
        return false;

    }
}
