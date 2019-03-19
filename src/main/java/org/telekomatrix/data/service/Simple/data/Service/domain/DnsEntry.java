package org.telekomatrix.data.service.Simple.data.Service.domain;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Table(name = "dns_enttry")
@Entity
public class DnsEntry {
	
	@GeneratedValue
	@Id
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "domain_name_id")
	private DomainName domainName;
	
	
	@ManyToOne
	@JoinColumn(name = "ip_address_id")
	private IpAddress ipAddress;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "timestamp")
	private Date timestamp;
	
	@Version
    private Long version;

	public DnsEntry() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DnsEntry(Long id, DomainName domainName, IpAddress ipAddress, Date timestamp) {
		super();
		this.id = id;
		this.domainName = domainName;
		this.ipAddress = ipAddress;
		this.timestamp = timestamp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getTimeStamp() {
		return timestamp;
	}

	public void setTimeStamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	
	
	

}
