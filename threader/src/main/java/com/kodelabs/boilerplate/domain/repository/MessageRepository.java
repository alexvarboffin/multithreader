package com.kodelabs.boilerplate.domain.repository;

public interface MessageRepository {
    String getWelcomeMessageById(int id);

    String getWelcomeMessage();
}
