# Test Technique – Développeur Full Stack Junior

## Contexte

Un employé peut soumettre des demandes de formation.  
Le système décide automatiquement si chaque demande est **APPROVED**, **REJECTED_BUDGET**, **REJECTED_DAYS**, ou **PENDING**, selon :

- Le **budget annuel** disponible pour l’employé
- Le **quota annuel de jours** maximum (20 jours)

Les demandes sont traitées **dans l’ordre chronologique** (la plus ancienne en premier).

---

## Logique métier

1. Trier les demandes par date de création (ancienne → récente)
2. Pour chaque demande :
   - Vérifier si le budget restant est suffisant
   - Vérifier si le nombre de jours restant est suffisant
   - Si les deux conditions sont remplies :
     - Statut → **APPROVED**
     - Mettre à jour le budget et les jours restants
   - Sinon si budget insuffisant → **REJECTED_BUDGET**
   - Sinon si jours insuffisants → **REJECTED_DAYS**

> Les demandes rejetées ne consomment **ni budget ni jours**.

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

## Complexité

- Tri par date : **O(n log n)**  
- Parcours des demandes : **O(n)**  
- **Complexité totale : O(n log n)**

---

## Limites et améliorations possibles

- Gestion multi-employés (aujourd’hui le code gère un seul employé)
- Persistance en base de données (ex: MySQL, MongoDB)
- Exposition via une API REST (Spring Boot Controller)
- Tests unitaires pour chaque scénario (JUnit)

---

## Comment exécuter

1. Cloner le dépôt
2. Ouvrir le projet dans **VS Code**
3. Compiler et exécuter `Main.java`
4. Les résultats des demandes s’affichent dans la console
