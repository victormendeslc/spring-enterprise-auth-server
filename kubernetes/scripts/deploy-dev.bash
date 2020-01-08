#!/usr/bin/env bash

# Print commands to the terminal before execution and stop the script if any error occurs
set -ex

# Map minikube.me to the IP address of the Minikube instance by
# adding a line to the file /etc/hosts with the following command:
# sudo bash -c "echo $(minikube ip) minikube.me | tee -a /etc/hosts"

kubectl create configmap auth-server-configmap --from-file=/src/main/resources/application.yml --save-config

kubectl create secret generic postgres-server-credentials \
    --from-literal=POSTGRES_DB=auth_db \
    --from-literal=POSTGRES_USER=postgres \
    --from-literal=POSTGRES_PASSWORD=postgres \
    --save-config

kubectl create secret generic postgres-credentials \
    --from-literal=SPRING_DATASOURCE_USERNAME=postgres \
    --from-literal=SPRING_DATASOURCE_PASSWORD=postgres \
    --save-config

#kubectl create secret tls tls-certificate --key kubernetes/cert/tls.key --cert kubernetes/cert/tls.crt

# First deploy the resource managers and wait for their pods to become ready
kubectl apply -f kubernetes/services/overlays/dev/postgres.yml
kubectl wait --timeout=600s --for=condition=ready pod --all

# Next deploy the microservices and wait for their pods to become ready
kubectl apply -k kubernetes/services/overlays/dev
kubectl wait --timeout=600s --for=condition=ready pod --all

set +ex