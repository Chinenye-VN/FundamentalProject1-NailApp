package com.qa.fundamentalproject.repo;

import com.qa.fundamentalproject.domain.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment,Long> {
}
