# kata-clean-rest-api

## Objectif du kata
Comparer différentes manières d'implémenter une API REST en Java avec SpringBoot.
Apprendre, en fonction de son contexte, à positionner le bon curseur entre l'isolation du code métier avec celui de l'API.

Les différentes solutions sont décrites dans les commits :
- Utilisation des maps.
- Mapping implicites entre attribut de classe et json. Tout est lié, mais sans le dire.
- Mapping explicites, avec annotation de la classe. La classe connait le mapping.
- Mapping explicites dans une classe séparée.  Le mapping est externalisé.
- Mapping explicites, avec désérialiseur, vraiment quand Jackson ne le permet pas par configuration.

## Documentation de l'API de modification de la designation d'un établissement
### Objectif
Demander la modification de la dénomination usuelle et de l'enseigne d'un établissement identifié par son SIRET. Ce couple correspond à la notion métier de désignation INSEE.

### Paramètres
- Siret
- dénomination usuelle
- Enseigne

La dénomination usuelle est obligatoire dès la création de l'établissement.
Néanmoins, dans cette API, aucun des champs "enseigne" ou "dénomination usuelle" n'est obligatoire ; l'absence d'un champ indique juste qu'on ne souhaite pas modifier sa valeur.

Le Siret peut être proposé avec des espaces, et sans les 0 en tête. Des exemples sont donnés en fin de documents.

Dénomination usuelle et Enseigne peuvent contenir des caractères accentués, mais ceux-ci seront remplacés par les caractères non accentués correspondant à l'enregistrement.
### Retours
Cas nominal : renvoie la dénomination usuelle et l'Enseigne de l'établissement. Ces informations auront été normalisées le cas échéant (remplacement des accents).

Cas d'erreur : requête invalide si les deux champs sont absent.

### Exemples
#### Siret dans l'URI
Requête :
`POST /etablissement/73282932000074/designation/`
```json
{
  "denomination_usuelle": "Nature SAS",
  "enseigne": "Le Beau Pré"
}
```
Réponse (sans accent) : `200` 
```json
{
  "denomination_usuelle": "Nature SAS",
  "enseigne": "Le Beau Pre"
}

```

#### Siret dans le body
`POST /dénomination/`
```json
{
  "SIRET": "73282932000074",
  "designation": {
    "denomination_usuelle": "Nature SAS",
    "enseigne": "Le Beau Pré"
  }
}
```
Réponse (sans accent) : `200`
```json
{
  "denomination_usuelle": "Nature SAS",
  "enseigne": "Le Beau Pre"
}

```

#### Exemple de Siret valides
- 51320534400031
- 513 205 344 00031
- 00320534400452
- 320534400452
- 3205344 00452



