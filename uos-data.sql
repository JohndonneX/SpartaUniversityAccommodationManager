USE uos_manager;

SELECT * FROM resident;

INSERT INTO occupancy_type VALUES (1, 1, "Studio Flatlets", ": Floors 11 to 20 will be given over to single occupancy studio flats. Each floor will house 15 of these flats along with a communal kitchen that will include a seating area."),
	(2, 1, "Self Contained Flatlets One Bedroom", "Floors 1 to 10 will contain flats. Each floor will consist of 5 one bedroom flats, 2 x two bedroom flats and one 3 bedroom flat. All flats will be self contained units with kitchens included.

The first floor will be for the exclusive use of those students with young children."),
    (3, 2, "Self Contained Flatlets Two Bedrooms", "Floors 1 to 10 will contain flats. Each floor will consist of 5 one bedroom flats, 2 x two bedroom flats and one 3 bedroom flat. All flats will be self contained units with kitchens included.

The first floor will be for the exclusive use of those students with young children."),
    (4, 3, "Self Contained Flatlets Three Bedrooms", "Floors 1 to 10 will contain flats. Each floor will consist of 5 one bedroom flats, 2 x two bedroom flats and one 3 bedroom flat. All flats will be self contained units with kitchens included.

The first floor will be for the exclusive use of those students with young children.");
    

INSERT INTO occupancy VALUES (1, 1, 0, 11),
	(2, 2, 0, 2),
    (3, 3, 0, 2),
    (4, 4, 0, 2);

    
INSERT INTO resident VALUES (1, "Michael", "Camacho", "michaelcamacho@hotmail.com", "+44 123456789", 1, "Moderator"),
	(2, "David", "Trieu", "davidtrieu@gmail.com", "+44 234567891", 2, "Resident"),
    (3, "Tasnia", "Khan", "tasniakhan@gmail.com", "+44 345678912", 3, "Resident");


INSERT INTO admin VALUES (1, "Bill", "Gates", "billgates@microsoft.com", "+44 11111111", "billgates.png", "Senior Manager"),
	(2, "Jeff", "Bezos", "jeffbezos@amazon.com", "+44 222222222", "jeffbezos.png", "Executive Manager");
    

INSERT INTO login VALUES (1, "billgates@microsoft.com", "abcdef", NULL, 1),
	(2, "jeffbezos@amazon.com", "abcdef", NULL, 2),
    (3, "michaelcamacho@hotmail.com", "abcdef", 1, NULL),
    (4, "davidtrieu@gmail.com", "abcdef", 2, NULL),
    (5, "tasniakhan@gmail.com", "abcdef", 3, NULL);


INSERT INTO resident_notice VALUES (1, 1, "2020/09/29", "Welcome to Sparta University!", "I would like to extend a warm welcome to all new students!");


INSERT INTO admin_notice VALUES (1, 1, "2020/09/28", "System Check", "Performing System check to ensure process runs smoothly");


INSERT INTO enquiry VALUES (1, "2020/09/29", "newstudent@gmail.com", "+44 333333333", "Could I join the University accomodation?", "In Progress"),
	(2, "2020/09/29", "newstudent2@gmail.com", "+44 444444444", "Could I join the University accomodation?", "In Progress"),
    (3, "2020/09/29", "newstudent3@gmail.com", "+44 555555555", "Could I join the University accomodation?", "In Progress");


INSERT INTO issue VALUES (1, "2020/09/28", "Door Hinge Broken", "Fixing door hinge on floor 2 at main entrance", "Completed", "2020/09/28"),
	(2, "2020/09/27", "Window Issue", "Window lock is broken", "Pending", NULL);


INSERT INTO delivery VALUES (1, 1, "2020/09/28", "Small Amazon package waiting at reception", "Awaiting Collection"),
	(2, 1, "2020/09/28", "Medium size Fed-Ex package", "Awaiting Collection");


INSERT INTO recreational_room_type VALUES (1, "Pool Table Game Room", "Contains a pool table and TV with a floor space of 10m x 10m"),
	(2, "TV Lounge Room", "3 TV devices are mounted across the main wall, with audio sync available for each TV");


INSERT INTO booking VALUES (1, 1, 1, "2020/09/28", "2020/09/29", "Approved"),
	(2, 2, 1, "2020/09/28T12:00", "2020/09/28T13:00", "Pending");
    


    

