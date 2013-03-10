package com.kspichale.assert_playground.model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.kspichale.assert_playground.model.extras.Extra;

public class Car {

	private EngineType engineType;
	private VehicleIdentificationNumber vin;
	private Id id;
	private final Set<Extra> extras = new HashSet<Extra>();

	public Car withEngineType(EngineType engineType) {
		setEngineType(engineType);
		return this;
	}

	public void setEngineType(EngineType engineType) {
		this.engineType = engineType;
	}

	public Car withVin(VehicleIdentificationNumber vin) {
		setLicenseNumber(vin);
		return this;
	}

	public void setLicenseNumber(VehicleIdentificationNumber vin) {
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
		return Collections.unmodifiableSet(extras);
	}

	public VehicleIdentificationNumber getVin() {
		return this.vin;
	}

	public Id getId() {
		return this.id;
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
