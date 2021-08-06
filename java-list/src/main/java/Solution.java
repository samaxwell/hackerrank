import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer.parseInt(br.readLine()); // size not used
        List<Integer> nums = stringToIntList(br.readLine().trim());

        int numberOfQueries = Integer.parseInt(br.readLine());
        while (numberOfQueries-- > 0) {
            String op = br.readLine().trim();
            List<Integer> arguments = stringToIntList(br.readLine().trim());
            if("Insert".equals(op)) {
                nums.add(arguments.get(0).intValue(), arguments.get(1));
            }
            else {
                nums.remove(arguments.get(0).intValue());
            }
        }

        System.out.println(nums.stream().map(n->""+n).collect(Collectors.joining(" ")));
    }
    // Split string of numbers and return as list
    static List<Integer> stringToIntList(String line) {
        StringTokenizer st = new StringTokenizer(line);
        List<Integer> nums = new ArrayList<>();
        while (st.hasMoreTokens()) {
            nums.add(Integer.parseInt(st.nextToken()));
        }
        return nums;
    }
}
