package com.management.app.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "device")
public class DeviceModel {

	// 主キー
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	// 管理コード
	@Column(name = "management_cd")
	private Integer management_cd;

	// 機器名
	@Column(name = "equipment_name")
	private String equipment_name;

	// 種別
	@Column(name = "equipment_type")
	private String equipment_type;

	// 備考
	@Column(name = "notes")
	private String notes;

	// 管理部門
	@Column(name = "department")
	private String department;

	// 調達先
	@Column(name = "bought_Enterprise")
	private String bought_Enterprise;

	// 耐用年数
	@Column(name = "useful_life")
	private Integer useful_life;

	// 使用開始日
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "use_start_date")
	private Date use_start_date;

	// 使用終了日
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "use_end_date")
	private Date use_end_date;

	// 廃棄日
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "disposal_date")
	private Date disposal_date;

	// 廃棄フラグ
	@Column(name = "disposal_flag")
	private Boolean disposal_flag;

}
