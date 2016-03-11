package local.swasd.api.response;

import java.util.Date;

import javax.persistence.Id;

import lombok.Data;

@Data
public class TodoResponse {
	@Id
	private long id;

	private String title;

	private boolean done;

	private Date createdAt;

	private Date updatedAt;
}
