package org.telekomatrix.data.service.Simple.data.Service.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name = "category")
public class Category implements Serializable {
	
	@GeneratedValue
	@Id
	@Column(name = "category_id")
	private Long categoryId;
	
	@Column(name = "category_name", nullable = false)
	@NaturalId
	private String categoryName;
	
	
	@OneToMany(mappedBy = "pk.category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	private Set<DomainCategory> domains = new HashSet<>();
	
	@Version
    private Long version;
	
	@CreationTimestamp
	private Date createdAt;

	public Category() {
		
	}

	public Category(String categoryName, Set<DomainCategory> domains) {
		this.categoryName = categoryName;
		this.domains = domains;
		
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
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(categoryName, category.categoryName);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(categoryName);
    }

	public Set<DomainCategory> getDomains() {
		return domains;
	}

	public void setDomains(Set<DomainCategory> domains) {
		this.domains = domains;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
		

}
