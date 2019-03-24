package org.telekomatrix.data.service.Simple.data.Service.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

@Table(name="domain_name")
@Entity
public class DomainName {
	
	@GeneratedValue
	@Id
	private Long id;
	
	@Column
	private String dns;
	
	@Version
    private Long version;
	
	@OneToMany(mappedBy = "pk.domainName", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<DomainNameIpAddress> domainNameIpAddress = new HashSet<>();

	public DomainName() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public DomainName(String dns, Set<DomainNameIpAddress> domainNameIpAddress) {
		super();
		this.dns = dns;
		this.domainNameIpAddress = domainNameIpAddress;
	}



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Set<DomainNameIpAddress> getDomainNameIpAddress() {
		return domainNameIpAddress;
	}


	public void setDomainNameIpAddress(Set<DomainNameIpAddress> domainNameIpAddress) {
		this.domainNameIpAddress = domainNameIpAddress;
	}


	public String getDns() {
		return dns;
	}

	public void setDns(String dns) {
		this.dns = dns;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}	
	
	
	

}
