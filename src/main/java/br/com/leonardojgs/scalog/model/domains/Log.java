package br.com.leonardojgs.scalog.model.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="LOGS")
public class Log {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="{log.message.notnull}")
	@NotEmpty(message="{log.message.notempty}")
	@Size(message="{log.message.sizeerror}", min=10, max=255)
	private String message;

	@Lob
	@NotNull(message="{log.detail.notnull}")
	@NotEmpty(message="{log.detail.notempty}")
	@Size(message="{log.detail.sizeerror}", min=10, max=1000)
	private String detail;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
}
