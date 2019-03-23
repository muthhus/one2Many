package org.telekomatrix.data.service.Simple.data.Service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.telekomatrix.data.service.Simple.data.Service.domain.Domain;

public interface DomainRepository extends JpaRepository<Domain, Long>, JpaSpecificationExecutor<Domain> {
	
	Domain findByDomainName(@Param("domainName") String domainName);
}
