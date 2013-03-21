package com.kspichale.assert_playground.model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Car extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1579677179893541654L;

	@Column
	private EngineType engineType;

	@Column
	private String vin;

	@ElementCollection(targetClass = Extra.class)
	@Enumerated(EnumType.STRING)
	@CollectionTable(name = "car_extras")
	@Column(name = "car")
	private final Collection<Extra> extras = new HashSet<Extra>();

	public Car withEngineType(EngineType engineType) {
		setEngineType(engineType);
		return this;
	}

	public void setEngineType(EngineType engineType) {
		this.engineType = engineType;
	}

	public Car withVin(String vin) {
		setLicenseNumber(vin);
		return this;
	}

	public void setLicenseNumber(String vin) {
		this.vin = vin;
	}

	public Car withExtras(Extra... extras) {
		for (Extra extra : extras) {
			this.extras.add(extra);
		}
		return this;
	}

	public EngineType getEngineType() {
		return this.engineType;
	}

	public Collection<Extra> getExtras() {
		return Collections.unmodifiableCollection(extras);
	}

	public String getVin() {
		return this.vin;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}
}
