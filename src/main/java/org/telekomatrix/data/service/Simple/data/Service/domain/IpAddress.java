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
@Table(name = "ip_address")
public class IpAddress {
	
	@GeneratedValue
	@Id
	private Long id;
	
	@Column(name = "ip_address")
	private String ipAddress;
	
	@OneToMany(mappedBy = "ipAddress", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<DnsEntry> dnsEntries = new ArrayList<DnsEntry>();
	
	@Version
    private Long version;

	public IpAddress() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IpAddress(Long id, String ipAddress, List<DnsEntry> dnsEntries) {
		super();
		this.id = id;
		this.ipAddress = ipAddress;
		this.dnsEntries = dnsEntries;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<DnsEntry> getDnsEntries() {
		return dnsEntries;
	}

	public void setDnsEntries(List<DnsEntry> dnsEntries) {
		this.dnsEntries = dnsEntries;
	}
	
	public void addDnsEntry(DnsEntry dnsEntry) {
		dnsEntries.add(dnsEntry);
		dnsEntry.setIpAddress(this);
	}
	
	public void removeDnsEntry(DnsEntry dnsEntry) {
		dnsEntries.add(dnsEntry);
		dnsEntry.setIpAddress(null);
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	
	
	

}
