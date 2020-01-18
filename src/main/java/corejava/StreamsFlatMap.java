package corejava;

import java.util.*;

enum City {
    COLOMBO, KANDY, SINGAPORE, NEW_YORK;
}

enum Country {
    SRI_LANKA, SINGAPORE, UNITED_STATES;
}

class Address {
    int id;
    City City;
    Country Country;

    Address() {
    }

    public Address(int id, corejava.City city, corejava.Country country) {
        this.id = id;
        City = city;
        Country = country;
    }
}

class Employee {
    int id;
    String name;
    List<Address> addressList;

    Employee() {
    }

    Employee(int id, String name, List<Address> addressList) {
        this.id = id;
        this.name = name;
        this.addressList = addressList;
    }
}

public class StreamsFlatMap {
/*
  public static void main(String[] args) {
    List<Employee> employeeList = List.of(
        new Employee(
            1,
            "Damith",
            List.of(
                new Address(1, City.KANDY, Country.SRI_LANKA),
                new Address(1, City.COLOMBO, Country.SRI_LANKA),
                new Address(1, City.SINGAPORE, Country.SINGAPORE)
            )
        ),
        new Employee(
            2,
            "Jorge",
            List.of(
                new Address(1, City.NEW_YORK, Country.UNITED_STATES)
            )
        )
    );

    //print all employees
    employeeList.stream().map(e -> e.name).forEach(System.out::println);

    //print all employee with id=1
    employeeList.stream().filter(e -> e.id == 1).map(e -> e.name).forEach(System.out::println);

    //print all employee from Sri Lanka
    employeeList.stream()
        .filter(e -> e.addressList.stream().anyMatch(a -> a.Country == Country.SRI_LANKA))
        .map(e -> e.name)
        .forEach(System.out::println);

    //print all cities of resident of employees from Sri Lanka
    employeeList.stream()
        .filter(e -> e.addressList.stream().anyMatch(a -> a.Country == Country.SRI_LANKA))
        .flatMap(e -> e.addressList.stream())
        .map(a -> a.City)
        .forEach(System.out::println);

* }
*/
}
