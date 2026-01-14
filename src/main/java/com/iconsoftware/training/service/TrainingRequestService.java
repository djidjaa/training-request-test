package com.iconsoftware.training.service;

import com.iconsoftware.training.model.TrainingRequest;

import java.util.Comparator;
import java.util.List;

public class TrainingRequestService {

    /**
     * Traite une liste de demandes de formation
     * @param requests liste des demandes
     * @param annualBudget budget annuel disponible
     * @param annualDaysQuota nombre de jours annuel disponible
     */
    public void processRequests(
            List<TrainingRequest> requests,
            double annualBudget,
            int annualDaysQuota
    ) {
        // 1️⃣ Trier par date de création (ancienne → récente)
        requests.sort(Comparator.comparing(TrainingRequest::getCreatedAt));

        double remainingBudget = annualBudget;
        int remainingDays = annualDaysQuota;

        // 2️⃣ Parcourir chaque demande
        for (TrainingRequest request : requests) {

            // Vérification budget
            if (request.getCost() > remainingBudget) {
                request.setStatus(TrainingRequest.Status.REJECTED_BUDGET);
            }
            // Vérification jours
            else if (request.getDays() > remainingDays) {
                request.setStatus(TrainingRequest.Status.REJECTED_DAYS);
            }
            // Tout est OK
            else {
                request.setStatus(TrainingRequest.Status.APPROVED);
                remainingBudget -= request.getCost();
                remainingDays -= request.getDays();
            }
        }
    }
}
