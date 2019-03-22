package org.telekomatrix.data.service.Simple.data.Service.domain;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name ="domain_category")
public class DomainCategory {

	@EmbeddedId
	private DomainCategoryId id;
	
	@ManyToOne
	@MapsId("domainId")
	private Domain domain;
	
	@ManyToOne
	@MapsId("categoryId")
	private Category category;

	public DomainCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Domain getDomain() {
		return domain;
	}


	public void setDomain(Domain domain) {
		this.domain = domain;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public DomainCategory(Domain domain, Category category) {
		super();
		this.domain = domain;
		this.category = category;
	}
	
	@Override
	public boolean equals(Object o) {
	if (this == o) return true;
	if (o == null || getClass() != o.getClass()) return false;
	DomainCategory that = (DomainCategory) o;
	return Objects.equals(domain, that.domain) &&
	Objects.equals(category, that.category);
	}
	@Override
	public int hashCode() {
	return Objects.hash(domain, category);
	}
}
