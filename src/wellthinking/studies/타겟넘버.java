package wellthinking.studies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 타겟넘버 {

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

//        int[] numbers = {4, 1, 2, 1};
//        int target = 4;

        int answer = 0;

        List<Integer> bigBox = new ArrayList<Integer>();

        bigBox.add(-numbers[0]);
        bigBox.add(numbers[0]);

        int countOfTargetedNums = 0;
        int cnt     = numbers.length;
        for(int index = 1; index <= numbers.length; index++){
            // ?
            if(index == cnt){
                break;
            }

            List<Integer> anotherBox = new ArrayList<Integer>();

            for(int num : bigBox){
                System.out.println("[index] : " + index + " / [num] : " + num + " / [anotherBox] : " +anotherBox.size());

                anotherBox.add(num + (-numbers[index]));
                anotherBox.add(num + numbers[index]);

            }

            for(int num : anotherBox){
                System.out.println("[num]" + num);
            }

            bigBox = new ArrayList<>(anotherBox);

        }

        answer = Collections.frequency(bigBox, target);

        System.out.println(answer);


    }
}
