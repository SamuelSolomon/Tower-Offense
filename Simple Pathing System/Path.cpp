#include <iostream>
#include <fstream>

using namespace std;

int main(int argc, char *argv[]) {
	char response;
	double x1;
	double y1;
	double x2;
	double y2;
	int wayPoints;
	
	while (response != 'N'){
		cout << "Would you like to enter a path? Y/N : ";
		cin >> response;
		if (response == 'Y'){
			cout << "Enter the coordinates for x1 first, then y1, x2, and y2" << endl;
			cin >> x1;
			cin >> y1;
			cin >> x2;
			cin >> y2;
			cout << "Enter the # of waypoints : ";
			cin >> wayPoints;
			
			//Declare the Path 
			double path[wayPoints+1][2];
			
			//Initialize start coordinates
			path[0][0] = x1;
			path[0][1] = y1;
			//Initialize end coordinates
			path[wayPoints][0] = x2;
			path[wayPoints][1] = y2;
			
			//waypoint marker variables
			double xMarker = (x2 - x1) / wayPoints;
			double yMarker = (y2 - y1) / wayPoints;
			
			//Initialize the Path
			for (int i = 1; i < wayPoints; i++){
				path[i][0] = path[i-1][0] + xMarker;
				path[i][1] = path[i-1][1] + yMarker;
			}
			
			//Print the coordinates to a file
			cout << "What would you like to name your file?" << endl;
			string fileName;
			cin >> fileName;
			
			ofstream outPath;
			outPath.open(fileName+".txt");
			for (int i = 0; i <= wayPoints; i++){
				outPath << "(" << path[i][0] << "," << path[i][1] << ")" << endl;
			}
		}
	}
}