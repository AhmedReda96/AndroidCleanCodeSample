# AndroidCleanCodeSample
### using Layers module , MVVM , Dagger-hilt , Kotlin , Coroutines , JetpackCompose , Navigation Compose 
________________________________________________________________________________________________________________________________________________________________________    
# DEMO:

![VID_20230307_201527_AdobeExpress](https://user-images.githubusercontent.com/32768768/223518623-648c7745-6c0b-4132-a103-fb9c8e609a4d.gif)
________________________________________________________________________________________________________________________________________________________________________    
### Why Clean Architecture?
- Separation of Concerns — Separation of code in different modules or sections with specific responsibilities making it easier for maintenance and further modification.

- Loose coupling — flexible code anything can be easily be changed without changing the system.

- Easily Testable.
________________________________________________________________________________________________________________________________________________________________________    
### Layers of Clean Architectre:

- APP : A layer that interacts with the UI, mainly Android Stuff like Activities, Fragments,etc. It would include Presentation, domain and data layers.

- Presentation : Contains the ViewModel and DI.

- Domain : Contains the business logic of the application. It is the individual and innermost module. It’s a complete java module.

- Data : It includes the domain layer. It would implement the interface exposed by domain layer and dispenses data to app


<img src="https://miro.medium.com/v2/resize:fit:720/format:webp/1*LldbQQRy3_ujZHbUU7X64Q.png" alt="img">
<img src="https://miro.medium.com/v2/resize:fit:1400/format:webp/1*q2AL8a9a1ZN6m5OxgLJMvg.png" alt="img">


________________________________________________________________________________________________________________________________________________________________________    

### In this sample you'll find:

-Reactive UIs using [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) for asynchronous operations.

-User Interface built with [Jetpack Compose](https://developer.android.com/jetpack/compose).

-A single-activity architecture, using [Navigation Compose](https://developer.android.com/jetpack/compose/navigation).



    
    
    
