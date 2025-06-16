package entity;

public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private String telephone;
    public Student(Integer id, String name, Integer age, String telephone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.telephone = telephone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void showInfo(){
        System.out.println("Thông tin sinh viên:");
        System.out.println(this.getId());
        System.out.println(this.getName());
        System.out.println(this.getAge());
        System.out.println(this.getTelephone());
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Tên: " + name +
                ", Tuổi: " + age +
                ", SĐT: " + telephone;
    }

}