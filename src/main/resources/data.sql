create schema projectDB;
use projectDB;
drop table if exists users;
drop table if exists flights;
drop table if exists reservations;

CREATE TABLE Users (
                       id int not null PRIMARY KEY auto_increment,
                       username varchar(255),
                       password varchar(255)
);

CREATE TABLE Flights (
                         id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                         departure VARCHAR(255),
                         arrival VARCHAR(255),
                         departureDate DATE,
                         arrivalDate DATE
);

CREATE TABLE Reservations(
                             userID int ,
                             flightID int,
                             numberOfAdults int not null,
                             numberOfChildren int not null,

                             PRIMARY KEY(userID, flightID),
                             FOREIGN KEY (userID) REFERENCES Users(id) ON DELETE CASCADE,
                             FOREIGN KEY (flightID) REFERENCES Flights(id)
);

INSERT INTO Users (username, password) VALUES ('Maria', '123');

INSERT INTO Flights (departure, arrival, departureDate, arrivalDate)
VALUES ('New York', 'Los Angeles', '2025-10-01', '2025-10-01');

INSERT INTO Flights (departure, arrival, departureDate, arrivalDate)
VALUES ('Chicago', 'Miami', '2025-10-02', '2025-10-02');

INSERT INTO Flights (departure, arrival, departureDate, arrivalDate)
VALUES ('San Francisco', 'Seattle', '2025-10-03', '2025-10-03');

INSERT INTO Flights (departure, arrival, departureDate, arrivalDate)
VALUES ('Atlanta', 'Dallas', '2025-10-04', '2025-10-04');

INSERT INTO Flights (departure, arrival, departureDate, arrivalDate)
VALUES ('Boston', 'Denver', '2025-10-05', '2025-10-05');

INSERT INTO Flights (departure, arrival, departureDate, arrivalDate)
VALUES ('Las Vegas', 'New York', '2025-10-06', '2025-10-06');

INSERT INTO Flights (departure, arrival, departureDate, arrivalDate)
VALUES ('Houston', 'Chicago', '2025-10-07', '2025-10-07');

INSERT INTO Flights (departure, arrival, departureDate, arrivalDate)
VALUES ('Phoenix', 'Philadelphia', '2025-10-08', '2025-10-08');

INSERT INTO Flights (departure, arrival, departureDate, arrivalDate)
VALUES ('Orlando', 'San Diego', '2025-10-09', '2025-10-09');

INSERT INTO Flights (departure, arrival, departureDate, arrivalDate)
VALUES ('Detroit', 'Atlanta', '2025-10-10', '2025-10-10');