package in.sp_java_practice;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayRelated {

    public static final int[] intArray = {9, 7, 6, 5, 4, 3, 2, 1, 19, 18, 17, 16, 15, 14};
    public static final List<Integer> intList = new ArrayList<>(Arrays.asList(9, 7, 6, 5, 4, 3, 2, 1, 19, 18, 17, 16, 15, 14));

    public static int removeDuplicates(int[] nums) {
        int currentPos = 0;
        boolean stopExec = false;
        for (int i = 0; i < nums.length; i++) {
            if (stopExec)
                break;
            currentPos = i;
            stopExec = isStopExec(nums, currentPos, false, i, i);
        }
        return currentPos;
    }

    private static boolean isStopExec(int[] nums, int currentPos, boolean stopExec, int i, int dupePosition) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] <= nums[currentPos]) {
                if (dupePosition == i)
                    dupePosition = j;
                if (j == nums.length - 1) {
                    stopExec = true;
                }
            } else {
                if (dupePosition != currentPos) {
                    int temp = nums[j];
                    nums[j] = nums[dupePosition];
                    nums[dupePosition] = temp;
                }
                break;
            }
        }
        return stopExec;
    }

    public static int removeDupes(int[] nums) {
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        printArray(nums);
        return i + 1;
    }

    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int totalProfit = 0;
        for (int k : worker) {
            int localProfit = 0;
            int j = 0;
            while (j < difficulty.length) {
                if (k >= difficulty[j]) {
                    localProfit = Math.max(localProfit, profit[j]);
                }
                j++;
            }
            totalProfit += localProfit;
        }
        return totalProfit;
    }

    public static int maxProfitAssignmentOrig(int[] difficulty, int[] profit, int[] worker) {
        int num = difficulty.length;
        Point[] jobs = new Point[num];
        for (int i = 0; i < num; ++i)
            jobs[i] = new Point(difficulty[i], profit[i]);
        Arrays.sort(jobs, Comparator.comparingInt(a -> a.x));
        Arrays.sort(worker);

        int ans = 0;
        int i = 0;
        int best = 0;
        for (int skill : worker) {
            while (i < num && skill >= jobs[i].x)
                best = Math.max(best, jobs[i++].y);
            ans += best;
        }

        return ans;
    }

    public static long countBadPairs(int[] nums) {
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((i < j) && (j - i) != (nums[j] - nums[i])) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int lastStoneWeight(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }
        Stack<Integer> stack = new Stack<>();
        for (int i : stones) {
            stack.push(i);
        }
        Collections.sort(stack);
        reduceStack(stack);
        return stack.pop();
    }

    private static void reduceStack(Stack<Integer> stack) {
        Integer integer = stack.pop() - stack.pop();
        stack.push(integer);
        Collections.sort(stack);
        if (stack.size() > 1) {
            reduceStack(stack);
        }
    }

    public static int lastStoneWeightOriginal(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : stones)
            priorityQueue.add(i);
        while (priorityQueue.size() > 1) {
            int stone1 = priorityQueue.poll();
            int stone2 = priorityQueue.poll();
            if (stone1 > stone2)
                priorityQueue.add(stone1 - stone2);
        }
        return priorityQueue.peek();
    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boats = 0;
        int left = 0;
        int right = people.length - 1;
        while (left <= right) {
            int sum = people[left] + people[right];
            if (sum <= limit) {
                left++;
                right--;
                boats++;
            } else {
                right--;
                boats++;
            }
        }
        return boats;
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int localProfit = prices[j] - prices[i];
                if (profit < localProfit) {
                    profit = localProfit;
                }
            }
        }
        return profit;
    }

    public static boolean can_reach_end(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; ) {
            if (i + nums[i] >= nums.length) {
                return true;
            } else if (nums[i] == 0) {
                return false;
            }
        }
        return false;
    }

    public static int longest_flat(int[] array) {
        int maxSeq = 0;
        Map<Integer, Integer> integerCount = new HashMap<>();
        for (int i = 0; i < array.length - 1; i++) {
            if (integerCount.containsKey(array[i])) {
                int count = integerCount.get(array[i]);
                integerCount.put(array[i], ++count);
            } else {
                integerCount.put(array[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : integerCount.entrySet()) {
            if (maxSeq < entry.getValue()) {
                maxSeq = entry.getValue();
            }
        }
        return maxSeq;
    }

    public static void splitArray(int[] intArray, int splitSize) {
        List<int[]> arrayList = new ArrayList<>();
        int[] tempArr = new int[splitSize];
        for (int i = 0; i < intArray.length / splitSize; i++) {
            splitTheArray(intArray, i, splitSize, arrayList);
        }
        for (int[] ele :
                arrayList) {
            System.out.println("------------");
            printArray(ele);
        }
    }

    private static void splitTheArray(int[] intArray, int start, int splitSize, List<int[]> arrayList) {
        int[] arr = new int[splitSize];
        for (int i = 0; i < splitSize; i++) {
            if (intArray.length < start) {
                arr[i] = intArray[start++];
            } else {
                arr[i] = 0;
            }
        }
        arrayList.add(arr);
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        int count = 0;
        if (k % 2 != 0) {
            for (int i = 0; i < (nums.length - k + 1); i++) {
                result[count++] = nums[(i + i + k) / 2];
            }
        } else {
            for (int i = 0; i < (nums.length - k + 1); i++) {
                result[count++] = (double) (nums[(i + i + k) / 2] + nums[((i + i + k) / 2) + 1]) / 2;
            }
        }
        return result;
    }

    public static void lorgestSumSubArray(int[] intArray) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < intArray.length; i++) {
            currentSum += intArray[i];
            if (currentSum > maxSum)
                maxSum = currentSum;
            if (currentSum < 0)
                currentSum = 0;

        }
        System.out.println("Max sum: " + maxSum);
    }

    public static int noOfTriplets(int[] numberArr){
        int result = 0;

        return result;
    }

    public static int[] returnUniqueEle(int[] arr){
        Map<Integer, Integer> countOfIntegers = new HashMap<>();
        for (int ele: arr) {
            if (countOfIntegers.containsKey(ele)){
                int temp = countOfIntegers.get(ele);
                countOfIntegers.put(ele, ++temp);
            } else {
                countOfIntegers.put(ele, 1);
            }
        }
        for (int i=0; i<arr.length; i++) {
            if (countOfIntegers.get(arr[i]) > 1){
                arr[i] = 0;
            }
        }
        return arr;
    }

    public static List<Integer> removeAllInstancesOfNum(int num, List<Integer> numbers){
        List<Integer> result = new ArrayList<>();
        result = numbers.stream().filter(ele -> ele.equals(num)).collect(Collectors.toList());
        numbers.removeAll(result);
        return result;
    }

    public static void printArray(int[] numbers) {
        Arrays.stream(numbers).forEach(System.out::println);
    }

    public static void printArray(double[] numbers) {
        Arrays.stream(numbers).forEach(System.out::println);
    }
}
