import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        Employee employee1 = new Employee("Honkeytonk", "Cumbercooch", 25, List.of("Java", "Javascript", "Python"));
        Employee employee2 = new Employee("Brewery", "Chickenstrips", 31, List.of("C#"));
        Employee employee3 = new Employee("Beetlejuice", "Snugglesnatch", 23, List.of("Java", "Haskell", "Scala"));
        Employee employee4 = new Employee("Boobytrap", "Humperdinkck", 42, List.of("PHP", "Javascript", "React", "Angular"));
        Employee employee5 = new Employee("Buttermilk", "Bumbersplat", 38, List.of("Java", "Scala"));
        Employee employee6 = new Employee("Rinkydink", "Curdlesnoot", 30, List.of("C", "C++"));
        Employee employee7 = new Employee("Cooglesnatch", "Splishnsplash", 27, List.of("Rust", "Python"));
        Employee employee8 = new Employee("Tiddleywomp", "Charmander", 51, List.of("Java", "Spring", "Hibernate"));

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        employees.add(employee6);
        employees.add(employee7);
        employees.add(employee8);


        employees.stream().forEach(System.out::println);
        employees.stream().map(employee -> employee.getFirstName() + " " + employee.getLastName()).forEach(System.out::println);

        List<List<String>> allSkills = employees.stream().map(employee -> employee.getSkills()).collect(Collectors.toList());
        System.out.println(allSkills);

        List<String> allSkills2 = employees.stream()
                .map(employee -> employee.getSkills())
                .flatMap(list -> list.stream())
                .distinct() //get rid of duplicates
                .collect(Collectors.toList());
        System.out.println(allSkills2);

        employees.stream().filter(employee -> employee.getFirstName().startsWith("B")).forEach(System.out::println);

        employees.stream().sorted(Comparator.comparing(Employee::getAge)).forEach(System.out::println);

        employees.stream().sorted(Comparator.comparing(employee -> employee.getLastName())).limit(2).forEach(System.out::println);

        employees.stream().sorted(Comparator.comparing(Employee::getLastName)).skip(2).forEach(System.out::println);

        long numberOfEmployees = employees.stream().filter(employee -> employee.getFirstName().startsWith("B")).count();
        System.out.println(numberOfEmployees);

        Employee youngestEmployee = employees.stream().min(Comparator.comparing(Employee::getAge)).get();
        System.out.println(youngestEmployee);

        Employee oldestEmployee = employees.stream().max(Comparator.comparing(Employee::getAge)).get();
        System.out.println(oldestEmployee);

        Employee employeeFind = employees.stream().
                filter(employee -> employee.getFirstName()
                        .startsWith("B")).findAny().get();
        System.out.println(employeeFind);

        boolean b = employees.stream().allMatch(employee -> employee.getFirstName().startsWith("B")); //anyMatch, noneMatch
        System.out.println(b);

        Integer sumOfAllAges = employees.stream()
                .map(Employee::getAge)
                .reduce((age1, age2) -> age1 + age2)
                .get();
        System.out.println(sumOfAllAges);

        Integer sumOfAllAges2 = employees.stream()
                .map(Employee::getAge)
                .reduce(0, Integer::sum);

        System.out.println(sumOfAllAges2);

        Integer sumOfAllAges3 = employees.stream().reduce(0, (age, employee) -> age + employee.getAge(), Integer::sum);
        System.out.println(sumOfAllAges3);

        String allNames = employees.stream()
                .map(employee -> employee.getFirstName())
                .reduce((name, name2) -> name + ", " + name2)
                .get();
        System.out.println(allNames);

        employees.stream()
                .sorted(Comparator.comparing(employee -> employee.getAge()))
                .takeWhile(employee -> employee.getAge() < 30)
                .forEach(System.out::println);

        employees.stream().sorted(Comparator.comparing(employee -> employee.getAge()))
                .dropWhile(employee -> employee.getAge() < 30)
                .forEach(System.out::println);

        String sentence = "Jak nauczyć się programowania?";
        sentence.chars().forEach(s -> System.out.print((char) s));
        sentence.chars().parallel().forEachOrdered(s -> System.out.print((char) s));

        List<Employee> newEmployeees = employees.stream().peek(employee -> employee.setFirstName("Kamil"))
                .collect(Collectors.toList());
        System.out.println(newEmployeees);
        System.out.println();
        System.out.println(employees);
    }
}
