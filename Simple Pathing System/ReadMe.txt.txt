Path is a simple test of how to go about creating a system that can take two points and generate path between them

//Initialize the Path
for (int i = 1; i < wayPoints; i++){
	path[i][0] = path[i-1][0] + xMarker;
	path[i][1] = path[i-1][1] + yMarker;
}