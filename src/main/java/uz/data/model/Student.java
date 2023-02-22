package uz.data.model;

public class Student {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String region;
    private String district;

    public Student(){
    }

    public Student(String name,
                   String phone,
                   String email,
                   String region,
                   String district) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.region = region;
        this.district = district;
    }

    public Student(Long id, String name, String phone, String email, String region, String district) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.region = region;
        this.district = district;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", redion='" + region + '\'' +
                ", district='" + district + '\'' +
                '}';
    }
}
