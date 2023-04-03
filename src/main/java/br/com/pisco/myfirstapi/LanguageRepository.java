package br.com.pisco.myfirstapi;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LanguageRepository extends MongoRepository<Language, String> {
    List<Language> findByOrderByRanking();
}
