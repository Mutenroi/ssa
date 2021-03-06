package es.gorka.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.gorka.edu.dto.UserDTO;
import es.gorka.edu.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	@Qualifier(value = "userService")
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST, value = "/insert/new")
	public Boolean insertNewUser(@RequestBody UserDTO dto) {
		return userService.insertNewEntityDto(dto);
	}
}
