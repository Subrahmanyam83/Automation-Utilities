package Utils.Interview.Strings

/**
 * Created by subrahmanayamv on 1/27/15.
 */
class IsStringBalanced {

    public static List stack = new ArrayList();
    public static int index;

    public static void main(String []args){
        String [] arr = "{{}[]{}}";
        String balanced = isBalanced(arr)? "BALANCED":"NOT-BALANCED"
        println("The Array is: "+balanced);
    }

    public static void push(String a){
        stack.add(a);
    }

    public static void popTheElement(){
        if(!stack.size().equals(0))
            stack.remove(stack.size() - 1);
    }

    public static boolean pop(String poppingElement){

        if(poppingElement.equals("}")){
            if (getTop().equals("{")){
                popTheElement()
                return true
            }
            else return false
        }
        if(poppingElement.equals("]")){
            if (getTop().equals("[")){
                popTheElement()
                return true
            }
            else return false
        }
        if(poppingElement.equals(")")){
            if (getTop().equals("(")){
                popTheElement()
                return true
            }
            else return false
        }
    }

    public static boolean isBalanced(String[] array) {
        for (String s : array) {
            if (s.equals("{") || s.equals("[") || s.equals("(")) {
                push(s);
            }
            else if (s.equals("}") || s.equals("]") || s.equals("}")){
                boolean bool = pop(s);
                if (!bool) {
                    return false;
                }
            }
            else {
                println("PLEASE ONLY ENTER PARANTHESIS IN YOUR STRING")
                return false;
            }
        }
        return true;
    }

    public static String getTop(){
        if(stack.size().equals(0))
            return 0;
        else
        return stack[stack.size() - 1]
    }
}
