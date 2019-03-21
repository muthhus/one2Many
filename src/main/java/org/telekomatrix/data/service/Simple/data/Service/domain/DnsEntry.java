package org.telekomatrix.data.service.Simple.data.Service.domain;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "dns_enttry")
@Entity
public class DnsEntry {
	
	@GeneratedValue
	@Id
	private Long id;
	
//	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@Fetch(FetchMode.SELECT)
//	@JoinColumn(name="domainName",referencedColumnName="ID")
//	@JsonManagedReference
//	private DomainName domainName;
//	
//	
//	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@Fetch(FetchMode.SELECT)
//	@JoinColumn(name="ipAddress",referencedColumnName="ID")
//	@JsonManagedReference
//	private IpAddress ipAddress;
	
	@OneToMany(mappedBy = "dnsEntry", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	private Set<DomainName> domainNames = new HashSet<>(0);
	
	@OneToMany(mappedBy = "dnsEntry", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	private Set<IpAddress> ipAddresses = new HashSet<>(0);
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "timestamp")
	private Date timestamp;
	
	@Version
    private Long version;

	public DnsEntry() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DnsEntry(Long id, Set<DomainName> domainNames, Set<IpAddress> ipAddresses, Date timestamp, Long version) {
		super();
		this.id = id;
		this.domainNames = domainNames;
		this.ipAddresses = ipAddresses;
		this.timestamp = timestamp;
		this.version = version;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<DomainName> getDomainNames() {
		return domainNames;
	}

	public void setDomainNames(Set<DomainName> domainNames) {
		this.domainNames = domainNames;
	}

	public Set<IpAddress> getIpAddresses() {
		return ipAddresses;
	}

	public void setIpAddresses(Set<IpAddress> ipAddresses) {
		this.ipAddresses = ipAddresses;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	
	
	

}
