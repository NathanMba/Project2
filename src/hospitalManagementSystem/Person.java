package hospitalManagementSystem;

public abstract class Person {
    private String name;
    private int age;
    private String id;

    public Person(String name, int age, String id){
        this.name = name;
        this.age = age;
        this.id = id;
    }

    abstract String getRole();

    public String getDetails(){
       return "ID: " + id + ", Name: " + name  + ", Age: " + age  + ", Role: " + getRole();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
}

