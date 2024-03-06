# Implementation

Please use this space to provide the pseudocode that you wrote before writing your code.

Pseudocode: 

boolean startSolver(maze m) {
    int currentLocation = startLocation
    return recursiveSolver(currentLocation, maze m)
}

boolean recursiveSolver(currentLocation, maze m) {
    IF(currentLocation is finished location) {
        RETURN True; 
    }
    ELSE if(m.getContent(currentlocation row, currentlocation column) is a wall or visited) {
        RETURN False; 
    }
    ELSE {
        boolean getToFinish = recursiveSolver(neighbor(north), m) || recursiveSolver(neighbor(south), m) || recursiveSolver(neighbor(west), m) || recursiveSolver(neighbor(east), m);

        IF(getToFinish is false) {
            set currentlocation to dead end
        }
        return getToFinish; 
    }
}


