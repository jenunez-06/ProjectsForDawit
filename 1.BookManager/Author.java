package Assignment_1;


public class Author {

    private String name;
    private String[] List;




    public Author(String name) {
        this.name = name;
    }



    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String[] getList() {
        return List;
    }
    public void setList(String[] List) {
        this.List = List;
    }





    @Override
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
        //return id+" -  "+name+" - "+ gpa;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Author)obj).getName().equalsIgnoreCase(this.name);
    }
}


