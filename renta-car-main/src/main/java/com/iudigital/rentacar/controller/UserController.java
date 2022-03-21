package com.iudigital.rentacar.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.iudigital.rentacar.controller.converter.UserConverter;
import com.iudigital.rentacar.controller.dto.UserDTO;
import com.iudigital.rentacar.domain.User;
import com.iudigital.rentacar.service.UserService;



@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserConverter userConverter;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createUser(@RequestBody UserDTO userDTO) {
		userService.createUser(userConverter.convertUserDTOToUser(userDTO));
	}
	
	@GetMapping
	public List<UserDTO> getUsers() {
		return userService.getUsers()
							.stream()
							.map(user -> userConverter.convertUserToUserDTO(user))
							.collect(Collectors.toList());
	}
	
	@GetMapping("/{userId}")
	public User getUser(@PathVariable int userId) {
		return userService.getUserById(userId);
	}
	
	@PutMapping("/{userId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void  editUser(@PathVariable int userId, @RequestBody User user) {
		 userService.editUser(userId, user );
	}
	
	@DeleteMapping("/{userId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable int userId) {
		 userService.deleteUser(userId);
	}
	
	//1. busqueda distinta por nombre y apellido
	
	@GetMapping("/distinct/nombre/{nombre}/apellido/{apellido}")
	public List<UserDTO> getFindDistinctByNombreAndApellido(@PathVariable String nombre, @PathVariable String apellido){
		return userService.getDistinctByNombreAndApellido(nombre, apellido)
							.stream()
							.map(user -> userConverter.convertUserToUserDTO(user))
							.collect(Collectors.toList());
				
	}
	

	//2. busqueda por nombre y apellido
	@GetMapping("/and/nombre/{nombre}/apellido/{apellido}")
	public List<UserDTO> getFindByNombreAndApellido(@PathVariable String nombre, @PathVariable String apellido){
		return userService.getUserByNombreAndApellido(nombre, apellido)
							.stream()
							.map(user -> userConverter.convertUserToUserDTO(user))
							.collect(Collectors.toList());
	}
	
	//3. busqueda por nombre o apellido
	
	@GetMapping("/or/nombre/{nombre}/apellido/{apellido}")
	public List<UserDTO> getFindByNombreOrApellido(@PathVariable String nombre, @PathVariable String apellido){
		return userService.getUserByNombreOrApellido(nombre, apellido)
							.stream()
							.map(user -> userConverter.convertUserToUserDTO(user))
							.collect(Collectors.toList());
	}
	
	//4. busqueda por nombre
	
	@GetMapping("/nombre/{nombre}")
	public List<UserDTO> getFindByNombre(@PathVariable String nombre){
		return userService.getUserByNombre(nombre)
							.stream()
							.map(user -> userConverter.convertUserToUserDTO(user))
							.collect(Collectors.toList());
	}
	
	//5. listado de usuario con una edad menor que un valor dado
	@GetMapping ("/edadMenorQue/{age}")
	public List<UserDTO> getUserByAgeLessThan(@PathVariable int age){
		return userService.getUserByAgeLessThan(age)
							.stream()
							.map(user -> userConverter.convertUserToUserDTO(user))
							.collect(Collectors.toList());
		
	}
	
	//7. Listade usuarios con una edad menor o igual que
	@GetMapping ("/edadmenoroigual/{age}")
	public List<UserDTO> getUserByAgeLessThanEqual(@PathVariable int age){
		return userService.getUserByAgeLessThanEqual(age)
							.stream()
							.map(user -> userConverter.convertUserToUserDTO(user))
							.collect(Collectors.toList());
					
	}
	
	//8. Listado de usuarios con una edad mayor que
	@GetMapping ("/edadmayorque/{age}")
	public List<UserDTO> getUserByAgeGreaterThan(@PathVariable int age){
		return userService.getUserByAgeGreaterThan(age)
							.stream()
							.map(user -> userConverter.convertUserToUserDTO(user))
							.collect(Collectors.toList());
		
	}
	
	//9. Listado de usuarios con una edad mayor o igual que
	@GetMapping ("/edadmayoroigualque/{age}")
	public List<UserDTO> getUserByAgeGreaterThanEqual(@PathVariable int age){
		return userService.getUserByAgeGreaterThanEqual(age)
							.stream()
							.map(user -> userConverter.convertUserToUserDTO(user))
							.collect(Collectors.toList());
		
	}
	
	//12. Listado de usuarios con edad nula
	@GetMapping("/apellidonulo")
	public List<UserDTO> getUserByApellidoIsNull(){
		return userService.getUserByApellidoIsNull()
						.stream()
						.map(user -> userConverter.convertUserToUserDTO(user))
						.collect(Collectors.toList());
	}
	
	
	
	
}
