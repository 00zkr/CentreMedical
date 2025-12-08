# 🏥 Cabinet Médical – Java Swing Application

## 📌 Description
Ce projet est une application de **gestion de cabinet médical** développée en **Java (Swing)**.  
Elle permet de gérer les **patients**, **médecins** et **rendez-vous**, avec des fonctionnalités de recherche, de statistiques et de calcul des recettes.

Le projet suit une architecture claire basée sur **DAO / Entities / GUI** et utilise une base de données relationnelle.

---

## ⚙️ Fonctionnalités

### 👤 Gestion des patients
- Ajouter un patient  
- Modifier un patient  
- Supprimer un patient  
- Afficher la liste des patients  

### 👨‍⚕️ Gestion des médecins
- Gestion des spécialités  
- Association des médecins aux rendez-vous  

### 📅 Gestion des rendez-vous (RDV)
- Ajouter / modifier / supprimer un rendez-vous  
- Associer un patient et un médecin  
- Filtrer les rendez-vous :
  - Par **date (de → à)**
  - Par **spécialité**
- Suivi des actes réalisés  

### 💰 Calcul des recettes
- Calcul automatique des recettes  
- Mise à jour selon les filtres appliqués  
- Affichage clair et sans décimales  

### 📊 Statistiques
- Graphique du nombre de rendez-vous par mois  
- Mois affichés
- Graphiques réalisés avec **JFreeChart**  

---

## 🧱 Architecture du projet

```text
src/
│
├── dao/            # Accès aux données (DAO)
├── entities/       # Entités (Patient, Medcin, RDV ...)
├── gui/            # Interfaces graphiques (JFrame, JInternalFrame, JDialog)
├── connexion/      # Connexion à la base de données
```

## 🛠️ Technologies utilisées

Java SE (Swing)

JDBC

MySQL

JFreeChart & JCommon

NetBeans IDE

MVC / DAO Pattern

## 🖥️ Interface utilisateur

Application Desktop

JFrame principal avec JDesktopPane

Navigation via JInternalFrame

Dialogues personnalisés pour les ajouts / modifications

Design épuré et moderne

## ▶️ MCD:

<img width="1348" height="316" alt="{A67EADA3-492A-45C9-BD15-5C9E716E8D15}" src="https://github.com/user-attachments/assets/17e9b8ad-71f0-45e1-8899-c797df3575d7" />

## ▶️ Creation dex tableaux (MYSQL):

```text
-- Creation du table Patient
CREATE TABLE Patient(
	idPt INT auto_increment PRIMARY KEY,
    nom VARCHAR(70),
    age INT,
    ville VARCHAR(70)
);

-- Creation du table Medcin
CREATE TABLE Medcin(
	idMd INT auto_increment PRIMARY KEY,
    nom VARCHAR(70),
    specialite VARCHAR(70),
    telephone VARCHAR(10)
);

-- Creation du table RDV
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
```


## ✅ Remarques

Gestion des erreurs courantes (sélection vide, données invalides)

Filtres et calculs dynamiques

Code structuré et facilement extensible

## ✅ Vidéos

https://github.com/user-attachments/assets/f73a7bd9-eef4-4b94-8e74-210b54ab9d20

Installation (Le fichier CentreMed.exe est dans le dossier dist)

https://github.com/user-attachments/assets/52e452a8-ea48-4130-87a2-9faca63276f3

## 👤 Auteur

Développé par Rhendour Zakaria

Projet pédagogique – Gestion de cabinet médical
