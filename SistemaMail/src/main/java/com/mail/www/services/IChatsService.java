package com.mail.www.services;

import java.util.List;

import com.mail.www.entity.Chats;

public interface IChatsService {
	
	public Chats crear(Chats chats);
	
	public Chats comprobarE (Chats chats);
	
	public Chats comprobarR (Chats chats);
	
	public List<Chats>listar();
	
	public Chats obtenerCategoria(Chats chats);
	
	public void eliminar(long id);
}
