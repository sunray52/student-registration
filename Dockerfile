#FROM openjdk:20
#LABEL maintainer="pavlovld2007@gmail.com"
#RUN mkdir /opt/app
#WORKDIR /usr/src/my_app_directory
#COPY

# Start your image with a node base image
FROM node:18-alpine

# The /app directory should act as the main application directory
WORKDIR /app

# Copy the app package and package-lock.json file
COPY package*.json ./

# Copy local directories to the current local directory of our docker image (/app)
COPY welcome-to-docker/src ./src
COPY welcome-to-docker/public ./public

# Install node packages, install serve, build the app, and remove dependencies at the end
RUN npm install \
    && npm install -g serve \
    && npm run build \
    && rm -fr node_modules

EXPOSE 3000

# Start the app using serve command
CMD [ "serve", "-s", "build" ]