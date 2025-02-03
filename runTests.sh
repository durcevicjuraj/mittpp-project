#!/bin/bash

# Prompt for browser selection
echo "Which browser do you want to use for tests? (chrome/firefox)"
read browser

if [ "$browser" != "chrome" ] && [ "$browser" != "firefox" ]; then
  echo "Unknown browser '$browser'. Defaulting to chrome."
  browser="chrome"
fi

echo "Running tests on $browser..."

# Run tests and then generate the aggregated report in one Maven invocation
mvn clean test surefire-report:report -Dbrowser=$browser -Dmaven.test.failure.ignore=true

echo "Aggregated test report generated at: target/site/surefire-report.html"
echo "Open that file in your browser to view the report."

exit 0
