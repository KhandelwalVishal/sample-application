DROP TABLE IF EXISTS datasets;


CREATE TABLE datasets(
id INT AUTO_INCREMENT  PRIMARY KEY,
  quarter INT,
stock VARCHAR(25),date VARCHAR(25),open DECIMAL(20,10),high DECIMAL(20,10),low DECIMAL(20,10),close DECIMAL(20,10),volume DECIMAL(20,10)
,percent_change_price DECIMAL(20,10),percent_change_volume_over_last_wk DECIMAL(20,10),previous_weeks_volume DECIMAL(20,10),next_weeks_open DECIMAL(20,10),next_weeks_close DECIMAL(20,10),percent_change_next_weeks_price DECIMAL(20,10),
days_to_next_dividend DECIMAL(20,10),percent_return_next_dividend DECIMAL(20,10));