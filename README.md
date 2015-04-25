# Simple TCP Server
TCP server which accepts sql like query and execute it on csv file and print the result.

At the high level application does the following 

- Listen on a tcp socket for data from a tcp client. https://github.com/vaibhs28/tcp_server/blob/master/src/tcpserver/TCPServer.java

- Create new thread for each client. https://github.com/vaibhs28/tcp_server/blob/master/src/request/RequestHandler.java

- Parse the sql text. https://github.com/vaibhs28/tcp_server/blob/master/src/query/QueryParser.java

- Read csv file. https://github.com/vaibhs28/tcp_server/blob/master/src/reader/CSVFileReader.java

- Excute parsed query on a csv file. https://github.com/vaibhs28/tcp_server/blob/master/src/query/QueryExecutor.java

- Return the output and format it. https://github.com/vaibhs28/tcp_server/blob/master/src/request/RequestHandler.java
