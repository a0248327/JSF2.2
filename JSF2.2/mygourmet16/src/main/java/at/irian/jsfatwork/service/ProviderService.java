package at.irian.jsfatwork.service;

import at.irian.jsfatwork.domain.Provider;

import java.util.List;

public interface ProviderService {

    Provider createNew();

    boolean save(Provider entity);

    void delete(Provider entity);

    List<Provider> findAll();

    Provider findById(long id);

}
