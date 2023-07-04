# Overview

It is critical to achieving high service availability and measuring different parameters during its lifecycle for better observability and analytics. Primarily, any of the service metrics is one of the below types.

1. **Counter**, denotes an integer value, which is the total number of times a method or some code snippet in interest is processed
2. **Timer**, denotes a real number, which is the latency for a method call or time taken for some code snippet to process

Each metric has a set of tags (or labels) . Some tags are static, while some are dynamic. These tags provide extra information and can be used for various analytic purposes.

This section enlists all supported metric(s), along with a details description of each in the upcoming section. For alert information, see
[here](./Alert.md).

# Supported metric(s)

Different metrics are meant to serve some telemetry aspects of service. The service supports the following category metrics.

1. **Request**, tells about the rate at which service processes API calls.
2. **Error Rate**, tells about failed requests, i.e. those which could not be processed by service successfully.
3. **Availability**, tells the overall availability of service service.
4. **Delay**, tells about latency to process a given request as processed by service service.
5. **Saturation**, tells about the saturation level of various types of resources used during their lifecycle at different loads.

**Request**

| Metric                                    | Type    | Description                         |
|:------------------------------------------|:--------|:------------------------------------|
| [api.requests.count](#apirequestscount)   | Counter | Total number of API requests served |

**Error Rate**

| Metric                                                    | Type    | Description                                                                               |
|:----------------------------------------------------------|:--------|:------------------------------------------------------------------------------------------|
| [api.requests.count {status=5**}](#apirequestserrorcount) | Counter | Total number of failed request. We can compute this value by filtering on the status tag. |

**Availability**

| Metric                   | Type  | Description                                                                                    |
|:-------------------------|:------|:-----------------------------------------------------------------------------------------------|
| [api.status](#apistatus) | Gauge | Health status of the service. Possible values - 'no data' if service down, 1 if service is up. |

**Delay**

| Metric                              | Type  | Description                                                                |
|:------------------------------------|:------|:---------------------------------------------------------------------------|
| [api.requests.avg](#apirequestsavg) | Timer | Average time spent processing API requests for the given period.           |
| [api.requests.max](#apirequestsmax) | Timer | Maximum time spent in processing single API request for the given period.  |
| [api.requests.sum](#apirequestssum) | Timer | Total time spent in processing a set of API requests for the given period. |

**Saturation**

| Metric                                | Type  | Description                                           |
|:--------------------------------------|:------|:------------------------------------------------------|
| [api.cpu.usage](#apicpuusage)         | Gauge | CPU usage in the range of 0-1.                        |
| [api.memory.used](#apimemoryused)     | Gauge | Absolute amount of memory being used at a given time. |
| [api.memory.max](#apimemorymax)       | Gauge | Total amount of memory available.                     |

The below section details various aspects of each metric like name, type, description, labels, analytical usage etc. The reader can use it to plot the given metrics over some time if stored in a big data analytic platform and derive critical inferences.

# Request Metric Detail(s)

#### _api.requests.count_

| Aspect      | Detail                                                        | 
|:------------|:--------------------------------------------------------------|
| Metric name | api.requests.count                                            |
| Type        | Counter                                                       |
| Description | Computes the total number of requests, including pair request |
| Tag(s)      | method, uri, status, outcome                                  |


# Error Rate Metrics Detail(s)

#### <a name="apirequestserrorcount"><> _api.requests.count {status=5**}_

| Aspect      | Detail                                                                                             | 
|:------------|:---------------------------------------------------------------------------------------------------|
| Metric name | api.requests.count {status=5**}                                                                    |
| Type        | Counter                                                                                            |
| Description | Computes the total number of failed requests. This can be computed by filtering on the status tag. |
| Tag(s)      | method, uri, status, outcome                                                                       |


# Availability Metrics Detail(s)

#### _api.status_

| Aspect      | Detail                                                                                                      | 
|:------------|:------------------------------------------------------------------------------------------------------------|
| Metric name | api.status                                                                                                  |
| Type        | Gauge                                                                                                       |
| Description | Health status of the service. Possible values are 'no-data' (service is down) and 1 (if the service is up). |

# Latency Metric Detail(s)

#### _api.requests.avg_

| Aspect      | Detail                                                                                           | 
|:------------|:-------------------------------------------------------------------------------------------------|
| Metric name | api.requests.avg                                                                                 |
| Type        | Timer                                                                                            |
| Description | Computes average latency incurred while processing the service over a pre-defined time interval. |
| Tag(s)      | method, uri, status, outcome                                                                     |

#### _api.requests.max_

| Aspect      | Detail                                                                                            | 
|:------------|:--------------------------------------------------------------------------------------------------|
| Metric name | api.requests.max                                                                                  |
| Type        | Timer                                                                                             |
| Description | Computes maximum time spent in the processing of a set of requests over some time by the service. |
| Tag(s)      | method, uri, status, outcome                                                                      |

#### _api.requests.sum_

| Aspect      | Detail                                                                                          | 
|:------------|:------------------------------------------------------------------------------------------------|
| Metric name | api.requests.sum                                                                                |
| Type        | Timer                                                                                           |
| Description | Computes total time spent in the processing of a set of requests over some time by the service. |
| Tag(s)      | method, uri, status, outcome                                                                    |

# Saturation Metric Detail(s)

### _api.cpu.usage_

| Aspect      | Detail                         | 
|:------------|:-------------------------------|
| Metric name | api.cpu.usage                  |
| Type        | Gauge                          |
| Description | CPU usage in the range of 0-1. |

### _api.memory.used_

| Aspect         | Detail                                                | 
|:---------------|:------------------------------------------------------|
| Metric name(s) | api.memory.used                                       |
| Type           | Gauge                                                 |
| Description    | Absolute amount of memory being used at a given time. |

### _api.memory.max_

| Aspect         | Detail                            | 
|:---------------|:----------------------------------|
| Metric name(s) | api.memory.max                    |
| Type           | Gauge                             |
| Description    | Total amount of memory available. |
