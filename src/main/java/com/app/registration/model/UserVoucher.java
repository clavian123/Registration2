package com.app.registration.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_voucher")
public class UserVoucher {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_user_voucher")
	private long idUserVoucher;
	
	@Column(name="login_name")
	private String loginName;
	
	@Column(name="id_voucher")
	private long idVoucher;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@Column(name = "expiry_date")
	private Date expiryDate;
	
	@Column(name = "redeem_date")
	private Date redeemDate;
	
	@Column(name = "status")
	private long status;
	
	@Column(name="redeem_counter")
	private long redeemCounter;
	
	@Column(name = "cif_code")
	private String cifCode;
	

	public UserVoucher() {

	}

	public UserVoucher(long idUserVoucher, String loginName, long idVoucher, Date createdDate, Date expiryDate,
			Date redeemDate, long status, long redeemCounter, String cifCode) {
		super();
		this.idUserVoucher = idUserVoucher;
		this.loginName = loginName;
		this.idVoucher = idVoucher;
		this.createdDate = createdDate;
		this.expiryDate = expiryDate;
		this.redeemDate = redeemDate;
		this.status = status;
		this.redeemCounter = redeemCounter;
		this.cifCode = cifCode;
	}

	public long getIdUserVoucher() {
		return idUserVoucher;
	}

	public void setIdUserVoucher(long idUserVoucher) {
		this.idUserVoucher = idUserVoucher;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public long getIdVoucher() {
		return idVoucher;
	}

	public void setIdVoucher(long idVoucher) {
		this.idVoucher = idVoucher;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Date getRedeemDate() {
		return redeemDate;
	}

	public void setRedeemDate(Date redeemDate) {
		this.redeemDate = redeemDate;
	}

	public long getStatus() {
		return status;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	public long getRedeemCounter() {
		return redeemCounter;
	}

	public void setRedeemCounter(long redeemCounter) {
		this.redeemCounter = redeemCounter;
	}

	public String getCifCode() {
		return cifCode;
	}

	public void setCifCode(String cifCode) {
		this.cifCode = cifCode;
	}


}
