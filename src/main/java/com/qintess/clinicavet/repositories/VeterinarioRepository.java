package com.qintess.clinicavet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qintess.clinicavet.models.Veterinario;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Long>{

	List<Veterinario> findAllByEspecialidade(String especialidade);
	
}
