import java.util.ArrayList;
import java.util.Calendar;

public class Developer extends RegularEmployee {
    // projects: ArrayList<Project> numberOfDevelopers: int
    ArrayList<Project> projects;
    public static int numberOfDevelopers;

    public Developer(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus, String hasDriverLicence, double salary, Calendar hireDate, Department department, double performanceScore, ArrayList<Project> projects) throws Exception {
        super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department, performanceScore);
        this.projects = projects;
    }

    public Developer(RegularEmployee employee, ArrayList<Project> projects) throws Exception {
        super(employee, employee.getPerformanceScore());
        this.projects = projects;
    }
    public boolean addProject(Project s) throws Exception {
       if (projects.contains(s)){
           throw new Exception("You cannot add a project which has already existed!!");
       }
       projects.add(s);
       return true;
    }
    public boolean removeProject(Project s) throws Exception {
        if (!projects.contains(s)){
            throw new Exception("You cannot remove a project which has not existed in the project list!!");
        }
        projects.remove(s);
        return true;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public static int getNumberOfDevelopers() {
        return numberOfDevelopers;
    }

    public static void setNumberOfDevelopers(int numberOfDevelopers) {
        Developer.numberOfDevelopers = numberOfDevelopers;
    }

    @Override
    public String toString() {
        return super.toString() + "\n\t\t\t\t" +
                projects ;
    }
}
