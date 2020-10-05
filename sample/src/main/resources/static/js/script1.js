$('#searchstock')
		.click(
				function(ev) {
					var el = ev.currentTarget;
					Val = $("#stock", this.$el);
					$
							.ajax({
								url : "http://localhost:8080/datasets/"
										+ Val.val() + "/getDataByStockTicker",
								dataType : 'json',
								success : function(resp) {
									var trHTML = '';
									$
											.each(
													resp,
													function(i, userData) {
														for (i = 0; i < resp.length; i++) {
															trHTML += '<tr><td>'
																	+ resp[i].quarter
																	+ '</td><td>'
																	+ resp[i].stock
																	+ '</td><td>'
																	+ resp[i].date
																	+ '</td><td>'
																	+ resp[i].open
																	+ '</td><td>'
																	+ resp[i].high
																	+ '</td><td>'
																	+ resp[i].low
																	+ '</td><td>'
																	+ resp[i].close
																	+ '</td><td>'
																	+ resp[i].volume
																	+ '</td><td>'
																	+ resp[i].ptChangePrice
																	+ '</td><td>'
																	+ resp[i].ptChangeVolOvrLstWk
																	+ '</td><td>'
																	+ resp[i].prWeeksVol
																	+ '</td><td>'
																	+ resp[i].nxtWeeksOpen
																	+ '</td><td>'
																	+ resp[i].nxtWeeksClose
																	+ '</td><td>'
																	+ resp[i].ptChangeNextWeeksPrice
																	+ '</td><td>'
																	+ resp[i].daysToNextDividend
																	+ '</td><td>'
																	+ resp[i].ptReturnNextDividend
																	+ '</td></tr>';
														}
													});
									$('#tBody').append(trHTML);
								},
								error : function(err) {
									let error = `Ajax error: ${err.status} - ${err.statusText}`;
									console.log(error);
								}
							})
				});

$('#addstock').click(
		function(ev) {
			var dataSetModel = new Object();
			var el = ev.currentTarget;
			dataSetModel.quarter = $("#quarter", this.$el).val();
			dataSetModel.stock = $("#Stock", this.$el).val();
			dataSetModel.date = $("#Date", this.$el).val();
			dataSetModel.open = $("#Open", this.$el).val();
			dataSetModel.high = $("#High", this.$el).val();
			dataSetModel.low = $("#Low", this.$el).val();
			dataSetModel.close = $("#Close", this.$el).val();
			dataSetModel.volume = $("#Volume", this.$el).val();
			dataSetModel.ptChangePrice = $("#chng_prc", this.$el).val();
			dataSetModel.ptChangeVolOvrLstWk = $("#chng_vol_over_last_wk",
					this.$el).val();
			dataSetModel.prWeeksVol = $("#prv_weeks_vol", this.$el).val();
			dataSetModel.nxtWeeksOpen = $("#nxt_weeks_open", this.$el).val();
			dataSetModel.nxtWeeksClose = $("#nxt_weeks_close", this.$el).val();
			dataSetModel.ptChangeNextWeeksPrice = $("#change_nxt_weeks_prc",
					this.$el).val();
			dataSetModel.daysToNextDividend = $("#days_to_next_dvnd", this.$el)
					.val();
			dataSetModel.ptReturnNextDividend = $("#return_nxt_dvnd", this.$el)
					.val();

			$.ajax({
				url : 'http://localhost:8080/datasets/addDataSet',
				type : "POST",
				contentType : "application/json",
				data : JSON.stringify(dataSetModel)
			}).done(function(result) {

			}).fail(function() {
				$.jGrowl("Falied to Add data set.", {
					theme : 'error'
				});
			});
		});
