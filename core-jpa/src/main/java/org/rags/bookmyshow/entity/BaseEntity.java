package org.rags.bookmyshow.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@MappedSuperclass
@SuperBuilder
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {

	@CreatedDate
	@Column(updatable = false)
	private Timestamp createdDate;

	@UpdateTimestamp
	@Column()
	private Timestamp lastModified;

	@Column(columnDefinition = "boolean default true")
	private boolean isActive;

	BaseEntity(){

	}


}
