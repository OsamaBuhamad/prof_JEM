import java.util.Date;
import java.util.EventObject;


public class CourseEvent extends EventObject {
	Date midtermDate; 
	Date assignmentDeadline;
	

	public CourseEvent(Object arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
		//this.midtermDate=midtermDate;
		//this.assignmentDeadline= assignmentDeadline;
	}


	/**
	 * ??????????????????????
	 */
	private static final long serialVersionUID = 1L;

}
