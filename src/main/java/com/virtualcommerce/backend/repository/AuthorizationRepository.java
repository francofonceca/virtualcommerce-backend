package com.virtualcommerce.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtualcommerce.backend.dto.UserDto;

@Repository
public interface AuthorizationRepository extends JpaRepository<UserDto, Long> {

	Optional<UserDto> findById(Integer id);

	Optional<UserDto> findByEmail(String email);
}
