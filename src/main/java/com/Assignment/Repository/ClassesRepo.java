package com.Assignment.Repository;

import com.Assignment.Entity.Classes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassesRepo extends JpaRepository<Classes,Integer> {

    Classes findByClassName(String className);

}
