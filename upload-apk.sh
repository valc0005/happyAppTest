  #create the new directory will contain que October generated apk
  mkdir buildApk
  #copy generated apk from build folder to the folder just created
  cp -R app/build/outputs/apk/app-debug.apk /buildApk/
  #go to home and git setup
  cd ..
  git config --global user.email "valc0005@hz.nl"
  git config --global user.name "valc0005"
  # Clone the repository in the folder buildApk  git clone --quiet --branch master = https: // user-name: $GITHUB_API_KEY@github.com/user-name/repo-name master> / dev / null
  #go into directory and copy data we're interested  cd master cp -Rf $ HOME / android / *.
  #add, commit and push files  git add -f.
  git remote add origin https://github.com/valc0005/happyAppTest.git
   . git add -f
  git commit -m "Travis build $ TRAVIS_BUILD_NUMBER pushed [skip ci] "
  git push origin master -fq> / dev / null
  echo -e" Done \ n "