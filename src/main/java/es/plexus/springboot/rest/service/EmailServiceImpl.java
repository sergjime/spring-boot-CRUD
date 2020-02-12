package es.plexus.springboot.rest.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import es.plexus.springboot.rest.entity.Email;
import es.plexus.springboot.rest.repository.IEmailRepository;

@RestController
@RequestMapping("/api")
public class EmailServiceImpl implements IEmailService {
	
	@Autowired
	private IEmailRepository emailRepository;

	@Transactional(readOnly = true)
	public List<Email> findAll() {
		return emailRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Email findById(Long id) {
		return emailRepository.findById(id).orElse(null);
	}

	@Transactional
	public Email save(Email cliente) {
		return emailRepository.save(cliente);
	}

	@Transactional
	public void delete(Long id) {
		emailRepository.deleteById(id);
	}

}
