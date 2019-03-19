package org.telekomatrix.data.service.Simple.data.Service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.telekomatrix.data.service.Simple.data.Service.domain.DnsEntry;

public interface DnsEntryRepository extends JpaRepository<DnsEntry, Long>, JpaSpecificationExecutor<DnsEntry>{

}
