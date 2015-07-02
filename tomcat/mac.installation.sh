# From: http://blog.bolshchikov.net/post/50277857673/installing-tomcat-on-macos-with-homebrew

#Install
brew update
brew install tomcat

#Find tomcat version
tomcat_version=$(find /usr/local/Cellar/tomcat/ | grep startup.sh | cut -d/ -f7)

# Create symlink
sudo ln -s /usr/local/Cellar/tomcat/$tomcat_version/libexec /Library/Tomcat

# Homebrew will install you tomcat under /usr/local folder. So, instead of writing the path all the type, we are going to create a symbol link
# Change the folder ownership so you could write there
sudo chown -R $USER /Library/Tomcat

# Make script in bin folder executable
sudo chmod +x /Library/Tomcat/bin/*.sh
