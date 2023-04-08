 package costomSorting;

import java.util.Comparator;

import com.SDMS.Student;

public class SortStudentByName implements Comparator<Student>
{
   public int compare(Student x, Student y)
   {
	   return y.getName().compareTo(x.getName());
   }
}
