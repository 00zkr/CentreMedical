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

<img width="1341" height="424" alt="{5089F397-BC9E-4AA3-90AE-9A6CB88E3327}" src="https://github.com/user-attachments/assets/f6d1b40d-644c-4964-aacb-5fdd9ba7f855" />

## ▶️ Creation dex tableaux (MYSQL):




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
