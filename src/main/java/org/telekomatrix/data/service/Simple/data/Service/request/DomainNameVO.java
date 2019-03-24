package org.telekomatrix.data.service.Simple.data.Service.request;

import java.util.List;

public class DomainNameVO {

	private String id;
	
	private String dns;
	
	private List<DnsEntryVO> dnsEntryList;

	public DomainNameVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DomainNameVO(String id, String dns, List<DnsEntryVO> dnsEntryList) {
		super();
		this.id = id;
		this.dns = dns;
		this.dnsEntryList = dnsEntryList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDns() {
		return dns;
	}

	public void setDns(String dns) {
		this.dns = dns;
	}

	public List<DnsEntryVO> getDnsEntryList() {
		return dnsEntryList;
	}

	public void setDnsEntryList(List<DnsEntryVO> dnsEntryList) {
		this.dnsEntryList = dnsEntryList;
	}

	
	
}
