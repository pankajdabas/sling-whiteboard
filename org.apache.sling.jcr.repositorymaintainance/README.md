[![Apache Sling](https://sling.apache.org/res/logos/sling.png)](https://sling.apache.org)

&#32;

# Apache Sling JCR Maintenance

This project provides reference implementation of Maintenance jobs for maintaining a Apache Jackrabbit OAK repository in Apache Sling.

This includes the following Maintenance jobs:

- [DataStoreCleanupScheduler](src/main/java/org/apache/sling/maintenance/internal/DataStoreCleanupScheduler.java) - Run the [RepositoryManagementMBean.startDataStoreGC(true)](https://jackrabbit.apache.org/oak/docs/apidocs/org/apache/jackrabbit/oak/api/jmx/RepositoryManagementMBean.html#startDataStoreGC-boolean-) method to perform a Garbage Collection of the Data Store
- [RevisionCleanupScheduler](src/main/java/org/apache/sling/maintenance/internal/RevisionCleanupScheduler.java) - Run the [RepositoryManagementMBean.startRevisionGC()](https://jackrabbit.apache.org/oak/docs/apidocs/org/apache/jackrabbit/oak/api/jmx/RepositoryManagementMBean.html#startRevisionGC--) method to perform a Garbage Collection of the Revision Store
- [VersionCleanup](src/main/java/org/apache/sling/maintenance/internal/VersionCleanup.java) - Job to traverse the JCR Version Store
  and remove versions (oldest-first) exceeding a configurable limit

As well as a [Health Check](src/main/java/org/apache/sling/maintenance/internal/RepositoryMaintenanceHealthCheck.java) to ensure the jobs are scheduled and have not failed.

## Configuration

To see a reference implementation, see the [Configuration Feature](src/main/features/configuration.json).

## Features

There are two primary features made by this project include:

- **Base** - org.apache.sling:org.apache.sling.jcr.maintenance:slingosgifeature:base:${project.version} - only the bundle and service user
- **Default** - org.apache.sling:org.apache.sling.jcr.maintenance:slingosgifeature:default:${project.version} - the bundle, service user and default configuration which keeps 5 versions and runs the jobs every night

This module is part of the [Apache Sling](https://sling.apache.org) project.
