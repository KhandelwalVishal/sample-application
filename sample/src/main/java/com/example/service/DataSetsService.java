package com.example.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.DataSets;
import com.example.repository.DataSetsRepository;

@Service("dataSetsService")
public class DataSetsService {

	private static final Logger LOG =  LoggerFactory.getLogger(DataSetsService.class);
	
	@Autowired
	DataSetsRepository datasetsRepository;
	
	public List<DataSets> getDataByStockTicker(String stockTicker) {
		List<DataSets> dataSets;
		LOG.info("Finding data set by stock ticker");
		dataSets = datasetsRepository.findByStockTicker(stockTicker);
		return dataSets;		
	}

	public void addDataSet(DataSets dataSet) {
		if (dataSet != null) {
			DataSets existingDataSet = datasetsRepository.findByQuarterAndStockAndDate(dataSet.getQuarter(),
					dataSet.getStock(), dataSet.getDate());
			if (existingDataSet == null) {
				LOG.info("Inserting new row");
				datasetsRepository.save(dataSet);
			} else {
				LOG.info("Updating existing data set...");
				existingDataSet.setOpen(dataSet.getOpen());
				existingDataSet.setHigh(dataSet.getHigh());
				existingDataSet.setLow(dataSet.getLow());
				existingDataSet.setClose(dataSet.getClose());
				existingDataSet.setVolume(dataSet.getVolume());
				existingDataSet.setPtChangePrice(dataSet.getPtChangePrice());
				existingDataSet.setPtChangeVolOvrLstWk(dataSet.getPtChangeVolOvrLstWk());
				existingDataSet.setPrWeeksVol(dataSet.getPrWeeksVol());
				existingDataSet.setNxtWeeksOpen(dataSet.getNxtWeeksOpen());
				existingDataSet.setNxtWeeksClose(dataSet.getNxtWeeksClose());
				existingDataSet.setPtChangeNextWeeksPrice(dataSet.getPtChangeNextWeeksPrice());
				existingDataSet.setDaysToNextDividend(dataSet.getDaysToNextDividend());
				existingDataSet.setPtReturnNextDividend(dataSet.getPtReturnNextDividend());
				datasetsRepository.save(existingDataSet);
			}
		}
	}

	public void uploadBulkDataSets(InputStream inputStream) {
		List<DataSets> dataList = this.readInputFile(inputStream);

		if (!dataList.isEmpty()) {
			for (DataSets row : dataList) {
				addDataSet(row);
			}
		}
	}

	private List<DataSets> readInputFile(InputStream inputStream) {
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		return br.lines().map(mapToDataSets).collect(Collectors.toList());
	}

	private Function<String, DataSets> mapToDataSets = line -> {
		String[] rowArr = line.split(",");

		if (!rowArr[0].equalsIgnoreCase("quarter")) {
			return new DataSets(Integer.valueOf(rowArr[0]), rowArr[1], rowArr[2], new BigDecimal(rowArr[3]),
					new BigDecimal(rowArr[4]), new BigDecimal(rowArr[5]), new BigDecimal(rowArr[6]),
					new BigDecimal(rowArr[7]), new BigDecimal(rowArr[8]), new BigDecimal(rowArr[9]),
					new BigDecimal(rowArr[10]), new BigDecimal(rowArr[11]), new BigDecimal(rowArr[12]),
					new BigDecimal(rowArr[13]), new BigDecimal(rowArr[14]), new BigDecimal(rowArr[15]));
		}
		return null;
	};
}
