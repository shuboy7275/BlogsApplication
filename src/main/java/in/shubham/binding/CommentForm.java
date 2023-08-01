package in.shubham.binding;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class CommentForm {
	
	private Integer blogId;
	private String name;
	private String email;
	private String comment;

}
