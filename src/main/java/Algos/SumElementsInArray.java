package Algos;

public class SumElementsInArray {
    // You are given an array of integers. Please return sum of all elements

/*    Questions:
    1. Input: What is the input parameter ==> arr[]
    2. Output: What datatype should have your function to return ==> int
    3. What data structures and methods associated with it will be used ==>
    4. Where are going to store temp data (if needed)
    5. Describe model of your algorithm before implementing solution in code
    6. Write unit tests for your solution
    7. Complexity  */

    // [5, 1, 10, 24, -4]
    public int sumElementsInArray(int[] arr) {
        int sum = 0;
        for (int element : arr) {
            sum += element;
        }
        return sum;
    }


//
//    public void SumElementsInArray() {
//        // You are given an array of integers. Please return sum of all elements.
//
//        // what is our input parameters? - an array of integers
//        //
//
//
//
//        int num[] = {1,2,3,4,5};
//        int sum = 0;
//        for (int i = 0; i < num.length; i++) {
//            sum = sum + num[i];
//        }
//        System.out.println(sum);

//        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3));
//
//        int sum = 0;
//        for (int i = 0; i < numbers.size(); i++) {
//            sum = sum + numbers.get(i);
//        }
//        System.out.println(sum);
}
