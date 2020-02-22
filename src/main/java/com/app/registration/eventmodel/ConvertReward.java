package com.app.registration.eventmodel;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"type",
	"status",
	"id",
	"voucher_code",
	"reward_code"
})
public class ConvertReward {
	@JsonProperty("type")
	private String type;
	@JsonProperty("status")
	private Integer status;
	@JsonProperty("id")
	private Integer id;
	@JsonProperty("voucher_code")
	private Integer voucherCode;
	@JsonProperty("reward_code")
	private String rewardCode;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	@JsonProperty("type")
	public String getType() {
		return type;
	}
	
	@JsonProperty("type")
		public void setType(String type) {
		this.type = type;
	}
	
	@JsonProperty("status")
		public Integer getStatus() {
		return status;
	}
	
	@JsonProperty("status")
		public void setStatus(Integer status) {
		this.status = status;
	}
	
	@JsonProperty("id")
		public Integer getId() {
		return id;
	}
	
	@JsonProperty("id")
		public void setId(Integer id) {
		this.id = id;
	}
	
	@JsonProperty("voucher_code")
		public Integer getVoucherCode() {
		return voucherCode;
	}
	
	@JsonProperty("voucher_code")
		public void setVoucherCode(Integer voucherCode) {
		this.voucherCode = voucherCode;
	}
	
	@JsonProperty("reward_code")
		public String getRewardCode() {
		return rewardCode;
	}
	
	@JsonProperty("reward_code")
		public void setRewardCode(String rewardCode) {
		this.rewardCode = rewardCode;
	}
	
	@JsonAnyGetter
		public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}
	
	@JsonAnySetter
		public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}