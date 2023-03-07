#!/usr/bin/env bash
FROM rodolpheche/wiremock

COPY ./stubs /home/wiremock

COPY ./start-simulator.sh /start-simulator.sh

ENTRYPOINT ["sh","/start-simulator.sh"]

CMD ["/start-simulator.sh"]

