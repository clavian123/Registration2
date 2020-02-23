  package com.app.registration.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class Customers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_customer")
	private long idCustomer;
	
	@Column(name="cif_code")
	private String cifCode;
	
	@Column(name="title")
	private String title; 
	
	@Column(name="name")
	private String name;
	
	@Column(name="id_type")
	private String idType;
	
	@Column(name="id_number")
	private String idNumber;
	
	@Column(name="id_expiry_date")
	private Date idExpiryDate;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="marital_status")
	private String maritalStatus;
	
	@Column(name="address")
	private String address;
	
	@Column(name="rt_rw")
	private String rtRw;
	
	@Column(name="kelurahan")
	private String kelurahan;
	
	@Column(name="kecamatan")
	private String kecamatan;
	
	@Column(name="city")
	private String city;
	
	@Column(name="postal_code")
	private String postalCode;
	
	@Column(name="province")
	private String province;
	
	@Column(name="current_address")
	private String currentAddress;
	
	@Column(name="current_rt_rw")
	private String currentRtRw;
	
	@Column(name="current_kelurahan")
	private String currentKelurahan;
	
	@Column(name="current_kecamatan")
	private String currentKecamatan;
	
	@Column(name="current_city")
	private String currentCity;
	
	@Column(name="current_postal_code")
	private String currentPostalCode;
	
	@Column(name="current_province")
	private String currentProvince;
	
	@Column(name="mothers_maiden")
	private String mothersMaiden;
	
	@Column(name="birth_place")
	private String birthPlace;
	
	@Column(name="birth_date")
	private Date birthDate;
	
	@Column(name="occupation")
	private String occupation;
	
	@Column(name="monthly_income")
	private String monthlyIncome;
	
	@Column(name="email")
	private String email;
	
	@Column(name="mobile_number")
	private String mobileNumber;
	
	@Column(name="nationality")
	private String nationality;
	
	@Column(name="status")
	private long status;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="last_updated_date")
	private Date lastUpdatedDate;
	
	@Column(name="last_updated_by")
	private String lastUpdatedBy;
	
	@Column(name="pan")
	private String pan ;
	
	@Column(name="pin")
	private String pin;
	
	public Customers() {
		// TODO Auto-generated constructor stub
	}

	public Customers(long idCustomer, String cifCode, String title, String name, String idType, String idNumber,
			Date idExpiryDate, String gender, String maritalStatus, String address, String rtRw, String kelurahan,
			String kecamatan, String city, String postalCode, String province, String currentAddress,
			String currentRtRw, String currentKelurahan, String currentKecamatan, String currentCity,
			String currentPostalCode, String currentProvince, String mothersMaiden, String birthPlace, Date birthDate,
			String occupation, String monthlyIncome, String email, String mobileNumber, String nationality, long status,
			Date createdDate, String createdBy, Date lastUpdatedDate, String lastUpdatedBy, String pan, String pin) {
		super();
		this.idCustomer = idCustomer;
		this.cifCode = cifCode;
		this.title = title;
		this.name = name;
		this.idType = idType;
		this.idNumber = idNumber;
		this.idExpiryDate = idExpiryDate;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.address = address;
		this.rtRw = rtRw;
		this.kelurahan = kelurahan;
		this.kecamatan = kecamatan;
		this.city = city;
		this.postalCode = postalCode;
		this.province = province;
		this.currentAddress = currentAddress;
		this.currentRtRw = currentRtRw;
		this.currentKelurahan = currentKelurahan;
		this.currentKecamatan = currentKecamatan;
		this.currentCity = currentCity;
		this.currentPostalCode = currentPostalCode;
		this.currentProvince = currentProvince;
		this.mothersMaiden = mothersMaiden;
		this.birthPlace = birthPlace;
		this.birthDate = birthDate;
		this.occupation = occupation;
		this.monthlyIncome = monthlyIncome;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.nationality = nationality;
		this.status = status;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.lastUpdatedDate = lastUpdatedDate;
		this.lastUpdatedBy = lastUpdatedBy;
		this.pan = pan;
		this.pin = pin;
	}

	public long getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(long idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getCifCode() {
		return cifCode;
	}

	public void setCifCode(String cifCode) {
		this.cifCode = cifCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public Date getIdExpiryDate() {
		return idExpiryDate;
	}

	public void setIdExpiryDate(Date idExpiryDate) {
		this.idExpiryDate = idExpiryDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRtRw() {
		return rtRw;
	}

	public void setRtRw(String rtRw) {
		this.rtRw = rtRw;
	}

	public String getKelurahan() {
		return kelurahan;
	}

	public void setKelurahan(String kelurahan) {
		this.kelurahan = kelurahan;
	}

	public String getKecamatan() {
		return kecamatan;
	}

	public void setKecamatan(String kecamatan) {
		this.kecamatan = kecamatan;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public String getCurrentRtRw() {
		return currentRtRw;
	}

	public void setCurrentRtRw(String currentRtRw) {
		this.currentRtRw = currentRtRw;
	}

	public String getCurrentKelurahan() {
		return currentKelurahan;
	}

	public void setCurrentKelurahan(String currentKelurahan) {
		this.currentKelurahan = currentKelurahan;
	}

	public String getCurrentKecamatan() {
		return currentKecamatan;
	}

	public void setCurrentKecamatan(String currentKecamatan) {
		this.currentKecamatan = currentKecamatan;
	}

	public String getCurrentCity() {
		return currentCity;
	}

	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}

	public String getCurrentPostalCode() {
		return currentPostalCode;
	}

	public void setCurrentPostalCode(String currentPostalCode) {
		this.currentPostalCode = currentPostalCode;
	}

	public String getCurrentProvince() {
		return currentProvince;
	}

	public void setCurrentProvince(String currentProvince) {
		this.currentProvince = currentProvince;
	}

	public String getMothersMaiden() {
		return mothersMaiden;
	}

	public void setMothersMaiden(String mothersMaiden) {
		this.mothersMaiden = mothersMaiden;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(String monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public long getStatus() {
		return status;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	

		
}

