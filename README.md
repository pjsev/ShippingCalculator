# ShippingCalculator

## Endpoint
POST http://localhost:8080/calculate
Content-Type: application/json

## Request Payload (JSON message)
|Field|Data Type|Description|
|----|-----|-------|   
|weight|double|Weight expressed in numeric form|
|height|double|Height expressed in numeric form|
|width|double|Width expressed in numeric form|
|length|double|Length expressed in numeric form|
|voucher|object|voucher details(optional)|
|code|string|voucher code|

### Sample Request Body
#### with Voucher
```json
{
    "weight": 12,
    "height": 100,
    "width": 10,
    "length": 2,
    "voucher": {
    	"code":"MYNT"
    }
}
```

#### without Voucher
```json
{
    "weight": 8,
    "height": 100,
    "width": 10,
    "length": 2
}
```

## Response Payload (JSON message)
|Field|Data Type|Description|
|----|-----|-------|   
|weight|double|Weight expressed in numeric form|
|height|double|Height expressed in numeric form|
|width|double|Width expressed in numeric form|
|length|double|Length expressed in numeric form|
|volume|double|computed volume|
|voucher|object|voucher details(optional)|
|code|string|voucher code|
|discount|double|discount price|
|expiry|string|expiry date|
|message|string|message if code is invalid|
|parcelType|object|parcel details|
|price|double|parcel price|
|name|string|parcel name/type|
|shippingCost|double|total shipping cost with discount|

### Sample Response
```json
{
    "weight": 8,
    "height": 100,
    "width": 10,
    "length": 2,
    "voucher": {
        "code": "MYNT",
        "discount": 12.25,
        "expiry": "2020-09-16",
        "message": null
    },
    "volume": 2000,
    "parcelType": {
        "price": 0.04,
        "name": "Medium Parcel",
        "shippingCost": 67.75
    }
}
```
