package com.shaksoft.crudoperation.service;

import com.shaksoft.crudoperation.payload.PersonDto;

import java.util.List;

public interface PersonServiceI {
    //create
    PersonDto createPersonDetail(PersonDto personDto);
    //update
    PersonDto updatePersonDetail(PersonDto personDto,Long Id);
    //get
    PersonDto getPersonDetail(Long Id);
    //get All
    List<PersonDto> getAllPersonDetails();
    //delete
    void deletePersonDetail(Long Id);

}
