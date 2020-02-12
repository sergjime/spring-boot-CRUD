package es.plexus.springboot.rest.service;

import java.util.List;

import es.plexus.springboot.rest.entity.Email;

public interface IEmailService {

	public List<Email> findAll();

	public Email findById(Long id);

	public Email save(Email email);

	public void delete(Long id);
}
