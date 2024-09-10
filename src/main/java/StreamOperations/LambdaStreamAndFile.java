package StreamOperations;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LambdaStreamAndFile {



    static void doRegexMatching() throws IOException {
        Pattern pp =  Pattern.compile("\\s");

        Map<String,Long> wordsMap = Files.lines(Paths.get("SampleFileToParse.txt"))
                .flatMap(line -> pp.splitAsStream(line))
                .collect(Collectors.groupingBy(String::toLowerCase,TreeMap::new, Collectors.counting()));

        for(Map.Entry<String,Long> itemEntry:wordsMap.entrySet()){
            System.out.println(itemEntry);
        }
    }

    public static void main(String[] args) {
       long startTime = System.nanoTime();
        //scores object consists of score value and name
        StudentScore[] scoreArray = {new StudentScore("valentine",65),
                                new StudentScore("joel",75),
                                new StudentScore("charles",80),
                                new  StudentScore("valentine",10),
                                new StudentScore("joel",95)};



        List<StudentScore> scoreList = Arrays.asList(scoreArray);

        Double avg = scoreList.stream()
                .mapToDouble(StudentScore::score)
                .average().getAsDouble();

        System.out.println(avg);


        Map<String,Double> avgMap =

                scoreList.stream().collect(Collectors.groupingBy(StudentScore::name,Collectors.averagingInt(StudentScore::score)));

        System.out.println(avgMap.entrySet().stream().max(Map.Entry.comparingByValue()
        ).get().getKey()
        );
        System.out.println(System.nanoTime() - startTime);
    }
}

record StudentScore(String name, Integer score){

}
