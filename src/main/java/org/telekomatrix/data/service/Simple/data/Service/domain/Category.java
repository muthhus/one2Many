package org.telekomatrix.data.service.Simple.data.Service.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "category")

public class Category {
	
	@GeneratedValue
	@Id
	private Long id;
	
	@Column(name = "category_name")
	private String categoryName;
	
	@OneToMany
	@JoinTable(
			name = "category_domain",
			joinColumns = @JoinColumn(name="category_id"),
			inverseJoinColumns = @JoinColumn(name = "domain_id")
	)
	private Set<Domain> domains = new HashSet();

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

	public Set<Domain> getDomains() {
		return domains;
	}

	public void setDomains(Set<Domain> domains) {
		this.domains = domains;
	}
	
	

}
