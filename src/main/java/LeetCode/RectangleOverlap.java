package LeetCode;

public class RectangleOverlap {
    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (rec1[2] <= rec2[0] || rec1[0] >= rec2[2]) return false; // if x2 <= x3 or x1 >= x4, they are not overlapping
        if (rec1[1] >= rec2[3] || rec1[3] <= rec2[1]) return false; // if y1 >= y4 or y2 <= y3, they are not overlapping
        return true;
    }
}
