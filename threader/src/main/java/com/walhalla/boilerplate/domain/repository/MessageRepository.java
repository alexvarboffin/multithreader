package com.walhalla.boilerplate.domain.repository;

import com.walhalla.boilerplate.domain.repository.base.Repository;

public interface MessageRepository extends Repository{

    String getWelcomeMessageById(int id);

    String getWelcomeMessage();

}
