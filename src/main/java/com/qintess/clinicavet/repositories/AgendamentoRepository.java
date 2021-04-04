package com.qintess.clinicavet.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qintess.clinicavet.models.Agendamento;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

	@Query("SELECT a FROM Agendamento a WHERE a.data = ?1 AND a.veterinario.id = ?2")
    List<Agendamento> findByDataAndVeterinario(LocalDate data, Long vetId);
	
	@Query("SELECT a FROM Agendamento a WHERE a.veterinario.id = ?1")
	List<Agendamento> findAllByVeterinario(Long vetId);
}
