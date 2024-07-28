package com.management.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.management.app.model.DeviceModel;

public interface DeviceRepository extends JpaRepository<DeviceModel, Integer> {

	// ソート抽出
	List<DeviceModel> findAllByOrderByIdAsc();

	// 検索　SQL
	@Query("SELECT d FROM DeviceModel d WHERE " +
			"(:managementCd IS NULL OR d.management_cd = :managementCd) AND " +
			"(:equipmentName IS NULL OR d.equipment_name LIKE %:equipmentName%) AND " +
			"(:equipmentType IS NULL OR d.equipment_type LIKE %:equipmentType%) AND " +
			"(:notes IS NULL OR d.notes LIKE %:notes%) AND " +
			"(:department IS NULL OR d.department LIKE %:department%) AND " +
			"(:boughtEnterprise IS NULL OR d.bought_Enterprise LIKE %:boughtEnterprise%) AND " +
			"(:usefulLife IS NULL OR d.useful_life = :usefulLife)")
	List<DeviceModel> searchDevices(@Param("managementCd") Integer managementCd,
			@Param("equipmentName") String equipmentName,
			@Param("equipmentType") String equipmentType,
			@Param("notes") String notes,
			@Param("department") String department,
			@Param("boughtEnterprise") String boughtEnterprise,
			@Param("usefulLife") Integer usefulLife);
}
