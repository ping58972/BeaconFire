/*
* Given a 2-D String array of student-marks find the student with the highest average and output his average score.
* If the average is in decimals, floor it down to the nearest integer.
* Example 1:
Input:  [{"Bob","87"}, {"Mike", "35"},{"Bob", "52"}, {"Jason","35"}, {"Mike", "55"}, {"Jessica", "99"}]
Output: 9
Explanation: Since Jessica's average is greater than Bob's, Mike's and Jason's average.
* */

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(medianSortedList());
    }
    public static double medianSortedList(){
        Queue<Integer> l1 = new LinkedList<>(Arrays.asList(1,3,4,8, 11, 15,20));
        Queue<Integer> l2 = new LinkedList<>(Arrays.asList(2,5,9));
        int size = l1.size() + l2.size();
        int medianIndex = size /2;
        List<Integer> result = new ArrayList<>();
        while(!l1.isEmpty() || !l2.isEmpty()){
            if(l1.isEmpty()){
                result.add(l2.poll());
            }
            else if(l2.isEmpty()){
                result.add(l1.poll());
            }
            else if(l1.peek() < l2.peek()){
                result.add(l1.poll());
            } else{
                result.add(l2.poll());
            }
        }

        return size%2 == 0 ? (result.get(medianIndex-1) + result.get(medianIndex))/2.0 : result.get(medianIndex);
    }
    public static void searchId(){
        List<String> lines = Arrays.asList("10.0.0.1 - GET 2020-08-24","10.0.0.1 - GET 2020-07-24", "10.0.0.1 - GET 2020-08-24",
                "10.0.0.2 - GET 2020-08-20", "10.0.0.2 - GET 2020-08-20", "10.0.0.4 - GET 2020-08-20");
        String zeroTo255
                = "(\\d{1,2}|(0|1)\\"
                + "d{2}|2[0-4]\\d|25[0-5])";

        // Regex for a digit from 0 to 255 and
        // followed by a dot, repeat 4 times.
        // this is the regex to validate an IP address.
        String regex
                = zeroTo255 + "\\."
                + zeroTo255 + "\\."
                + zeroTo255 + "\\."
                + zeroTo255;
        Pattern pattern = Pattern.compile(regex);
        Map<String, Integer> map = new HashMap<>();
        Matcher matcher;
        for(String line: lines) {
             matcher = pattern.matcher(line);
            if (matcher.find()){
                String st = matcher.group();
                if(map.containsKey(st)){
                    Integer c = map.get(st) + 1;
                    map.put(st, c);
                } else{
                    map.put(st, 1);
                }
            } else System.out.println("Not found!");
        }
        List<Map.Entry<String, Integer>> entryList = map.entrySet().stream().sorted((e1, e2) -> {
            if( e1.getValue().equals(e2.getValue())){
                return e1.getKey().compareTo(e2.getKey());
            }
            return e2.getValue() - e1.getValue();
        }).collect(Collectors.toList());
        System.out.println(entryList);
        String ans = "";
        int v = entryList.get(0).getValue();
        for(Map.Entry<String, Integer> m: entryList){
            if(m.getValue().equals(v)){
                ans += m.getKey()+ ", ";
            }
        }
        System.out.println(ans);
    }
//        List<List<String>> list2d = new ArrayList<>(10);
//        list2d.add(Arrays.asList("Bob", "87"));
//        list2d.add(Arrays.asList("Mike", "35"));
//        list2d.add(Arrays.asList("Bob", "52"));
//        list2d.add(Arrays.asList("Jason","35"));
//        list2d.add(Arrays.asList("Mike", "55"));
//        list2d.add(Arrays.asList("Jessica", "99"));
//
//        Map<String, Student> map = new HashMap<>();
//        final int[] highestAverage = new int[1];
//        list2d.forEach(l ->{
//            if(map.containsKey(l.get(0))){
//                int score = Integer.parseInt(l.get(1));
//                Student sts = map.get(l.get(0));
//                sts.scores.add(score);
//            } else{
//                map.put(l.get(0), new Student(l.get(0),Integer.parseInt(l.get(1))));
//            }
//            int stsAve = map.get(l.get(0)).getAverage();
//            if(highestAverage[0] < stsAve){
//                highestAverage[0] = stsAve;
//            }
//        });
//        System.out.println(map);
//        System.out.println(highestAverage[0]);
//    }
}
class Student{
    String name;
    List<Integer> scores = new ArrayList<>();
    public Student (String name, Integer score) {
        this.name = name;
        this.scores.add(score);
    }
    public int getAverage(){
       return scores.stream().reduce(0, (a,b)-> a+b) / scores.size();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", scores=" + scores +
                '}';
    }
}