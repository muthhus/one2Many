package org.telekomatrix.data.service.Simple.data.Service.domain;

import java.io.Serializable;
import java.sql.Timestamp;
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
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="domain")
public class Domain implements Serializable {
	
	@GeneratedValue
	@Id
	@Column(name = "domain_id")
	private Long domainId;
	
	@Column(name="domain_name", nullable = false)
	private String domainName;
	
	@Version
    private Long version;
	
	@CreationTimestamp
	private Timestamp timpstamp;
	
	@UpdateTimestamp
	private Date updatedTimestamp;
	
	@OneToMany(mappedBy = "pk.domain", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Fetch(FetchMode.SELECT)
	@JsonManagedReference
	private Set<DomainCategory> domainCategories = new HashSet<>();

	public Domain() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Domain(String domainName, Set<DomainCategory> domainCategories) {
		super();
		this.domainName = domainName;
		this.domainCategories = domainCategories;
	}


	public Long getDomainId() {
		return domainId;
	}

	public void setDomainId(Long domainId) {
		this.domainId = domainId;
	}


	public Set<DomainCategory> getDomainCategories() {
		return domainCategories;
	}

	public void setDomainCategories(Set<DomainCategory> domainCategories) {
		this.domainCategories = domainCategories;
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

	
	public void addCategory(Category category) {
        DomainCategory domainCategory = new DomainCategory();
        domainCategories.add(domainCategory);
    	domainCategory.setCreatedDate(new Date());
		domainCategory.setCreatedBy("System");
        category.getDomains().add(domainCategory);
    }


}
