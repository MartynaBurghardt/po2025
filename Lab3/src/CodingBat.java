import java.util.concurrent.Callable;

public class CodingBat {
    public int doubleSum(int a, int b) {
        return (a + b) * 2;
    }
    public boolean lastDigit(int a, int b) {
        return (a % 10 == b % 10);
    }
    public String front22(String str) {
        int take = 2;
        if (take > str.length()) {
            take = str.length();
        }
        String front = str.substring(0, take);
        return front + str + front;
    }
    public boolean endsLy(String str) {
        if (str.length() < 2) {
            return false;
        }
        return str.endsWith("ly");
    }
    public int[] makeEnds( int[] nums) {
        int first = nums[0];
        int last = nums[nums.length - 1];
        return new int[] {first, last};

    }
    public static void main(String[] args) {
        CodingBat cb = new CodingBat();

        System.out.println("doubleSum(2,3)" + cb.doubleSum(2,3));
        System.out.println("lastDigit" + cb.lastDigit(7,17));
        System.out.println("front22" + cb.front22("Ha"));
        System.out.println("endsLy" + cb.endsLy("oddly"));

        int[] result1 = cb.makeEnds(new int[] {1,2,3});
        int[] result2 = cb.makeEnds(new int[] {7,4,5});
        System.out.println(result1[0] + " " + result1[1] + " " + result2[0] + " " + result2[1]);
        System.out.println(result2[0] + " " + result2[1] + " " + result2[0] + " " + result2[1]);

    }
        };



