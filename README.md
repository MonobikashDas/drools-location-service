# drools-location-service

This example demonstrates how to use dynamic JSON to execute Drools rules. In this example, a location JSON is used, which can vary depending on the country. The Drools rule is run against this fact to update the location.

## Sample Input

The following is an example of the input JSON structure:

```json
{
	"address": {
		"addressLine1": [{
			"language": "eng",
			"value": "flat no 101"
		}, {
			"language": "ara",
			"value": "شقة رقم 101"
		}, {
			"language": "kan",
			"value": "ಫ್ಲಾಟ್ ಸಂಖ್ಯೆ 101"
		}],
		"addressLine2": [{
			"language": "eng",
			"value": "Salarpuria Sattva"
		}, {
			"language": "ara",
			"value": "سالاربوريا ساتفا"
		}, {
			"language": "kan",
			"value": "ಸಾಲರ್ಪುರಿಯ ಸತ್ವ"
		}],
		"addressLine3": [{
			"language": "eng",
			"value": "Hongasandra"
		}, {
			"language": "ara",
			"value": "هونغاساندرا"
		}, {
			"language": "kan",
			"value": "ಹೊಂಗಸಂದ್ರ"
		}],
		"city": [{
			"language": "eng",
			"value": "Bangalore"
		}, {
			"language": "ara",
			"value": "كِنِترَ"
		}, {
			"language": "kan",
			"value": "ಬೆಂಗಳೂರು"
		}],
		"region": [{
			"language": "eng",
			"value": "Bengaluru Urban"
		}, {
			"language": "ara",
			"value": "بنغالورو أوربان"
		}, {
			"language": "kan",
			"value": "ಬೆಂಗಳೂರು ನಗರ"
		}],
		"pincode": "560068",
		"zone": [{
			"language": "eng",
			"value": "Karnataka"
		}, {
			"language": "ara",
			"value": "بكارناتاكا"
		}, {
			"language": "kan",
			"value": "ಕರ್ನಾಟಕ"
		}],
		"country": [{
			"language": "eng",
			"value": "India"
		}, {
			"language": "ara",
			"value": "الهند"
		}, {
			"language": "kan",
			"value": "ಭಾರತ"
		}]
	}
}
