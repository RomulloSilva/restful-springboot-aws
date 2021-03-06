package com.springcourse.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcourse.domain.Request;
import com.springcourse.domain.enums.RequestState;
import com.springcourse.repository.RequestRepository;

@Service
public class RequestService {
	
	@Autowired private RequestRepository requestRepository;
	
	
	//Chamada do método save.
	public Request save(Request request) {
		
		request.setState(RequestState.OPEN);
		request.setCreationDate(new Date());
		
		Request createdRequest = requestRepository.save(request);
		
		return createdRequest;
		
	}
	
	//Chamada do método update.
	public Request update (Request request) {
		Request updateRequest = requestRepository.save(request);
		
		return updateRequest;
	}
	
	
	//Chamada do método get.
	public Request getById(Long id) {
		Optional<Request> result = requestRepository.findById(id);
		
		return result.get();
	}
	
	//Chamada do método list.
	public List<Request> listAll(){
		List<Request> requests = requestRepository.findAll();
		return requests;
	}
	
	
	//Chamada do método List pelo user.
	public List<Request> listAllByOwnerId(Long ownerId){
		List<Request> requests = requestRepository.findAllByOwnerId(ownerId);
		
		return requests;
	}

}
