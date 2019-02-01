package queryjoin;

import javax.persistence.EntityManager;

public class DepartmentDAOImpl implements DepartmentDAO {

	private EntityManager entityManager;

	public DepartmentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Department3 insertDepartment(String name) {

		Department3 department = new Department3(name);
		entityManager.persist(department);

		return department;
	}

}
