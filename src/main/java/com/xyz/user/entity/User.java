package com.xyz.user.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
public class User {
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String username;
	@Column
	private String email;
	@CreatedDate
	private LocalDateTime createdOn;
	@LastModifiedDate
	private LocalDateTime modifiedOn;
	
	public User() {
		
	}

	public User(String username, String email, LocalDateTime createdOn, LocalDateTime modifiedOn) {
		this.username = username;
		this.email = email;
		this.createdOn = createdOn;
		this.modifiedOn = modifiedOn;
	}
	

    @PrePersist
    public void prePersist() {
        this.createdOn = this.modifiedOn = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.modifiedOn = LocalDateTime.now();
    }


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
		
	}
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public LocalDateTime getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}


	public LocalDateTime getModifiedOn() {
		return modifiedOn;
	}


	public void setModifiedOn(LocalDateTime modifiedOn) {
		this.modifiedOn = modifiedOn;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
}