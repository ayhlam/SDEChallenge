# PaytmLabs SDE Challenge 
Completed by Aaron Lam

## Coding Question Solution

The challenge requires methods for: 
- Add elements to structure
- Get all elements
- Calculate moving average

An interface was created to provide the signature of each of these methods. It accepts a generic type so that its 
implementation classes define what type of elements will be stored. 

For the challenge, an implementation class was created from the interface with type `Long`. When a new value is 
added to the data structure, the method will check if the window `n` will shift. If so, we calculate a new sum 
such that our moving average includes the newest element.

A basic driver class was created to demonstrate the usage of the interface and implementation. A test class
was included to ensure functionality of the moving average calculations. 

## Design Question Solution

We are looking to create a backend system that can handle a large volume of traffic and provide metrics. 
On a high level, we will need to consider solutions that can asynchronously communicate that guarantees a form of
reliability and that can handle traffic. 

To summarize the design: 
- nginx, Eureka, and Spring Cloud for load balancing and service registry to ensure high performance under traffic
- Springboot microservice architecture for horizontal scalability and independent services
- Kafka messaging library for streaming and storing to reproduce data if required, and Spark to process stream data
- Cassandra as a NoSQL database for exceptional read and write performance and fault resistance
- InfluxDB and Grafana to report traffic metrics to customers as configurable dashboards

**Load Balancing**: We'll need a load balancer to ensure high performance is maintained by distributing the 
traffic across our servers. This also maintains a breadth of reliability, in case any of our servers go down. We can 
use nginx for this. We'll also need Eureka and Spring Cloud for service registry.

**Miroservices**: We can adopt a microservice architecture for our application. This allows our code to 
be run as separate services independently. The main asset is that is architecture is scalable. As each service is 
independent, we can scale high-volume and critical services individually. This works well with load balancing as well,
as having multiple services provides reliability and minimizes downtime. Springboot is a great framework that supports 
microservices well. However, we must also keep in mind that having fine-grained services offer some complexities since
services are separated. 

**Messaging**: We need a platform that can support communication within our application, given the high volume
of data that we will be expecting. Kafka is an excellent candidate, as it is stream-processing software that can 
asynchronously handle the traffic we expect. It can store and stream records, which is resilient in nature and can
allow for reprocessing of historic data in case of any issues. Our stream data can be processed using Spark. 

**Database**: We need a persistent database for all the data. It must be highly scalable and maintain reliability 
through heavy traffic. Cassandra is a strong candidate, as it strives with read and write performance, something that
our application will be doing a lot of. One key feature is that it offers "asynchronous masterless replication", 
which allows low latency operations. 

**Metrics Dashboard**: Our application must report traffic metrics to customers. InfluxDB along with Grafana can
display human-readable health check status and historic data to customers if requested. Users can also configure 
dashboards to view network data in real time. 