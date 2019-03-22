package org.telekomatrix.data.service.Simple.data.Service.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;



@Entity
@Table(name = "category")
@NaturalIdCache
@Cache(
    usage = CacheConcurrencyStrategy.READ_WRITE
)
public class Category {
	
	@GeneratedValue
	@Id
	private Long categoryId;
	
	@Column(name = "category_name")
	@NaturalId
	private String categoryName;
	
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
//	@JsonManagedReference
	private List<DomainCategory> domains = new ArrayList<>();
	
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

	public List<DomainCategory> getDomains() {
		return domains;
	}

	public void setDomains(List<DomainCategory> domains) {
		this.domains = domains;
	}




//	http://webdev.jhuep.com/~jcs/ejava-javaee/coursedocs/content/html/jpa-relationex-one2many-bi.html
	

}
