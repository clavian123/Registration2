package com.app.registration.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="voucher")
public class Voucher {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	@Column(name="id_voucher")
	private long idVoucher;
	
	@Column(name="voucher_code")
	private String voucherCode;
	
	@Column(name="type")
	private String type;
	
	@Column(name="max_redeem")
	private long maxRedeem;
	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="end_date")
	private Date endDate;
	
	@Column(name="amount")
	private long amount;
	
	@Column(name="description")
	private String description;
	
	@Column(name="id_status")
	private long idStatus;
	
	
	@ManyToOne
	@JoinColumn(name="id_status",nullable = false, insertable = false, updatable = false)
	private Status status2;

	
	

	public Voucher() {
	}

	public Voucher(long idVoucher, String voucherCode, String type, long maxRedeem, Date startDate, Date endDate,
			long amount, String description, long idStatus, Status status2) {
		super();
		this.idVoucher = idVoucher;
		this.voucherCode = voucherCode;
		this.type = type;
		this.maxRedeem = maxRedeem;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
		this.description = description;
		this.idStatus = idStatus;
		this.status2 = status2;
	}

	public long getIdVoucher() {
		return idVoucher;
	}

	public void setIdVoucher(long idVoucher) {
		this.idVoucher = idVoucher;
	}

	public String getVoucherCode() {
		return voucherCode;
	}

	public void setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getMaxRedeem() {
		return maxRedeem;
	}

	public void setMaxRedeem(long maxRedeem) {
		this.maxRedeem = maxRedeem;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(long idStatus) {
		this.idStatus = idStatus;
	}

	public Status getStatus2() {
		return status2;
	}

	public void setStatus2(Status status2) {
		this.status2 = status2;
	}

		
}
