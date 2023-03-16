package com.virtualcommerce.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtualcommerce.backend.dto.CommerceDto;

@Repository
public interface CommerceRepository extends JpaRepository<CommerceDto, Long> {

	Optional<CommerceDto> findById(Integer id);
	
	Optional<CommerceDto> findByIdUser(Integer idUser);

}
