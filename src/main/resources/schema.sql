/*CREATE TABLE IF NOT EXISTS item (
  id 				int(20) 	PRIMARY KEY AUTO_INCREMENT,
  basket_no 		varchar(64),
  rack_chemical_id 	int(20),
  purchase_date 	DATE,
  disposal_date		DATE,
  combined_date 	DATE,
  remarks 			varchar(64),
);

CREATE TABLE IF NOT EXISTS rack_chemical (
  id int(20) PRIMARY KEY AUTO_INCREMENT,
  chemical_id int(20),
  count int(20),
  quantity int(20),
  remaining_amount int(20),
  status varchar(64),
);
*/
CREATE TABLE IF NOT EXISTS chemical (
  name varchar(64) PRIMARY KEY,
  chemical_id int(20),
  count int(20),
  quantity int(20),
  remaining_amount int(20),
  status varchar(64),
);
