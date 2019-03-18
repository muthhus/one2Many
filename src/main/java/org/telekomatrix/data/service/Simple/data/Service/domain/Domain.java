package org.telekomatrix.data.service.Simple.data.Service.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="domain")

public class Domain {
	
	@GeneratedValue
	@Id
	private Long id;
	
	@Column(name="domain_name")
	private String domainName;
	

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
		
	

}
