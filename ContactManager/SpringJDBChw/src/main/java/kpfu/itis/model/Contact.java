package kpfu.itis.model;

/**
 * Created by Admin on 14.03.2017.
 */
public class Contact {
    private Integer id;
    private String name;
    private String email;
    private String address;
    private Integer phone;

    public Contact() {
    }

    public Contact(String name, String email, String address, int phone) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Integer getPhone() {
        return phone;
    }
}
