package com.example.cms.model.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.cms.model.entity.Camera;
@Repository
public interface CameraRepository extends JpaRepository<Camera, Long> {

}
