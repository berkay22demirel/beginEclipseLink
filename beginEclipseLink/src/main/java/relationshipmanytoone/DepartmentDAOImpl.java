package relationshipmanytoone;

import javax.persistence.EntityManager;

public class DepartmentDAOImpl implements DepartmentDAO {

	private EntityManager entityManager;

	public DepartmentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Department insertDepartment(String name) {

		Department department = new Department(name);
		entityManager.persist(department);

		return department;
	}

}
