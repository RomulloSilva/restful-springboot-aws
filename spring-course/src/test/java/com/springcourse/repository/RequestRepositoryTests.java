package com.springcourse.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springcourse.domain.Request;
import com.springcourse.domain.User;
import com.springcourse.domain.enums.RequestState;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)  //Executa os testes em ordem alfabética.
public class RequestRepositoryTests {
	
	@Autowired private RequestRepository requestRepository;
	
	
	@Test
	public void AsaveTest() {
		User owner = new User();
		owner.setId(1L);
		Request request = new Request(null, "Novo Laptop HP", "Adição de mais um computador", new Date(), RequestState.OPEN, owner, null);
		
		Request createdRequest = requestRepository.save(request);
		
		assertThat(createdRequest.getId()).isEqualTo(1L);
	}
	
	
	@Test
	public void updateTest() {
			
		User owner = new User();
		owner.setId(1L);
		Request request = new Request(1L, "Novo Laptop HP", "Adição de mais um computador ao departamento de justiça", null, RequestState.OPEN, owner, null);
		
		Request updatedRequest = requestRepository.save(request);
		
		assertThat(updatedRequest.getDescription()).isEqualTo("Adição de mais um computador ao departamento de justiça");
		
		
		
	}
	
	
	@Test
	public void getByIdTest() {
		
		Optional<Request> result = requestRepository.findById(1L);
		Request request = result.get();	
		
		assertThat(request.getSubject()).isEqualTo("Novo Laptop HP");
	}
	
	
	@Test
	public void ListTest() {
		
		
		List<Request> requests = requestRepository.findAll();
		assertThat(requests.size()).isEqualTo(1);
		
	}
	
	@Test
	public void ListByOwnerIdTest() {
		
		
		List<Request> requests = requestRepository.findAllByOwnerId(1L);
		assertThat(requests.size()).isEqualTo(1);
		
	}
	
	
	@Test
	public void upadateStatusTest() {
		int affectedRows = requestRepository.updateStatus(1L, RequestState.IN_PROGRESS);
		assertThat(affectedRows).isEqualTo(1);
	
	
	}

}
