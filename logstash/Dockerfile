ARG ELK_VERSION

#    volumes:
#      - type: bind
#        source: ./logstash/config/logstash.yml
#        target: /usr/share/logstash/config/logstash.yml
#        read_only: true
#      - type: bind
#        source: ./logstash/pipeline
#        target: /usr/share/logstash/pipeline
#        read_only: true

# https://www.docker.elastic.co/
FROM docker.elastic.co/logstash/logstash:${ELK_VERSION}

COPY config/logstash.yml /usr/share/logstash/config/logstash.yml
COPY pipeline/logstash.conf /usr/share/logstash/pipeline/logstash.conf

# Add your logstash plugins setup here
# Example: RUN logstash-plugin install logstash-filter-json
