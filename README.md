# Dr. Elephant

[![Build Status](https://api.travis-ci.org/linkedin/dr-elephant.svg)](https://travis-ci.org/linkedin/dr-elephant/)
[![Join the chat at https://gitter.im/linkedin/dr-elephant](https://badges.gitter.im/linkedin/dr-elephant.svg)](https://gitter.im/linkedin/dr-elephant?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

<a href=""><img src="images/wiki/dr-elephant-logo-150x150.png" align="left" hspace="10" vspace="6"></a>

**Dr. Elephant** is a performance monitoring and tuning tool for Hadoop and Spark. It automatically gathers all the metrics, runs analysis on them, and presents them in a simple way for easy consumption. Its goal is to improve developer productivity and increase cluster efficiency by making it easier to tune the jobs. It analyzes the Hadoop and Spark jobs using a set of pluggable, configurable, rule-based heuristics that provide insights on how a job performed, and then uses the results to make suggestions about how to tune the job to make it perform more efficiently.

## Documentation

For more information on Dr. Elephant, check the wiki pages [here](https://github.com/linkedin/dr-elephant/wiki).

For quick setup instructions: [Click here](https://github.com/linkedin/dr-elephant/wiki/Quick-Setup-Instructions)

Developer guide: [Click here](https://github.com/linkedin/dr-elephant/wiki/Developer-Guide)

Administrator guide: [Click here](https://github.com/linkedin/dr-elephant/wiki/Administrator-Guide)

User guide: [Click here](https://github.com/linkedin/dr-elephant/wiki/User-Guide)

Engineering Blog: [Click here](https://engineering.linkedin.com/blog/2016/04/dr-elephant-open-source-self-serve-performance-tuning-hadoop-spark)

## Mailing-list & Github Issues

Google groups mailing list: [Click here](https://groups.google.com/forum/#!forum/dr-elephant-users)

Github issues: [click here](https://github.com/linkedin/dr-elephant/issues)

## Meetings

We have scheduled a weekly Dr. Elephant meeting for the interested developers and users to discuss future plans for Dr. Elephant. Please [click here](https://github.com/linkedin/dr-elephant/issues/209) for details.

## How to Contribute?

Check this [link](https://github.com/linkedin/dr-elephant/wiki/How-to-Contribute%3F).





## How to compile and launch on Gaia3 from Thales gitlab
1. Clone the project
	* _git clone https://yourAccount@outils-communs-pastel.ts-tlse.fr/gitlab/GAIA/Dr-elephant.git_
	* Update remote
		* _git remote rename origin GAIA-repo_
		* _git remote add linkedIn-repo https://github.com/linkedin/dr-elephant.git_
	
2. Global variables
	* HTTP_PROXY and HTTPS_PROXY
	* Check the file "setPath.txt" and type: _source setPath.txt_
 	
3. Database
	* Start the service mysql.
	* Default account is drelephant with pwd = "Dr-elephant123"
	* Create your account  or use default account.
	* Create a database or use default database (default datadase is "drelephant")
	
4. Compile
 *	**<span style="color:red">Only for the First compilation</span>**
 	* _cd $PROJECT_ROOT/web_
 	* _npm install_
 	* In file "./node_modules/bower/lib/node_modules/bower-config/lib/util/defaults.js" replace "'registry': 'https://bower.herokuapp.com'" by "'registry': 'https://registry.bower.io'"
 	* In file "./node_modules/bower/lib/node_modules/bower-config/lib/util/expand.js" replace "config.registry.default = config.registry.default || 'https://bower.herokuapp.com'" by "config.registry.default = config.registry.default || 'https://registry.bower.io'"
  * _./compile.sh compile.conf_

* For all others compilations

	* In compil.sh you can add or remove tests.
		* Replcace "play_command $OPTS clean compile dist"by "play_command $OPTS clean compile test dist"
	* _./compile.sh compile.conf_
	
5. Start & Stop
	* After compilation:
		* cd dist/; unzip dr-elephant*.zip; cd dr-elephant*
		* Edit the following parameters in file app-conf/elephant.conf : port, db_url, db_name, db_user and db_password;
	* Launch dr.Elephant -> ./bin/start.sh app-conf/ and go to localhost: "port" to use web UI.
	* To stop the application type ./bin/stop
	
## Get the latest modification from linkedIn github on master branch
1. Type the following command: git remote -v
This should output something like:
GAIA-repo       https://yourAccount@outils-communs-pastel.ts-tlse.fr/gitlab/GAIA/Dr-elephant.git (fetch)
GAIA-repo       https://yourAccount@outils-communs-pastel.ts-tlse.fr/gitlab/GAIA/Dr-elephant.git (push)
linkedIn-repo   https://github.com/linkedin/dr-elephant.git (fetch)
linkedIn-repo   https://github.com/linkedin/dr-elephant.git (push)
If not type:
	* git remote rename origin GAIA-repo
	* git remote add linkedIn-repo https://github.com/linkedin/dr-elephant.git
	
2. Pull the project from github
	* git pull linkedIn-repo master
	
## Push modifications on Thales gitlab.
* Update remote (or check file .git/config)
	* git remote rename origin GAIA-repo
	* git remote add linkedIn-repo https://github.com/linkedin/dr-elephant.git
* Check all modified files: _git status_
* Add all modified/untracked files to the staging area: _git add ._
* Commit your modification: _git commit -m "message de commit"_
* Push on remote repository: _git push -u GAIA-repo_
	
## Tag a new version of Dr.elephant
* Checkout on master branch: _git checkout master_
* Create the tag: _git tag -a v1.0 -m "Version 1.0"_
* Check that the tag is well created on local machine: _git tag_
* Push the tag on remote: _git push GAIA-repo --tags_

## Generate the delivery

* Checkout the tag on a new branch: _git checkout tags/tagName -b branchName_
* Check that the branch is well created: _git branch_
* You can also check the last commit of the tag: _git log_
* Generate the delivery: compile the project (you can follow steps 2 and 4 of part "How to compile and launch on Gaia3 from Thales gitlab")

## License

    Copyright 2016 LinkedIn Corp.

    Licensed under the Apache License, Version 2.0 (the "License"); you may not
    use this file except in compliance with the License. You may obtain a copy of
    the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
    WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
    License for the specific language governing permissions and limitations under
    the License.
