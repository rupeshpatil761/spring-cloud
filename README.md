# spring-cloud

http://localhost:8100/currency-convertor-feign/from/EUR/to/INR/quantity/10000

http://localhost:8000/currency-exchange/from/EUR/to/INR

http://localhost:8100/currency-convertor/from/USD/to/INR/quantity/10

http://localhost:8765/currency-exchange-service/currency-exchange/from/EUR/to/INR

http://localhost:8765/currency-conversion-service/currency-convertor-feign/from/EUR/to/INR/quantity/10000

Eureka: localhost:8761

Install RabbitMQ and Erlang to achieve distributed tracing.

RabbitMQ and Erlang installation video. https://www.youtube.com/watch?v=-td8qgCU75E
localhost:15672

Download and run Zipkin jar to start zipkin server.
Open Gitbash and execute below commands

curl -sSL https://zipkin.io/quickstart.sh | bash -s <br /> 
java -jar zipkin.jar

http://localhost:9411/zipkin
