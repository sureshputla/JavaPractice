package in.sp_java_practice;

public class Main {
    public static void main(String[] args) {
        try {
            int[] arr = {1,-5,6,1,-9,7,1,2,3,-4,3,2}; //
            ArrayRelated.lorgestSumSubArray(arr);
//            ArrayRelated.printArray(ArrayRelated.medianSlidingWindow(arr,3));
//            ArrayRelated.printArray(ArrayRelated.medianSlidingWindow(arr,4));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
// Utilities available isPrime, intToBinaryString