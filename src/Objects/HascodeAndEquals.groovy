package Utils.Interview.Objects

/**
 * Created by subrahmanyamr on 7/16/2015.
 */
class HascodeAndEquals {

    public static void main(String[] args) {
        String a = "ABC"
        String b = "ABC"
        println(a.equals(b))
        println(a==b)
        println(a.hashCode()+"---"+b.hashCode())

        String m = new String("ABC");
        String n = new String("XYZ");
        println(m.hashCode()+"--"+n.hashCode())

    }
}
