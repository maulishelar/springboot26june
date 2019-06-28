package org.com.dao;

import java.util.List;

import org.com.entity.Employee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Employee> getAllEmployee() {
		Session session=this.sessionFactory.getCurrentSession();
		List<Employee> allEmp=session.createQuery("FROM Employee").list();
		return allEmp;
		
	}

	@Override
	public void InsertEmp(Employee emp) {
		Session session=this.sessionFactory.getCurrentSession();
		session.save(emp);
		}

	@Override
	public void DelEmp(int nbr) {
		Session session=this.sessionFactory.getCurrentSession();
		Employee emp=session.get(Employee.class, nbr);
		session.delete(emp);
		}

	@Override
	public void UpdateEmp(Employee emp) {
		Session session=this.sessionFactory.getCurrentSession();
		session.update(emp);
	}

	@Override
	public List<Employee> getEmp(String eid) {
        Criteria criteria=this.sessionFactory.getCurrentSession().createCriteria(Employee.class);
		criteria.add(Restrictions.like("eid", eid));
		return criteria.list();
	}
	
	
}
