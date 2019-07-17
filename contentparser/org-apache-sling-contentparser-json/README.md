Apache Sling Content Parser for JSON
====
This module is part of the [Apache Sling](https://sling.apache.org) project.

The Apache Sling Content Parser for JSON provides support for parsing JSON files into Apache Sling resource trees, by implementing the 
API provided by the [`org.apache.sling.contentparser.api`](https://github.com/apache/sling-whiteboard/tree/master/contentparser/org-apache-sling-contentparser-api) bundle.

To obtain a reference to the JSON content parser just filter on the `ContentParser.SERVICE_PROPERTY_CONTENT_TYPE` service registration 
property:

```java
    @Reference(target = "(" + ContentParser.SERVICE_PROPERTY_CONTENT_TYPE + "=" + ContentParser.JSON_CONTENT_TYPE + ")")
    private ContentParser jsonParser;
``` 