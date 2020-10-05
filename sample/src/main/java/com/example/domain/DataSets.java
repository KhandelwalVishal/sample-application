package com.example.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Vkhandelwal
 */

@Entity
@Table(name = "DATASETS")
public class DataSets implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6819186935275406695L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private Integer id;

	@Column(name = "quarter")
	private Integer quarter;

	@Column(name = "stock")
	private String stock;

	@Column(name = "date")
	private String date;

	@Column(name = "open")
	private BigDecimal open;

	@Column(name = "high")
	private BigDecimal high;

	@Column(name = "low")
	private BigDecimal low;

	@Column(name = "close")
	private BigDecimal close;

	@Column(name = "volume")
	private BigDecimal volume;

	@Column(name = "percent_change_price")
	private BigDecimal ptChangePrice;

	@Column(name = "percent_change_volume_over_last_wk")
	private BigDecimal ptChangeVolOvrLstWk;

	@Column(name = "previous_weeks_volume")
	private BigDecimal prWeeksVol;

	@Column(name = "next_weeks_open")
	private BigDecimal nxtWeeksOpen;

	@Column(name = "next_weeks_close")
	private BigDecimal nxtWeeksClose;

	@Column(name = "percent_change_next_weeks_price")
	private BigDecimal ptChangeNextWeeksPrice;

	@Column(name = "days_to_next_dividend")
	private BigDecimal daysToNextDividend;

	@Column(name = "percent_return_next_dividend")
	private BigDecimal ptReturnNextDividend;
	
	
	public DataSets() {
		super();
	}

	public DataSets(Integer quarter, String stock, String date, BigDecimal open, BigDecimal high, BigDecimal low,
			BigDecimal close, BigDecimal volume, BigDecimal ptChangePrice, BigDecimal ptChangeVolOvrLstWk,
			BigDecimal prWeeksVol, BigDecimal nxtWeeksOpen, BigDecimal nxtWeeksClose, BigDecimal ptChangeNextWeeksPrice,
			BigDecimal daysToNextDividend, BigDecimal ptReturnNextDividend) {
		super();
		this.quarter = quarter;
		this.stock = stock;
		this.date = date;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
		this.ptChangePrice = ptChangePrice;
		this.ptChangeVolOvrLstWk = ptChangeVolOvrLstWk;
		this.prWeeksVol = prWeeksVol;
		this.nxtWeeksOpen = nxtWeeksOpen;
		this.nxtWeeksClose = nxtWeeksClose;
		this.ptChangeNextWeeksPrice = ptChangeNextWeeksPrice;
		this.daysToNextDividend = daysToNextDividend;
		this.ptReturnNextDividend = ptReturnNextDividend;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuarter() {
		return quarter;
	}

	public void setQuarter(Integer quarter) {
		this.quarter = quarter;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public BigDecimal getOpen() {
		return open;
	}

	public void setOpen(BigDecimal open) {
		this.open = open;
	}

	public BigDecimal getHigh() {
		return high;
	}

	public void setHigh(BigDecimal high) {
		this.high = high;
	}

	public BigDecimal getLow() {
		return low;
	}

	public void setLow(BigDecimal low) {
		this.low = low;
	}

	public BigDecimal getClose() {
		return close;
	}

	public void setClose(BigDecimal close) {
		this.close = close;
	}

	public BigDecimal getVolume() {
		return volume;
	}

	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}

	public BigDecimal getPtChangePrice() {
		return ptChangePrice;
	}

	public void setPtChangePrice(BigDecimal ptChangePrice) {
		this.ptChangePrice = ptChangePrice;
	}

	public BigDecimal getPtChangeVolOvrLstWk() {
		return ptChangeVolOvrLstWk;
	}

	public void setPtChangeVolOvrLstWk(BigDecimal ptChangeVolOvrLstWk) {
		this.ptChangeVolOvrLstWk = ptChangeVolOvrLstWk;
	}

	public BigDecimal getPrWeeksVol() {
		return prWeeksVol;
	}

	public void setPrWeeksVol(BigDecimal prWeeksVol) {
		this.prWeeksVol = prWeeksVol;
	}

	public BigDecimal getNxtWeeksOpen() {
		return nxtWeeksOpen;
	}

	public void setNxtWeeksOpen(BigDecimal nxtWeeksOpen) {
		this.nxtWeeksOpen = nxtWeeksOpen;
	}

	public BigDecimal getNxtWeeksClose() {
		return nxtWeeksClose;
	}

	public void setNxtWeeksClose(BigDecimal nxtWeeksClose) {
		this.nxtWeeksClose = nxtWeeksClose;
	}

	public BigDecimal getPtChangeNextWeeksPrice() {
		return ptChangeNextWeeksPrice;
	}

	public void setPtChangeNextWeeksPrice(BigDecimal ptChangeNextWeeksPrice) {
		this.ptChangeNextWeeksPrice = ptChangeNextWeeksPrice;
	}

	public BigDecimal getDaysToNextDividend() {
		return daysToNextDividend;
	}

	public void setDaysToNextDividend(BigDecimal daysToNextDividend) {
		this.daysToNextDividend = daysToNextDividend;
	}

	public BigDecimal getPtReturnNextDividend() {
		return ptReturnNextDividend;
	}

	public void setPtReturnNextDividend(BigDecimal ptReturnNextDividend) {
		this.ptReturnNextDividend = ptReturnNextDividend;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataSets other = (DataSets) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "DataSets [id=" + id + ", quarter=" + quarter + ", stock=" + stock + ", date=" + date + ", open=" + open
				+ ", high=" + high + ", low=" + low + ", close=" + close + ", volume=" + volume + ", ptChangePrice="
				+ ptChangePrice + ", ptChangeVolOvrLstWk=" + ptChangeVolOvrLstWk + ", prWeeksVol=" + prWeeksVol
				+ ", nxtWeeksOpen=" + nxtWeeksOpen + ", nxtWeeksClose=" + nxtWeeksClose + ", ptChangeNextWeeksPrice="
				+ ptChangeNextWeeksPrice + ", daysToNextDividend=" + daysToNextDividend + ", ptReturnNextDividend="
				+ ptReturnNextDividend + "]";
	}

}
