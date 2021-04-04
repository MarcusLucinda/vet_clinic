package com.qintess.clinicavet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qintess.clinicavet.models.Exame;

@Repository
public interface ExameRepository extends JpaRepository<Exame, Long> {

}
