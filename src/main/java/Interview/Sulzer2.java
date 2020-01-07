package Interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Sulzer2 {
    public static int[] routeCount(int[] T){
        List<Integer> output=new ArrayList<>();
        int[] output2=new int[T.length-1];
        int root=0;
        for(int i=0;i<T.length;i++){
            if(T[i]==i) {root=i;break;}
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<T.length;i++){
            if(T[i]==root&&i!=root) queue.add(i);
        }
        int size=queue.size();
        output.add(size);
        while(queue.size()>0){
            for(int k=0;k<size;k++) {
                root = queue.poll();
                for (int i = 0; i < T.length; i++) {
                    if (T[i] == root) queue.add(i);
                }
            }
            size=queue.size();
            output.add(size);
        }
        for(int i=0;i<output.size();i++){
            output2[i]=output.get(i);
        }
        return output2;
    }
}
