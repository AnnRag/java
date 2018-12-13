package main.java;

public class Person {
    private final boolean man;
    private final String name;
    private Person spouse;

    public Person(boolean man, String name) {
        this.man = man;
        this.name = name;
    }

    public boolean marry(Person person) {
        //Person newspouse = new Person(man, name);
        if ((person.spouse == null) & (spouse == null)){
            person.spouse = this;
            spouse = person;
            return true;
        }
        else if (!(person.man == this.man)&!(person == spouse)) {
            person.spouse = this;
            spouse = person;
            return true;
        }
        else return false;
    }

    public boolean divorce(Person person) {
        if ((person == spouse)) {
            person.spouse = null;
            spouse = null;
            return true;
        }
        else return false;
    }
}