# Smithy Test Package

This is just for testing Smithy with GitHub's package repositories.

There are three branches of note:

* `main` - Contains the package that is actually being
  published. Gradle is configured to publish this branch to the maven
  package repo on GitHub.
* `smithy-cli-dependency`  (you are here) - Contains a Smithy CLI-based Smithy
  package that depends on the pacakge in `main`.
* `gradle-dependency` - Contains a Gradle-based Smithy package that depends
  on the package in `main`.
