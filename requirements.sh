#!/bin/bash

echo "Checking and installing project dependencies..."

# Check for Node.js and install JSON Server
if ! command -v json-server &> /dev/null
then
    echo "Installing JSON Server globally..."
    npm install -g json-server
else
    echo "JSON Server already installed."
fi

# Check Java installation
if ! command -v java &> /dev/null
then
    echo "Java not found. Please install Java 17 or later."
else
    echo "Java is installed."
fi

# Check Maven installation
if ! command -v mvn &> /dev/null
then
    echo "Maven not found. Please install Apache Maven."
else
    echo "Maven is installed."
fi

echo "Setup complete. Run the following to begin:"
echo "  json-server --watch db.json --port 3000"
echo "  mvn clean test"
