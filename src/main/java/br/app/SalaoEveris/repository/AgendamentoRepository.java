package br.app.SalaoEveris.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.app.SalaoEveris.model.Agendamento;

	
	@Repository
	public interface AgendamentoRepository extends JpaRepository<Agendamento,Long>{
		
	

}
