package com.iconsoftware.training;

import com.iconsoftware.training.model.TrainingRequest;
import com.iconsoftware.training.service.TrainingRequestService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // 1️⃣ Créer des demandes de formation
        List<TrainingRequest> requests = new ArrayList<>();

        requests.add(new TrainingRequest(500, 5, LocalDate.of(2025, 1, 1)));  // A
        requests.add(new TrainingRequest(600, 4, LocalDate.of(2025, 1, 5)));  // B
        requests.add(new TrainingRequest(200, 4, LocalDate.of(2025, 1, 10))); // C
        requests.add(new TrainingRequest(100, 2, LocalDate.of(2025, 1, 15))); // D

        // 2️⃣ Budget et quota annuel
        double annualBudget = 1000;
        int annualDaysQuota = 10;

        // 3️⃣ Créer le service et traiter les demandes
        TrainingRequestService service = new TrainingRequestService();
        service.processRequests(requests, annualBudget, annualDaysQuota);

        // 4️⃣ Afficher le résultat
        System.out.println("=== Résultats des demandes ===");
        for (TrainingRequest req : requests) {
            System.out.println(
                    "Date: " + req.getCreatedAt()
                    + " | Cost: " + req.getCost()
                    + " | Days: " + req.getDays()
                    + " | Status: " + req.getStatus()
            );
        }
    }
}
