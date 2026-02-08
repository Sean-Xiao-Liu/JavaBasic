package LeetCode.SlidingWindow;

public class MaximumNumberOfVowelsInSubstringOfGivenLength {
    public int maxVowels(String s, int k) {
        int count = 0;
        for (int i = 0 ; i < k; i++){
            if (isVowel(s.charAt(i))) count++;
        }

        int result = count;

        for (int j = k; j < s.length(); j++) {
            if((isVowel(s.charAt(j)))) count++;
            if(isVowel(s.charAt(j-k))) count--; // if the leftmost character is a vowel, decrement the count
            result = Math.max(result,count);
        }

        return result;
    }

    // method 2: boolean lookup array + early exit - O(n) time, faster constant factor
    public int maxVowelsFast(String s, int k) {
        boolean[] vowels = new boolean[128];
        vowels['a'] = vowels['e'] = vowels['i'] = vowels['o'] = vowels['u'] = true;

        int count = 0;
        for (int i = 0; i < k; i++) {
            if (vowels[s.charAt(i)]) count++;
        }

        int result = count;
        if (result == k) return k; // early exit

        for (int j = k; j < s.length(); j++) {
            if (vowels[s.charAt(j)]) count++;
            if (vowels[s.charAt(j - k)]) count--;
            result = Math.max(result, count);
            if (result == k) return k; // early exit
        }

        return result;
    }

    public boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }

    public static void main(String[] args) {
        String s = "aeiou";
        System.out.println(new MaximumNumberOfVowelsInSubstringOfGivenLength().maxVowels(s, 2));
    }
}
