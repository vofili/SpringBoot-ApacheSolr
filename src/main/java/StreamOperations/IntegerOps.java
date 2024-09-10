package StreamOperations;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntegerOps {

     void doStreamOperations(){

         Integer[] nums = {5,10,9,2,6,3};
         int[] scores = {5,10,9,2,6,3};


        double totalAverage = IntStream.of(scores).average().getAsDouble();
        int totalSum  = IntStream.of(scores).sum();
        String numStr =  IntStream.of(scores).mapToObj(String::valueOf).collect(Collectors.joining(","));

        int intMin = IntStream.of(scores).min().getAsInt();
        int optIntMin = IntStream.of(scores).min().getAsInt();
        System.out.printf("The total average is: %.3f; The total Sum is %d; The joined values are %s%n",totalAverage,totalSum,numStr);
        System.out.println(IntStream.of(scores).summaryStatistics());

        int[] intValues={13,4,5,12,0,9,18,21};
        //Sort an array
        Arrays.sort(intValues);
        System.out.println(Arrays.toString(intValues));
        //Reduce array using a product

        int product = IntStream.of(scores).reduce(1,(x,y)->x*y);
        System.out.println(product);


        //Sum an array using reduce
        int arraySum = IntStream.of(scores).reduce(0,(x,y)->x+y);
        System.out.printf("%n Sum of array elements %s is %d %n",Arrays.toString(scores),arraySum);

        //sorting IntStream
        //int result [] = IntStream.of(scores).sorted().toArray();
        // System.out.println(Arrays.toString(result));

        System.out.println(IntStream.of(scores).sorted().mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }

    public static void main(String[] args) {
        int[] scr = {5,10,9,2,6,3};
            IntStream.of(scr).forEachOrdered((x)->{

                System.out.println(x);
            });
    }
}
