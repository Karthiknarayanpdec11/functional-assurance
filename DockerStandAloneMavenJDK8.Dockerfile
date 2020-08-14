FROM markhobson/maven-chrome

RUN apt-get install -y git

RUN echo "Hello BootCamp"
MAINTAINER "Mohanraj"
RUN echo 'mybootcampproject:test'
RUN git clone -b master --single-branch 'https://github.com/TechnologyBootCamps/functional-assurance.git'
WORKDIR /functional-assurance
RUN ls