package es.plexus.springboot.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.plexus.springboot.rest.entity.Email;

public interface IEmailRepository extends JpaRepository<Email, Long>{

}
