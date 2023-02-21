package com.shaksoft.crudoperation.service.impl;

import com.shaksoft.crudoperation.entity.Person;
import com.shaksoft.crudoperation.exception.ResourceNotFoundException;
import com.shaksoft.crudoperation.payload.PersonDto;
import com.shaksoft.crudoperation.repository.PersonRepositoryI;
import com.shaksoft.crudoperation.service.PersonServiceI;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonServiceI {
    @Autowired
    private PersonRepositoryI personRepositoryI;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public PersonDto createPersonDetail(PersonDto personDto) {
        Person person = this.modelMapper.map(personDto, Person.class);
        Person save = this.personRepositoryI.save(person);
        return this.modelMapper.map(save,PersonDto.class);
    }

    @Override
    public PersonDto updatePersonDetail(PersonDto personDto, Long Id) {

        Person person = this.personRepositoryI.findById(Id).orElseThrow(() -> new ResourceNotFoundException());
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        person.setEmail(personDto.getEmail());
        person.setAge(personDto.getAge());
        Person update = this.personRepositoryI.save(person);
        return this.modelMapper.map(update,PersonDto.class);
    }

    @Override
    public PersonDto getPersonDetail(Long Id) {
        Person person = this.personRepositoryI.findById(Id).orElseThrow(() -> new ResourceNotFoundException());

        return this.modelMapper.map(person,PersonDto.class);
    }

    @Override
    public List<PersonDto> getAllPersonDetails() {
        List<Person> personList = this.personRepositoryI.findAll();
        List<PersonDto> personDtos = personList.stream().map((p) -> this.modelMapper.map(p, PersonDto.class)).collect(Collectors.toList());
        return personDtos;
    }

    @Override
    public void deletePersonDetail(Long Id) {
        Person person = this.personRepositoryI.findById(Id).orElseThrow(() -> new ResourceNotFoundException());
        this.personRepositoryI.delete(person);

    }
}
