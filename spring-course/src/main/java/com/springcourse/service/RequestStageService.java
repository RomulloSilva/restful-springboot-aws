package com.springcourse.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcourse.domain.RequestStage;
import com.springcourse.domain.enums.RequestState;
import com.springcourse.repository.RequestRepository;
import com.springcourse.repository.RequestStageRepository;

@Service
public class RequestStageService {
	
	@Autowired private RequestStageRepository requestStageRepository;
	@Autowired private RequestRepository requestRepository;
	
	//Chamada do método save.
	public RequestStage save (RequestStage stage) {
		
		stage.setRealizationDate(new Date());
		
		
		RequestStage createdStage = requestStageRepository.save(stage);
		
		
		Long requestId = stage.getRequest().getId();
		RequestState state = stage.getState();
		
		requestRepository.updateStatus(requestId, state); //Aqui será feita a atualização do status.
		
		return createdStage;
	}
	
	//Chamada do método get.
	public RequestStage getById(Long id) {
		
		Optional<RequestStage> results = requestStageRepository.findById(id);
		return results.get();
	}
	
	
	//Chamada do método buscando pelo Id do request
	public List<RequestStage> listAllByRequestId(Long requestId){
		List<RequestStage> stages = requestStageRepository.findAllByRequestId(requestId);
		return stages;
	}
	

}
