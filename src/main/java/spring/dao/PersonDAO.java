package spring.dao;

import org.springframework.stereotype.Component;
import spring.models.Person;

import java.util.ArrayList;
import java.util.List;

//Will communicate with the list and will extract people from the list, find a specific person by id, will add
//person from the list, update and delete later etc...
@Component
public class PersonDAO {
    private List<Person> people;
    private static int PEOPLE_COUNT;

    {
        //Create people
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Tom"));
        people.add(new Person(++PEOPLE_COUNT, "Bob"));
        people.add(new Person(++PEOPLE_COUNT, "Mike"));
        people.add(new Person(++PEOPLE_COUNT, "katy"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        //In one line we find the id of the person and return it
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}
