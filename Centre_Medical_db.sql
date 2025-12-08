Create database Centre_Medical_db;
use Centre_Medical_db;


SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

-- Creation du table Patient
CREATE TABLE Patient(
	idPt INT auto_increment PRIMARY KEY,
    nom VARCHAR(70),
    age INT,
    ville VARCHAR(70)
);

-- Remplissage du table Patient
INSERT INTO Patient(nom, age, ville)
VALUES
('Jordan Carter', 30, 'Atlanta'),
('Kanye West', 48, 'Chicago'),
('Frank Ocean', 38, 'California');

-- Creation du table Medcin
CREATE TABLE Medcin(
	idMd INT auto_increment PRIMARY KEY,
    nom VARCHAR(70),
    specialite VARCHAR(70),
    telephone VARCHAR(10)
);

-- Remplissage du table Medcin
INSERT INTO Medcin(nom, specialite, telephone)
VALUES
('Samir Axki', 'Cardiologie', '0612131415'),
('Khalid abuysf', 'neurologie', '061617181920'),
('Hamza mizo', 'pathologique', '062122232425');

-- Creation du table Rendez-vous
CREATE TABLE RDV (
    dateRDV DATE,
    acte VARCHAR(255),
    tarif DOUBLE,
	idPt INT,
    idMd INT,
    PRIMARY KEY (idPt, idMd, dateRDV),
    FOREIGN KEY (idPt) REFERENCES Patient(idPt),
    FOREIGN KEY (idMd) REFERENCES Medcin(idMd)
);

-- Remplissage du table Rendez-vous
INSERT INTO RDV (dateRDV, acte, tarif, idPt, idMd)
VALUES
('2025-11-12', 'Consultation', 150.00, 1, 1),
('2025-11-15', 'Radio', 300.00, 2, 1),
('2025-11-20', 'Vaccination', 220.00, 3, 2);

-- Creation du table Utilisateur
CREATE TABLE User (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(50) NOT NULL UNIQUE,
    nom VARCHAR(50),
    password CHAR(64) NOT NULL
);

-- +7 rows for Patient (total 10)
INSERT INTO Patient(nom, age, ville) VALUES
('Drake Graham', 39, 'Toronto'),
('Rihanna Fenty', 37, 'Bridgetown'),
('The Weeknd', 35, 'Toronto'),
('Adele Adkins', 36, 'London'),
('Bruno Mars', 40, 'Honolulu'),
('Doja Cat', 29, 'Los Angeles'),
('Billie Eilish', 23, 'Los Angeles');

-- +7 rows for Medcin (total 10)
INSERT INTO Medcin(nom, specialite, telephone) VALUES
('Youssef Karim', 'Dermatologie', '0601010101'),
('Amina Zahra', 'Pediatrie', '0602020202'),
('Omar Benali', 'Orthopedie', '0603030303'),
('Sara Elhadi', 'Gynecologie', '0604040404'),
('Nabil Farouk', 'Ophtalmologie', '0605050505'),
('Imane Toumi', 'Psychiatrie', '0606060606'),
('Hakim Razi', 'Radiologie', '0607070707');

-- +7 rows for RDV (total 10)
INSERT INTO RDV(dateRDV, acte, tarif, idPt, idMd) VALUES
('2025-12-01', 'Consultation', 120, 1, 3),
('2025-12-03', 'Analyse', 200, 10, 2),
('2025-12-05', 'Consultation', 150, 12, 8),
('2025-12-06', 'IRM', 500, 14, 10),
('2025-12-07', 'Consultation', 130, 12, 14),
('2025-12-08', 'Radio', 280, 15, 9),
('2025-12-09', 'Controle', 100, 10, 9);