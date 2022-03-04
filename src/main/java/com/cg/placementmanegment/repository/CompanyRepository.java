package com.cg.placementmanegment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.placementmanegment.model.Company;


@Repository
public interface CompanyRepository extends JpaRepository <Company, Long>{

}
