package org.telekomatrix.data.service.Simple.data.Service.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
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
	
	@OneToMany(mappedBy = "domain", cascade = CascadeType.ALL, orphanRemoval = true)
	@OrderColumn(name = "entry")
	private List<Domain_Category> categories = new ArrayList<>();

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
	
	public void addCategory(Domain_Category category) {
		categories.add(category);
//		category.getDomain().add(this);
	}
	
	public void removeCategory(Category category) {
		categories.remove(category);
		category.getDomains().remove(this);
	}
		
	
	public void removeTag(Category category) {
		for (Iterator<Domain_Category> iterator = categories.iterator(); iterator.hasNext(); ) {
		Domain_Category domainCategory = iterator.next();
		if (domainCategory.getDomain().equals(this) && domainCategory.getCategory().equals(category)) {
		iterator.remove();
		domainCategory.getCategory().getDomains().remove(domainCategory);
		domainCategory.setDomain(null);
		domainCategory.setCategory(null);
		break;
		}
		}
		}
	

}
