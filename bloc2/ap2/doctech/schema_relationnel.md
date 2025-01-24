## Proposition de Schéma relationnel

agents (_ag_matricule_, ag_nom, ag_pwd, #ve_immat, #se_id, #ta_int)
  - Le champ ag_matricule constitue la clé primaire de la table. C'était déjà un identifiant de l'entité agents.
  - Le champ ve_immat est une clé étrangère. Il a migré par l'association de dépendance fonctionnelle roule à partir de l'entité vehicules en perdant son caractère identifiant.
  - Le champ se_id est une clé étrangère. Il a migré par l'association de dépendance fonctionnelle gere à partir de l'entité secteurs en perdant son caractère identifiant.
  - Le champ ta_int est une clé étrangère. Il a migré par l'association de dépendance fonctionnelle est de à partir de l'entité types_agent en perdant son caractère identifiant.

fdrm (_#ag_matricule_, _fdrm_mois_, fdrm_reception, fdrm_valisation, fdrm_paiement,fdrm_remboursement, nbrj_conges, #ag_comptable)
  - Le champ ag_matricule 1 fait partie de la clé primaire de la table. C'est une clé étrangère qui a migré à partir de l'entité agents pour renforcer l'identifiant.
  - Le champ fdrm_mois fait partie de la clé primaire de la table. C'était déjà un identifiant de l'entité fdrm.
  - Le champ ag_comptable est une clé étrangère. Il a migré par l'association de dépendance fonctionnelle compta valide à partir de l'entité agents en perdant son caractère identifiant.

frais (_fr_id_, fr_libelle, fr_date, fr_quantite, fr_montant, fr_taxe, fr_status, #tre_id, #ag_matricule, #fdrm_mois, #mfr_id)
  - Le champ fr_id constitue la clé primaire de la table. C'était déjà un identifiant de l'entité frais.
  - Le champ tre_id est une clé étrangère. Il a migré par l'association de dépendance fonctionnelle est de à partir de l'entité types_frais en perdant son caractère identifiant.
  - Les champs ag_matricule et fdrm_mois sont des clés étrangères. Ils ont migré par l'association de dépendance fonctionnelle comprenne à partir de l'entité fdrm en perdant leur caractère identifiant.
  - Le champ mfr_id est une clé étrangère. Il a migré par l'association de dépendance fonctionnelle est de à partir de l'entité modele_frais en perdant son caractère identifiant.

frais_km (_fkm_id_, fkm_cv, fkm_carburant, fkm_remb)
  - Le champ fkm_id constitue la clé primaire de la table. C'était déjà un identifiant de l'entité frais_km.

modele_frais (_mfr_id_, mfr_libelle, mfr_montant_unitaire)
  - Le champ mfr_id constitue la clé primaire de la table. C'était déjà un identifiant de l'entité modele_frais.

parametres (_pa_id_, keyword, value)
  - Le champ pa_id constitue la clé primaire de la table. C'était déjà un identifiant de l'entité parametres.

secteurs (_se_id_, se_libelle)
  - Le champ se_id constitue la clé primaire de la table. C'était déjà un identifiant de l'entité secteurs.

types_agent (_ta_int_, ta_libelle)
  - Le champ ta_int constitue la clé primaire de la table. C'était déjà un identifiant de l'entité types_agent.

types_frais (_tre_id_, tre_libelle)
  - Le champ tre_id constitue la clé primaire de la table. C'était déjà un identifiant de l'entité types_frais.

vehicules (_ve_immat_, ve_marque, ve_model, #fkm_id)
  - Le champ ve_immat constitue la clé primaire de la table. C'était déjà un identifiant de l'entité vehicules.
  - Le champ fkm_id est une clé étrangère. Il a migré par l'association de dépendance fonctionnelle applique à partir de l'entité frais_km en perdant son caractère identifiant.