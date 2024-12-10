package co.company.macrosoft.pruebatenica.rest.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "collector")
public class Collector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name="telephone")
    private String telephone;
    @Column(name="email")
    private String email;

    // Getters y setters
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
        return telephone;
    }

    public void setPhone(String phone) {
        this.telephone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
