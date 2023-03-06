package Algorithm.Sort;



public class SortCharArray {
    public static char[] sortChatArray(char[] chars){
        int n = chars.length;
        for(int i = 0; i < n-1;i++){
            for(int j = 0 ; j < n-i-1 ; j++){
                if(chars[j] > chars[j+1]){
                    //swap the char at i and j
                    char temp = chars[j+1];
                    chars[j+1] = chars[j];
                    chars[j] = temp;
                }
            }
        }
        return chars;
    }


    public static void main(String[] args) {
        char[] chars = {'e','d','c','b','a'};
        System.out.println(sortChatArray(chars));
    }
}

