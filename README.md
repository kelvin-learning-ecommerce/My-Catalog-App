# Kelvin Keda Tech Coding Challenge

## Getting Started

## Modules:

* App
  * Core - Setup Dependency Injection
  * Main Activity - initiate Navigation
  * Main Application - setup startup function
* Data
  * Datasource - Api Datasource & Room Datasource
  * Model - Datasource Model
  * Query - Api query model
  * Room - Setup DAO Database
  * Util - Abstract class for Resource State handling
* Domain
  * Data - Repository Model
  * Mapper - Data Mapper used in repository from DTO Model to Repository Model
  * Repository - for handling Datasource model to Entity Model(used in presentation)
  * Usecase - handling any action interact from domain to presentation 
* Presentation
  * Dashboard - View for showing list of Github user
  * Favorite - View for favorite user
  * Home - Handling Tab View for Dashboard & Favorite
  * Shared - Shared component used by any view
  * Splash - View for Splash Screen
  * Theme - App Theme used by any view
  * Unit Test

### Libraries & Tools Used

* Android Compose
* Navigation Compose
* Test Unit (Junit, kluent, mockk, coroutines test)
* google dagger hilt
* Retrofit
* Kotlin coroutines
* Room
