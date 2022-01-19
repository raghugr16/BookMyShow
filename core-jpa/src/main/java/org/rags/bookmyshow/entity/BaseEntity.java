package org.rags.bookmyshow.entity;

import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	@CreatedDate
	@Column(updatable = false)
	private Timestamp createdDate;

	@UpdateTimestamp
	private Timestamp lastModified;

	@Column(columnDefinition = "boolean default true")
	private boolean isActive;

}
