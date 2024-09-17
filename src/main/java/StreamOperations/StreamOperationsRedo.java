package StreamOperations;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOperationsRedo {
        //static initializer for String array




        static String[] names =  {"Jerry","Freddy","Kandi","Lambi","Bambi","Joey","Shelly","Lenny","Benny"};
        static {
            System.out.println("static block has been called " + Arrays.toString(names));
        }
        static void doStringSortOperation(){
//usage of peek
            Arrays.stream(names)
                    .sorted()
                    .peek(x->{
                        System.out.println(x);
                    }).collect(Collectors.toList());

        }


    static int doIntegerSum(int start, int end){
        return IntStream.rangeClosed(start,end).sum();
    }

    public static void main(String[] args) {
        System.out.printf("The sum of integers from %d to %d is %d %n", 1, 10,doIntegerSum(1, 10));

        doStringSortOperation();
    }
}
