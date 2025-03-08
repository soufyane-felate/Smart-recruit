CREATE DATABASE SmartRecruit;
USE SmartRecruit;


CREATE TABLE Utilisateur (
    id INT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(100) UNIQUE NOT NULL,
    motDePasse VARCHAR(255) NOT NULL,
    role ENUM('Candidat', 'Recruteur') NOT NULL
);
CREATE TABLE Candidat (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    cv TEXT,
    idUtilisateur INT NOT NULL,
    FOREIGN KEY (idUtilisateur) REFERENCES Utilisateur(id)
);
CREATE TABLE OffreEmploi (
    id INT PRIMARY KEY AUTO_INCREMENT,
    titre VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    datePublication DATE NOT NULL,
    idRecruteur INT NOT NULL,
    FOREIGN KEY (idRecruteur) REFERENCES Utilisateur(id)
);
CREATE TABLE Candidature (
    id INT PRIMARY KEY AUTO_INCREMENT,
    idCandidat INT NOT NULL,
    idOffreEmploi INT NOT NULL,
    dateCandidature DATE NOT NULL,
    statut ENUM('En attente', 'Accepté', 'Refusé') DEFAULT 'En attente',
    FOREIGN KEY (idCandidat) REFERENCES Candidat(id),
    FOREIGN KEY (idOffreEmploi) REFERENCES OffreEmploi(id)
);