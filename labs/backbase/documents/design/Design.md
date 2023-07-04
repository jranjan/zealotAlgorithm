# Overview

# Architectural Style

Any product can be designed with a any architectural style. Also, every architecture style choice 
has its pros and cons. Also, any architecture style can be challenged at any time with certain 
points as no architecture style is sufficient to serve all cons. Otherwise, the entire development 
generation might have picked that.  For e.g.

- Monolith is very highly performant (still best choices for embedded systems) but comes with a lot of pain of refactoring, difficulty to make a change, and difficult to measure. Anyone working on such a system may not do this!
- 2-tier architecture comes with the simplest model but has its cons when it comes to scalability, building a distributed system, performance and so on.
- Domain Driven Design comes with the benefit of self-intuitiveness but requires a good amount of expertise and knowledge of constructs like microservice, Kubernetes, design patterns and so on.

So, every style is a best fit model driven by task, situation and current development paradigm. 
For our product, we choose DDD because its a close ally for cloud native applications following 
micro-services pattern. Keeping this style, this section defines some of artefacts resulting as 
part of process of following this style:

- [Bounded Context](#bounded-context)
- [Domain Elements](#domain-elements)
- [Domain Element Relationship](#domain-element-relationship)
- [Domain Model](#domain-model)

### Bounded Context

![Backbase API Bounded Context](./images/bounded_context.png)

### Domain Elements

![Backbase API Bounded Context](./images/domain_elements.png)

### Domain Element Relationship

![Backbase API Bounded Context](./images/domain_element_relationship.png)

### Domain Model

![Backbase API Domain Model](./images/domain_model.png)

# Architecture

This section lays out logical architecture of Public API System as depicted below. 

![Functional Architecture](./images/functional_architecture.png)

Also, it explains its constituents and external interface as described through below table.

Component | Description | Deployable
:| --- :| --- :| ---
API Client | Anyone performing REST calls, can be developed in language. It must adhered API specification | Depends on client eco-system
External Load Balancer | An external component to distribute API calls across multiple deployable unit of API | Yes, but out of purview of Backbase API component
API System | Responsible for performing RESTful operation as per its specification | Yes
Rest Controller | An internal component (entry point) for any rest request. | No independent deployment (is part of API System)
Anti-corruption Layer | An internal component helping in realisation of all request sent by REST Controller. It is responsible for talking to backend | No independent deployment (is part of API System)
Persistent Client | An internal component required to interact with DB  | No independent deployment (is part of API System)
Database | An independent persistence system supporting storage and retrieval of API data | Yes

The above architecture can be realised by using below stack.

![Technology Stack](./images/technology_stack.png)

# Backbase API RESTful Resource Identification 

The Backbase API's approach is to identify the resources, the relationship, then the methods.  
To archived that that the following points have been taken care.

- Usage or resource model
- Allow flexibility in API layers to be able to navigate up and down the resource,
- Keep REST method simple standard and focused on the resources eliminating complex naming conventions and point to point methods.

API design will be Resource Model centric instead of relying heavily on any physical implementation. 
The change in business layer implementing various concepts of business, data model, algorithm implementing 
business logic is imminent. At the same time, it is very important to provide stable, extensible 
and agile API which does not require consumers to adopt to new version very frequently is a critical 
ask. And, creating a constant interface for the aspect ever changing is a really changing tasks. 
If not done thoughtfully, API consumption patterns is going to get affected, and hence monetising 
its value. The goal is to adhere to 3 steps approach depicted below.

![RESTful Resource Engineering Process](./images/restful_resource_modelling_process.png)

The advantages of choosing this process are the following:

- Prevents redefining the data every time we make an API. Service concepts are quickly changing and they will be used in many implementations from events to APIs to NOSQL databases.  Having a resource model where we can “drag and drop” the resource, opposed to redefining it for every implementation will save time on the design and build while removing complex mappings and transformations that have a tendency to become massive technical debt.
- Not bound to a physical model.  Swagger, RAML, YAML, GraphQL, WADL, XSD, JSON, JSON:API etc have all been part of the API ecosystem for sometime.  By maintaining a resource model at the logical level you can support the different physical implementation styles.  Managing resource models at the physical level is possible in one format but it will not translate well into implementation styles (XSD to JSON for example).  It will help us to be open for using latest standards and not get mired down in format to format mappings use a resource model that is independent of those formats.
- Increased chances of adoption. Usage of One API layer that clearly represents the resource and allows for numerous contextual boundaries whether they are system-based, process-based, or business-based is an ideal approach. Otherwise, the shape of the legacy contexts will proliferate to the API layers, and eventually requiring change very frequently,
- Empowering developer community.  Resource model provides developer a leadership role as the integration teams can expect the transformations to be aligned to the resource model opposed to a best-guess approach that may include out of date or misleading elements
- Avoid technical debts by designing resources on the fly. This is the pattern we do follow as of today. It increases the chances are there will be gaps between what we build and how the API consumer understands our view of the resource.  It will eventually lead to scenario where adoption will be poor and technical debt will increase.
- Simplified API. We will be adhering mature resource model defines the structure of the resource including the definition of what the data represents at a very fine grained level.  

Keeping this philosophy in mind, the following resource model graph is identified.

![RESTful Resource Graph](./images/restful_resource_graph.png)

TODO: PUT A TABLE DESCRIBING RESOURCE 


# Low Level Design 

### Sequence Diagram 
### Class Diagram
### Error Reporting

# Low Level Design Future Consideration 

As you can see that there is no change in architecture but the way these components 
are going to serve scenario is important thing to be considered especially for 
resource creation and update scenario. It leads to a huge set of new requirement or 
challenge at fundamental level which our system should be able to sustain.

> Note that the section enlists high level challenges which is written in the context
> API but might be applicable generically. So, the discussion will also reflect
> its generic nature which readers need to keep in mind. For scenario specific
> details.

Any interaction where one or more the above listed participant misbehaves or does 
not perform as expected, we are going to face a erratic situation especially in 
CUD path of CRUD operations. The common challenges we see are following.

- [Synchronous vs. Asynchronous](#synchronous-vs-asynchronous)
- [Transaction](#transaction)
- [Component failure](#component-failure)
- [Partial Successful Transaction](#partial-successful-transaction)
- [Latency](#latency)
- [RBAC](#rbac)

### Synchronous vs. Asynchronous

This section is more about how we do deal with POST/DELETE/PUT (selectively) 
operations which might take longer than what is acceptable for an API caller. 
Should we do synchronous like GET? Or, should we provide URI as someone performs 
POST / PUT / DELETE which can be monitored by the client to see operation status? 
Effectively, we are left with the following design choices which is well 
understood and explore in industry. Let us evaluate them.

Choices	|                                                                                                                                                                                                                                                                                                                	Pros | Cons
|--- :|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|---
Synchronous call for all CRUD operations |           	Let everything to be synchronous call even for POST/PUT/DELETE operations.  In this case, no URI is needed to be generated to track progress of requested operation. 	Simple implementation	Request timeout which is as good as API failure or sometime worse than that. No extra investment in framework |	Client gets blocked unless it plays smart
Asynchronous call for time conusming POST/PUT/DEELETE operartions	|Adhere to industry standard mechanism of generating status *URI* which client needs to track to get success or failure result of requested operation.	A full proof operation for POST / PUT / DELETE scenarios especially when the required operation is going to be time consuming	Requires investment in framework  | Incurs development cost. Also, it	requires client to track status uri provided by API server


### Component failure

The failure is imminent and so is component failure. So far, the failure of GET calls would have 
affected only client behavior, which was reasonably accepted as client might have applied retry 
logic or could have tried same request after some time. Have not wee seen commonly?

> Server is down, please try after sometime!

Now, it is not so because failure of component can lead us to partial / dirty write scenario or 
keeping client in guess mode. All depends on what fails at what time. This section is more about 
how we do deal with failure of POST/DELETE/PUT operations.  Let us enlist and evaluate them.

It is important to note down the traditional flow of any requests: API → Backend → Persistent Layer. 
All our conversation will be based around this interaction flow. Failure of the component means that 
underneath component succeeded unless stated otherwise explicitly. So, failure of Backend means that 
it the communication between Backend → Persistent Layer was successful unless stated otherwise.

Id | Scenario                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            | 	Description/Analysis                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             | Causes Data Inconsistency                                           | Rollback Required | Causes User Response Inconsistency | Response  |	Expectation from Client
|--- |-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------|--- |--- |--- |--- 
1.01 | 	API is down	API server is down because of XYZ reason.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              | No                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                | 	No	                                                                |No	 |Client will not be able to perform any CRUD operation. Not an issue as such it is common pattern seen with any API server.	 |Client retry when server is up and running
1.02 | 	API fails to process the request                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   | 	Server received the request but fails to process because of bug or something unknown. It could not even send the request to Backend component.	                                                                                                                                                                                                                                                                                                                                                                  | No	                                                                 |No	 |No	 |Client will get HTTP failure with respective application message code. |	Client retry. *If it consistently fails, he or she has to raise a support request in #usd-support slack channel.*
1.03 | 	API fails to pass on the response                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  | 	Server received the request, passed on to Backend which in turn responded successfully. But API failed to pass on the response because of some error.	                                                                                                                                                                                                                                                                                                                                                           | No	                                                                 |No	 |Yes	 |Client will get HTTP failure with respective application message code. *The message code could be as obscure as its unknonw error.*	 |Client retry. *If it consistently fails, he or she has to raise a support request in #usd-support slack channel.*
1.04 | 	API is talking to Backend Service, all of which are down                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           | 	All Backend Services are down. So, API request will fail.                                                                                                                                                                                                                                                                                                                                                                                                                                                        | 	No                                                                 |	No |	No	 |Client will get HTTP failure with respective application message code. *The message code clearly tells what backend service failed.*	 |Client retry. *If it consistently fails, he or she has to raise a support request in #usd-support slack channel.*
1.05 | 	API is talking to more than one Backend Service, One ore more of which is Down among set of many. *However, API is talking to only one backend service to get its job done.*                                                                                                                                                                                                                                                                                                                                                                                                                                                       | 	In this case, there is no composite CRUD operation. So, failure or success is as good as what happens to backend service.	                                                                                                                                                                                                                                                                                                                                                                                       | No	                                                                 |No |	No	 |Client will get HTTP failure with respective application message code. *The message code clearly tells what backend service failed.*	 |Client retry. *If it consistently fails, he or she has to raise a support request in #usd-support slack channel.*
1.06 | 	API is talking to more than one Backend Service, One ore more of which is down among set of many. *However, API is talking to more than one backend service to get its job done where one of them is down.*	                                                                                                                                                                                                                                                                                                                                                                                                                       | What might happen is that partial data is persisted in one of backend scenario but we could not process it scucessfully in other side.	                                                                                                                                                                                                                                                                                                                                                                           | Yes	                                                                |Yes	 |No	Client will get HTTP failure with respective application message code. *The message code clearly tells what backend service failed and should ask client to retry*	 |Client retry. *If it consistently fails, he or she has to raise a support request in #usd-support slack channel.*
2.01 | 	Backend Service is down	No issue. API server will deal as if Backend Server is down. It will be more like scenario *(1.04)*	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       | No	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               | No	                                                                 |No	 | Client will get HTTP error.	 |Client retry. *If it consistently fails, he or she has to raise a support request in #usd-support slack channel.*
2.02 | 	Backend Service failed to process the incoming request	No issue. API server will not get response and eventually timeout. Or. API server will be notified of error.                                                                                                                                                                                                                                                                                                                                                                                                                                                                | 	No                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               | 	No                                                                 |	No	Client will get HTTP error.	 |Client retry. *If it consistently fails, he or she has to raise a support request in #usd-support slack channel.*
2.03 | 	Backend Service failed to pass on the response although it performed operation on Persistent Layer successfully. | 	No issue. API server will not get response and eventually timeout. *However, it is different from (2.02) in a way. In this case, peristence change layer is committed. So, we have two choices: rollout or let things as it is. In later case, client will discover eventually,*	Yes or  No	Yes  or  No	Yes / No	Client will get HTTP error.	The documentation should highlight these scenario. Client retry. *If it consistently fails, he or she has to raise a support request in #usd-support slack channel.* 
2.04 | 	Backend accepted requested but took too long for API to wait  | 	Ita dicy situation where backend might succeed eventually but we have notified API user about the failure. So, we need to somehow find a way to cancel the ongoing / abort the request. For this, backend need to support abortion of the request.	  | Yes or No	Yes / No                                                  | 	Yes or No	Client will get HTTP error	The document should highlight these scenario. In 246, client has to be smart enough to deal with scneario where resource already exist although API told that his or her or earlier requested. In long run, we will support CANCEL / ABORT cases at backend level and will lbe leveraged by API accordingly 
3.01 | 	Persistent Layer is Down | 	No issue.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        | Backend will fail to process the request which is same to *(2.03)*	 |No	 |No	 |No	Client will get HTTP error.	The documentation should highlight these scenario.Client retry. *If it consistently fails, he or she has to raise a support request in #usd-support slack channel.*
3.02 | 	Persistent Layer fails to accept the incoming request	 | No issue.   | Backend will fail to process the request which is same to *(2.03)*  |	No | 	No                                                                                                                                                                                                                                                                                                                                               |	No	Client will get HTTP error.	The documentation should highlight these scenario.Client retry. *If it consistently fails, he or she has to raise a support request in #usd-support slack channel.*
3.03 | 	Persisent Layer succeeds in database operation but fails to pass on the response to caller.	Its a big issue!                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       | In this case peristence layer has to rollback changes and should say that it could not serve the request. *In a nutshell, persistence layer interface has to ensure that transmission to caller has succeeded always.*	                                                                                                                                                                                                                                                                                           | No	                                                                 |No	No	 | Client will get HTTP error.	 |The documentation should highlight these scenario. Client retry. *If it consistently fails, he or she has to raise a support request in #usd-support slack channel.*



### Partial Successful Transaction

API will provide batch operation for many resources. It is imperative that GET/POST/PUT/DLEETE operation might not always successful at batch level. The reason can be one of the following:


1. Batch request was having input error
2. Component failed while performing certain operation

We do not see a situation where we provide batch response to client partially. So, we will not be dealing this. Let me know if you think otherwise

Let us evaluate them.

ID | Scenario | Description | Causes Data Inconsistency | Rollback Required | Causes User Response Inconsistency | Response | Expectation from Cient
|--- |--- |--- |--- |--- |--- |--- |---
1	| A batch request succeeded	In this case, everything work as expected	|No	|No|	No|	Client will get desired result.	|None
2	| A batch request got accepted but all inputs were invalid. *No issue with Backend Service.*|	Server accepted all request but all were invalid input.	|No	|No	|No|	Client will get HTTP error refleting incorrect client data |	Client retry with valid input data
3	|A batch request got accepted but some inputs were invalid. *No issue with Backend Service.*|	Server accept the request but some of input data were invalid	|No|	No	|No	Client will get HTTP error refleting incorrect client data. Server will result partial success.	|Client need to retry for invalid input. For valid input, things will be sane.
4	|A batch request failed partially because system failed to serve certain input *when API server is dealing with* *only one backend service.*	|Let us assume that a batch request contains 3 input I1, I2 and I3. Also, all of processing of input does not require interaction with more than one backend. *Because of some reason one of the Backend Server fails to process certain input. Here, Backend can be same or different.*	|No	|No|	No|	Client will get HTTP error refleting incorrect client data. Server will result partial success.	|Client need to retry for invalid input. For valid input, things will be sane.
5	|A batch request failed partially because system failed to serve certain request *when API server is dealing with* *more than one backend service (a composite operation) and one of Backend failed to perform desired task because of input / request error only*	Let us assume that a batch request contains 3 input I1, I2 and I3. Also, all of processing of input does not require _*composite interaction*_ with more than one backend. *Because of some reason one of the Backend Server fails to process certain input. In this case, we need to ensure that a composite operation is successful or rolled back. We can not or should not leave system with partial darta in one backend.*	|Yes	|Yes	|No	|Client will get HTTP failure with respective application message code. *The message code clearly tells what backend service failed and should ask client to retry*|Client retry. *If it consistently fails, he or she has to raise a support request in #usd-support slack channel.*
6	|A batch request failed partially because system failed to serve certain request *when API server is dealing with* *more than one backend service (a composite operation) and one of Backend failed to perform desired task*	|What might happen is that partial darta is persisted in one of backend scenario but we could not process it scucessfully in other side.	|Yes	|Yes	|No|	Client will get HTTP failure with respective application message code. *The message code clearly tells what backend service failed and should ask client to retry*	|Client retry. *If it consistently fails, he or she has to raise a support request in #usd-support slack channel.*


### Latency

As we build POST / PUT / DELETE API and that too with ability to perform batch call, 
it is important to keep response time in mind. The response time is very-very valid as delayed 
response might cause a lot of issue to client workflow. So, we need to do a good job in the 
following aspects:

1. Mechanism to measure latency
2. Mechanism to emit logs reflecting latency if it cross certain limit
3. Building timeout protocol
4. Measuring latency with average load

In this section, we will talk about different scenarios related to latency and our strategy to 
deal with it.

ID | Category | Scenario | Description | User expectation
|--- |--- |--- |--- |--- 
1 |	API Server Slowness	 |	API takes more than 500ms.  |	Should API Server respond with timeout message?	 |	 In this case, we might not be technically failing but we are failing to serve client requirement | Do whatever it takes but respond within 500ms.
2 |		Backend Server Slowness  |	API talks to multiple backend but one of the backend is taking longer than anticipated.  No retry performed at API server level so far. Should API Server timeout?	 |	In this case, everything is fine but one of the backend is taking longer time, may be because of retry or slowness of system itself | Do whatever it takes but respond within 500ms.
3 |		Backend Server Retry	 |	 API talks to multiple backend but one of the response from the backend fails. Should we retry at again backend level?	 |	 Everything is fine! However, one of the backend failed because of some reason, not sure why. The question is whethere API Server should retry or not.| Do whatever it takes but respond within 500ms.
4 |		Display API latency	 |	 User wants to know detail about latency either through metric or log analysis.	  |	Need a way to know details of latency data. | Do whatever it takes but respond within 500ms.


### RBAC

We are building a set of API which imperatively creates a schema. Yes, we are talking of substrate 
API. It makes important question to ask ourselves, do we want to allow all CRUD operations to be 
performed on all resources for anyone who authenticates to API server. It is important from 
the following angle:

1. How do prevent data corruption? How can we prevent GET /service user to manoeuvre POST /substrate
2. Why POST/PUT/DELETE should be available to all users? Why should not we restrict this to specific tenant type or specific set of user group?

It is imperative that we do not need to support RBAC. Let us talk about more here.

Id | Choices | Description | Pros | Cons
|--- |--- | --- |--- |---
1 |	Make everything accessible once you get authenticated	| As of now, we use JWT token for authentication. Once you get authenticate, you get complete right of all operations including POST / PUT / DELETE calls on all resources. Hmm!	| Simple implementation. No extra investment in framework  | 	Data corruption likelihood	
2 |	Support RBAC for respective API sets | Provide specific user group only to access specific operation on certain API	Brings RBAC	Extra investment is required. Prevents data corruption knowingly or mistakenly	| Extra investment is required
