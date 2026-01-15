# Training Request Test – ICON SOFTWARE

## Contexte
Un employé soumet des demandes de formation. Le système décide automatiquement si chaque demande est :

- **APPROVED** : budget et jours disponibles suffisants  
- **REJECTED_BUDGET** : budget insuffisant  
- **REJECTED_DAYS** : quota de jours dépassé  
- **PENDING** : en attente de traitement  

Les demandes sont traitées dans **l’ordre chronologique** (la plus ancienne en premier).

---
## Structure du projet
```bash
training-request-test/
├── src/
│ └── main/java/com/iconsoftware/training/
│ ├── model/ # Contient la classe TrainingRequest
│ ├── service/ # Contient la logique de traitement des demandes
│ └── Main.java # Point d'entrée du programme
├── target/ # Fichiers compilés
├── pom.xml # Gestionnaire de dépendances Maven
└── README.md
   ```

---

## Algorithme et logique métier

1. **Trier les demandes** par date de création.  
2. Pour chaque demande :  
   - Vérifier si le budget restant et le quota de jours permettent l’approbation.  
   - Mettre à jour le statut : `APPROVED`, `REJECTED_BUDGET`, `REJECTED_DAYS` ou `PENDING`.  
3. Après approbation, **mettre à jour le budget et les jours restants** de l’employé.  

---

## Exemple

### Données initiales
- Budget annuel : 1000 €
- Quota annuel : 10 jours
- Demandes :

| Date       | Cost | Days |
|------------|------|------|
| 01/01/2025 | 500  | 5    |
| 05/01/2025 | 600  | 4    |
| 10/01/2025 | 200  | 4    |
| 15/01/2025 | 100  | 2    |

### Résultat attendu

| Date       | Cost | Days | Status         |
|------------|------|------|----------------|
| 01/01/2025 | 500  | 5    | APPROVED       |
| 05/01/2025 | 600  | 4    | REJECTED_BUDGET|
| 10/01/2025 | 200  | 4    | APPROVED       |
| 15/01/2025 | 100  | 2    | REJECTED_DAYS  |

---

## Complexité approximative

- Tri des demandes : **O(n log n)**  
- Parcours et traitement des demandes : **O(n)**  
- **Total : O(n log n)**

---

## Limites et améliorations possibles

- Gestion d’un seul employé à la fois. Peut être étendu à plusieurs employés.  
- Pas de persistance en base de données (tout est en mémoire).  
- Possibilité d’ajouter des validations pour les dates ou les valeurs négatives.  
- Amélioration possible : priorisation des formations selon le type ou l’urgence.  

---

## Exécution

### Option 1 – Avec VS Code 

1. Cloner le dépôt :  
```bash
git clone https://github.com/djidjaa/training-request-test.git
   ```
2. Ouvrir le projet dans VS Code.

3. Ouvrir Main.java et cliquer sur Run ou F5.

4. Les résultats des demandes s’affichent dans la console, avec les statuts APPROVED, REJECTED_BUDGET, REJECTED_DAYS ou PENDING.

### Option 2 – Avec PowerShell 

1. Cloner le dépôt :  
```bash
git clone https://github.com/djidjaa/training-request-test.git
cd training-request-test
   ```
2. Compiler les fichiers Java :
```bash
javac -d target\classes (Get-ChildItem -Recurse src\main\java\*.java)
   ```
4. Lancer le programme :
```bash
java -cp target\classes com.iconsoftware.training.Main
   ```
6. Les résultats des demandes s’affichent dans la console.
