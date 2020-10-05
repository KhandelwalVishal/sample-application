package com.example.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.domain.DataSets;
import com.example.service.DataSetsService;

@RestController
@RequestMapping(value = "${controller.uri.datasets}")
public class WebController {

	private static final Logger LOG = LoggerFactory.getLogger(WebController.class);

	@Autowired
	DataSetsService dataSetsService;

	@GetMapping(value = "/{stockTicker}/getDataByStockTicker")
	public ResponseEntity<?> getDataByStockTicker(@PathVariable String stockTicker) {
		LOG.info("Retriving Data sets by stock");
		try {
			List<DataSets> dataSets = dataSetsService.getDataByStockTicker(stockTicker);
			return new ResponseEntity<>(dataSets, HttpStatus.OK);
		} catch (Exception ex) {
			LOG.error("Error in Retriving Data Sets", ex);
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(value = "/addDataSet")
	public ResponseEntity<?> addDataSet(@RequestBody DataSets dataSet) {
		LOG.info("Updating Data Set...");
		try {
			dataSetsService.addDataSet(dataSet);
			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception ex) {
			LOG.error("Error while updating Data Set...", ex);
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@PostMapping(value = "/uploadBulkDataSets")
	public ResponseEntity<?> uploadBulkDataSets(@RequestParam("fileUpload") MultipartFile fileUpload) {
		LOG.info("Bulk Uploading Data Sets");
		try {
			dataSetsService.uploadBulkDataSets(fileUpload.getInputStream());
			return new ResponseEntity<>("success", HttpStatus.OK);

		} catch (Exception ex) {
			LOG.error("Error while Uploading Bulk Data Set...", ex);
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
