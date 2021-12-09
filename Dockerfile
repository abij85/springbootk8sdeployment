FROM JAVA_BASE_IMAGE_REGISTRY_PATH

LABEL some_labels_to_describe_docker_image_like_maintainer_etc
COPY JAR_FROM_JENKINS_WORKSPACE_To_CONTAINER_WORKDIR /CONTAINER_WORKDIR/infraautomation.jar
RUN SET_PERMISSIONS_CHMOD_IF_REQUIRED
EXPOSE 8443
ENTRYPOINT ["java", "-jar", "/CONTAINER_WORKDIR/infraautomation.jar"]