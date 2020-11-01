package Assignment_2;

public class College {

    private String name;
    private String location;

    public College(String name, String location) {
        super();
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "College Name: "+ getName()+"\tCollege Address: "+getLocation();
    }

    public void display() {
        System.out.println("College Name: "+ getName()+"\tCollege Address: "+getLocation());
    }

}