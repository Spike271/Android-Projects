<div align="center">

# Lemonade App

![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)
![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)
![Material 3](https://img.shields.io/badge/Material%203-7D5260?style=for-the-badge&logo=materialdesign&logoColor=white)

</div>

## About the Project

Lemonade App is a fun, interactive Android application built with Jetpack Compose and Material Design 3. It guides users through the simple process of making lemonade: picking a lemon, squeezing it multiple times, drinking the lemonade, and restarting.

## Key Features

- **Interactive Flow**: A 4-step process (Pick, Squeeze, Drink, Restart) with randomized squeeze requirements.
- **State Management**: Uses Compose state to track progress and update UI dynamically.
- **Material 3 UI**: Features M3 components like `Scaffold`, `CenterAlignedTopAppBar`, `Button`, and custom theming for colors and shapes.

## Screenshots

<p align="center">

  <img src="GitVisuals/App_screenshot_01.png" width="250" alt="Lemon Tree">
  <img src="GitVisuals/App_screenshot_02.png" width="250" alt="Lemon">
  <img src="GitVisuals/App_screenshot_03.png" width="250" alt="Lemonade">
  <img src="GitVisuals/App_screenshot_04.png" width="250" alt="Empty Glass">

</p>

## Tech Stack

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Design System**: Material Design 3
- **Target SDK**: 36
- **Min SDK**: 27

## Project Structure

```text
app/src/main/java/com/example/lemonade/
├── ui/theme/       # Material 3 Theme (Color, Theme, Type)
└── MainActivity.kt
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
