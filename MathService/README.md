## Math Service
The following endpoints are exposed within the Math Service. All endpoints use HTTP method `POST`
and consume and produce a Content-Type of `application/json`.

Clients should be prepared for additive changes to be made to the existing JSON documents (i.e.,
adding new fields). To that end, clients should ignore properties in a JSON response that they do
not understand.


### Addition Endpoint
This endpoint adds two numbers together and returns the result.

- Location: `/add`
- Status Codes:
  - `200`: The sum was computed successfully.
  - `400`: One or both of `augend` or `addend` was null, or the summation resulted in an integer
  overflow, or the request was otherwise malformed.

_Sample Addition Request_
```
{
  "augend": 2,
  "addend": 6
}
```

_Sample Addition Response_
```
{
  "sum": 8
}
```


### Division Endpoint
This endpoint divides two numbers using integer division and returns the quotient. 

- Location: `/divide`
- Status Codes:
  - `200`: The quotient was computed successfully.
  - `400`: One or both of `dividend` or `divisor` was null, or `divisor` was `0`, or the request was
  otherwise malformed.

_Sample Division Request_
```
{
  "dividend": 12,
  "divisor": 5
}
```

_Sample Division Response_
```
{
  "quotient": 2,
  “remainder”: 2	
}
```


### Intersect Endpoint
This endpoint computes the intersection over two sets of numbers, using set-wise logic.

- Location: `/intersect`
- Status Codes:
  - `200`: The intersect was computed successfully.
  - `400`: `left` or `right` was null, or the request was otherwise malformed.

_Sample Intersect Request_
```
{
  "left": [5, 12, 9, 3, 2, -12, 4, 0, 1],
  "right": [3, 8, 7, 1, 5]
}
```

_Sample Intersect Response_
```
{
  "intersection": [3, 5, 1]
}
```


### Max Endpoint
This endpoint computes the maximum over a range of numbers.

- Location: `/max`
- Status Codes:
  - `200`: The minimum was computed successfully.
  - `400`: `numbers` was null or empty, or the request was otherwise malformed.

_Sample Max Request_
```
{
  "numbers": [5, 12, 9, 3, 2, -12, 4, 0, 1]
}
```

_Sample Max Response_
```
{
  "max": 12
}
```


### Min Endpoint
This endpoint computes the minimum over a range of numbers.

- Location: `/min`
- Status Codes:
  - `200`: The minimum was computed successfully.
  - `400`: `numbers` was null or empty, or the request was otherwise malformed.

_Sample Min Request_
```
{
  "numbers": [5, 12, 9, 3, 2, -12, 4, 0, 1]
}
```

_Sample Min Response_
```
{
  "min": -12
}
```


### Multiplication Endpoint
This endpoint multiplies two numbers together and returns the result.

- Location: `/multiply`
- Status Codes:
  - `200`: The product was computed successfully.
  - `400`: One or both of `multiplicand` or `multiplier` was null, the product cause integer overflow, or the request was otherwise
  malformed.

_Sample Multiplication Request_
```
{
  "multiplicand": 2,
  "multiplier": 6
}
```

_Sample Multiplication Response_
```
{
  "product": 12
}
```


### Union Endpoint
This endpoint computes the union over two sets of numbers, using set-wise logic.

- Location: `/union`
- Status Codes:
  - `200`: The union was computed successfully.
  - `400`: `left` or `right` was null, or the request was otherwise malformed.

_Sample Union Request_
```
{
  "left": [5, 12, 9, 3, 2, -12, 4, 0, 1],
  "right": [3, 8, 7, 1, 5]
}
```

_Sample Union Response_
```
{
  "union": [8, 5, 12, 9, 3, 2, -12, 4, 0, 1, 7]
}
```
### Subscraction Endpoint
This endpoint subtracts two integers and returns the difference.

- Location: `/substract`
- Status Codes:
  - `200`: The difference was computed successfully.
  - `400`: One or both of `minuend` or `substrachend` was null, or the request was otherwise malformed.

_Sample Substracation Request_
```
{
  “minuend": 7,
  “substrachend”: 2
}
```

_Sample Substraction Response_
```
{
  “difference”: 5
}
```
