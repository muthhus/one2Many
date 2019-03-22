package org.telekomatrix.data.service.Simple.data.Service.domain;

import java.util.ArrayList;
import java.util.Iterator;
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
	
	@OneToMany(mappedBy = "domain", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DomainCategory> categories = new ArrayList<>();

	public Domain() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Domain(String domainName, Long version, List<DomainCategory> categories) {
		super();
		this.domainName = domainName;
		this.version = version;
		this.categories = categories;
	}


	public Long getDomainId() {
		return domainId;
	}

	public void setDomainId(Long domainId) {
		this.domainId = domainId;
	}


	public List<DomainCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<DomainCategory> categories) {
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
        DomainCategory domainCategory = new DomainCategory(this, category);
        categories.add(domainCategory);
        category.getDomains().add(domainCategory);
    }
 
    public void removeCategory(Category category) {
        for (Iterator<DomainCategory> iterator = categories.iterator();
             iterator.hasNext(); ) {
        	DomainCategory domainCategory = iterator.next();
 
            if (domainCategory.getDomain().equals(this) &&
            		domainCategory.getCategory().equals(category)) {
                iterator.remove();
                domainCategory.getCategory().getDomains().remove(domainCategory);
                domainCategory.setDomain(null);
                domainCategory.setCategory(null);
            }
        }
    }
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        Domain domain = (Domain) o;
        return Objects.equals(domainName, domain.domainName);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(domainName);
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
