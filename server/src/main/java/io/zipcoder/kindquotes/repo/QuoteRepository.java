package io.zipcoder.kindquotes.repo;

import io.zipcoder.kindquotes.model.Quote;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by brianmullin on 6/26/17.
 */
public interface QuoteRepository extends CrudRepository<Quote, Integer> {
}
