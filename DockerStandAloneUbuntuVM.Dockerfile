FROM ubuntu

# Update and install s/w
RUN apt-get update
RUN apt-get install -y openjdk-8-jdk
RUN apt-get install -y git
RUN apt-get install -y xvfb libxi6 libgconf-2-4
RUN apt-get install -y wget unzip curl gnupg
RUN apt-get install maven

# Install Chrome driver for Ubuntu
RUN wget -N https://chromedriver.storage.googleapis.com/85.0.4183.38/chromedriver_linux64.zip
RUN unzip chromedriver_linux64.zip -d /usr/local/share
RUN rm chromedriver_linux64.zip
RUN chmod +x /usr/local/share/chromedriver
RUN ln -s /usr/local/share/chromedriver /usr/local/bin/chromedriver
RUN ln -s /usr/local/share/chromedriver /usr/bin/chromedriver

# Install Chrome
RUN set -xe \
&& curl -fsSL https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - \
&& echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google-chrome.list \
&& apt-get update \
&& apt-get install -y google-chrome-stable \
&& rm -rf /var/lib/apt/lists/*

RUN echo "Hello BootCamp"

MAINTAINER "Mohanraj"

RUN echo 'Project Name:test'
RUN git clone -b master --single-branch 'https://github.com/TechnologyBootCamps/functional-assurance.git'
WORKDIR /functional-assurance