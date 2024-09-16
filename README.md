# Airofly - Google Map with Pollution and Rain Tracking

Airofly is a comprehensive pollution and rain tracking system developed using Java, JSP, and Android. The project integrates Google Maps to detect and display real-time environmental conditions, including the presence of pollutants such as LPG, CO, and smoke, as well as rainfall.

## Features

- **Pollution Detection**: Monitors and tracks pollutants in the air such as LPG, CO (Carbon Monoxide), and smoke.
- **Rain Tracking**: Detects rainfall and visualizes it on the map.
- **Google Maps Integration**: Uses Google Maps to provide a real-time view of pollution and rain data.
- **Android Application**: User-friendly Android interface to view pollution and weather updates.
- **JSP and Java Backend**: The backend is developed in Java and JSP, handling data processing and communication with the Android frontend.

## Technologies Used

- **Java**: Core language for backend logic and processing.
- **JSP**: Java Server Pages for server-side processing and web interface.
- **Android**: Android application to provide real-time data to users.
- **Google Maps API**: For visualizing pollution and rain data on a map.
- **Sensors**: Used to detect various gases like LPG, CO, and smoke in the environment.

## Project Structure

- `/src`: Contains the source code for the Java and JSP backend.
- `/android`: Android application files.
- `/web`: Web resources and JSP files for server-side functionality.
- `/resources`: Environmental data, sensor configurations, and API keys.

## How It Works

1. **Pollution Detection**: Sensors detect the presence of gases such as LPG, CO, and smoke. This data is then processed by the backend to determine pollution levels.
2. **Rain Detection**: Rain sensors detect precipitation levels and send data to the backend.
3. **Data Visualization**: The processed data is displayed on Google Maps via the Android application and web interface. Users can view pollution levels and rain intensity on the map in real-time.
4. **Alerts**: Notifications and alerts are generated when pollution levels exceed certain thresholds.

## Installation

### Prerequisites

- Java 8+
- Android Studio (for Android app)
- Google Maps API Key
- Sensors for LPG, CO, and smoke detection
- Tomcat server for JSP deployment

### Steps

1. Clone this repository:
   ```bash
   git clone https://github.com/yourusername/airofly.git
