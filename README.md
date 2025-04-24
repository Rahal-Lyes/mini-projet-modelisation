# 📚 Mini Projet de Modélisation : Gestion d'une Bibliothèque

Ce projet est une application Java basée sur Swing qui permet de gérer une bibliothèque avec des utilisateurs (admin, lecteurs) et des livres. Il est développé dans le cadre d’un mini-projet du module **Modélisation**.

##  UML

![UML Diagram of Library Classes](../diagramm%20de%20class.jpg)


## 🛠️ Technologies utilisées

- Java (JDK 8+)
- Java Swing (interface graphique)
- Architecture orientée objet (POO)
- **Pattern Singleton** (Lazy Singleton avec Double-Checked Locking)
- **Pattern Factory** (Factory Method pour la création des utilisateurs et la recherche de livres)

---

## ⚙️ Fonctionnalités

### ✅ Utilisateurs
- Création d'utilisateurs (admin ou lecteur)
- Affichage de tous les utilisateurs inscrits

### ✅ Livres
- Ajout de livres avec un titre, un auteur et un code
- Recherche de livres par mot-clé (titre)
- Affichage de tous les livres disponibles

---

## 🧑‍💻 Design Patterns Utilisés

### 🔹 **Lazy Singleton avec Double-Checked Locking**

Le **Lazy Singleton** est un modèle de conception qui garantit qu'une seule instance d'une classe sera créée et utilisée tout au long de l'application. Ce pattern est particulièrement utile pour les objets comme les connexions à une base de données ou les configurations d'application, où une seule instance suffit pour toute l'application.

Dans ce projet, le pattern **Lazy Singleton** est utilisé pour la classe `Bibliotheque`. L'objectif principal est de créer l'instance de la classe `Bibliotheque` uniquement lorsqu'elle est nécessaire, plutôt qu'au démarrage de l'application.

De plus, pour garantir l'efficacité dans un environnement multithreadé, la technique de **Double-Checked Locking** est utilisée. Cela signifie que l'instance est d'abord vérifiée sans verrouillage pour éviter les coûts de synchronisation inutiles lors des appels répétés à la méthode de récupération de l'instance. Le verrouillage est appliqué uniquement lors de la première création de l'instance pour garantir qu'une seule instance soit créée de manière thread-safe.

Cette combinaison permet de s'assurer qu'une seule instance de `Bibliotheque` est utilisée, tout en maintenant des performances optimales dans les scénarios multithreadés.

---
