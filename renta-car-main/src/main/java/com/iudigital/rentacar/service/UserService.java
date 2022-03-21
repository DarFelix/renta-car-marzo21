package com.iudigital.rentacar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iudigital.rentacar.data.UserRepository;
import com.iudigital.rentacar.domain.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void createUser(User user) {
		userRepository.save(user);
	}

	public List<User> getUsers() {
		List<User> users = (List<User>) userRepository.findAll();
		return users;
	}

	public User getUserById(int idUser) {

		// Optional<User> user= userRepository.findById(idUser);
		// return user.orElse(new User());

		User user = userRepository.findById(idUser).orElse(new User());
		return user;

	}

	public void editUser(int idUser, User user) {

		User userUpdate = userRepository.findById(idUser).orElse(null);
		if (userUpdate != null) {
			userUpdate.setNombre(user.getNombre());
			userUpdate.setApellido(user.getApellido());
			userUpdate.setAge(user.getAge());
			userUpdate.setBarrio(user.getBarrio());
			userUpdate.setCedula(user.getCedula());
			userUpdate.setCiudad(user.getCiudad());
			userUpdate.setDireccion(user.getDireccion());
			userUpdate.setFoto(user.getFoto());
			userRepository.save(userUpdate);
		}

	}
	
	public void deleteUser(int idUser) {
		
		userRepository.deleteById(idUser);
		
	}
		
		
	//1. busqueda distinta por nombre y apellido
	
	public List<User> getDistinctByNombreAndApellido(String nombre, String apellido){
		List<User> users= userRepository.findDistinctByNombreAndApellido(nombre, apellido);
		return users;
	}
	
	
	//2.  busqueda por nombre y apellido
	
		public List<User> getUserByNombreAndApellido(String nombre, String apellido){
			List<User> users = userRepository.findByNombreAndApellido(nombre, apellido);
			return users;
		}
		
		//3.  busqueda por nombre o apellido
		
		public List<User> getUserByNombreOrApellido(String nombre, String apellido){
			List<User> users = userRepository.findByNombreOrApellido( nombre, apellido);
			return users;
		}
		
		//4. busqueda por nombre
		
		public List<User> getUserByNombre(String nombre){
			List<User> users = userRepository.findByNombre(nombre);
			return users;
		}
		
		//5. listado de ususario con una edad menor que un valor dado
		
		public List<User> getUserByAgeLessThan(int age){
			List<User> users = userRepository.findByAgeLessThan(age);
			return users;
		}
		
		//7. listado de usuarios con una edad menor o igual a 
		
		public List<User> getUserByAgeLessThanEqual(int age){
			List<User> users = userRepository.findByAgeLessThanEqual(age);
			return users;
		}
		
		//8. listado de usuarios con una edad mayor que
		
		public List<User> getUserByAgeGreaterThan(int age){
			List<User> users = userRepository.findByAgeGreaterThan(age);
			return users;
		}
		
		//9. listado de usuario con una edad mayor o igual que
		public List<User> getUserByAgeGreaterThanEqual(int age){
			List<User> users = userRepository.findByAgeGreaterThanEqual(age);
			return users;
		}
		
		
		//12. busqueda por usuarios con apellido nulo
		public List<User> getUserByApellidoIsNull(){
			List<User> users = userRepository.findByApellidoIsNull();
			return users;
		}
 		
		
	

}
	

