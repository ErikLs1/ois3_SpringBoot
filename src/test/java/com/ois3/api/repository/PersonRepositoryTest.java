package com.ois3.api.repository;

import com.ois3.entity.Person;
import com.ois3.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void testSavePerson() {

        Person person = Person.builder()
                .uniId("123456")
                .firstName("John")
                .lastName("Doe")
                .gender("Male")
                .phoneNumber("+1-555-1234")
                .address("123 Elm Street, New York, NY")
                .email("john.doe@example.com")
                .dateOfBirth(LocalDate.of(1995, 7, 20))
                .build();

        Person savedPerson = personRepository.save(person);

        assertNotNull(savedPerson);
        assertNotNull(savedPerson.getPersonId());
        assertEquals("John", savedPerson.getFirstName());
        assertEquals("Doe", savedPerson.getLastName());

        Optional<Person> retrievedPerson = personRepository.findById(savedPerson.getPersonId());
        assertTrue(retrievedPerson.isPresent());
        assertEquals("john.doe@example.com", retrievedPerson.get().getEmail());
    }

    @Test
    public void testFindAllPersons() {
        Person p1 = Person.builder().uniId("123456").firstName("John").lastName("Doe")
                .email("john.doe@example.com").dateOfBirth(LocalDate.of(1995, 7, 20)).build();
        Person p2 = Person.builder().uniId("654321").firstName("Jane").lastName("Smith")
                .email("jane.smith@example.com").dateOfBirth(LocalDate.of(1990, 1, 1)).build();

        personRepository.save(p1);
        personRepository.save(p2);

        List<Person> people = personRepository.findAll();

        assertNotNull(people);
        assertEquals(2, people.size());
        assertTrue(people.stream().anyMatch(p -> p.getEmail().equals("john.doe@example.com")));
        assertTrue(people.stream().anyMatch(p -> p.getEmail().equals("jane.smith@example.com")));
    }

    @Test
    public void testFindPersonById() {
        Person p1 = Person.builder().uniId("123456").firstName("John").lastName("Doe")
                .email("john.doe@example.com").dateOfBirth(LocalDate.of(1995, 7, 20)).build();

        personRepository.save(p1);

        Person person = personRepository.findById(p1.getPersonId()).get();

        assertNotNull(person);
    }
}
