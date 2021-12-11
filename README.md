# kata-clean-rest-api

## Objectif du kata
Comparer différentes manières d'implémenter une API REST en Java avec SpringBoot.
Apprendre, en fonction de son contexte, à positionner le bon curseur entre l'isolation du code métier avec celui de l'API.

Les différentes solutions sont décrites dans les commits :
- Mapping implicites entre attribut de classe et json (72c6f19). Tout est lié, mais sans le dire.
- Mapping explicites, avec annotation de la classe (229bf40). La classe connait le mapping.
- Mapping explicites, avec désérialiseur (65be8e1). Le mapping est externalisé.

@TODOs / Points ouverts
- la règle qui dit qu'un champ non présent dans le json indique qu'on ne souhaite pas le modifier casse le fait de pouvoir utiliser des objets métier dès le controller. Ce n'est donc pas implémenté ici.  Cela semble remettre pas mal de choses en cause, puisque je trouve cette pratique bonne. Cela promouvrait l'utilisation de DTO, sans règle métier.
- le verbe Patch ne semblerait pas fonctionner avec le RestController SpringBoot.
- traiter les retours de la même manière.

## Documentation de l'API de modification de la designation d'un établissement
### Objectif
Demander la modification de la denomination usuelle et de l'enseigne d'un établissement identifié par son SIRET. Ce couple correspond à la notion métier de désignation INSEE.

### Paramètres
- Siret
- denomination usuelle
- Enseigne

La denomination usuelle est obligatoire dès la création de l'établissement.
Néanmoins, dans cette API, aucun des champs "enseigne" ou "denomination usuelle" n'est obligatoire ; l'absence d'un champ indique juste qu'on ne souhaite pas modifier sa valeur.

Le Siret peut être proposé avec des espaces, et sans les 0 en tête. Des exemples sont donnés en fin de documents.

denomination usuelle et Enseigne peuvent contenir des caractères accentués, mais ceux-ci seront remplacés par les caractères non accentués correspondant à l'enregistrement.
### Retours
Cas nominal : renvoie la denomination usuelle et l'Enseigne de l'établissement. Ces informations auront été normalisées le cas échéant (remplacement des accents).

Cas d'erreur : requête invalide si les deux champs sont absent.

### Exemples
#### Siret dans l'URI
Requête :
`POST /etablissement/73282932000074/designation/`
```json
{
  "denomination-usuelle": "Nature SAS",
  "enseigne": "Le Beau Pré"
}
```
Réponse (sans accent) : `200` 
```json
{
  "denomination-usuelle": "Nature SAS",
  "enseigne": "Le Beau Pre"
}

```

#### Siret dans le body
`POST /denomination/`
```json
{
  "SIRET": "73282932000074",
  "designation": {
    "denomination-usuelle": "Nature SAS",
    "enseigne": "Le Beau Pré"
  }
}
```
Réponse (sans accent) : `200`
```json
{
  "denomination-usuelle": "Nature SAS",
  "enseigne": "Le Beau Pre"
}

```

#### Exemple de Siret valides
- 51320534400031
- 513 205 344 00031
- 00320534400452
- 320534400452
- 3205344 00452



