package com.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Todoitems;
@Repository
public interface TodoRepo extends JpaRepository<Todoitems, Long>{

}
