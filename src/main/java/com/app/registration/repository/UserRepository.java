package com.app.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.registration.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByIdCustomer(long idCustomer);
	User findByUsername(String username);
}
