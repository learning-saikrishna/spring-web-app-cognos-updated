package org.jpm.deco.app;

import org.jpm.deco.modal.Cognos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CognosRepo extends JpaRepository<Cognos,Integer> {

}
