package costomSorting;

import java.util.Comparator;

import com.SDMS.Student;

public class SortStudentByMarks implements Comparator<Student> 
{
	public int compare(Student x,Student y)
	{
		return x.getMarks()-y.getMarks();
	}
}
