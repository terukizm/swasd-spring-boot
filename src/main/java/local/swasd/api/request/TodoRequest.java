package local.swasd.api.request;

import lombok.Data;

@Data
public class TodoRequest {

	private String title;

	private boolean done;
}
