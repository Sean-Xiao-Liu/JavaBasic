package LeetCode.String;
/*
 * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * 
 * Example 1:
 * 
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Example 2:
 * 
 * Input: s = "God Ding"
 * Output: "doG gniD"
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 5 * 104
 * s contains printable ASCII characters.
 * s does not contain any leading or trailing spaces.
 * There is at least one word in s.
 * All the words in s are separated by a single space.
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] words = s.split("\\s+"); // split by one or more spaces
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0) {
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String s = "the sky is           blue";
        System.out.println(new ReverseWordsInAString(). reverseWords(s));
    }
}
