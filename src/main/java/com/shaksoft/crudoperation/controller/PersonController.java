package com.shaksoft.crudoperation.controller;

import com.shaksoft.crudoperation.config.ApiConstants;
import com.shaksoft.crudoperation.exception.ApiResponse;
import com.shaksoft.crudoperation.payload.PersonDto;
import com.shaksoft.crudoperation.service.PersonServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    @Autowired
    private PersonServiceI personServiceI;
    //create Person Detail

    /**
     * @author Saurabh
     * @apiNote This api is for creating Person Detail
     * @param personDto
     * @return PersonDto
     */
    @PostMapping("/create")
    public ResponseEntity<PersonDto> createPersonDetail(@RequestBody PersonDto personDto){
        PersonDto personDetail = this.personServiceI.createPersonDetail(personDto);
        return new ResponseEntity<PersonDto>(personDetail, HttpStatus.CREATED);
    }
    //update Person Detail

    /**
     * @author Saurabh
     * @apiNote This api is for updating Person Detail
     * @param personDto
     * @param Id
     * @param personDto
     * @return PersonDto
     */
    @PutMapping("/personId/{personId}")
    public ResponseEntity<PersonDto> updatePersonDetail(@RequestBody PersonDto personDto,
                                                        @PathVariable("personId") Long Id){
        PersonDto updatePersonDetail = this.personServiceI.updatePersonDetail(personDto, Id);
        return new ResponseEntity<PersonDto>(updatePersonDetail,HttpStatus.CREATED);
    }
    /**
     * @author Saurabh
     * @apiNote This api is for getting a Person Detail
     * @param Id
     * @return PersonDto
     */
    @GetMapping("/personId/{personId}")
    public ResponseEntity<PersonDto> getPersonDetail(@PathVariable("personId") Long Id){
        PersonDto personDetail = this.personServiceI.getPersonDetail(Id);
        return new ResponseEntity<PersonDto>(personDetail,HttpStatus.OK);

    }

    /**
     * @author Saurabh
     * @apiNote This api is for getting all Person Details
     * @return List of PersonDto
     */
    @GetMapping("/persons")
    public ResponseEntity<List<PersonDto>> getAllPersonDetails(){
        List<PersonDto> allPersonDetails = this.personServiceI.getAllPersonDetails();
        return new ResponseEntity<List<PersonDto>>(allPersonDetails,HttpStatus.OK);
    }
    /**
     * @author Saurabh
     * @param Id
     * @apiNote This api is for Deleting a Person Detail
     * @return ApiResponse
     */
    @DeleteMapping("/personId/{personId}")
    public ResponseEntity<ApiResponse>deletePersonDetail(@PathVariable("personId") Long Id){
        this.personServiceI.deletePersonDetail(Id);
        return new ResponseEntity<ApiResponse>(new ApiResponse(ApiConstants.DELETED_SUCCESS,true),
                HttpStatus.OK);
        }
    }


