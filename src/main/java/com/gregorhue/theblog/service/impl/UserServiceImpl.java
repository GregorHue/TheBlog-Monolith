package com.gregorhue.theblog.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

import com.gregorhue.theblog.dto.UserDto;
import com.gregorhue.theblog.mapper.UserMapper;
import com.gregorhue.theblog.model.User;
import com.gregorhue.theblog.repository.UserRepository;
import com.gregorhue.theblog.service.UserService;

/**
 * Created by gregorhue on 08.10.2020.
 */
@Stateless
public class UserServiceImpl implements UserService {

	@Inject
	private UserRepository userRepository;

	@Inject
	private UserMapper userMapper;

	@Inject
	private Pbkdf2PasswordHash hashAlgorithm;

	@Override
	public List<UserDto> getAllUsers() {
		return userMapper.toUserDtos(userRepository.findAll());
	}

	@Override
	public UserDto getUserById(Long id) {
		return userMapper.toUserDto(userRepository.findOne(id));
	}

	@Override
	public UserDto getUserByUsername(String username) {
		return userMapper.toUserDto(userRepository.findByUsername(username));
	}

	@Override
	public void saveNewUser(UserDto userDto) {
		User user = userMapper.toUser(userDto);
		user.setPassword(hashAlgorithm.generate(userDto.getPassword().toCharArray()));
		user.setCreatedAt(LocalDateTime.now());
		userRepository.saveNewEntity(user);
	}

	@Override
	public void updateUser(Long id, UserDto userDto) {
		User user = userMapper.toUser(userDto);
		if (userDto.getPassword() != null) {
			user.setPassword(hashAlgorithm.generate(userDto.getPassword().toCharArray()));
		}
		else {
			User originalUser = userRepository.findOne(id);
			user.setPassword(originalUser.getPassword());
		}
		user.setLastUpdatedAt(LocalDateTime.now());
		user.setId(id);
		userRepository.updateEntry(user);
	}

	@Override
	public void deleteUserById(Long id) {
		User user = userRepository.findOne(id);
		user.setDeletedTs(LocalDateTime.now());
		userRepository.updateEntry(user);
	}

}

