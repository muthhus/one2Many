package org.telekomatrix.data.service.Simple.data.Service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.telekomatrix.data.service.Simple.data.Service.domain.IpAddress;

public interface IpAddressRepository extends JpaRepository<IpAddress, Long> , JpaSpecificationExecutor<IpAddress>{

	IpAddress findByIpAddress(@Param("ipAddress") String ipAddress);
}
