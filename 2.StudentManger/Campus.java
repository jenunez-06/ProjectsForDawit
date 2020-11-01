package Assignment_2;

public class Campus extends College {


    public Campus(String name, String location) {
        super(name, location);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "Campus Name: "+ getName()+"\tCampus Address: "+getLocation();
    }

    @Override
    public void display() {
        System.out.println("Campus Name: "+ getName()+"\tCampus Address: "+getLocation());
    }
}
