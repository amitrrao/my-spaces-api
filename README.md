# my-spaces-api
This is an exercise for developing a REST based webservice. It uses Spring boot under the covers with Tomcat as its webserver. The default Tomcat port for this application is 4000. If this needs to be changed, you can modify application.properties file under the src/main/resources folder. 

The API design follows a Builder pattern. There is a generic 'Item' instance which could be one of the following: (a) Space (b) Entry (c) Asset (d) User.

There are individual builders that build these specific type of instances at runtime and return the results. This design makes it extensible for building any custom type of 'Item' by writing a new builder for it.

All the data in this exercise is coming from a TestData class. In production, the data would ideally come from a database.

The application logs can be found at logs/exercise.log.

### System Requirements:
 * Java 1.8

