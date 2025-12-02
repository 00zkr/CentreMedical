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
- Mois affichés en **français**  
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

MySQL (ou autre SGBD relationnel)

JFreeChart & JCommon

NetBeans IDE

MVC / DAO Pattern

## 🖥️ Interface utilisateur

Application Desktop

JFrame principal avec JDesktopPane

Navigation via JInternalFrame

Dialogues personnalisés pour les ajouts / modifications

Design épuré et moderne

## ▶️ Exécution du projet

Importer le projet dans NetBeans

Configurer la connexion à la base de données dans Connexion.java

Créer les tables nécessaires (Patient, Medcin, RDV)

Lancer la classe principale

## ✅ Remarques

Gestion des erreurs courantes (sélection vide, données invalides)

Filtres et calculs dynamiques

Code structuré et facilement extensible

## 👤 Auteur

Développé par Rhendour Zakaria

Projet pédagogique – Gestion de cabinet médical
