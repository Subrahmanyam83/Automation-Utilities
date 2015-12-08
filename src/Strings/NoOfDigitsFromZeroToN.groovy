package Utils.Interview.Strings

/**
 * Created by subrahmanyamr on 6/30/2015.
 */
class NoOfDigitsFromZeroToN {

    public static void main(String[] args){

        int n =999,x=0;

        for(int i in 1..50){
            if (i.toString().contains("4")){
                println(i);
                x++;
            }
        }
        print("No of times 4 is present is :"+x)
    }
}
