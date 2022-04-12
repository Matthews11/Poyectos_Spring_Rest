package com.mail.www.repositories;
 
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

import com.mail.www.entity.Usuarios;

@Repository

public interface IUsuarioRepository extends JpaRepository<Usuarios, Long>{
	
	public Usuarios findByMailAndContrasena(String mail, String contrasena);
	
	public Usuarios findByMail(String mail);

}
