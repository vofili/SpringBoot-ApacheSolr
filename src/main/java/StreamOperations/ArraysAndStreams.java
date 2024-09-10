package StreamOperations;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArraysAndStreams
{

    //static and default methods in functional interfaces
    //stream performs operations on reference type object
    //perform mutliple operations on an array of Integers using Streams
    //sort values in ascending order
    //perform filter on the  array
    //copy one stream to another
    //perform filter and do a multiplier
    //perform a filter and a sort
    //perform a sort on a stream and return a list

    static void doIntArraysAndStreams(){
            Integer[] values = {3,1,4,2,6,9,34,5,0};

            List<Integer> resultlist = Arrays.stream(values).sorted()
             .collect(Collectors.toList());

            List<Integer> greaterThan5 = Arrays.stream(values).filter(e -> e > 5).toList();

            List <Integer> transformToEven = Arrays.stream(values)
                    .filter(e-> e > 3)
                    .map(e -> e * 2)
                    .peek(System.out::println)
                    .toList();

            System.out.println(Arrays.toString(resultlist.toArray()));

            System.out.println(Arrays.toString(greaterThan5.toArray()));

    }

    static void stringsAndStreams(){
        List<String> tcoll = new ArrayList<>();
        String[] names = {"happy","tony","stark","adama","hulk","vivian","amad","ibrahim","tony"};
        List<String> namelist = Arrays.stream(names)
               // .peek(System.out::println)
             //   .filter(name->name.toUpperCase().startsWith("t"))
                //.peek(System.out::println)
                .peek((t)-> {
                    if(t.toLowerCase().startsWith("t")){
                        tcoll.add(t);
                    }
                })
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        Map<String,Long> namesMap = namelist.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        for(Map.Entry<String,Long> item : namesMap.entrySet()){
            System.out.println(item.toString());
        }

    }


    public static void main(String[] args) {
        //doIntArraysAndStreams();
        stringsAndStreams();
    }
}
