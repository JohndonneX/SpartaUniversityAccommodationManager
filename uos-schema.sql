DROP SCHEMA IF EXISTS uos_manager;
CREATE SCHEMA uos_manager;
USE uos_manager;

 

CREATE TABLE occupancy_type (
    room_type_id INT NOT NULL,
    no_of_bedrooms INT NOT NULL,
	details VARCHAR(500),
    type_description TEXT,
    PRIMARY KEY (room_type_id) 
    );

 

CREATE TABLE occupancy (
    room_id INT NOT NULL,
    room_type_id INT NOT NULL,
    current_occupants INT,
    floor_no INT NOT NULL,
    PRIMARY KEY (room_id),
    CONSTRAINT fk_room_type FOREIGN KEY (room_type_id) REFERENCES occupancy_type (room_type_id) ON DELETE RESTRICT
    );
    

    
CREATE TABLE resident (
    resident_id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(35) NOT NULL,
    last_name VARCHAR(35) NOT NULL,
    email VARCHAR(255) NOT NULL,
    contact_no VARCHAR(20) NOT NULL,
    room_id INT,
    role VARCHAR(20),
    PRIMARY KEY (resident_id),
    CONSTRAINT fk_room FOREIGN KEY (room_id) REFERENCES occupancy (room_id) ON DELETE RESTRICT
);

 

CREATE TABLE admin (
    admin_id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(35) NOT NULL,
    last_name VARCHAR(35) NOT NULL,
    email VARCHAR(255) NOT NULL,
    contact_no VARCHAR(20) NOT NULL,
    profile_image VARCHAR(20),
    role VARCHAR(20),
    PRIMARY KEY (admin_id)
);

 

CREATE TABLE login (
    login_id INT NOT NULL AUTO_INCREMENT,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(30) NOT NULL,
    resident_id INT,
    admin_id INT,
    PRIMARY KEY (login_id),
    CONSTRAINT fk_resident FOREIGN KEY (resident_id) REFERENCES resident (resident_id) ON DELETE CASCADE,
    CONSTRAINT fk_admin FOREIGN KEY (admin_id) REFERENCES admin (admin_id) ON DELETE CASCADE
);

 

CREATE TABLE resident_notice (
    resident_post_id INT NOT NULL AUTO_INCREMENT,
    resident_id INT NOT NULL,
    date_time_posted DATETIME NOT NULL,
    title VARCHAR(255),
    content TEXT,
    PRIMARY KEY (resident_post_id),
    CONSTRAINT fk_resident2 FOREIGN KEY (resident_id) REFERENCES resident (resident_id) ON DELETE CASCADE
);

 

CREATE TABLE admin_notice (
    admin_post_id INT NOT NULL AUTO_INCREMENT,
    admin_id INT NOT NULL,
    date_time_posted DATETIME NOT NULL,
    title VARCHAR(255),
    content TEXT,
    PRIMARY KEY (admin_post_id),
    CONSTRAINT fk_admin2 FOREIGN KEY (admin_id) REFERENCES admin (admin_id) ON DELETE CASCADE
);

 

CREATE TABLE enquiry (
    enquiry_id INT NOT NULL AUTO_INCREMENT,
    date_time_posted DATETIME NOT NULL,
    email VARCHAR(255) NOT NULL,
    contact_no VARCHAR(20) NOT NULL,
    content TEXT,
    status VARCHAR(20),
    PRIMARY KEY (enquiry_id)
);

 

CREATE TABLE issue (
    issue_id INT NOT NULL AUTO_INCREMENT,
    date_time_posted DATETIME NOT NULL,
    title VARCHAR(255),
    content TEXT,
    status VARCHAR(20),
    date_time_resolved DATETIME,
    PRIMARY KEY (issue_id)
);

 

CREATE TABLE delivery (
    delivery_id INT NOT NULL AUTO_INCREMENT,
    resident_id INT NOT NULL,
    date_time_of_arrival DATETIME,
    delivery_description TEXT,
    status VARCHAR(20),
    PRIMARY KEY (delivery_id),
    CONSTRAINT fk_resident3 FOREIGN KEY (resident_id) REFERENCES resident (resident_id) ON DELETE CASCADE
);

 

CREATE TABLE recreational_room_type (
    recreational_room_type_id INT NOT NULL,
    title VARCHAR(50),
    description TEXT,
    PRIMARY KEY (recreational_room_type_id)
);

 


CREATE TABLE booking (
    booking_id INT NOT NULL AUTO_INCREMENT,
    resident_id INT NOT NULL,
    recreational_room_type_id INT NOT NULL,
    start_date_time DATETIME NOT NULL,
    end_date_time DATETIME NOT NULL,
    status VARCHAR(20),
    PRIMARY KEY (booking_id),
    CONSTRAINT fk_recreational_room_type FOREIGN KEY (recreational_room_type_id) REFERENCES recreational_room_type (recreational_room_type_id) ON DELETE RESTRICT,
    CONSTRAINT fk_resident4 FOREIGN KEY (resident_id) REFERENCES resident (resident_id) ON DELETE CASCADE
);