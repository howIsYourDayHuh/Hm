package wellthinking.studies;

import java.util.Arrays;

public class 주식가격 {

    public static class WeirdStock{

        int price;
        int index;

        WeirdStock(int price, int index){
            this.price = price;
            this.index = index;
        }

        public int getPrice() {
            return this.price;
        }

        public int getIndex() {
            return this.index;
        }

        public void check(int price){

            if(this.price <= price){
                this.index++;
            }

        }

        public void justUp(){
            this.index++;

        }
    }

    // 참고했습니다.
    // https://go-coding.tistory.com/5
    public static class Stack{
        int top;
        int size;
        Object[] stack;
        public Stack(int size){
            this.size = size;
            stack = new Object[size];
            top = -1;
        }

        public void push(Object item){
            stack[++top] = item;
        }

        public void pop(){
            Object pop = stack[top];
            stack[top--] = new Object();
        }

        public Object peek(){
            return stack[top];
        }
    }

    public static void main(String[] args) {

        int[] prices = {1, 2, 3, 2, 3};

        int[] answer = new int[prices.length];

        Stack stack = new Stack(prices.length);

        int len = prices.length;
        int index = len - 1;
        boolean AreWeThereYet = true;
        while (AreWeThereYet){

            WeirdStock weirdStock = new WeirdStock(prices[index], 0);
            stack.push(weirdStock);

            if(index != (len - 1)){
                for(int subIndex = (index + 1); subIndex < len; subIndex ++){
                    WeirdStock firstChk =  (WeirdStock) stack.peek();
                    // stack.pop();
                    if(firstChk.getPrice() <= prices[subIndex]){
                        firstChk.check(prices[subIndex]);
                    } else {
                        firstChk.justUp();
                        break;
                    }

//                    if(firstChk.getPrice() > prices[subIndex]){
//                        stack.push(firstChk);
//                        break;
//                    } else {
//
//                        stack.push(firstChk);
//                    }
                }
            }


            if(index == 0){
                AreWeThereYet = false;
            }
            index--;
        }


        for(int inputIndex = 0; inputIndex < len; inputIndex++){
            WeirdStock firstChk =  (WeirdStock) stack.peek();
            answer[inputIndex] = firstChk.getIndex();
            stack.pop();

        }


        System.out.println(Arrays.toString(Arrays.stream(answer).toArray()));

    }

}
