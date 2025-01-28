package com.ois3.controller;

import com.ois3.dto.PersonDto;
import com.ois3.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonService personService;

    // Add Person REST API
    @PostMapping
    public ResponseEntity<PersonDto> createPerson(@RequestBody PersonDto personDto) {
        PersonDto savedPerson = personService.createPerson(personDto);
        return new ResponseEntity<>(savedPerson, HttpStatus.CREATED);
    }

    // Get Person REST API
    @GetMapping("{id}")
    public ResponseEntity<PersonDto> getPersonById(@PathVariable("id") Integer personId) {
        PersonDto personDto = personService.getPersonById(personId);
        return ResponseEntity.ok(personDto);
    }

    // Get All Persons REST API
    @GetMapping
    public ResponseEntity<List<PersonDto>> getAllEmployees() {
        List<PersonDto> persons = personService.getAllPersons();
        return ResponseEntity.ok(persons);
    }

    // Update Person REST API
    @PutMapping("{id}")
    public ResponseEntity<PersonDto> updatePerson(@PathVariable("id") Integer personId,
                                                  @RequestBody PersonDto updatedPerson) {
        PersonDto personDto = personService.updatePerson(personId, updatedPerson);
        return ResponseEntity.ok(personDto);
    }

    // Delete Person Rest API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePerson(@PathVariable("id") Integer personId) {
        personService.deletePerson(personId);

        return ResponseEntity.ok("Person deleted successfully!");
    }
}
