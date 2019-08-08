package com.exercise.apiexample.apiexample.Service;

import java.util.Comparator;
import java.util.Objects;

public class Person {

    private int id;
    private String name;
    private double salary;

    public Person(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return id == person.id &&
                Double.compare(person.salary, salary) == 0 &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary);
    }


}
