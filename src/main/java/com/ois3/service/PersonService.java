package com.ois3.service;

import com.ois3.dto.PersonDto;

import java.util.List;

public interface PersonService {

    PersonDto createPerson(PersonDto dto);

    PersonDto updatePerson(Integer id, PersonDto dto);

    PersonDto getPersonById(Integer id);

    List<PersonDto> getAllPersons();

    void deletePerson(Integer id);
}
