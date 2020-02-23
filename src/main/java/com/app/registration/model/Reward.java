package com.app.registration.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reward")
public class Reward {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_reward")
	private long idReward;
	
	@Column(name="reward_code")
	private String rewardCode;
	
	@Column(name = "type")
	private String type;
	
	@Column(name="status")
	private long status;
	
	@Column(name="voucher_code")
	private long voucherCode;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="status", nullable = false, insertable = false, updatable = false)
	private Status status1;
	
	
	public Reward() {
		// TODO Auto-generated constructor stub
	}


	public Reward(long idReward, String rewardCode, String type, long status, long voucherCode, Status status1) {
		super();
		this.idReward = idReward;
		this.rewardCode = rewardCode;
		this.type = type;
		this.status = status;
		this.voucherCode = voucherCode;
		this.status1 = status1;
	}


	public long getIdReward() {
		return idReward;
	}


	public void setIdReward(long idReward) {
		this.idReward = idReward;
	}


	public String getRewardCode() {
		return rewardCode;
	}


	public void setRewardCode(String rewardCode) {
		this.rewardCode = rewardCode;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public long getStatus() {
		return status;
	}


	public void setIdStatus(long status) {
		this.status = status;
	}


	public long getVoucherCode() {
		return voucherCode;
	}


	public void setVoucherCode(long voucherCode) {
		this.voucherCode = voucherCode;
	}


	public Status getStatus1() {
		return status1;
	}


	public void setStatus1(Status status1) {
		this.status1 = status1;
	}

	@Override
	public String toString()
	{
		return "[type=" + type + ", status=" + status + ", " +
	            "id=" + idReward + ", reward_code=" + rewardCode + ", voucher_code=" + voucherCode + "]";
		}
		
			
}
