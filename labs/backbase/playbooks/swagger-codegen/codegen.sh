#!/usr/bin/env bash

if [[ -z $1 ]]; then
  echo "No specification type specified."
  exit 1
fi

specification=$1

if [[ -z $2 ]]; then
  if [ -f "./openapi-generator-cli.jar" ]; then
    echo "Code generator already exists. Skipping download."
  else
    echo "A code generator jar will be automatically downloaded as it is not present in specified location."
    echo "Downloading..."
    curl -o openapi-generator-cli.jar https://repo1.maven.org/maven2/org/openapitools/openapi-generator-cli/6.0.1/openapi-generator-cli-6.0.1.jar
    echo "Code generator downloaded"
  fi
  code_generator_path="./openapi-generator-cli.jar"
else
  echo "Code generator explicitly specified."
  code_generator_path=$2
fi

case $specification in
  platform)
    specification_path="../platform-apis/oas-v3.0.1/platform-apis.yaml"
    config="../platform-apis/oas-config.yaml"
    output_folder="../platform-apis/gen"
    ;;

  *)
    echo -n "No specification has been mapped to $specification."
    ;;
esac

mkdir -p $output_folder
echo "Generating code for the specification: '$specification'"

set -ex
java -jar $code_generator_path generate \
    -i $specification_path \
    -g java \
    -o $output_folder \
    -c $config