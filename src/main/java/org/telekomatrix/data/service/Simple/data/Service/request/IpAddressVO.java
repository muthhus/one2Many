package org.telekomatrix.data.service.Simple.data.Service.request;

import java.util.List;

public class IpAddressVO {
	
	private String id;
	
	private String ipAddress;
	
	private List<DnsEntryVO> dnsEntryList;

	public IpAddressVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IpAddressVO(String id, String ipAddress, List<DnsEntryVO> dnsEntryList) {
		super();
		this.id = id;
		this.ipAddress = ipAddress;
		this.dnsEntryList = dnsEntryList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public List<DnsEntryVO> getDnsEntryList() {
		return dnsEntryList;
	}

	public void setDnsEntryList(List<DnsEntryVO> dnsEntryList) {
		this.dnsEntryList = dnsEntryList;
	}

	
}
