package Utils.MyUtils

/**
 * Created by subrahmanayamv on 6/23/14.
 */
class DateUtil {

    DateUtil(){

    }

    public static void main(String[] args)
    {
      abc()
    }


    def getDate(){
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        println(cal.get(Calendar.MINUTE)+"--"+cal.get(Calendar.SECOND))
    }
    public static void abc(){

        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        println(cal.get(Calendar.MONTH)+1+"-----"+cal.get(Calendar.DATE)+"-----"+cal.get(Calendar.HOUR)+"--"+cal.get(Calendar.MINUTE))
    }
}
