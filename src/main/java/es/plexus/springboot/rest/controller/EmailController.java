package es.plexus.springboot.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.plexus.springboot.rest.entity.Email;
import es.plexus.springboot.rest.service.IEmailService;

@RestController
@RequestMapping("/api")
public class EmailController {

	@Autowired
	private IEmailService emailService;
	
	@GetMapping("/correos")
	public List<Email> showEmails() {
		return emailService.findAll();
	}
	
	@GetMapping("/correos/{id}")
	public Email showEmail(@PathVariable Long id) {
		return emailService.findById(id);
	}
	
	@PostMapping("/correos")
	@ResponseStatus(HttpStatus.CREATED)
	public Email create(@RequestBody Email email) {
		return emailService.save(email);
	}
	
	@PutMapping("/correos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Email update(@RequestBody Email email, @PathVariable Long id) {
		Email emailActual = emailService.findById(id);
		
		emailActual.setSubject(email.getSubject());
		emailActual.setMessage(email.getMessage());
		emailActual.setSender(email.getSender());
		emailActual.setAddressee(email.getAddressee());
		
		
		return emailService.save(emailActual);
	}
	
	@DeleteMapping("/correos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		emailService.delete(id);
	}
}
