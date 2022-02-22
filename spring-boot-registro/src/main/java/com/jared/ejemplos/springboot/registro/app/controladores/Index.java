package com.jared.ejemplos.springboot.registro.app.controladores;

import java.awt.List;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.jared.ejemplos.springboot.registro.app.editora.NombreEditor;
import com.jared.ejemplos.springboot.registro.app.editora.PaisPropertyEditor;
import com.jared.ejemplos.springboot.registro.app.editora.RolesEditor;
import com.jared.ejemplos.springboot.registro.app.modelo.Cliente;
import com.jared.ejemplos.springboot.registro.app.modelo.Pais;
import com.jared.ejemplos.springboot.registro.app.models.domain.Role; 
import com.jared.ejemplos.springboot.registro.app.service.PaisService;
import com.jared.ejemplos.springboot.registro.app.service.RoleService;
import com.jared.ejemplos.springboot.registro.app.validation.ClienteValidacion;

@Controller
@SessionAttributes("cliente")
public class Index {

	@Autowired
	private ClienteValidacion validacion;
	
	
	@Autowired
	private PaisService paisService;

	@Autowired
	private PaisPropertyEditor paisEditor;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private RolesEditor rol;
	
	// validacion
	@InitBinder
	public void initBinder(WebDataBinder binder) {// valida los campos
		binder.addValidators(validacion);
		SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "fechaNacimiento", new CustomDateEditor(DateFormat, false));

		binder.registerCustomEditor(String.class, "nombre", new NombreEditor());
		binder.registerCustomEditor(String.class, "apellido", new NombreEditor());
		binder.registerCustomEditor(Pais.class, "pais",paisEditor);
		binder.registerCustomEditor(Role.class, "roles", rol);

	}

	@GetMapping("/formulario")
	public String inicio(Model model) {
		Cliente client = new Cliente();

		client.setNombre("Jared");
		client.setId("12.458.168-K");
		client.setHabilitar(true);
		client.setValorSecreto("Algun valor");
		client.setPais( new Pais(3, "I", "Italia"));
		client.setRoles(Arrays.asList(new Role (1,"Cliente VIP","VIP")));
		model.addAttribute("titulo", "Formulario de registro");
		model.addAttribute("cliente", client);

		return "formulario";
	}

	@PostMapping("/formulario")
	public String proceso(@Valid Cliente client, BindingResult validar, Model model) {

		// validacion.validate(client, validar);

		if (validar.hasErrors()) {
			model.addAttribute("titulo", "Formulario de registro"); 
			return "formulario";

		} else {
			  
			return "redirect:/ver";
		}

	}
	@GetMapping("/ver")
	public String ver (@SessionAttribute(name="cliente",required=false)Cliente client, Model model, SessionStatus status)
	{
		if (client == null)
		{
			return "redirect:/formulario";
		}
		
		model.addAttribute("titulo", "Sus datos personales son ");
		status.setComplete();
		return "resultado";
		
	}
	
	
	@ModelAttribute("genero")
	public java.util.List<String> genero()
	{
		return Arrays.asList("Hombre","Mujer");
	}

	@ModelAttribute("ListaPaises")
	public java.util.List<Pais> ListaPaises()
	{
		return Arrays.asList( 
				new Pais (1,"ES","Espana"),
				new Pais (2,"MX","Mexico"),
				new Pais(3,"I","Italia"));
	}

	@ModelAttribute("paises")
	public java.util.List<String> paises() {
		return Arrays.asList("Espana", "Mexico", "Italia");
	}

	@ModelAttribute("paisesMap")
	public Map<String, String> paisesMap() {
		Map<String, String> paises = new HashMap<String, String>();
		paises.put("ES", "Espana");
		paises.put("MX", "Mexico");
		paises.put("CL", "Chile");
		paises.put("ESA", "El Salvador");
		return paises;
	}

	@ModelAttribute("ROL")
	public java.util.List<String> listaRoles()
	{
		
		java.util.List<String> roles = new ArrayList<>();
		roles.add("Cliente frecuente");
		roles.add("Cliente VIP");
		roles.add("Cliente Nuevo");
		return roles;
		
	}
	
	@ModelAttribute("RolMap")
	public Map<String, String> rolMap() {
		Map<String, String> roles = new HashMap<String, String>();
		roles.put("VIP", "Cliente VIP");
		roles.put("NEW", "Cliente Nuevo");
		roles.put("FRECUENTE", "Cliente Frecuente"); 
		return 		roles;
	}
	
	
	@ModelAttribute("Roles")
	public java.util.List<Role> ROL()
	{
		return this.roleService.listar();
	}
	
}
