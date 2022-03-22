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
			userUpdate.setReporte(user.isReporte());
		
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
		
		//13. busqueda por usuario con apellido no nulo
		public List<User> getUserByApellidoNotNull(){
			List<User> users = userRepository.findByApellidoNotNull();
			return users;
		}
		
		//14. busqueda por nombres como el determinado
		public List<User> getUserByNombreLike(String nombre){
			List<User> users = userRepository.findByNombreLike(nombre);
			return users;
		}
		
		//15. busqueda por nombre que no sean como
		public List<User> getUserByNombreNotLike(String nombre){
			List<User> users = userRepository.findByNombreNotLike(nombre);
			return users;
		}
		
		//16. busqueda por nombre que empiece por
		public List<User> getUserByNombreStartingWith(String nombre){
			List<User> users = userRepository.findByNombreStartingWith(nombre);
			return users;
		}
		
		//17. busqueda por nombre que terminen en
		public List<User> getUserByNombreEndingWith(String nombre){
			List<User> users = userRepository.findByNombreEndingWith(nombre);
			return users;
		}
		
		//18. busqueda por nombres que contengan
		public List<User> getUserByNombreContaining(String nombre){
			List<User> users = userRepository.findByNombreContaining(nombre);
			return users;
		}
		
		//19. listado de usuarios por edad en orden descendente
		public List<User> getUserByOrderByAgeDesc(){
			List<User> users = userRepository.findByOrderByAgeDesc();
			return users;
		}
		
		//20. busqueda por nombres que no sean igual a
		public List<User> getUserByNombreNot(String nombre){
			List<User> users = userRepository.findByNombreNot(nombre);
			return users;
		}
		
		//21. listado de usuarios que contengan los nombres dados
		public List<User> getUserByNombreIn(List<String> nombres){
			List<User> users = userRepository.findByNombreIn(nombres);
			return users;
		}
		
		//22. listado de usuarios que no contengan los nombres dados
		public List<User> getUserByNombreNotIn(List<String> nombres){
			List<User> users = userRepository.findByNombreNotIn(nombres);
			return users;
		}
		
		//23. listado de usuarios con reporte activo
		public List<User> getUserByReporteTrue(){
			List<User> users = userRepository.findByReporteTrue();
			return users;
		}
		
		//24. listado de usuarios sin reporte activo
		public List<User> getUserByReporteFalse(){
			List<User> users = userRepository.findByReporteFalse();
			return users;
		}
		
		//25. busqueda por nombre sin importar minusculas o mayusculas
		public List<User> getUserByNombreIgnoreCase(String nombre){
			List<User> users = userRepository.findByNombreIgnoreCase(nombre);
			return users;
		}

}
	

