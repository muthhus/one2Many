package org.telekomatrix.data.service.Simple.data.Service.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ip_address")
public class IpAddress {
	
	@GeneratedValue
	@Id
	private Long id;
	
	@Column(name = "ip")
	private String ip;
	
	@Version
    private Long version;
	
	
	@OneToMany(mappedBy = "pk.ipAddress", cascade=CascadeType.ALL, orphanRemoval=true)
	private Set<DomainNameIpAddress> domainNames = new HashSet<>();

	public IpAddress() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IpAddress(String ip, Set<DomainNameIpAddress> domainNames) {
		super();
		this.ip = ip;
		this.domainNames = domainNames;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Set<DomainNameIpAddress> getDomainNames() {
		return domainNames;
	}

	public void setDomainNames(Set<DomainNameIpAddress> domainNames) {
		this.domainNames = domainNames;
	}
	
	
}
