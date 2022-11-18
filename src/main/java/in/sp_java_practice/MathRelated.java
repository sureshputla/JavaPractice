package in.sp_java_practice;

public class MathRelated {
    public static boolean isThree(int n) {
        int count = 0;
        if (n<2)
            return false;
        else if (n == 3) {
            return true;
        } else {
            for (int i = 1; i <= n/2; i++) {
                if (n % i == 0){
                    count++;
                    if (count > 3)
                        return false;
                }
            }
        }
        return count == 2;
    }
}
