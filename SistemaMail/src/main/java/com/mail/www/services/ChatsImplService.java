package com.mail.www.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mail.www.entity.Chats;
import com.mail.www.repositories.IChatsRepository;
@Service

public class ChatsImplService implements IChatsService{

	@Autowired
	private IChatsRepository chatsRepo;
	
	@Transactional
	@Override
	public Chats crear(Chats chats) {
		 return chatsRepo.save(chats);
	}

	@Transactional
	@Override
	public Chats comprobar(Chats chats) {
		 return chatsRepo.findByMailE(chats.getMailE());
	}

}
