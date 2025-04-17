package hospitalManagementSystem;

public abstract class Person {
    private String name;
    private int age;
    private int id;

    public Person(String name, int age, int id){
        this.name = name;
        this.age = age;
        this.id = id;
    }

    abstract String getRole();

    public String getDetails(){
        String information = "ID: " + id + ", Name: " + name  + ", Age: " + age  + ", Role: " + getRole();
       System.out.println(information);
       return information;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

}

