package com.website.repository;

import com.website.model.FootballMatch;
import org.springframework.data.repository.CrudRepository;

public interface MatchRepository extends CrudRepository<FootballMatch, Integer> {
}
