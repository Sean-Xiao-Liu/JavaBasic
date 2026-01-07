package LeetCode.Stack;
//TODO: Correct the current method, the number can be multiple digits
public class BasicCalculatorII {
    public static int calculate(String s) {
        StringBuilder builder = new StringBuilder(s.replace(" ",""));
        int index = 0;
        while(index < builder.length()){
            if (builder.charAt(index) == '*' ||builder.charAt(index) == '/'){
                if(builder.charAt(index) == '*'){
                    builder.replace(index-1,
                            index+2,
                            String.valueOf(Integer.valueOf(builder.charAt(index-1)-'0') * Integer.valueOf(builder.charAt(index+1)-'0')));
                    index --;
                } else {
                    builder.replace(index-1,
                            index+2,
                            String.valueOf(Integer.valueOf(builder.charAt(index-1)-'0') / Integer.valueOf(builder.charAt(index+1)-'0')));
                    index --;
                }
            } else {
                index++;
            }

        }

        index = 0;
        while(index < builder.length()){
            if (builder.charAt(index) == '+' ||builder.charAt(index) == '-'){
                if(builder.charAt(index) == '+'){
                    builder.replace(index-1,
                            index+2,
                            String.valueOf(Integer.valueOf(builder.charAt(index-1)-'0') + Integer.valueOf(builder.charAt(index+1)-'0')));
                    index --;
                } else{
                    builder.replace(index-1,
                            index+2,
                            String.valueOf(Integer.valueOf(builder.charAt(index-1)-'0') - Integer.valueOf(builder.charAt(index+1)-'0')));
                    index --;
                }
            } else {
                index++;
            }

        }

        return Integer.parseInt(builder.toString());
    }

    public static void main(String[] args) {
        System.out.println(calculate("5*5*5"));
    }
}
