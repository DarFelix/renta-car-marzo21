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
	
	//13. SELECT * FROM user WHERE apellido NOT NULL;
	public List<User> findByApellidoNotNull();
	
	//14. SELECT * FROM users WHERE nombre like darwin;
	public List<User> findByNombreLike(String nombre);

	//15. SELECT * FROM users WHERE nombre not like darwin;
	public List<User> findByNombreNotLike(String nombre);
	
	//16. SELECT * FROM users WHERE nombre LIKE d%;
	public List<User> findByNombreStartingWith(String nombre);
	
	//17. SELECT * FROM users WHERE nombre LIKE %o;
	public List<User> findByNombreEndingWith(String nombre);
	
	//18. SELECT * FROM users WHERE nombre Like %est%;
	public List<User> findByNombreContaining(String nombre);
	
	//19. SELECT * FROM users ORDER BY age DESC;
	public List<User> findByOrderByAgeDesc();
	
	//20. SELECT * FROM users WHERE NOT nombre="darwin";
	public List<User> findByNombreNot(String nombre);
	
	//21. SELECT * FROM users WHERE nombre IN ('darwin','mario');
	public List<User> findByNombreIn (List<String> nombres);
	
	//22. SELECT * FROM users WHERE nombre NOT IN ('darwin' 'mario');
	public List<User> findByNombreNotIn(List<String> nombres);
		
	//23. SELECT * FROM users WHERE reporte = true;
	public List<User> findByReporteTrue();
	
	//24. SELECT * FROM users WHERE reporte = false;
	public List<User> findByReporteFalse();
	
	
	//24. SELECT * FROM users WHERE UPPER(nombre)=UPPER(NOMBRE);
	public List<User> findByNombreIgnoreCase(String nombre);
	
	
	
	
	
	
	
 	
	

}
