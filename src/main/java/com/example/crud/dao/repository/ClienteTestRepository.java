package com.example.crud.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crud.beans.domain.ClienteTest;
@Repository
public interface ClienteTestRepository extends JpaRepository<ClienteTest, String>{

}
