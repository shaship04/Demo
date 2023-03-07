java -cp /var/wiremock/lib/*:/var/wiremock/extensions/* \
  com.github.tomakehurst.wiremock.standalone.WireMockServerRunner \
  ${EXTRA_WIREMOCK_OPTIONS}