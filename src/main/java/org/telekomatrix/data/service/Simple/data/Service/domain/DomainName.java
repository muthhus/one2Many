package org.telekomatrix.data.service.Simple.data.Service.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="domain_name")
@Entity

public class DomainName {
	
	@GeneratedValue
	@Id
	private Long id;
	
	@Column
	private String domainName;
	
//	@OneToMany(mappedBy = "domainName", cascade = CascadeType.ALL, orphanRemoval=true)
//	private List<DnsEntry> dnsEntries = new ArrayList<DnsEntry>();
	
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn(name="dns_entry_id")
	private DnsEntry dnsEntry;
	
//	@OneToMany(mappedBy = "domainName", cascade = CascadeType.ALL, orphanRemoval=true)
//	private Set<IpAddress> ipAddresses = new HashSet<>();
	
	@Version
    private Long version;

	public DomainName() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DomainName(Long id, String domainName, DnsEntry dnsEntry, Long version) {
		super();
		this.id = id;
		this.domainName = domainName;
		this.dnsEntry = dnsEntry;
		this.version = version;
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

	public DnsEntry getDnsEntry() {
		return dnsEntry;
	}

	public void setDnsEntry(DnsEntry dnsEntry) {
		this.dnsEntry = dnsEntry;
	}


	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}	
	
	
	

}
