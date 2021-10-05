# Rick and Morty Challenge 

## Requerimiento

Usando la API de Rick And Morty:

- https://rickandmortyapi.com/documentation/#get-a-single-character 
- https://rickandmortyapi.com/documentation/#get-a-single-location 

Se expone un endpoint que permita realizar una petición con el id de 
algún personaje de la serie. Se entrega una respuesta basándose en el 
siguiente JSON Schema: 


```
{
  "$schema":"http://json-schema.org/draft-07/schema",
  "$id":"http://example.com/example.json",
  "type":"object",
  "required":[
    "id",
    "name",
    "status",
    "species",
    "type",
    "episode_count",
    "origin"
  ],
  "properties":{
    "id":{
      "$id":"#/properties/id",
      "type":"int"
    },
    "name":{
      "$id":"#/properties/name",
      "type":"string"
    },
    "status":{
      "$id":"#/properties/status",
      "type":"string"
    },
    "species":{
      "$id":"#/properties/species",
      "type":"string"
    },
    "type":{
      "$id":"#/properties/type",
      "type":"string"
    },
    "episode_count":{
      "$id":"#/properties/episode_count",
      "type":"int"
    },
    "origin":{
      "$id":"#/properties/origin",
      "type":"object",
      "required":[
        "name",
        "url",
        "dimension",
        "residents"
      ],
      "properties":{
        "name":{
          "$id":"#/properties/origin/properties/name",
          "type":"string"
        },
        "url":{
          "$id":"#/properties/origin/properties/url",
          "type":"string"
        },
        "dimension":{
          "$id":"#/properties/origin/properties/dimension",
          "type":"string"
        },
        "residents":{
          "$id":"#/properties/origin/properties/residents",
          "type":"array",
          "items":{
            "$id":"#/properties/origin/properties/residents/items",
            "type":"string"
          }
        }
      }
    }
  }
}

```

Por ejemplo si consultamos por el id 1 , nos quedaria algo asi:

```
{
  "id":1,
  "name":"Rick Sanchez",
  "status":"Alive",
  "species":"Human",
  "type":"",
  "episode_count":41,
  "origin":{
    "name":"Earth (C-137)",
    "url":"https://rickandmortyapi.com/api/location/1",
    "dimension":"Dimension C-137",
    "residents":[
      "https://rickandmortyapi.com/api/character/38",
      "https://rickandmortyapi.com/api/character/45",
      "https://rickandmortyapi.com/api/character/71",
      "https://rickandmortyapi.com/api/character/82",
      "https://rickandmortyapi.com/api/character/83",
      "https://rickandmortyapi.com/api/character/92",
      "https://rickandmortyapi.com/api/character/112",
      "https://rickandmortyapi.com/api/character/114",
      "https://rickandmortyapi.com/api/character/116",
      "https://rickandmortyapi.com/api/character/117",
      "https://rickandmortyapi.com/api/character/120",
      "https://rickandmortyapi.com/api/character/127",
      "https://rickandmortyapi.com/api/character/155",
      "https://rickandmortyapi.com/api/character/169",
      "https://rickandmortyapi.com/api/character/175",
      "https://rickandmortyapi.com/api/character/179",
      "https://rickandmortyapi.com/api/character/186",
      "https://rickandmortyapi.com/api/character/201",
      "https://rickandmortyapi.com/api/character/216",
      "https://rickandmortyapi.com/api/character/239",
      "https://rickandmortyapi.com/api/character/271",
      "https://rickandmortyapi.com/api/character/302",
      "https://rickandmortyapi.com/api/character/303",
      "https://rickandmortyapi.com/api/character/338",
      "https://rickandmortyapi.com/api/character/343",
      "https://rickandmortyapi.com/api/character/356",
      "https://rickandmortyapi.com/api/character/394"
    ]
  }
}
```


