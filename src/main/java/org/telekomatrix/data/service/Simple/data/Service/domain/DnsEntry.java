package org.telekomatrix.data.service.Simple.data.Service.domain;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Table(name = "dns_entry")
@Entity
public class DnsEntry {
	
	@GeneratedValue
	@Id
	private Long dnsEntryId;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	@JsonBackReference
	private DomainName domainName;
	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	@JsonBackReference
	private IpAddress ipAddress;
	
	private long timpstamp;
	
	@NotNull(message="Request Source Type can't be empty")
	@Column(name = "requestSourceType", nullable = false, length = 6)
	@Enumerated(EnumType.STRING)
	private RequestSourceType requestSourceType;
	
	@Version
    private Long version;

	public DnsEntry() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public DnsEntry(DomainName domainName, IpAddress ipAddress, long timpstamp,
			@NotNull(message = "Request Source Type can't be empty") RequestSourceType requestSourceType) {
		super();
		this.domainName = domainName;
		this.ipAddress = ipAddress;
		this.timpstamp = timpstamp;
		this.requestSourceType = requestSourceType;
	}


	public Long getDnsEntryId() {
		return dnsEntryId;
	}

	public void setDnsEntryId(Long dnsEntryId) {
		this.dnsEntryId = dnsEntryId;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public DomainName getDomainName() {
		return domainName;
	}

	public void setDomainName(DomainName domainName) {
		this.domainName = domainName;
	}

	public IpAddress getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(IpAddress ipAddress) {
		this.ipAddress = ipAddress;
	}

	public long getTimpstamp() {
		return timpstamp;
	}

	public void setTimpstamp(long timpstamp) {
		this.timpstamp = timpstamp;
	}

	public RequestSourceType getRequestSourceType() {
		return requestSourceType;
	}

	public void setRequestSourceType(RequestSourceType requestSourceType) {
		this.requestSourceType = requestSourceType;
	}

}
