package com.pack.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.pack.PersonalInfo;



@Entity
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    @Type(type = "org.hibernate.type.UUIDCharType") // <-------------------------- THIS LINE
    private UUID id;

    @NotNull(message = "Name must not be null")
    @Column(nullable = false)
    private String empName;

    @Email(message = "Email should be valid")
    @NotNull(message = "Email must not be null")
    @Column(unique = true, nullable = false)
    private String email;

    @NotNull(message = "Phone number must not be null")
    @Column(unique = true, nullable = false)
    private String phoneNumber;

    @Embedded
    private Address address;

    @Embedded
    private ContactInfo contactInfo;

    @Embedded
    private PersonalInfo personalInfo;

    @ElementCollection
    @CollectionTable(name = "customer_phone_numbers", joinColumns = @JoinColumn(name = "customer_id"))
    @Column(name = "phone_number")
    private List<String> additionalPhoneNumbers;

    @ElementCollection
    @CollectionTable(name = "customer_email_addresses", joinColumns = @JoinColumn(name = "customer_id"))
    @Column(name = "email_address")
    private List<@Email String> additionalEmailAddresses;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}


	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}

	public List<String> getAdditionalPhoneNumbers() {
		return additionalPhoneNumbers;
	}

	public void setAdditionalPhoneNumbers(List<String> additionalPhoneNumbers) {
		this.additionalPhoneNumbers = additionalPhoneNumbers;
	}

	public List<String> getAdditionalEmailAddresses() {
		return additionalEmailAddresses;
	}

	public void setAdditionalEmailAddresses(List<String> additionalEmailAddresses) {
		this.additionalEmailAddresses = additionalEmailAddresses;
	}

}