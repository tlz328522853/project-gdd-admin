package cn.hacz.edu.hibernate;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Type;

@MappedSuperclass
public class BaseEntity {

	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	@Comment("主键id")
	private UUID bid;// base ID

	@Comment("创建时间")
	private LocalDateTime createDateTime;

	@Comment("修改时间")
	private LocalDateTime modifyDateTime;

	@Comment("是否删除")
	@Type(type = "true_false")
	private Boolean deleted;

	@Comment("是否执行成功")
	@Type(type = "true_false")
	private Boolean success;//

	@Comment("执行返回的信息")
	@Column(length = 200)
	private String info;

	@Comment("接收时间")
	private LocalDateTime receiveTime;

	public UUID getBid() {
		return bid;
	}

	public void setBid(UUID bid) {
		this.bid = bid;
	}

	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}

	public LocalDateTime getModifyDateTime() {
		return modifyDateTime;
	}

	public void setModifyDateTime(LocalDateTime modifyDateTime) {
		this.modifyDateTime = modifyDateTime;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public LocalDateTime getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(LocalDateTime receiveTime) {
		this.receiveTime = receiveTime;
	}

}
