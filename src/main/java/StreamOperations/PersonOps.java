package StreamOperations;

public class PersonOps {

    public static void main(String[] args) {
       Person p1 = new Person("Benson","heath",45);
    }
}
record Person(String firstName,String lastName,int age){

}