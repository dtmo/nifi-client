nifi-1.1.2-update-attribute-ui
==============================

** This project contains a modified version of NiFi 1.1.2 nifi-update-attribute-ui **

Overview
--------

`nifi-1.1.2-client-api` is essentially a wrapper around a number of invokers that interact with the NiFi REST API.
The invokers themselves are automatically generated from the annotations on the nifi-web-api `ApplicationResource` classes
and `nifi-update-attribute-ui` RuleResource class.
In order to have the necessary classes on the classpath, the `nifi-update-attribute-ui` classes need to be made available as
a jar, which it is not by default. Also, there are some omissions in the description of the NiFi REST interface that need to
be corrected for the invoker classes to be automatically generated.

This project contains the source for the modified, corrected `nifi-update-attribute-ui` project. It is intended to be used to
support the automatic generation of invoker classes and for no other purpose.
