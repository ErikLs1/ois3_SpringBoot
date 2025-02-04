package com.ois3.service.impl;

import com.ois3.dto.PersonDto;
import com.ois3.entity.Person;
import com.ois3.mapper.PersonMapper;
import com.ois3.repository.PersonRepository;
import com.ois3.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Override
    public PersonDto createPerson(PersonDto dto) {
        Person entity = personMapper.toEntity(dto);
        Person saved = personRepository.save(entity);
        return personMapper.toDto(saved);
    }

    @Override
    public PersonDto updatePerson(Integer id, PersonDto dto) {
        // Check if person exists
        Person existing = personRepository.findById(id).orElseThrow(() -> new RuntimeException("Person not found with id: " + id));

        // Update fields
        existing.setUniId(dto.getUniId());
        existing.setFirstName(dto.getFirstName());
        existing.setLastName(dto.getLastName());
        existing.setGender(dto.getGender());
        existing.setPhoneNumber(dto.getPhoneNumber());
        existing.setAddress(dto.getAddress());
        existing.setDateOfBirth(dto.getDateOfBirth());

        Person updated = personRepository.save(existing);
        return personMapper.toDto(updated);
    }

    @Override
    public PersonDto getPersonById(Integer id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found with id: " + id));
        return personMapper.toDto(person);
    }

    @Override
    public List<PersonDto> getAllPersons() {
        return personRepository.findAll().stream()
                .map(personMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deletePerson(Integer id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found with id: " + id));
        personRepository.deleteById(id);
    }
}
