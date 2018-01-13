# my-spaces-api
This is an exercise for developing a REST based webservice. It uses Spring boot under the covers with Tomcat as its webserver.

The API design follows a Builder pattern. There is an 'Item' instance which could be one of the following: (a) Space (b) Entry (c) Asset (d) User.

There are individual builders that build these specific type of instances at runtime and return the results.

All the data in this exercise is coming from a TestData class. In production, it would ideally come from a database.

The application logs can be found at logs/exercise.log.
