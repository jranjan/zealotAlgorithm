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
- [Domain Elements](!)
- [Domain Element Relationship](!)
- [Domain Model](!)

### Bounded Context

![Backbase API Bounded Context](/documents/design/images/bounded_context.png)



# Backbase API RESTful Resoruce Identification 

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

![RESTful Resource Engineering Process](/documents/design/images/restful_resource_modelling_process.png)

The advantages of choosing this process are the following:

- Prevents redefining the data every time we make an API. Service concepts are quickly changing and they will be used in many implementations from events to APIs to NOSQL databases.  Having a resource model where we can “drag and drop” the resource, opposed to redefining it for every implementation will save time on the design and build while removing complex mappings and transformations that have a tendency to become massive technical debt.
- Not bound to a physical model.  Swagger, RAML, YAML, GraphQL, WADL, XSD, JSON, JSON:API etc have all been part of the API ecosystem for sometime.  By maintaining a resource model at the logical level you can support the different physical implementation styles.  Managing resource models at the physical level is possible in one format but it will not translate well into implementation styles (XSD to JSON for example).  It will help us to be open for using latest standards and not get mired down in format to format mappings use a resource model that is independent of those formats.
- Increased chances of adoption. Usage of One API layer that clearly represents the resource and allows for numerous contextual boundaries whether they are system-based, process-based, or business-based is an ideal approach. Otherwise, the shape of the legacy contexts will proliferate to the API layers, and eventually requiring change very frequently,
- Empowering developer community.  Resource model provides developer a leadership role as the integration teams can expect the transformations to be aligned to the resource model opposed to a best-guess approach that may include out of date or misleading elements
- Avoid technical debts by designing resources on the fly. This is the pattern we do follow as of today. It increases the chances are there will be gaps between what we build and how the API consumer understands our view of the resource.  It will eventually lead to scenario where adoption will be poor and technical debt will increase.
- Simplified API. We will be adhering mature resource model defines the structure of the resource including the definition of what the data represents at a very fine grained level.  

Keeping this philosophy in mind, the following resource model graph is identified.

![RESTful Resource Graph](/design/images/restful_resource_graph.png)

TODO: PUT A TABLE DESCRIBING RESOURCE 