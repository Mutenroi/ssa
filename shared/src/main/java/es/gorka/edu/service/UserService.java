package es.gorka.edu.service;

import es.gorka.edu.dto.UserDTO;

public interface UserService extends IService<UserDTO> {

	boolean userExist(UserDTO userDto);

}
