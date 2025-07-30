package com.series.ratings.webseries.service;

import java.util.List;

import com.series.ratings.webseries.entity.User;
import com.series.ratings.webseries.request.UserRequestDTO;
import com.series.ratings.webseries.response.UserResponseDTO;


public interface IUserService {
		public UserResponseDTO createUser(UserRequestDTO user);
		public UserResponseDTO getUser(String name);
		public List<UserResponseDTO> getUserList();
		public User deleteUser(String name);
}
