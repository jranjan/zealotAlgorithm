# Preface
The document is the root page of the Backbase API micro-service and is intended for the consumer of the service. It does not deep dive into architecture or design but provides references to the same if someone is looking for details. The reader is expected to have a basic understanding of REST architecture, Swagger specification and Backbase product.

The content in this section is intended for multiple audiences like developers, Architects, Customers or DevOps. So, it is important to pick a specific section instead of getting lost in so much information. Here are a few points which might be of help to different audiences.

1. **Consumer of API**. you might like to focus on [swagger specification](./specs/openapi/backbase/oas-v3.0.1/backbase.yaml)
2. **Architect, Developer and DevOps Engineer**, you might like to read the following:
   - [Code](./src)
   - [Design document](./documents/design/Design.md)
   - [Message code strategy](./documents/design/Message.md)
   - [Metric]((./documents/operations/Metric.md)) and [Alerts](./documents/operations/Alert.md)
3. **DevOps Engineer**
   - Get functional overview of the system by looking at [swagger specification](./specs/openapi/backbase/oas-v3.0.1/backbase.yaml)
   - [Metric]((./documents/operations/Metric.md)) and [Alerts](./documents/operations/Alert.md)
   - [Message code](./documents/design/Message.md)
4. **Product Manager, Product Owner and Scrum Masters**
   - See [roadmap](./documents/design/Roadmap.md)



# Overview

Backbase API is RESTful API providing one ability to manage bank accounts and transactions associated with the account. It adheres to OpenAPI 3.x.y specification. This document in association with swagger specification can be used as a guide for consuming Backbase API for integrating with other systems. The document is divided into following sections:

* [Terminology](#terminology)
* [Supported User Operations](#operation)
* [Backbase API Specification](#specification)
* [Consuming API](#usage)
* [References](#references)

# Terminology

| **Item**                        | **Description**                                                                                    |
|:--------------------------------|:---------------------------------------------------------------------------------------------------|
| Backbase API                    | A RESTful micro-service                                                                            |
| OpenAPI                         | Open API specification, adherence to this provides integration benefits                            |
| Version                         | Represents API version                                                                             |
| Account                         | Represents an account, uniquely identified by a number                                             |
| Account Type                    | Type of account viz. Saving and Current. A user can have more than one account of different type.  |
| Transaction                     | A transaction performed with the account. Note that every transaction is assigned unique number.   |
| Daily Maximum Transaction Limit | Amount of money one can send to receipient in a single day. There is no limit for receiving money. |

# Operation

As of today, three resources are supported: Version, Account and Transaction. Each of which is described below.

### Version

| **Method** | **Description** |
|:-----------|:----------------|
| GET        | Get API version |

### Account

| **Method** | **Description**                                                                                                                            |
|:-----------|:-------------------------------------------------------------------------------------------------------------------------------------------|
| GET        | Get information for the given account                                                                                                      |
| POST       | Creates account. Every account is assigned a unique number if successfully created and remains same through out life-cycle of the account. |
| PUT        | Update account attributes. Note that some attributes (like account number) are not modifiable.                                             |
| DELETE     | Delete existing account, _if deletion criteria are met_                                                                                    |

### Transaction

| **Method** | **Description**                                                                |
|:-----------|:-------------------------------------------------------------------------------|
| GET        | View transaction associated with the account                                   |
| POST       | Perform a transaction on the account, only one transaction is allowed one time |

# Specification

The swagger specification can be found [here](http://localhost:8080/backbase/v1/swagger-ui/index.html)

# References

| **Item**                                              | **Description**                                                                           |
|:------------------------------------------------------|:------------------------------------------------------------------------------------------|
| [Design](./documents/design/Design.md)                | Provides deep-dive into design                                                            |
| [Message Code Strategy](./documents/design/Design.md) | Defines coding strategy used during log and error scenarios                               |
| [Metrics](./documents/operations/Metric.md)           | Provides metrics emitted by the system                                                    |
| [Alerts](./documents/operations/Alert.md)             | Providers alerts information                                                              |
| [Roadmap](./documents/design/Roadmap.md)              | Tells potential enahcment area, should be considered after consultation with stakeholders |