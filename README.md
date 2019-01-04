# reuters-dataset-parser-java


Play framework is used to create web application: https://www.playframework.com/getting-started

Start the project with : sbt run 

Below are the API's

1. GET http://localhost:9000/getContent : It fetches the all data from .sgm file
2. GET http://localhost:9000/search?match=ok : It is to search any content in .sgm file.
3. GET http://localhost:9000/getTopic?topic=IF DOLLAR FOLLOWS WALL STREET JAPANESE WILL DIVEST : This is to search a specific topic.
