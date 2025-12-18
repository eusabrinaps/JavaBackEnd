import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Comparator<Person> porIdade = Comparator.comparing(Person::getSalary);

        //Filtrar numeros pares
        List<Integer>  numeros = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numeros.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
        System.out.println("------------------------------------------");

        //Converter nome para maiuscula
        List<String> nomes = List.of("ana", "beatriz", "camila", "daniela");
        List<String> nomesMaiusculos = nomes.stream().map(String::toUpperCase).toList();
        System.out.println("Nomes: " + nomesMaiusculos);
        System.out.println("------------------------------------------");

        List<String> palavras = List.of("sol", "ventilador", "chuva", "luz", "relâmpago");
        palavras.stream().filter(p -> p.length() >5).forEach(System.out::println);
        System.out.println("-=-===-=-=-=-=-=-=-=-=-=-==-=-=-=-");

        List<Person> people = new java.util.ArrayList<>(List.of(
                new Person("Ana", 25, 3000),
                new Person("Beatriz", 32, 4500),
                new Person("Carlos", 40, 7000),
                new Person("Daniel", 19, 2000),
                new Person("Eva", 28, 3500)
        ));

        /*Liste apenas os nomes das pessoas com mais de 30 anos.
            Calcule a média salarial.
                Liste os nomes em ordem alfabética.
                    Mostre o nome da pessoa com maior salário.
                        Crie uma nova lista com apenas os objetos de pessoas que ganham mais de 3000.*/

        people.stream().filter(p -> p.getAge() > 30).forEach(System.out::println);
        System.out.println("-=-===-=-=-=-=-=-=-=-=-=-==-=-=-=-");
        people.stream().sorted(Comparator.comparing(Person::getName)).forEach(System.out::println);
        System.out.println("Por idade");
        System.out.println("-=-===-=-=-=-=-=-=-=-=-=-==-=-=-=-");
        people.stream().sorted(porIdade).forEach(System.out::println);
        System.out.println("-=-===-=-=-=-=-=-=-=-=-=-==-=-=-=-");
        people.stream().mapToDouble(Person::getSalary).average().ifPresent(System.out::println);
        System.out.println("-=-===-=-=-=-=-=-=-=-=-=-==-=-=-=-");
        people.stream().max(Comparator.comparing(Person::getSalary)).ifPresent(System.out::println);
        System.out.println("-=-===-=-=-=-=-=-=-=-=-=-==-=-=-=-");

        List<Course> courses = List.of(
                new Course("Java", List.of("Ana", "Beatriz", "Carlos")),
                new Course("Python", List.of("Ana", "Daniel")),
                new Course("C#", List.of("Carlos", "Eva", "Beatriz"))
        );

        //Liste todos os nomes de alunos (sem repetição).
        courses.stream().flatMap(course -> course.getStudents().stream()).distinct().forEach(System.out::println);
        System.out.println("-=-===-=-=-=-=-=-=-=-=-=-==-=-=-=-");

    }
}
