package com.iudigital.rentacar.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.iudigital.rentacar.controller.converter.UserConverter;
import com.iudigital.rentacar.controller.dto.UserDTO;
import com.iudigital.rentacar.data.IdContainer;
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
	
	//12. Listado de usuarios con apellido nulo
	@GetMapping("/apellidonulo")
	public List<UserDTO> getUserByApellidoIsNull(){
		return userService.getUserByApellidoIsNull()
						.stream()
						.map(user -> userConverter.convertUserToUserDTO(user))
						.collect(Collectors.toList());
	}
	
	//13. Listado de usuarios con apellido no nulo
	@GetMapping("/apellidononulo")
	public List<UserDTO> getUserByApellidoNotNull(){
		return userService.getUserByApellidoNotNull()
					.stream()
					.map(user -> userConverter.convertUserToUserDTO(user))
					.collect(Collectors.toList());
	}
	
	//14. busqueda por caracteres determinados dentro del nombre
	@GetMapping("/nombrelike/{nombre}")
	public List<UserDTO> getUserByNombreLike(@PathVariable String nombre){
		return userService.getUserByNombreLike(nombre)
							.stream()
							.map(user -> userConverter.convertUserToUserDTO(user))
							.collect(Collectors.toList());
	}
	
	//15. busqueda por nombre que no sean como
	@GetMapping("/nombrenotlike/{nombre}")
	public List<UserDTO> getUserByNombreNotLike(@PathVariable String nombre){
		return userService.getUserByNombreNotLike(nombre)
							.stream()
							.map(user -> userConverter.convertUserToUserDTO(user))
							.collect(Collectors.toList());
	}
	
	//16. busqueda por nombre que empiece por
	@GetMapping("/nombrestartingwith/{nombre}")
	public List<UserDTO> getUserByNombreStartingWith(@PathVariable String nombre){
		return userService.getUserByNombreStartingWith(nombre)
							.stream()
							.map(user -> userConverter.convertUserToUserDTO(user))
							.collect(Collectors.toList());
	}
	
	//17. busqueda por nombre que terminen en
	@GetMapping("/nombreendingwith/{nombre}")
	public List<UserDTO> getUserByNombreEndingWith(@PathVariable String nombre){
		return userService.getUserByNombreEndingWith(nombre)
							.stream()
							.map(user -> userConverter.convertUserToUserDTO(user))
							.collect(Collectors.toList());
				
	}
	
	//18. busqueda por nombres que contengan
	@GetMapping("/nombrecontaining/{nombre}")
	public List<UserDTO> getUserByNombreContaining(@PathVariable String nombre){
		return userService.getUserByNombreContaining(nombre)
							.stream()
							.map(user -> userConverter.convertUserToUserDTO(user))
							.collect(Collectors.toList());
				
	}
	
	//19. listado de usuarios por edad en orden descendente
	@GetMapping("/edaddesc")
	public List<UserDTO> getUserByOrderByAgeDesc(){
		return userService.getUserByOrderByAgeDesc()
							.stream()
							.map(user -> userConverter.convertUserToUserDTO(user))
							.collect(Collectors.toList());
	}
	
	//20. busqueda por nombres que no sean igual a
	@GetMapping("/nombreNot/{nombre}")
	public List<UserDTO> getUserByNombreNot(@PathVariable String nombre){
		return userService.getUserByNombreNot(nombre)
							.stream()
							.map(user -> userConverter.convertUserToUserDTO(user))
							.collect(Collectors.toList());
	}
	
	//21.  listado de usuarios que contengan los nombres dados
	@PostMapping("/in/nombres")
	@ResponseBody
	public List<UserDTO> getUserByNombreIn(@RequestBody List<IdContainer> idContainers){
				List<String> nombres = new ArrayList();
				for(IdContainer id : idContainers) {
					nombres.add(id.getNombre());
				}
				return userService.getUserByNombreIn(nombres)
						.stream()
						.map(user -> userConverter.convertUserToUserDTO(user))
						.collect(Collectors.toList());
				
	}
	
	//22. listado de usuarios que no contengan los nombres dados
	@PostMapping("/notin/nombres")
	@ResponseBody
	public List<UserDTO> getUserByNombreNotIn(@RequestBody List<IdContainer> idContainers){
				List<String> nombres = new ArrayList();
				for(IdContainer id: idContainers) {
					nombres.add(id.getNombre());
				}
				return userService.getUserByNombreNotIn(nombres)
						.stream()
						.map(user -> userConverter.convertUserToUserDTO(user))
						.collect(Collectors.toList());
	}
	
	//23. listado de usuarios con reporte activo
	@GetMapping("/reportetrue")
	public List<UserDTO> getUserByReporteTrue(){
		return userService.getUserByReporteTrue()
								.stream()
								.map(user -> userConverter.convertUserToUserDTO(user))
								.collect(Collectors.toList());
	}
	
	
	//24. listado de usuarios sin reporte activo
	@GetMapping("/reportefalse")
	public List<UserDTO> getUserByReporteFalse(){
		return userService.getUserByReporteFalse()
								.stream()
								.map(user -> userConverter.convertUserToUserDTO(user))
								.collect(Collectors.toList());			
	}
	
	
	//25. busqueda por nombre sin importar minusculas o mayusculas
	@GetMapping("/nombreignorecase/{nombre}")
	public List<UserDTO> getUserByNombreIgnoreCase(@PathVariable String nombre){
		return userService.getUserByNombreIgnoreCase(nombre)
							.stream()
							.map(user -> userConverter.convertUserToUserDTO(user))
							.collect(Collectors.toList());	
	}
	
	
	
}
