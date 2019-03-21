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

@Entity
@Table(name = "ip_address")

public class IpAddress {
	
	@GeneratedValue
	@Id
	private Long id;
	
	@Column(name = "ip_address")
	private String ipAddress;
	
//	@OneToMany(mappedBy = "ipAddress", cascade=CascadeType.ALL, orphanRemoval=true)
//	private List<DnsEntry> dnsEntries = new ArrayList<DnsEntry>();
	
	@Version
    private Long version;
	
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn(name="dns_entry_id")
	private DnsEntry dnsEntry;
	
//	@OneToMany(mappedBy = "ipAddress", cascade=CascadeType.ALL, orphanRemoval=true)
//	private Set<DomainName> domainNames = new HashSet<>();

	public IpAddress() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IpAddress(Long id, String ipAddress, Long version, DnsEntry dnsEntry) {
		super();
		this.id = id;
		this.ipAddress = ipAddress;
		this.version = version;
		this.dnsEntry = dnsEntry;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public DnsEntry getDnsEntry() {
		return dnsEntry;
	}

	public void setDnsEntry(DnsEntry dnsEntry) {
		this.dnsEntry = dnsEntry;
	}



	
	

}
