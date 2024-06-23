package dev.destop;

import com.aparapi.Kernel;
import com.aparapi.Range;

public class Main {
    public static void main(String[] args) {
        final float inA[] = {1, 2, 4, 5 ,6 , 7};
        final float inB[] = {5, 6, 7, 3, 5};
        Kernel kernel = new Kernel() {
            @Override
            public void run() {
                int i = getGlobalId();
                result[i] = inA[i] + inB[i];
            }
        };

        Range range = Range.create(result.length);
        kernel.execute(range);
    }
}