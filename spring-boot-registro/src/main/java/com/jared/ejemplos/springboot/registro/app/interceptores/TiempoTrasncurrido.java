package com.jared.ejemplos.springboot.registro.app.interceptores;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component ("tiempoTrasncurrido")
public class TiempoTrasncurrido implements HandlerInterceptor{
	
	private static final Logger logger = LoggerFactory.getLogger(TiempoTrasncurrido.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if (request.getMethod().equalsIgnoreCase("post"))
		{
			return true;
		}
		
		logger.info("TiempoTrasncurrido: preHandler () entrando ...");
		long tiempo = System.currentTimeMillis();
		request.setAttribute("tiempo", tiempo);
		
		Random random = new Random (); 
		Integer demora= random.nextInt(500);
		Thread.sleep(demora);
		
		response.sendRedirect(request.getContextPath().concat("/login"));
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		
		if (request.getMethod().equalsIgnoreCase("post"))
		{
			return;
		}
		long tiempofin = System.currentTimeMillis();
		long tiempo = (Long) request.getAttribute("tiempo");
		long tiempoTranscurrido=  tiempofin- tiempo;
		
		if (modelAndView !=null)
		{
			modelAndView.addObject("ttiempoTranscurrido",tiempoTranscurrido );
			
		}
		
		logger.info("Tiempo transcurrido : "+ tiempoTranscurrido+" milisegundos");
		logger.info("TiempoTrasncurrido: posHandler () saliendo ...");
		 
	}
	
	

}
