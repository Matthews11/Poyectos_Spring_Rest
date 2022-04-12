package com.mail.www.repositories;
 

import org.springframework.data.jpa.repository.JpaRepository; 

import com.mail.www.entity.Chats;

public interface IChatsRepository extends JpaRepository<Chats, Long>{
	
	 
	public Chats findByMailE(String mail);

}
