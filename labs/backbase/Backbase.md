# Preface

The document is root page of backbase API micro-service and is intended for consumer of service. It does not deep dive into architecture or design but provides a references to the same, if someone is looking for details. The reader is expected to have basic understanding of REST architecture, Swagger specification and Backbase product.

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

# Usage

One

# References

**Item** | **Description** 
:--- | :---
Design | Provides deep-dive into design
Message Code Strategy | Defines coding strategy used during log and error scenarios
Metrics | Provides metrics emitted by the system
Alerts | Providers alerts information 
