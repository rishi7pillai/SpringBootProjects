package com.smartmanager.smartmanager.dao;

import com.smartmanager.smartmanager.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactDao extends JpaRepository<Contact,Integer> {

}
