# Calory Tracker Kotlin Android App

## Overview
This master document provides an overview and guidance for developing an Android Kotlin app using various modern Android development technologies and best practices. The app will utilize the following capabilities:

- Jetpack Compose: A modern UI toolkit for building native Android apps.
- Flows: Asynchronous programming with coroutines, providing reactive streams of data.
- Hilt: Dependency injection framework for managing dependencies.
- MVVM Architecture: Model-View-ViewModel architectural pattern for separation of concerns.
- Multimodule: Organizing the app into multiple modules for better code organization and scalability.
- Retrofit: A type-safe HTTP client for making API requests.
- Room Database: A SQLite object mapping library for database operations.
- Unit Tests: Writing tests for individual units of code.
- UI Tests: Testing the user interface of the app.
- End-to-End Tests: Testing the entire flow of the app.


## Modules by Feature
Instead of organizing the app by layers (such as presentation, data, domain), modules can be organized based on features or functional areas of the app. This approach promotes better encapsulation and modularity, allowing for independent development and maintenance of different features.

Each module represents a specific feature of the app and contains all the necessary components (UI, data, business logic, etc.) related to that feature. Here's an example of how the modules can be structured based on features:

app: The main application module that coordinates the different features and provides the entry point to the app. It depends on the other feature modules.

Tracker: This module represents the first feature of the app. It contains all the components (UI, data, business logic) specific to this feature. For example, if the app has a feature for user authentication, this module would handle the login UI, authentication logic, and user-related data operations.

Onboarding: This module represents the second feature of the app. It follows a similar structure as the first feature module, containing the UI, data, and business logic related to this feature. For instance, if the app has a feature for displaying user profiles, this module would handle the profile UI, data retrieval for user profiles, and related operations.

core: This module contains shared components, utilities, extensions, or helper classes that are used across multiple features. It promotes code reuse and avoids duplication of common functionalities.

By organizing the modules based on features, you can easily add or remove features without affecting the entire codebase. Each feature module can be developed, tested, and maintained independently, providing better modularity and scalability to the project.

Within each feature module, you can still follow the MVVM architectural pattern and utilize Jetpack Compose, Flows, Hilt, Retrofit, Room Database, unit tests, UI tests, and end-to-end tests, as mentioned in the previous master.md. However, the key difference lies in structuring the codebase based on features instead of layers.

Remember to consider the specific needs and requirements of your app when determining the features and their corresponding modules.


## Technology Stack
The app will utilize the following technology stack:

- Kotlin: As the primary programming language.
- Android Jetpack: Including Jetpack Compose, ViewModel, LiveData, Navigation, Room, etc.
- Kotlin Coroutines: For handling asynchronous operations.
- Retrofit: For making API requests.
- Hilt: For dependency injection.
- JUnit: For unit testing.
- Espresso: For UI testing.
- UI Automator: For end-to-end testing.
