package Utils.Interview.Strings

/**
 * Created by subrahmanyamr on 7/6/2015.
 */
class MagicNumber {

    public static void main(String[] args){
        println(findMagicNumber(10));
    }

    public static int pow(int n){
        int s=1;
        for (int i =0;i < n; i++){
            s=s*5;
        }
        return s;
    }

    public static int findMagicNumber(int num){
        int j = 1;
        int s;
        for (int x=1;x<num;x++){
            for(int y=0;y<x;y++){
                if(y==0) {
                    s = pow(x);
                }
                else{
                    s = pow(x) + pow(y);
                }
                if(j==num){
                    println(x+"---"+y);
                    return s;
                }
                j++;
            }
        }
    }
}
