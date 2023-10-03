package com.banco.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.model.Agencia;
import com.banco.repository.AgenciaRepository;

@Service
public class AgenciaServices {

	@Autowired
	AgenciaRepository agenciaRepository;

	public Agencia create(Agencia agencia) {
		return agenciaRepository.save(agencia);
	}

	public List<Agencia> findAll() {
		return agenciaRepository.findAll();
	}

	public Agencia findById(Integer id) throws Exception {

		Optional<Agencia> agenciaOptional = agenciaRepository.findById(id);

		if (agenciaOptional.isPresent()) {
			return agenciaOptional.get();
		} else {
			throw new Exception("Agencia não encontrado para o ID: " + id);
		}
	}

	public Agencia update(Agencia agencia, Integer id) {
		agencia.setIdentificador(id);
		return agenciaRepository.save(agencia);
	}
	
	public void delete(Integer id) {
		agenciaRepository.deleteById(id);
	}

}
