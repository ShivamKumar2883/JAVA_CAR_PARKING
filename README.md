# JAVA Car Parking System - Project README

## Project Overview:
The **Car Parking System** is a Java-based application that helps manage a parking lot. It records which vehicles are registered and which are currently parked, allows authorized cars to enter the parking lot, and provides various reports. The project includes functionality to register vehicles, park and remove them from the lot, and generate daily reports.

### Key Features:
- **Vehicle Registration**: Only registered vehicles are allowed to park in the lot.
- **Vehicle Parking**: Vehicles can be parked and removed from specific spots in the lot.
- **Reports**: The system generates reports on registered vehicles, parked vehicles, and the status of the parking lot (whether full or not).
- **Data Persistence**: Registered vehicle data and parking lot status are saved in text files for later use.

## How to Run the Program:

### Prerequisites:
- Java Development Kit (JDK) installed on your system.
- A terminal or IDE capable of running Java programs.

### Steps:
1. **Clone or Download** the project files.
2. **Open the project** in your IDE or terminal.
3. **Run the `CarParkingSystem15F1.java` file**:
   - Compile the file using `javac CarParkingSystem15F1.java`.
   - Execute it with `java CarParkingSystem15F1`.

4. **Interact with the Program** using the menu displayed in the console. Below are the options you can choose:
    - **1**: Add a registered vehicle (required before parking).
    - **2**: Check if a vehicle is registered.
    - **3**: Park a registered vehicle.
    - **4**: Remove a parked vehicle.
    - **5**: Generate reports showing parking lot status.
    - **6**: Search for a parked vehicle by plate number.
    - **q**: Quit the program and save the data.

### Example of User Input:
```
Enter 1 to add a registered vehicle
Enter 2 to check if a vehicle is registered
Enter 3 to add a parked vehicle
Enter 4 to remove a parked vehicle
Enter 5 to generate reports
Enter 6 to check vehicle parked place
Enter q to quit
```

## File Structure:
- **`CarParkingSystem15F1.java`**: The main source file of the project.
- **`registered_plates.txt`**: A file where registered vehicle data is stored after the program is closed.
- **`parking_lot.txt`**: A file that contains the layout of the parking lot, showing which spots are occupied.

## Features Under Development:
- **Graphical User Interface (GUI)**: A GUI version of this project is currently under development to enhance user experience.

## Output Files:
1. **`registered_plates.txt`**: Contains the list of registered vehicle plates.
2. **`parking_lot.txt`**: Contains the parking layout, showing which spots are occupied by which vehicle.

## Future Improvements:
- Add an owner registration feature to store and display vehicle owner details.
- Implement a GUI for easier interaction.
- Provide real-time notifications when the parking lot is full.

## License:
This project is open-source and can be modified or distributed under the terms of the MIT License.

