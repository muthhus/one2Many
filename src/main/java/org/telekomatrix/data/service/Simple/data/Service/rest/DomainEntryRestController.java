package org.telekomatrix.data.service.Simple.data.Service.rest;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telekomatrix.data.service.Simple.data.Service.domain.DnsEntry;
import org.telekomatrix.data.service.Simple.data.Service.domain.DomainName;
import org.telekomatrix.data.service.Simple.data.Service.domain.IpAddress;
import org.telekomatrix.data.service.Simple.data.Service.repository.DnsEntryRepository;
import org.telekomatrix.data.service.Simple.data.Service.repository.DomainNameRepository;
import org.telekomatrix.data.service.Simple.data.Service.repository.IpAddressRepository;
import org.telekomatrix.data.service.Simple.data.Service.request.DnsEntryVO;

@RestController
@RequestMapping("/v1/domainEntries")
public class DomainEntryRestController {
	
	@Autowired
	private DnsEntryRepository dnsEntryRepository;
	
	@Autowired
	private DomainNameRepository domainNameRepository;
	
	@Autowired
	private IpAddressRepository ipAddressRepository;
	
	
	
	@PostMapping
	public ResponseEntity<DnsEntry> add(@RequestBody DnsEntryVO dnsEntryVO) {
		
		DnsEntry dnsEntry = new DnsEntry(null, null, null, null);
		
		BeanUtils.copyProperties(dnsEntryVO, dnsEntry);
		
		DomainName dname = new DomainName();
		dname.setDomainName(dnsEntryVO.getDomainName().getDomainName());
		domainNameRepository.save(dname);
		
		IpAddress ip = new IpAddress();
		ip.setIpAddress(dnsEntryVO.getIpAddress().getIpAddress());
		ipAddressRepository.save(ip);
		
		dnsEntry.setTimeStamp(new Date());
		dnsEntry.setDomainName(dname);
		dnsEntry.setIpAddress(ip);
		
		dnsEntryRepository.save(dnsEntry);
	
		
		return new ResponseEntity<>(dnsEntry, HttpStatus.CREATED);
	}

}
