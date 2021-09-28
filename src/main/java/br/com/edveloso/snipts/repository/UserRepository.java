package br.com.edveloso.snipts.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.edveloso.snipts.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findByLastname(String lastname);

	List<User> findByLastnameOrEmailAddress(String lastname, String emailAddress);

	@Query("select u from User u where u.emailAddress = ?1")
	User findByEmailAddress(String emailAddress);

	@Query("select u from User u where u.firstname like %?1")
	List<User> findByFirstnameEndsWith(String firstname);

	@Query(value = "SELECT * FROM USERS WHERE EMAIL_ADDRESS = ?1", nativeQuery = true)
	User findByEmailAddressNative(String emailAddress);

	@Query("select u from User u where u.lastname like ?1%")
	List<User> findByAndSort(String lastname, Sort sort);

	@Query("select u from User u where u.firstname = :firstname or u.lastname = :lastname")
	User findByLastnameOrFirstname(@Param("lastname") String lastname, @Param("firstname") String firstname);

}
