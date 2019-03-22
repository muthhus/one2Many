package org.telekomatrix.data.service.Simple.data.Service.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name = "category")

public class Category {
	
	@GeneratedValue
	@Id
	private Long categoryId;
	
	@Column(name = "category_name")
	private String categoryName;
	
//	@OneToMany
//	@JoinTable(
//			name = "category_domain",
//			joinColumns = @JoinColumn(name="category_id"),
//			inverseJoinColumns = @JoinColumn(name = "domain_id")
//	)
//	private Set<Domain> domains = new HashSet();
	
//	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
	@ManyToMany( fetch = FetchType.LAZY, mappedBy = "categories", cascade = CascadeType.ALL  )
	@JsonManagedReference
	private List<Domain> domains = new ArrayList<>();
	
	@Version
    private Long version;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(Long categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		
	}

	
	

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
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

	public List<Domain> getDomains() {
		return domains;
	}

	public void setDomains(List<Domain> domains) {
		this.domains = domains;
	}


//	http://outbottle.com/java-hibernate-manytomany-tutorial-with-add-and-delete-examples/
	

}
