import java.util.Date;
import java.util.EventObject;


public class CourseEvent extends EventObject {
	Date midtermDate; 
    Date assignmentDeadline;
	Date date;
	boolean set;
	

	public CourseEvent(Object source, boolean set, Date d ) {
		super(source);
		// TODO Auto-generated constructor stub
		this.set=set;
		this.midtermDate=d;
		//this.assignmentDeadline= assignmentDeadline;
	}


	/**
	 * ??????????????????????
	 */
	private static final long serialVersionUID = 1L;

}
