package org.telekomatrix.data.service.Simple.data.Service.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telekomatrix.data.service.Simple.data.Service.domain.DnsEntry;
import org.telekomatrix.data.service.Simple.data.Service.domain.DomainName;
import org.telekomatrix.data.service.Simple.data.Service.domain.DomainNameIpAddress;
import org.telekomatrix.data.service.Simple.data.Service.domain.IpAddress;
import org.telekomatrix.data.service.Simple.data.Service.domain.RequestSourceType;
import org.telekomatrix.data.service.Simple.data.Service.repository.DnsEntryRepository;
import org.telekomatrix.data.service.Simple.data.Service.repository.DomainNameRepository;
import org.telekomatrix.data.service.Simple.data.Service.repository.IpAddressRepository;
import org.telekomatrix.data.service.Simple.data.Service.request.DnsEntryVO;

@RestController
@RequestMapping("v1/dnsEntries")
public class DomainEntryRestController {
	
	@Autowired
	private DnsEntryRepository dnsEntryRepository;
	
	@Autowired
	private DomainNameRepository domainNameRepository;
	
	@Autowired
	private IpAddressRepository ipAddressRepository;
	
	
	
	@PostMapping
	public ResponseEntity<DnsEntry> add(@RequestBody DnsEntryVO dnsEntryVO) {
		
		DnsEntry dnsEntry = new DnsEntry(null, null, 1l, null);
		
		DomainName domainName = domainNameRepository.findByDns(dnsEntryVO.getDomainName().getDns());
		
		if(domainName == null) {
			domainName = new DomainName();
		}
		domainName.setDns(dnsEntryVO.getDomainName().getDns());
		
		IpAddress ip = ipAddressRepository.findByIp(dnsEntryVO.getIpAddress().getIpAddress());
		
		if(ip == null) {
			ip = new IpAddress();
		}
	
		ip.setIp(dnsEntryVO.getIpAddress().getIpAddress());
		
		Date date = new Date();
		dnsEntry.setTimpstamp(date.getTime());
		dnsEntry.setDomainName(domainName);
		dnsEntry.setIpAddress(ip);
		dnsEntry.setRequestSourceType(RequestSourceType.HTTP);
		
		dnsEntry.setDomainName(domainName);
		dnsEntry.setIpAddress(ip);
		dnsEntryRepository.save(dnsEntry);
		
		DomainNameIpAddress domainNameIpAddress = new DomainNameIpAddress();
		domainNameIpAddress.setDomainName(dnsEntry.getDomainName());
		domainNameIpAddress.setIpAddress(dnsEntry.getIpAddress());
		domainNameIpAddress.setCreatedDate(new Date());
		domainNameIpAddress.setCreatedBy("System");
				
		dnsEntry.getDomainName().getDomainNameIpAddress().add(domainNameIpAddress);
		domainNameRepository.save(domainName);
		
		return new ResponseEntity<>(dnsEntry, HttpStatus.CREATED);
		
	}
	
	@GetMapping
	public ResponseEntity<List<DnsEntry>> getAll() {
		return new ResponseEntity<>(dnsEntryRepository.findAll(), HttpStatus.OK);
	}

}
