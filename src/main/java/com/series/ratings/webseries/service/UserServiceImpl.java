package com.series.ratings.webseries.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.series.ratings.webseries.entity.User;
import com.series.ratings.webseries.exception.NotFoundException;
import com.series.ratings.webseries.repository.UserRepository;
import com.series.ratings.webseries.request.UserRequestDTO;
import com.series.ratings.webseries.response.UserResponseDTO;

@Service
public class UserServiceImpl implements IUserService  {

    
	@Autowired
	UserRepository userRepo;

	
    private ModelMapper mapper;
    
    public UserServiceImpl(ModelMapper mapper) {
    	this.mapper = mapper;
    }
    
	
	@Override
	public UserResponseDTO createUser(UserRequestDTO user) {
		User newUser = userRepo.insert(mapper.map(user, User.class));
		return mapper.map(newUser, UserResponseDTO.class);
	}

	@Override
	public  UserResponseDTO getUser(String name) {
		User response = userRepo.findByName(name);
		if(response == null) {
			throw new NotFoundException("User with name : "+name+" doesn't exist");
		}
		return mapper.map(response, UserResponseDTO.class);
	}

	@Override
	public List<UserResponseDTO> getUserList() {
		List<User> list  = userRepo.findAll();
		return list.stream().map(user-> mapper.map(user, UserResponseDTO.class)).collect(Collectors.toList());
	}

	@Override
	public User deleteUser(String name) {
		User user = userRepo.deleteByName(name);
		return user;
	}

}
