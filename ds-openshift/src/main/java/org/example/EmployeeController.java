package org.example;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class EmployeeController {

    @PersistenceContext
    private EntityManager em;

    public Employee createEmployee(Employee employee) {
        em.persist(employee);
        return employee;
    }

    public List<Employee> getAll() {
        return em.createNamedQuery(Employee.FIND_ALL).getResultList();
    }
}
