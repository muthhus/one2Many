package org.telekomatrix.data.service.Simple.data.Service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.telekomatrix.data.service.Simple.data.Service.domain.DomainName;

public interface DomainNameRepository extends JpaRepository<DomainName, Long> , JpaSpecificationExecutor<DomainName>{

	DomainName findByDns(@Param("domainName") String domainName);
}
