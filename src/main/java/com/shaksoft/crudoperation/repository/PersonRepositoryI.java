package com.shaksoft.crudoperation.repository;

import com.shaksoft.crudoperation.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepositoryI extends JpaRepository<Person,Long> {


}
