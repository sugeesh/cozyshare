package io.cozyshare.backend.repository;

import io.cozyshare.backend.model.SharedFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SharedFileRepository extends JpaRepository<SharedFile, Integer> {

    Optional<SharedFile> findByFileKey(String key);

}
