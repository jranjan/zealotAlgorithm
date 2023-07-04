# Overview

Alert is a critical element for notifying the operation team about the occurrence of some anomaly
and plays a significant role in quick turnaround in the remediation of system issues. This document
lists a set of alert(s) supported by xInterceptor, its interpretation and its remediation plan.

Metric(s) and alerts go hand to hand. The reader is expected to have a basic understanding of
metrics and alert eco-system supported in Salesforce, functional knowledge of service 
and metrics supported by it.

# Supported alert(s)

| Alert                                                             | Priority | Description
|:------------------------------------------------------------------|:---------| :----------- 
| [api.availability.critical_error](#apiavailabilitycritical_error) | Critical | Indicates service **API** is not available to serve request

# Alert Detail(s)

### _api.availability.critical_error_

| Aspect              | Detail                                                                                                                     | 
|:--------------------|:---------------------------------------------------------------------------------------------------------------------------|
| Name                | api.availability.critical_error                                                                                            |
| Priority            | Critical                                                                                                                   |
| Description         | Indicates that *MORE THAN ONE* of sub-component is not up. It should be dealt with urgency even alert is of high priority. |
| Associated metric   | [api.status](./Metric.md#apistatus)                                                                                        |
| Algorithm           | vyakaran.crawler.manager.status <= 0                                                                                       |
| Remediation step(s) | See remediation steps [here](./runbook/steps_to_remediate_alert.md)                                                        |

