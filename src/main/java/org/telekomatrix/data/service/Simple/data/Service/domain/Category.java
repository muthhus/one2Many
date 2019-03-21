package org.telekomatrix.data.service.Simple.data.Service.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;



@Entity
@Table(name = "category")

public class Category {
	
	@GeneratedValue
	@Id
	private Long id;
	
	@Column(name = "category_name")
	private String categoryName;
	
//	@OneToMany
//	@JoinTable(
//			name = "category_domain",
//			joinColumns = @JoinColumn(name="category_id"),
//			inverseJoinColumns = @JoinColumn(name = "domain_id")
//	)
//	private Set<Domain> domains = new HashSet();
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Domain_Category> domains = new ArrayList<>();
	
	
	
	public List<Domain_Category> getDomains() {
		return domains;
	}

	public void setDomains(List<Domain_Category> domains) {
		this.domains = domains;
	}

	@Version
    private Long version;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(Long id, String categoryName) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	
	

}
