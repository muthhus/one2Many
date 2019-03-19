package org.telekomatrix.data.service.Simple.data.Service.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="domain")

public class Domain {
	
	@GeneratedValue
	@Id
	private Long id;
	
	@Column(name="domain_name")
	private String domainName;
	
	@Version
    private Long version;
	

	public Domain() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Domain(Long id, String domainName) {
		super();
		this.id = id;
		this.domainName = domainName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
		
	
	

}
