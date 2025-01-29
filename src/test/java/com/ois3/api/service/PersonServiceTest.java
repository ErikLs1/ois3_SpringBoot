package com.ois3.api.service;

import com.ois3.dto.PersonDto;
import com.ois3.entity.Person;
import com.ois3.mapper.PersonMapper;
import com.ois3.repository.PersonRepository;
import com.ois3.service.impl.PersonServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonMapper personMapper;

    @InjectMocks
    private PersonServiceImpl personService;

    private PersonDto personDto;
    private Person person;

    @BeforeEach
    void setUp() {
        personDto = new PersonDto();
        personDto.setPersonId(1);
        personDto.setUniId("UNI12345");
        personDto.setFirstName("John");
        personDto.setLastName("Doe");
        personDto.setEmail("[email protected]");
        personDto.setDateOfBirth(LocalDate.of(1990, 1, 1));

        person = new Person();
        person.setPersonId(1);
        person.setUniId("UNI12345");
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setEmail("[email protected]");
        person.setDateOfBirth(LocalDate.of(1990, 1, 1));
    }

    @Test
    void createPerson_ShouldReturnPersonDto() {
        when(personMapper.toEntity(any(PersonDto.class))).thenReturn(person);
        when(personRepository.save(any(Person.class))).thenReturn(person);
        when(personMapper.toDto(any(Person.class))).thenReturn(personDto);

        PersonDto result = personService.createPerson(personDto);

        assertNotNull(result);
        assertEquals("John", result.getFirstName());
        verify(personRepository, times(1)).save(any(Person.class));
        verify(personMapper, times(1)).toEntity(personDto);
        verify(personMapper, times(1)).toDto(person);
    }
}
