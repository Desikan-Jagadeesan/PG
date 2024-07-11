package com.palani.PoultryAssist.Model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "POULTRY_EGG_HATCHING_DETAILS")
public class HatchingDetails {

	@Id
	@Column (name = "HATCHING_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long hatchingId;
	@Column (name="BREED_NAME")
	private String breedName;
	@Column(name="EGG_COUNT")
	private long eggCount;
	@Column (name ="START_DATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date startDate;
	@Column (name = "LOADER_END_DATE")
	private Date loaderEndDate;
	@Column (name = "HATCHING_DATE")
	private Date hatchingDate;
	@Column (name ="FERTILE_EGG_COUNT")
	private Date fertileEggCount;
	public long getHatchingId() {
		return hatchingId;
	}
	public void setHatchingId(long hatchingId) {
		this.hatchingId = hatchingId;
	}
	
	public String getBreedName() {
		return breedName;
	}
	public void setBreedName(String breedName) {
		this.breedName = breedName;
	}
	public void setLoaderEndDate(Date loaderEndDate) {
		this.loaderEndDate = loaderEndDate;
	}
	public void setHatchingDate(Date hatchingDate) {
		this.hatchingDate = hatchingDate;
	}
	public long getEggCount() {
		return eggCount;
	}
	public void setEggCount(long eggCount) {
		this.eggCount = eggCount;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getLoaderEndDate() {
		return loaderEndDate;
	}
	public Date getHatchingDate() {
		return hatchingDate;
	}
	public Date getFertileEggCount() {
		return fertileEggCount;
	}
	public void setFertileEggCount(Date fertileEggCount) {
		this.fertileEggCount = fertileEggCount;
	}
	public void setHatchingDate(Date startDate, long hatchingPeriod) {
        LocalDate localGivenDate = startDate.toLocalDate();
        LocalDate localAnotherDate = localGivenDate.plusDays(hatchingPeriod);
        this.hatchingDate = Date.valueOf(localAnotherDate);
	}
	public void setLoaderEndDate(Date startDate, long loadingPeriod) {
        LocalDate localGivenDate = startDate.toLocalDate();
        LocalDate localAnotherDate = localGivenDate.plusDays(loadingPeriod);
        this.loaderEndDate = Date.valueOf(localAnotherDate);
	}
	@Override
	public String toString() {
		return "HatchingDetails [hatchingId=" + hatchingId + ", eggCount=" + eggCount + ", startDate=" + startDate
				+ ", loaderEndDate=" + loaderEndDate + ", hatchingDate=" + hatchingDate + ", fertileEggCount="
				+ fertileEggCount + "]";
	}
	
}
