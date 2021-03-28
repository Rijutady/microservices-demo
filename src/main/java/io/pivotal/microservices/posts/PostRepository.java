package io.pivotal.microservices.posts;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface PostRepository extends Repository<Post, Long> {
	/**
	 * Find an account with the specified account number.
	 *
	 * @param accountNumber
	 * @return The account if found, null otherwise.
	 */
	public List<Post> findByAuthor(String author);

	public List<Post> findAll();
//
//	public List<Post> editPost(String author);

}