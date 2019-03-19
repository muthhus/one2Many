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

@Table(name="domain_name")
@Entity
public class DomainName {
	
	@GeneratedValue
	@Id
	private Long id;
	
	@Column
	private String domainName;
	
	@OneToMany(mappedBy = "domainName", cascade = CascadeType.ALL, orphanRemoval=true)
	private List<DnsEntry> dnsEntries = new ArrayList<DnsEntry>();
	
	@Version
    private Long version;

	public DomainName() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DomainName(Long id, String domainName, List<DnsEntry> dnsEntries) {
		super();
		this.id = id;
		this.domainName = domainName;
		this.dnsEntries = dnsEntries;
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

	public List<DnsEntry> getDnsEntries() {
		return dnsEntries;
	}

	public void setDnsEntries(List<DnsEntry> dnsEntries) {
		this.dnsEntries = dnsEntries;
	}
	
	public void addDnsEntry(DnsEntry dnsEntry) {
		dnsEntries.add(dnsEntry);
		dnsEntry.setDomainName(this);
		
	}
	
	public void removeDnsEntry(DnsEntry dnsEntry) {
		dnsEntries.add(dnsEntry);
		dnsEntry.setDomainName(null);
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	
	

}
