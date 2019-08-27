# Test Automation framework for Web
**Author**: Maksims Gusakovs.

## Features and stuff
* Code and whole test step reuse benefit from Cucumber;
* Different properties (yaml, csv) readers to set up default project configurations;

## Running tests locally
Several ways to run test from IDE:
* Running set of service specific test by running FeatureRunner from `\src\tests\java\testRunners\...`
* Running some specific test by tag using UniversalRunner `\src\tests\java\testRunners\UniversalRunner.java`. Put needed tag in tags block in runner.
* Running specific test case from feature file by right-clicking and selecting "Run scenario" or pressing CTRL + SHIFT + F10
    * if there is issue with too long command line, do following:
        In Cucumber java Run/Debug configuration "Shorten command line" set to JAR manifest

## Configurations
* Web-browser type configuration:
    * Configuration file `\config.yml`
    * For local testing available browsers are: chrome, firefox, ie, phantomjs, safari, opera
    * To switch browser type set browser.name to desired browser name
    * Note: for local testing selected browser should be installed on local machine
    * Chrome and Firefox browsers could be run in two modes: visible and invisible
    * To switch browser running mode set browser.headless to true for invisible mode and opposite
    * Example:

          browser:
            name: firefox
            startMaximized: false
            headless: false
