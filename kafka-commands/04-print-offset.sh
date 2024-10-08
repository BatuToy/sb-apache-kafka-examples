
# to print offset, time etc
kafka-console-consumer \
    --bootstrap-server localhost:9092 \
    --topic example-topic \
    --from-beginning \
    --property print.offset=true \ # to print all the offsets of the messages
    --property print.timestamp=true  # to print the created time of the messages in the topic