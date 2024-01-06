# STS Quick Start

## Introduction
This repository is meant to help people setup their springboot applications quickly while providing all the basic functionalities, in order to make it scalable, sustainable and secure. <br>
This is done by a person who is learning springboot and is interested in creating large scale applications <br>
Any Suggestions and improvements are gladly welcome

## Working
1. STSQuickStart <br>
    When you clone this repo STS-QuickStart you will see the folder STSQuickStart import as a project into Spring Tool Suite or your preferred IDE for development. It contains two modules Common and REST which will be discussed below.
2. Common <br>
    This Module contains various aspect such as Database Configuration, Global Exception Handler and its Exceptions and various Enums and helper functions. This meant as a movable module where it can be attached to any other Springboot Project
3. REST <br>
    This Module contains the Rest Controllers, It has been secured through Spring Security and JWT. User and Roles tables have been defined through JPA and Join Table exists between the two. You wilk need to configure the Database in the Common module in order for the various Repositories in the REST module to work. As you know spring security uses these repositories. Once everything is configured you can Register and Login with appropriate roles through the Auth Controller and then use the UserController or Admin Controller based on your roles. You will need the JWT to use the UserController and AdminController

## Conclusion
This is a work in progress and any suggestions will be gladly accepted as whether to which functionality you wish have added to this repository or just general programming practices. <br>
Hope this Readme file gives you enough understanding of repository to use it, if not message me @ athael.raj@gmail.com
