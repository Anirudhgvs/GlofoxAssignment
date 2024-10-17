package com.Assignment.repo;

import com.Assignment.entity.Classes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassesRepo extends JpaRepository<Classes,Integer> {

    Classes findByClassName(String className);

}
