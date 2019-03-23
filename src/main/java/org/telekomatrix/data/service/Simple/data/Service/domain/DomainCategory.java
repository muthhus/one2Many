package org.telekomatrix.data.service.Simple.data.Service.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name ="domain_category")
public class DomainCategory implements Serializable {

	@EmbeddedId
	private DomainCategoryId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("domainId")
//	@JoinColumn(name = "domain", referencedColumnName = "domain_id", insertable = false, updatable = false)
//	@NotFound(action=NotFoundAction.IGNORE)
	private Domain domain;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("categoryId")
//	@JoinColumn(name = "category", referencedColumnName = "category_id", insertable = false, updatable = false)
//	@NotFound(action=NotFoundAction.IGNORE)
	private Category category;
	
	@Column(name = "created_on")
	private Date createdOn = new Date();
	
	

	public DomainCategory() {
		
	}

	public DomainCategory(Domain domain, Category category) {
		this.domain = domain;
		this.category = category;
		this.id = new DomainCategoryId(domain.getDomainId(), category.getCategoryId());
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
