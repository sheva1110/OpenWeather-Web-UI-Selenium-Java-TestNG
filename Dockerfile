# Build a container with official image: python
FROM maven

# https://docs.gauge.org/howto/ci_cd/docker.html?os=macos&language=javascript&ide=vscode
RUN apt-key adv --keyserver hkp://pool.sks-keyservers.net --recv-keys 023EDB0B
RUN echo deb https://dl.bintray.com/gauge/gauge-deb stable main | tee -a /etc/apt/sources.list
RUN apt-get update

# Copy source to container
RUN mkdir web-ui-automation
RUN cd web-ui-automation
WORKDIR /web-ui-automation
COPY . /web-ui-automation

RUN mvn dependency:resolve

# Set Timezone
ENV TZ 'Asia/Ho_Chi_Minh'
RUN echo $TZ > /etc/timezone && \
    apt-get update -qq && apt-get install -y -qq tzdata && \
    rm /etc/localtime && \
    ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && \
    dpkg-reconfigure -f noninteractive tzdata && \
    apt-get clean -qq

# Set display port to avoid crash
ENV DISPLAY=:99
