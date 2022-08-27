const objs = [
  {
    "RAZAO": " AMBIUM SUSTENTABILIDADE DIGITAL",
    "TELEFONE": "(16) 3329-3196",
    "ENDERECO": "AV. PRESIDENTE VARGAS",
    "COMPLEMENTO": "SALA 2403"
  }
]

//console.log(objs)

//JSON
// converter objeto para json

const jsonData = JSON.stringify(objs);

console.log(jsonData)

// converter json para objeto

const objData = JSON.parse(jsonData);

console.log(objData)
