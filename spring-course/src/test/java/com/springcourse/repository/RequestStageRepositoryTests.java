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
import com.springcourse.domain.RequestStage;
import com.springcourse.domain.User;
import com.springcourse.domain.enums.RequestState;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RequestStageRepositoryTests {
	
	@Autowired private RequestStageRepository requestStageRepository;
	
	
	
	@Test
	public void ASaveTets() {
		
		User owner = new User();
		owner.setId(1L);
		
		Request request = new Request();
		request.setId(1L);
		
		RequestStage stage = new RequestStage(null, "Foi comprado computadores para o departamento de justiça", new Date(), RequestState.CLOSED, request, owner);
		
		RequestStage createdStage = requestStageRepository.save(stage);
		
		assertThat(createdStage.getId()).isEqualTo(1L);
		
		
	}
	
	
	@Test
	public void GetByIdTest() {
		
		Optional<RequestStage> result = requestStageRepository.findById(1L);
		
		RequestStage stage = result.get();	
		
		assertThat(stage.getDescription()).isEqualTo("Foi comprado computadores para o departamento de justiça");
	}
	
	
	
	@Test
	public void ListByRequestId() {
		
		List<RequestStage> stages = requestStageRepository.findAll();
		assertThat(stages.size()).isEqualTo(1);
		
	}
}
