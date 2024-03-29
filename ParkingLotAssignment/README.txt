This program works by simulating how long each car stays in the lot and simulating
a number of days. These are changed by the input file, as well as the seed used
for the random number generation deciding whether a car arrives or leaves. 

The parking lot is assumed to have only 1 entrance gate and 1 exit gate.

/*******************************INPUT FILES***********************************/
Each of the input files has 3 integer values, in this format:

HOURS_IN_LOT SIMULATION_DAYS SEED

HOURS_IN_LOT determines how many hours, for the sake of the simulation, that
each car will stay in the lot. Setting this to 0 will cause the simulation to
simulate real-time; since the simulation is done instantly, the money generated
will be $0.00. Cars are allowed to stay as long as they want, there is no upper
limit. Minimum value: 0

SIMULATION_DAYS determines how many "days" the simulation will run through. For
the sake of the simulation, each "day" is 50,000 iterations of a loop with a 
1/3 chance to add a car and a 2/3 chance to remove a car. At the end of each
"day", the program will output the total of all the charges on the cars in 
the lot as well as the total amount of money the lot has made thus far.
Minimum value: 1

SEED simply sets the seed of the random number generator that determines the
chance to add or remove a car from the lot as well as the generator that determines
the behavior of the Group class. This input is optional, leave blank or set it 
to 0 for a random seed.

The program will go through each test file every time it is run, so the test
files may be changed without altering any code. The code assumes that the test
files are in the base ParkingLotAssgnmnt directory. If the test file is invalid,
the program will notify the user of the issue and continue to the other test files.

/***********************************CARS**************************************/
A car is randomly assigned a preference on where they want to park. If the
preferred location is full, they will be assigned a new location in depreciating
order. If the location is Standard; however, the new location will be assigned
in appreciating order. Cars can ask for the prices of the group, and the result
will be printed to the standard output.

/*********************************LOCATIONS***********************************/
The locations and their order are as follows:

VIP - Garage - Covered - Close - Standard

All VIP locations are in a Garage, all Garage locations are Covered, and
all Covered locations are Close to the entrance. However, there exist Close
locations that are NOT Covered, Covered locations that are NOT in a Garage, and
so on. There also exist Standard locations that are none of the above.

/*******************************TICKET PRICING*******************************/
The pricing of the ticket is determined by the parking location. For each
type of location, an extra charge is added to the ticket: $0.50 for Covered, 
$0.15 for Close, $0.25 for Garage, and $5.00 for VIP. Since VIP is also Garage,
Covered, and Close, it functionally adds $5.90 for VIP locations and so on. 
The base price of the ticket is $1.50, and Standard locations incurr no extra 
charge. This charge is HOURLY; however, partial hours are still charged for
i.e staying 30 minutes at $6.00 an hour would charge $3.00.

Groups can change these prices; however, they will only vary by $0.05 as groups
must be competitive with other groups. These new assignments are random, and each
price is changed by the same amount from the standard. 

A discount may also be applied to the prices, but it is possible that a Group
does not have any discounts.
/***********************************GROUPS*************************************/
A Group, by random generation, has between 1-3 lots and will set a price within
$0.05 of the original prices for each parking type. Groups decide which lot a 
car is sent to when it arrives (it will always choose the lot with the lowest
number of cars currently in it). Groups also set discounts to their prices. All
parking lots within the Group follow the prices set by the Group. Parking Lots
control how many of each parking type and total capacity they have.