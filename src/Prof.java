/** SYSC 2101 - Prof-Student-TA Example
 * 
 *
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Prof {
	private String name;
	private Date midtermDate;
	private ArrayList<Student> students;
	private TeachingAssistant ta;
	
	//adding a list of Listeners 
	private static List <CourseListener> courseListeners ;  

	public Prof(String aName) {
		this.name = aName;
		this.students = new ArrayList<Student>();
		setCourseListeners(new ArrayList <CourseListener>());
	}

	public Date getMidterm() {
		return this.midtermDate;
	}

	public String getName() {
		return this.name;
	}

	public void setMidterm(Date date) {
		this.midtermDate = date;
		/*
		for(Student s: this.students){
			s.study(date);
		}
		ta.proctor(date);
		*/
		boolean set = true;
		CourseEvent e = new CourseEvent(this, set, midtermDate);
		
		for (CourseListener cl: courseListeners) {
			cl.midtermAnnounced(e);
		}

	}
	
	public void postponeMidterm(Date date){
		this.midtermDate = date;
		for(Student s: this.students){
			s.party(date);
		}
		ta.postpone(date);
	}
	
	public void setTA(TeachingAssistant theTA){
		this.ta = theTA;
	}
	
	public void addStudent(Student s){
		this.students.add(s);
	}
	
	//------------------------------------------------------
	//the new methods from Listener 
	//public static void addCourseListener (CourseListener c)
	//{
	//	getCourseListeners().add(c);
//	}
	
	 public synchronized static void addCourseListener (CourseListener cl){
			courseListeners.add(cl);
		}

	
	 public synchronized void removeCourseListener (CourseListener cl) {
			courseListeners.remove(cl);
		}

//	public void removeCourseListener (CourseListener c)
//	{
	//	if(getCourseListeners() != null)
	//	Prof.getCourseListeners().remove(c); 
		
	//}

	public static void main(String[] args) {
		
		//tryiing SOURCETREE
		System.out.println("im pushed from sourceTREE!!!!!");

		Prof p = new Prof("Babak");
		Student s = new Student("Homer");
		Student s2 = new Student("Bart");
		TeachingAssistant ta = new TeachingAssistant("Michael");
	
	
		p.addStudent(s);
		p.addStudent(s2);
		p.setTA(ta);
		
		addCourseListener(s);
		addCourseListener(s2);
		addCourseListener(ta);
		
		Date midterm = new Date();
		p.setMidterm(midterm);
	
		//p.postponeMidterm(new Date(midterm.getTime() + 1000000000));
	}

	public static List <CourseListener> getCourseListeners() {
		return courseListeners;
	}

	public static void setCourseListeners(List <CourseListener> courseListeners) {
		Prof.courseListeners = courseListeners;
	}

}
