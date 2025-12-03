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
CREATE TABLE RDV(
	idRDV INT auto_increment PRIMARY KEY,
    dateRDV DATE,
    acte VARCHAR(70),
    tarif DOUBLE,
    idPt INT,
    idMd INT,
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
