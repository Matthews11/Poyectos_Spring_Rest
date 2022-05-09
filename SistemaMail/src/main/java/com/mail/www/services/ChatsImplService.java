package com.mail.www.services;

import java.util.List;

import org.springframework.transaction.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mail.www.entity.Chats;
import com.mail.www.repositories.IChatsRepository;

@Service
public class ChatsImplService implements IChatsService{

	@Autowired
	private IChatsRepository chatsRepo;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Chats> listar() {
		return chatsRepo.findAll();
	}
	
	
	@Override
	@Transactional
	public Chats crear(Chats chats) {
		 return chatsRepo.save(chats);
	}

	
	@Override
	@Transactional(readOnly = true)
	public Chats comprobarE(Chats chats) {
		 return chatsRepo.findByMailE(chats.getMailE());
	}


	@Override
	@Transactional(readOnly=true)
	public Chats obtenerCategoria(Chats chats) {
		
		return chatsRepo.findByCategoriaAndMailR(chats.getCategoria(),chats.getMailR());
	}


	@Override
	@Transactional(readOnly=true)
	public Chats comprobarR(Chats chats) {
		chatsRepo.findByMailR(chats.getMailR());
		return null;
	}

	
	

}
