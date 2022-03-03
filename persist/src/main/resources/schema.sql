CREATE TABLE pizza_order (
	order_id BIGINT auto_increment,
	first_name varchar(100),
	last_name varchar(100),
	contact_number varchar(100),
	email varchar(100),
	address varchar(100),
	order_time TIMESTAMP
);

CREATE TABLE pizza (
	pizza_id BIGINT auto_increment,
	name varchar(100),
	quantity int,
	order_id BIGINT
);
