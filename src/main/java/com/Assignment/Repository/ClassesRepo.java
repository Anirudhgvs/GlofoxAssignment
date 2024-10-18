package com.Assignment.Repository;

import com.Assignment.Entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassesRepo extends JpaRepository<Class,Integer> {

    Class findByClassName(String className);

}
