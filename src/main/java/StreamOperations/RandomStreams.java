package StreamOperations;


import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.stream.IntStream;


public class RandomStreams {


    static void infiniteStream(){

       int sumOfTen = IntStream.iterate(1, x->x+1)
                .map(x->x*x)
                .limit(10)
               .peek(System.out::println)
                .sum();
    }


    static void getRandomGenerate(){
        SecureRandom random = new SecureRandom();
        IntStream.generate(
                ()->random.nextInt())
                .limit(10)
                .forEach(e-> System.out.println(e));
    }
    static void randomStream (){
        SecureRandom secureRandom = new SecureRandom();

        Map<Integer,Long> diceMap = secureRandom.ints(60_000_000,1,7)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));


        Iterator<Map.Entry<Integer,Long>> diceMapIterator = diceMap.entrySet().stream().iterator();

        while(diceMapIterator.hasNext()){
            Map.Entry<Integer,Long> entry =diceMapIterator.next();
            System.out.println("Key: "+entry.getKey()+" Value:"+entry.getValue()
            );
        }
    }
    public static void main(String[] args) {

      //  infiniteStream();
        getRandomGenerate();
      //  randomStream();
    }
}
