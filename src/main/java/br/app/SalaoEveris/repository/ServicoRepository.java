package br.app.SalaoEveris.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.app.SalaoEveris.model.Servico;

	
	@Repository
	public interface ServicoRepository extends JpaRepository<Servico,Long>{
		
	

}
