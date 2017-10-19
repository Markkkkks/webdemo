package jdbc.dao;

import domain.Department;

public interface DepartmentDao {
     void add(Department de);
     void delect(String name);
     void update(Department de);
     Department find(String  name);
}
