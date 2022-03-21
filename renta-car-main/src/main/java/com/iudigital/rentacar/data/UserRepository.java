package com.iudigital.rentacar.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.iudigital.rentacar.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	
	//1. SELECT DISTINCT * FROM User WHERE nombre='darwin' and apellido='felix';
	public List<User> findDistinctByNombreAndApellido (String nombre, String apellido);
	
	//2. SELECT * FROM user WHERE name='darwin' and apellido='felix';
	public List<User> findByNombreAndApellido(String nombre, String apellido);
	
	//3. SELECT * FROM user WHERE name='darwin' or 'apellido='felix';
	public List<User> findByNombreOrApellido(String nombre, String apellido);
	
	//4. SELECT * FROM user WHERE name='darwin'
	public List<User> findByNombre(String nombre);
	
	//6. SELECT * FROM user where edad < 30
	public List<User> findByAgeLessThan(int age);
	
	//7. SELECT * FROM user where edad <= 30
	public List<User> findByAgeLessThanEqual(int age);
	
	//8. SELECT * FROM user where edad > 30
	public List<User> findByAgeGreaterThan(int age);
	
	//9. SELECT * FROM user WHERE edad >= 30
	public List<User> findByAgeGreaterThanEqual(int age);
	
	//12. SELECT * FROM user WHERE apellido IS NULL;
	public List<User> findByApellidoIsNull();
	
	
	
	
	
 	
	

}
