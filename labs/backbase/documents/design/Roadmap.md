# Overview

Rom was not built in a single day! So applies to product development. At the same time, we must adhere to agile practices to ensure that product features are delivered promptly creating incremental value for customers. In the current world, we can not live with a wait cycle of 12m to release something `awesome` as the definition of `awesome` is changing every moment. There is no intent to create hurriedness in realising alternate data and converting agile into a fragile world. A balance is required. This document talks about how we can build our Backbase API on top of what is done as of today.

# Current state

In this section, we will talk about the current state, primarily from the business use case as well as system architecture.

### Business

**Account management**
As a user, I can create an account
As a user, I can update account attributes including daily transaction limit
As a user, I can delete the account if pre-conditions are met
As a user, I can get account details
**Transaction management**
As a user, I can submit a transaction if pre-conditions are met
As a user,  I can view transactions

### System

- Swagger specification is complete and can be shared with stakeholders looking for API integration. Also, it contains a well-defined application error code explicitly telling system responses in case of failure
A running framework is ready to serve business requests. The framework is extensible to support new business use cases without too much affecting the current implementation. I mean that it adheres to the Open-Closed architecture principle.
Metrics and Alerts are defined
- Architecture and design details are documents
  - Architecture style
  - RESTful resource model
  - Low-level design

# Future enhancements

This section highlights some of area which cna be picked up as next set of enhancement in coming days.

### Business

- As a user, I want to perform all transactions in a secure manner
- As a user, I want to view transactions in a paginated manner within a given time range
- As a user, I want REST client SDK to integrate with different systems
- As a user, I want to know the processing time taken to serve a specific request
- As a user, I want to perform batch transactions (not necessarily to the same account but to all accounts together
- As a user, I want to get account details for a specific branch

### System

- **Functional**
  - Support authentication and authorisation
  - Support API rate limiting
  - Develop SDK to ease out integration with third-party application
  - Provide backend integration point with a different system which can be a database or message quest or some other system
- **Security**
  - Support HTTPS
- **Deployment**
  - Deploy service in a scalable manner ensuring higher availability
- **Performance**
  - Measure performance for the bulk and individual transaction under low, average and maximum load
- **Operability**
  - Enhance metric and alert (add a few more)
  - Define runbooks
  - Document message codes pointing to specific runbook to deal with if a certain error occurs


