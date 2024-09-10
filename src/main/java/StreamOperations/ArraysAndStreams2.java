package StreamOperations;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArraysAndStreams2 {

    static void doStringStreamOperations() {
        String[] colors={"yellow","blue","green","indigo","orange","red","white","grey","neon","opaque"};
        System.out.printf("original colors: %s %n", Arrays.toString(colors));

        //print out upperCase
        List<String> colorOps = Arrays.stream(colors)
                .map(color->color.toUpperCase())
                .collect(Collectors.toList());

        Arrays.stream(colors)
                .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
                .peek(System.out::println)
                .collect(Collectors.toList());

        //print out colors less than n
       String answer =  Arrays.stream(colors)
                .filter(item->item.compareToIgnoreCase("n") < 0)
                .collect(Collectors.joining(
                        " "
                ));

       System.out.printf("The result of strings less than n is %s %n",answer);
    }

    static Predicate<Employee> above20below30 = emp -> {
        return emp.salary() >= 20000.00  && emp.salary()  <= 30000.00;
    };
    static void doEmployeesProcessing() {

        Employee e1 = new Employee(1, "Adama", "Traore", 25000.00, "Finance");
        Employee e2 = new Employee(2, "Fabian", "Barthez", 19000.00, "Hr");
        Employee e3 = new Employee(3, "Yaya", "Toure", 21000.00, "Services");
        Employee e4 = new Employee(4, "David", "CumberBatch", 20000.00, "Finance");
        Employee e5 = new Employee(5, "Jim", "Ratclife", 55000.00, "Executive");

        Employee[] employees = {e1, e2, e3, e4, e5};

        List<Employee> emp1 = List.of(employees);
        //convert array to list
        List<Employee> emp2 = new ArrayList(emp1);
        emp2.add(new Employee(6, "Barbara", "Chase", 15000.00, "Engineering"));
        emp2.add(new Employee(7, "Leonard", "Cooper", 13000d, "Engineering"));

        Collections.addAll(emp2, new Employee(8, "Shade", "Johnson", 10000.00, "Finance"));
        // emp2.add(new Employee(6,"Shada","Sola",45000.00,"Development"));
        Collections.addAll(emp2, e3);
        //display array list items as a stream
        System.out.println("display array list items as a stream");
        emp2.stream().forEach(System.out::println);

        System.out.println("Count total employees");
        System.out.println(emp2.stream()
                .count());

        System.out.println("Get average salaries");

        //display employees between 20k and 30k and sorted according to salary
        System.out.printf("%ndisplay employees between 20k and 30k and sorted according to salary%n");
        emp2.stream()
                .filter(above20below30)
                .sorted(Comparator.comparing(Employee::salary))
                .forEach(System.out::println);

        System.out.printf("%n Display first employee with salary in the range 10k to 20k%n");
        Optional<Employee> emplow = emp2.stream()
                .filter(emp -> emp.salary() >= 10000 && emp.salary() <= 20000)
                .findFirst();

        System.out.println("Display employees that match any of the criteria ");
        boolean findHighSal = emp2.stream().anyMatch(emp -> emp.salary() >= 30000);

        System.out.println(findHighSal);

        boolean findNoSal = emp2.stream().allMatch(emp -> emp.salary() == 0);
        System.out.println(findNoSal);
//        System.out.printf("%n display all employees sorted according to firstname %n");
//        emp2.stream().sorted(Comparator.comparing(Employee::firstName))
//                .forEach(System.out::println);
//
//        System.out.printf("%n display all employees sorted according to lastname %n");
//        emp2.stream().sorted(Comparator.comparing(Employee::lastName))
//                .forEach(System.out::println);

        Function<Employee, String> byFirstName = Employee::firstName;
        Function<Employee, String> byLastName = Employee::lastName;


        //Define a comparator
        System.out.println("Sort list based on employee lastname and firstname");
        Comparator<Employee> lastThenFirst = Comparator.comparing(byLastName).thenComparing(byFirstName);
        Comparator<Employee> firstThenLast = Comparator.comparing(byFirstName).thenComparing(byLastName);

        emp2.stream()
                .sorted(lastThenFirst)
                .forEach(System.out::println);

        //Map employees to lastNames and Sort
        System.out.println("Map Employees to LastNames and then Sort");

        emp2.stream()
                .map(emp -> emp.lastName())
                .sorted()
                .forEach(System.out::println);

        //Group employees by department
        Map<String,Double> resMap = emp2.stream()
                .collect(Collectors.groupingBy(Employee::department,Collectors.summingDouble(Employee::salary)));
        for(Map.Entry<String,Double> item : resMap.entrySet()){
            System.out.println("Key: "+item.getKey()+" Value: "+item.getValue());
        }
       Double avgSalary = emp2.stream().mapToDouble(Employee::salary)
                .average().getAsDouble();

        System.out.println("The average salary: "+avgSalary);

        Double maxSalary = emp2.stream().mapToDouble(Employee::salary).max().getAsDouble();
        System.out.println("The maximum salary: "+maxSalary);

        String names = "americana";
        List<String> namelist = Arrays.asList(names.split(""));

       Map<String,Long> strMap = namelist.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()
        ));
       System.out.println(strMap.values().stream().mapToLong(e->e).max());

    }

    static IntConsumer ageConsumer = value ->{
             System.out.println(value+" ");
    } ;
    static Supplier<String> msgSupplier = ()->{
        return "Welcome to Lambdas!";
    };

    static Function<String,String> fnUpperCase = (String s)->{
        return s.toUpperCase();
    };
    static UnaryOperator<Double> sqrtFnSq = x ->{
        return Math.sqrt(x);
    };
    public static void main(String[] args) {
        //doStringStreamOperations();
        doEmployeesProcessing();
    }
}