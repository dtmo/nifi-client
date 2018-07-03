nifi-1.1.2-update-attribute-dto
===============================

** This project contains a modified version of NiFi 1.1.2 nifi-update-attribute-ui **

Overview
--------

`nifi-1.1.2-client-api` is essentially a wrapper around a number of invokers that interact with the NiFi REST API.
In order to communicate with NiFi's REST API, DTO and Entity classes are required to encapsulate data being transferred.
The DTO and Entity classes included in `nifi-update-attribute-ui` are not published in JAR form by default, so this project
contains just those classes.
