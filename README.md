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
  "$schema": "http://json-schema.org/draft-07/schema",
  "$id": "http://example.com/example.json",
  "type": "object",
  "required": [
    "id",
    "name",
    "status",
    "species",
    "type",
    "episode_count",
    "origin"
  ],
  "properties": {
    "id": {
      "$id": "#/properties/id",
      "type": "integer"
    },
    "name": {
      "$id": "#/properties/name",
      "type": "string"
    },
    "status": {
      "$id": "#/properties/status",
      "type": "string"
    },
    "species": {
      "$id": "#/properties/species",
      "type": "string"
    },
    "type": {
      "$id": "#/properties/type",
      "type": "string"
    },
    "episode_count": {
      "$id": "#/properties/episode_count",
      "type": "integer"
    },
    "origin": {
      "$id": "#/properties/origin",
      "type": "object",
      "required": [
        "name",
        "url",
        "dimension",
        "residents"
      ],
      "properties": {
        "name": {
          "$id": "#/properties/origin/properties/name",
          "type": "string"
        },
        "url": {
          "$id": "#/properties/origin/properties/url",
          "type": "string"
        },
        "dimension": {
          "$id": "#/properties/origin/properties/dimension",
          "type": "string"
        },
        "residents": {
          "$id": "#/properties/origin/properties/residents",
          "type": "array",
          "items": {
            "$id": "#/properties/origin/properties/residents/items",
            "type": "string"
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
  "id": 1,
  "name": "Rick Sanchez",
  "status": "Alive",
  "species": "Human",
  "type": "",
  "episode_count": 41,
  "origin": {
    "name": "Earth (Replacement Dimension)",
    "url": "https://rickandmortyapi.com/api/location/20",
    "dimension": "Replacement Dimension",
    "residents": [
      "https://rickandmortyapi.com/api/character/1",
      "https://rickandmortyapi.com/api/character/2",
      "https://rickandmortyapi.com/api/character/3",
      "https://rickandmortyapi.com/api/character/4",
      "https://rickandmortyapi.com/api/character/5",
      "https://rickandmortyapi.com/api/character/9",
      "https://rickandmortyapi.com/api/character/11",
      "https://rickandmortyapi.com/api/character/13",
      "https://rickandmortyapi.com/api/character/16",
      "https://rickandmortyapi.com/api/character/31",
      "https://rickandmortyapi.com/api/character/32",
      "https://rickandmortyapi.com/api/character/50",
      "https://rickandmortyapi.com/api/character/58",
      "https://rickandmortyapi.com/api/character/59",
      "https://rickandmortyapi.com/api/character/64",
      "https://rickandmortyapi.com/api/character/66",
      "https://rickandmortyapi.com/api/character/76",
      "https://rickandmortyapi.com/api/character/88",
      "https://rickandmortyapi.com/api/character/103",
      "https://rickandmortyapi.com/api/character/107",
      "https://rickandmortyapi.com/api/character/109",
      "https://rickandmortyapi.com/api/character/113",
      "https://rickandmortyapi.com/api/character/115",
      "https://rickandmortyapi.com/api/character/124",
      "https://rickandmortyapi.com/api/character/128",
      "https://rickandmortyapi.com/api/character/137",
      "https://rickandmortyapi.com/api/character/138",
      "https://rickandmortyapi.com/api/character/141",
      "https://rickandmortyapi.com/api/character/147",
      "https://rickandmortyapi.com/api/character/149",
      "https://rickandmortyapi.com/api/character/151",
      "https://rickandmortyapi.com/api/character/154",
      "https://rickandmortyapi.com/api/character/166",
      "https://rickandmortyapi.com/api/character/167",
      "https://rickandmortyapi.com/api/character/170",
      "https://rickandmortyapi.com/api/character/171",
      "https://rickandmortyapi.com/api/character/172",
      "https://rickandmortyapi.com/api/character/180",
      "https://rickandmortyapi.com/api/character/181",
      "https://rickandmortyapi.com/api/character/182",
      "https://rickandmortyapi.com/api/character/185",
      "https://rickandmortyapi.com/api/character/189",
      "https://rickandmortyapi.com/api/character/190",
      "https://rickandmortyapi.com/api/character/210",
      "https://rickandmortyapi.com/api/character/217",
      "https://rickandmortyapi.com/api/character/218",
      "https://rickandmortyapi.com/api/character/219",
      "https://rickandmortyapi.com/api/character/227",
      "https://rickandmortyapi.com/api/character/230",
      "https://rickandmortyapi.com/api/character/233",
      "https://rickandmortyapi.com/api/character/234",
      "https://rickandmortyapi.com/api/character/236",
      "https://rickandmortyapi.com/api/character/237",
      "https://rickandmortyapi.com/api/character/240",
      "https://rickandmortyapi.com/api/character/241",
      "https://rickandmortyapi.com/api/character/243",
      "https://rickandmortyapi.com/api/character/244",
      "https://rickandmortyapi.com/api/character/245",
      "https://rickandmortyapi.com/api/character/248",
      "https://rickandmortyapi.com/api/character/251",
      "https://rickandmortyapi.com/api/character/255",
      "https://rickandmortyapi.com/api/character/259",
      "https://rickandmortyapi.com/api/character/262",
      "https://rickandmortyapi.com/api/character/265",
      "https://rickandmortyapi.com/api/character/272",
      "https://rickandmortyapi.com/api/character/276",
      "https://rickandmortyapi.com/api/character/280",
      "https://rickandmortyapi.com/api/character/292",
      "https://rickandmortyapi.com/api/character/293",
      "https://rickandmortyapi.com/api/character/324",
      "https://rickandmortyapi.com/api/character/326",
      "https://rickandmortyapi.com/api/character/327",
      "https://rickandmortyapi.com/api/character/332",
      "https://rickandmortyapi.com/api/character/335",
      "https://rickandmortyapi.com/api/character/341",
      "https://rickandmortyapi.com/api/character/346",
      "https://rickandmortyapi.com/api/character/347",
      "https://rickandmortyapi.com/api/character/352",
      "https://rickandmortyapi.com/api/character/353",
      "https://rickandmortyapi.com/api/character/354",
      "https://rickandmortyapi.com/api/character/357",
      "https://rickandmortyapi.com/api/character/360",
      "https://rickandmortyapi.com/api/character/361",
      "https://rickandmortyapi.com/api/character/363",
      "https://rickandmortyapi.com/api/character/365",
      "https://rickandmortyapi.com/api/character/374",
      "https://rickandmortyapi.com/api/character/377",
      "https://rickandmortyapi.com/api/character/390",
      "https://rickandmortyapi.com/api/character/391",
      "https://rickandmortyapi.com/api/character/401",
      "https://rickandmortyapi.com/api/character/402",
      "https://rickandmortyapi.com/api/character/405",
      "https://rickandmortyapi.com/api/character/423",
      "https://rickandmortyapi.com/api/character/435",
      "https://rickandmortyapi.com/api/character/437",
      "https://rickandmortyapi.com/api/character/438",
      "https://rickandmortyapi.com/api/character/439",
      "https://rickandmortyapi.com/api/character/440",
      "https://rickandmortyapi.com/api/character/452",
      "https://rickandmortyapi.com/api/character/453",
      "https://rickandmortyapi.com/api/character/467",
      "https://rickandmortyapi.com/api/character/468",
      "https://rickandmortyapi.com/api/character/469",
      "https://rickandmortyapi.com/api/character/471",
      "https://rickandmortyapi.com/api/character/492",
      "https://rickandmortyapi.com/api/character/493",
      "https://rickandmortyapi.com/api/character/497",
      "https://rickandmortyapi.com/api/character/509",
      "https://rickandmortyapi.com/api/character/510",
      "https://rickandmortyapi.com/api/character/511",
      "https://rickandmortyapi.com/api/character/512",
      "https://rickandmortyapi.com/api/character/513",
      "https://rickandmortyapi.com/api/character/514",
      "https://rickandmortyapi.com/api/character/516",
      "https://rickandmortyapi.com/api/character/517",
      "https://rickandmortyapi.com/api/character/523",
      "https://rickandmortyapi.com/api/character/524",
      "https://rickandmortyapi.com/api/character/526",
      "https://rickandmortyapi.com/api/character/534",
      "https://rickandmortyapi.com/api/character/535",
      "https://rickandmortyapi.com/api/character/536",
      "https://rickandmortyapi.com/api/character/537",
      "https://rickandmortyapi.com/api/character/538",
      "https://rickandmortyapi.com/api/character/539",
      "https://rickandmortyapi.com/api/character/540",
      "https://rickandmortyapi.com/api/character/541",
      "https://rickandmortyapi.com/api/character/561",
      "https://rickandmortyapi.com/api/character/562",
      "https://rickandmortyapi.com/api/character/564",
      "https://rickandmortyapi.com/api/character/570",
      "https://rickandmortyapi.com/api/character/575",
      "https://rickandmortyapi.com/api/character/584",
      "https://rickandmortyapi.com/api/character/585",
      "https://rickandmortyapi.com/api/character/586",
      "https://rickandmortyapi.com/api/character/588",
      "https://rickandmortyapi.com/api/character/590",
      "https://rickandmortyapi.com/api/character/591",
      "https://rickandmortyapi.com/api/character/592",
      "https://rickandmortyapi.com/api/character/667"
    ]
  }
}
```

Se puede verificar el esquema y las futuras salidas en:

```
https://www.jsonschemavalidator.net/s/cdXBTVGy
```

## Ejecución

Se debe configurar la variable de entorno APP_ENV direccionando al archivo de propiedades. Por ejemplo:

APP_ENV=C:\workspace\rymc\src\main\resources\rymc.properties


Se debe iniciar la aplicación Springboot, luego con algún cliente REST (por ejemplo, Postman) hacer una solicitud. 
En caso de levantarlo en el servidor local, la URL queda como la siguiente:

```
GET http://localhost:8889/rymc/api/rest/getCharacter/3
```
