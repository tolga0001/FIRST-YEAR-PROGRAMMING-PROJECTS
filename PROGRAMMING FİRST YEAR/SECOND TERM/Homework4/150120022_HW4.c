/** Name and Surname: Tolga Fehmioðlu
    ID:150120022
The aim of this program is to find the shortest path from one station to another.
 // Some of the functions couldn't be used. They are just for practising(: **/

// Libraries which will be used throughout all  processes
#include <stdio.h>
#include <string.h>
#include <math.h>

// defining a constant variable SIZE with value 10
# define SIZE 10


// The MetroStation Struct and its data field
typedef struct MetroStation {
    char name[20];
    double x, y;
} MetroStation;

// The MetroLine Struct and its data field
typedef struct MetroLine {
    char color[20];
    MetroStation MetroStations[SIZE];

} MetroLine;

// The MetroSystem Struct and its data field
typedef struct MetroSystem {
    char name[20];
    MetroLine MetroLines[SIZE];

} MetroSystem;

// Function Prototypes
void duplicatePath(struct MetroStation pStation[10], MetroStation *pStation1);

void addStartStation(MetroStation station, struct MetroStation pStation[10]);

int getIndexOfLastStation(MetroStation *pStation);

void printPath(struct MetroStation pStation[10]);

void findPath(MetroStation start, MetroStation finish, MetroStation path[]);

void recursiveFindPath(MetroStation start, MetroStation finish, MetroStation partialPath[], MetroStation bestPath[]);

void updateBestPath(MetroStation bestPath[], MetroStation currentPath[]);

// this method checks whether two stations are same or not according to their names.
int equals(MetroStation s1, MetroStation s2) {
    if (strcmp(s1.name, s2.name) == 0) {
        return 1;
    }
    return 0;
}

// this function enable us to find the lastStationIndex in a current line
int getLastStationIndex(MetroLine line) {
    int i = 0;
    do {
        if (line.MetroStations[i].name[0] == '\0') {
            break;
        }
        i++;
    } while (i < SIZE);
    return i - 1;
}

// this function will be used to add the stations to the given line
void addStation(MetroLine *metroLinePtr, MetroStation metroStation) {
    int i = 0;
    do {
        if (metroLinePtr->MetroStations[i].name[0] == '\0') {
            break;
        }
        i++;
    } while (i < SIZE);

    metroLinePtr->MetroStations[i] = metroStation;
}

// this function checks whether the given metro-station is in the given metroLine or not.
int hasStation(MetroLine metroLine, MetroStation metroStation) {
    int i;
    MetroStation currentStation;
    for (i = 0; i < SIZE; ++i) {
        currentStation = metroLine.MetroStations[i];
        if (equals(currentStation, metroStation)) {
            return 1;
        }
    }
    return 0;
}

// this function enables us to find the first stop of the given line
MetroStation getFirstStop(MetroLine metroLine) {
    if (metroLine.MetroStations[0].name[0] == '\0') {
        MetroStation empty;
        return empty;
    }
    return metroLine.MetroStations[0];

}

// this function enables us to find the previous stop of the given metro-station
MetroStation getPreviousStop(MetroLine metroLine, MetroStation metroStation) {
    MetroStation empty;

    if (equals(metroStation, metroLine.MetroStations[0]))
        return empty;
    int i;
    for (i = 1; i < SIZE; ++i) {
        if (equals(metroStation, metroLine.MetroStations[i])) {
            return metroLine.MetroStations[i - 1];
        }
    }
    return empty;
}

// this function enables us to find the next stop of the given metro-station
MetroStation getNextStop(MetroLine metroLine, MetroStation metroStation) {
    MetroStation empty;
    int i;
    char name[SIZE];
    int lastStIndex = getLastStationIndex(metroLine);
    if (equals(metroStation, metroLine.MetroStations[lastStIndex]))
        return empty;

    for (i = 0; i < SIZE - 1; ++i) {
        if (equals(metroStation, metroLine.MetroStations[i])) {
            return metroLine.MetroStations[i + 1];
        }
    }
    return empty;
}

// this function add the current line to the given metro system.
void addLine(MetroSystem *metroSystemPtr, MetroLine metroLine) {
    int i;
    for (i = 0; i < SIZE; ++i) {
        if (metroSystemPtr->MetroLines[i].color[0] == '\0') {
            break;
        }
    }
    metroSystemPtr->MetroLines[i] = metroLine;
}

// this function will be used to print the lines with their stations
void printLine(MetroLine metroLine) {
    printf("Metroline %s:  ", metroLine.color);
    int i;
    int lastIndex = getLastStationIndex(metroLine);
    for (i = 0; i < lastIndex; i++) {
        printf("%s, ", metroLine.MetroStations[i].name);
    }
    printf("%s.", metroLine.MetroStations[lastIndex].name);
    printf("\n");
}

// this function will find the number of stations in the given metro-line.
int getlength(MetroLine metroLine) {
    return getLastStationIndex(metroLine) + 1;
}

// this is a simple function which calculates the distance of two point.
double getdistance(double x0, double y0, double x1, double y1) {
    return sqrt(pow(x1 - x0, 2) + pow(y1 - y0, 2));
}

// this function will be used to calculate the number of stations in a given metro-station array.
int getstationslength(MetroStation *pStation) {
    int i;
    int length = 0;
    for (i = 0; pStation[i].name[0] != '\0'; i++) {
        length++;
    }
    return length;
}

// this function will be used to calculate the total distance in the given metro-station array
double getDistanceTravelled(MetroStation metroStations[]) {
    int len = getstationslength(metroStations);
    if (len >= 2) {
        int index;
        double totaldistance = 0;
        double x0, y0, x1, y1;
        for (index = 0; index < getstationslength(metroStations); index++) {
            x0 = metroStations[index].x;
            y0 = metroStations[index].y;
            x1 = metroStations[index + 1].x;
            y1 = metroStations[index + 1].y;
            totaldistance += getdistance(x0, y0, x1, y1);
        }
        return totaldistance;

    }


    return 0;
}

// this function returns the number of lines in a particular metro system
int getLinesLength(MetroSystem system) {
    int i, count = 0;
    for (i = 0; i < strlen(system.MetroLines[i].color) != 0; i++) {
        count++;
    }
    return count;

}

// this function is just to practising.It can work to calculate all the stations in a given metro system.
int getTotalStations(MetroSystem system) {
    int i, j, count = 0;
    MetroLine currentLine;
    for (i = 0; strlen(system.MetroLines[i].color) != 0; i++) {
        currentLine = system.MetroLines[i];
        count += getlength(currentLine);
    }
    return count;
}

// this function will be used to find the nearest station to the given  coordinates.
MetroStation findNearestStation(MetroSystem metroSystem, double x, double y) {
    MetroStation nearestSt = getFirstStop(metroSystem.MetroLines[0]);
    double nearestX = nearestSt.x;
    double nearestY = nearestSt.y;
    double nearestDistance = getdistance(x, y, nearestX, nearestY);

    int i, j, lineLength, stationLength;
    lineLength = getLinesLength(metroSystem);
    MetroLine currentLine;
    MetroStation currentStation;

    for (i = 0; i < lineLength; i++) {
        currentLine = metroSystem.MetroLines[i];
        for (j = 0; j < getlength(currentLine); ++j) {
            currentStation = currentLine.MetroStations[j];
            double distance = getdistance(x, y, currentStation.x, currentStation.y);
            if (distance < nearestDistance) {
                nearestDistance = distance;
                nearestSt = currentStation;
            }
        }
    }
    return nearestSt;


}

// this function calculates the index value of the given station in a current line.
int getIndex(MetroStation station, MetroLine line) {
    int i;
    for (i = 0; line.MetroStations[i].name[0] != '\0'; i++) {
        if (equals(station, line.MetroStations[i])) {
            return i;
        }
    }
    return -1;
}

// this function will be used to fill all the neighboring Stations of a given metro-station.
void fillArray(MetroStation metroStation, MetroStation neighboringStations[], int *k, MetroLine currentline) {
    int index = getIndex((metroStation), (currentline));

    if (index == 0 ) {
        neighboringStations[*k] = getNextStop(currentline, metroStation);
        (*k)++;

    } else if (index == getLastStationIndex((currentline))) {
        neighboringStations[*k] = getPreviousStop(currentline, metroStation);
        (*k)++;

    } else {
        neighboringStations[(*k)++] = getPreviousStop(currentline, metroStation);
        neighboringStations[(*k)++] = getNextStop(currentline, metroStation);

    }
}

// this function will help us find neighboring Stations of a given metro-station.
void getNeighboringStations(MetroSystem metroSystem, MetroStation metroStation, MetroStation neighboringStations[]) {
    int i;
    int nIndex = 0;
    MetroLine currentLine;


    for (i = 0; (metroSystem.MetroLines[i].color[0] != '\0'); i++) {
        currentLine = metroSystem.MetroLines[i];
        if (hasStation(currentLine, metroStation)) {

            fillArray(metroStation, neighboringStations, &nIndex, currentLine);
        }


    }
}

// this function will check whether the given station exists in the given station array or not.
int doescontains(MetroStation station, MetroStation *pStation) {
    int i = 0;
    for (i = 0; strlen(pStation[i].name) != 0; i++) {
        if (equals(pStation[i], station)) {
            return 1;
        }
    }
    return 0;
}

// this function will be used to add the current station to the shortest path/ the best Path.
void addStartStation(MetroStation start, MetroStation pStation[10]) {
    int lastIndex = getIndexOfLastStation(pStation);
    pStation[lastIndex + 1] = start;


}

// this function will be used to find the length of a particular metro-station array.
int getIndexOfLastStation(MetroStation *pStation) {
    int i, lastIndex;
    int indexCount = 0;
    for (i = 0; strlen(pStation[i].name) != 0; i++) {
        indexCount++;
    };
    lastIndex = indexCount - 1;
    return lastIndex;
}

// this function will copy the source array to the destination like an arraycopy function.Same logic.
void duplicatePath(struct MetroStation destination[10], MetroStation *source) {
    int i;
    for (i = 0; i < SIZE; i++) {
        strcpy(destination[i].name, source[i].name);
        destination[i].x = source[i].x;
       destination[i].y = source[i].y;
       // destination[i] = source[i];
    }

}


//Declare a MetroSystem with the name of istanbul and an empty content.
MetroSystem istanbul = {"istanbul", '\0'};

// Test case in main function
int main() {
    int i;
    double myX = 1, myY = 2;
    double goalX = 62, goalY = 45;

    // define 3 metro lines, 9 metro stations, and an empty myPath
    MetroLine red = {'\0'}, blue = {'\0'}, green = {'\0'};
    MetroStation s1, s2, s3, s4, s5, s6, s7, s8, s9;
    MetroStation myPath[SIZE] = {'\0'};

    strcpy(red.color, "red");
    strcpy(blue.color, "blue");
    strcpy(green.color, "green");


    strcpy(s1.name, "Haydarpasa");
    s1.x = 0;
    s1.y = 0;
    strcpy(s2.name, "Sogutlucesme");
    s2.x = 10;
    s2.y = 5;
    strcpy(s3.name, "Goztepe");
    s3.x = 20;
    s3.y = 10;
    strcpy(s4.name, "Kozyatagi");
    s4.x = 30;
    s4.y = 35;
    strcpy(s5.name, "Bostanci");
    s5.x = 45;
    s5.y = 20;
    strcpy(s6.name, "Kartal");
    s6.x = 55;
    s6.y = 20;
    strcpy(s7.name, "Samandira");
    s7.x = 60;
    s7.y = 40;
    strcpy(s8.name, "Icmeler");
    s8.x = 70;
    s8.y = 15;

    //Add several metro stations to the given metro lines.
    addStation(&red, s1);
    addStation(&red, s2);
    addStation(&red, s3);
    addStation(&red, s4);
    addStation(&red, s5);
    addStation(&red, s8);

    addStation(&blue, s2);
    addStation(&blue, s3);
    addStation(&blue, s4);
    addStation(&blue, s6);
    addStation(&blue, s7);

    addStation(&green, s2);
    addStation(&green, s3);
    addStation(&green, s5);
    addStation(&green, s6);
    addStation(&green, s8);

    // Add red, blue, green metro lines to the Istanbul metro system.
    addLine(&istanbul, red);
    addLine(&istanbul, blue);
    addLine(&istanbul, green);

    // print the content of the red, blue, green metro lines
    printLine(red);
    printLine(blue);
    printLine(green);


    // find the nearest stations to the current and target locations
    MetroStation nearMe = findNearestStation(istanbul, myX, myY);
    MetroStation nearGoal = findNearestStation(istanbul, goalX, goalY);

    printf("\n");

    printf("The best path from %s to %s is:\n", nearMe.name, nearGoal.name);

    // if the nearest current and target stations are the same, then print a message and exit.
    if (equals(nearMe, nearGoal)) {
        printf("It is better to walk!\n");
        return 0;
    }

    // Calculate and print the myPath with the minimum distance travelled from start to target stations.
    findPath(nearMe, nearGoal, myPath);

    if (strlen(myPath[0].name) == 0)
        printf("There is no path on the metro!\n");
    else {
        printPath(myPath);
    }

    return 0;

}

// this function will be used to find the shortest path of a given station to another and call the recursive function.
void findPath(MetroStation start, MetroStation finish, MetroStation path[]) {
    MetroStation partialPath[SIZE] = {};

    recursiveFindPath(start, finish, partialPath, path);
}

// this function prints the stations on given path.
void printPath(MetroStation *stations) {
    int i;
    for (i = 0; strlen(stations[i].name) != 0; i++) {
        printf("%d. %s\n", i + 1, stations[i].name);
    }
}

// the function will construct the best path which is the shortest path that we can travel.
void recursiveFindPath(MetroStation start, MetroStation finish, MetroStation partialPath[], MetroStation bestPath[]) {

    // Base case 1: If the partial path contains the start station, it will return immediately.
    if (doescontains(start, partialPath)) {

        return;
    }
    // creating the duplicatedPath array using partialPath array.
    MetroStation duplicatedPath[SIZE] = {"\0"};
    duplicatePath(duplicatedPath, partialPath);
    // adding all the stations which we passed to the duplicatedPath.
    addStartStation(start, duplicatedPath);

    // Base case 2: If the current start station is same with finish, that means we found a path from start to finish and return immediately.
    if (equals(start, finish)) {
        updateBestPath(bestPath, duplicatedPath);
        return;
    }
    // Getting the neighbours using the start station.
    MetroStation neighbors[SIZE] = {"\0"};
    getNeighboringStations(istanbul, start, neighbors);


    // Calling all neighbours of start stations using recursive  one by one.
    int index;

    for (index = 0; index < getstationslength(neighbors); index++) {
        recursiveFindPath(neighbors[index], finish, duplicatedPath, bestPath);


    }
}

// this function will be used to save the shortest path at each calling and set the best path to the currentPath when it's founded.
void updateBestPath(MetroStation bestPath[], MetroStation currentPath[]) {
    if (getDistanceTravelled(bestPath) == 0 || (getDistanceTravelled(currentPath) < getDistanceTravelled(bestPath))) {
        duplicatePath(bestPath, currentPath);

    }
}






















