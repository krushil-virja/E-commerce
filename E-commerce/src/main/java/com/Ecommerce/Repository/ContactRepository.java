package com.Ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
