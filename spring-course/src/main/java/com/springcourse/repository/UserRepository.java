package com.springcourse.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springcourse.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	/*
	 * Métodos de fazer um login/ buscar um usuário específico
	public User getByEmailAndPassword(String email, String password);
	pro utilizar a anotação repository e a extensão Jpa não é necessário,
	fazer alguns métodos de busca porque ele ja tem. Ex: findAll() 
	*/
	//Login o optional é um método de tratar valores nulos.
	@Query("SELECT u FROM user u WHERE email = ?1 AND password = ?2")
	public Optional<User> login(String email, String password);
	
	
	
}
