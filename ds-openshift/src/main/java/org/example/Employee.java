package org.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "EMPLOYEES")
@NamedQuery(name = Employee.FIND_ALL, query = "SELECT e FROM Employee e")
public class Employee implements Serializable {

    static final String FIND_ALL = "org.example.Employee.FIND_ALL";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String position;

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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", position='").append(position).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
