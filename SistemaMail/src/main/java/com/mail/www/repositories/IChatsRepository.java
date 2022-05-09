package com.mail.www.repositories;
 

import org.springframework.data.jpa.repository.JpaRepository; 

import com.mail.www.entity.Chats;

public interface IChatsRepository extends JpaRepository<Chats, Long>{
	
	 
	public Chats findByMailE(String mail);
	
	public Chats findByMailR(String mail);
	
	public Chats findByCategoriaAndMailR(String categoria, String mail);
	

}
