package org.telekomatrix.data.service.Simple.data.Service.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="domain")

public class Domain {
	
	@GeneratedValue
	@Id
	private Long domainId;
	
	@Column(name="domain_name")
	private String domainName;
	
	@Version
    private Long version;
	
//	@OneToMany(mappedBy = "domain", cascade = CascadeType.ALL, orphanRemoval = true)
//	@OrderColumn(name = "entry")
	@ManyToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE } )
	@JoinTable(
			name = "domain_category_map",
			joinColumns = @JoinColumn(name="domain_id"),
			inverseJoinColumns = @JoinColumn(name = "category_id"))
	@JsonBackReference
	private List<Category> categories = new ArrayList<>();

	public Domain() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Domain(Long id, String domainName) {
		super();
		this.domainId = domainId;
		this.domainName = domainName;
	}



	public Long getDomainId() {
		return domainId;
	}

	public void setDomainId(Long domainId) {
		this.domainId = domainId;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
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
	
	public void addCategory(Category category) {
		categories.add(category);
		category.getDomains().add(this);
	}
	
	public void removeCategory(Category category) {
		categories.remove(category);
		category.getDomains().remove(this);
	}
		
	
//	public void removeCategory(Category category) {
//		for (Iterator<DomainCategory> iterator = categories.iterator(); iterator.hasNext(); ) {
//		DomainCategory domainCategory = iterator.next();
//		if (domainCategory.getDomain().equals(this) && domainCategory.getCategory().equals(category)) {
//		iterator.remove();
//		domainCategory.getCategory().getDomains().remove(domainCategory);
//		domainCategory.setDomain(null);
//		domainCategory.setCategory(null);
//		break;
//		}
//		}
//		}
//	

}
