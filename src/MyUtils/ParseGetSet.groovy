package Utils.MyUtils

/**
 * Created by subrahmanayamv on 6/2/14.
 */
class ParseGetSet {

    String className;
    String packageName;
    int a;

    ParseGetSet(int a ,String className,String packageName) {
        this.a = a
        this.className = className
        this.packageName = packageName

    }

    String getClassName() {
        return className
    }

    void setClassName(String className) {
        this.className = className
    }

    String getPackageName() {
        return packageName
    }

    void setPackageName(String packageName) {
        this.packageName = packageName
    }

    int getA() {
        return a
    }

    void setA(int a) {
        this.a = a
    }

}
