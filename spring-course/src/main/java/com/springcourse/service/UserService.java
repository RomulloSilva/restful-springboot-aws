package com.springcourse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcourse.domain.User;
import com.springcourse.repository.UserRepository;
import com.springcourse.service.util.HashUtil;



@Service //Anotação para identificar ser um serviço
public class UserService {
	
	//Intância do repositorio onde encontra-se os métodos.
	@Autowired private UserRepository userRepository;
	
	//Chamada do método save.
	public User save(User user) {
		
		//Gerando uma codifiação para a senha
		String hash = HashUtil.getSecureHash(user.getPassword());
		user.setPassword(hash);
		
		
		User createdUser = userRepository.save(user);
		return createdUser;
	}
	
	//Chamada do método update.
	public User update(User user) {
		
		//Gerando uma codifiação para a senha
		String hash = HashUtil.getSecureHash(user.getPassword());
		user.setPassword(hash);
		
		User updateUser = userRepository.save(user);
		return updateUser;
	}
	
	
	//Chamada do método get.
	public User getById(Long id) {
		Optional<User> result = userRepository.findById(id);
		return result.get();
	}
	
	//Chamada do método list.
	public List<User> listAll(){
		List<User> users = userRepository.findAll();
		return users;
	}
	
	
	//Chamada do método login.
	public User login(String email, String password) {
		
		password = HashUtil.getSecureHash(password);
				
		Optional<User> result = userRepository.login(email, password);
		return result.get();
	}

}
