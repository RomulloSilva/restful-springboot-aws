package com.springcourse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springcourse.domain.Request;
import com.springcourse.domain.enums.RequestState;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

	//Retorna todos os pedidos de um id/usuário
	public List<Request> findAllByOwnerId(Long id);
	
	
	@Transactional(readOnly = false) // Assim este atributo estara disponivel para leitura.
	@Modifying //Significa que vamos modificar um dado.
	@Query("UPDATE request SET state = ?2 WHERE id = ?1")
	public int updateStatus(Long id, RequestState state); //int porque ele vai retornar o número de linhas afetadas pelo update.
}
