# Get current project path
PROJECT_PATH=$(pwd)

# Clean up environment
killall node
killall java
killall screen
killall SCREEN
killall chromium-browser
killall chromedriver
screen -wipe

# Start new hub, node session
echo $PROJECT_PATH

screen -dmS "hub-session" java -jar 'selenium-server-standalone-3.141.59.jar' -role hub
screen -dmS "node-session" java -jar 'selenium-server-standalone-3.141.59.jar' -role node -hub http://localhost:4444/grid/register

# List out all sessions
screen -ls

# Please recheck sessions on http://localhost:4444/grid/console#
