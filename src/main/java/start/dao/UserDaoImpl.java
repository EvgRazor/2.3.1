package start.dao;

import org.springframework.stereotype.Repository;
import start.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> index() {
        return entityManager.createQuery("select u from User u").getResultList();
    }

    @Override
    public User getUserId(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(int i, User userNew) {
        User user = getUserId(i);
        user.setName(userNew.getName());
        user.setAge(userNew.getAge());
        user.setEmail(user.getEmail());

    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(getUserId(id));
    }


}
