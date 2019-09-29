package LeetCode;

public class ImplementStrStr {
    public static int strStr(String haystack, String needle) {
        if(needle == "") return 0;
        int ans = haystack.indexOf(needle);
        return ans;
    }

    public static void main(String[] args){
        String haystack = "hello";
        String needle = "";
        System.out.println(strStr(haystack, needle));
    }
}
