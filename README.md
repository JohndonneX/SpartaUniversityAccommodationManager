# Sparta University  Accommodation Manager
A full stack web application handling the logistics of a university halls of residence. 

---------------------------------------------------------
# Types of users
- Public (Default)
- Resident (Account) 
- Admin (Account) 

# Database

## Occupancy Table
- room_id PK
- room_type_id 
- current_occupants int 
- floor_no

## Occupancy Type
- room_type_id PK
- no_of_bedrooms
- description

## Resident Table
- resident_id PK
- first_name
- last_name
- email
- contact_no
- room_id
- role

## Admin Table
- admin_id PK
- first_name
- last_name
- email
- contact_no
- profile_image
- role

## Resident Notice Table
- resident_post_id PK
- resident_id
- date_time_posted
- title
- content

## Admin Notice Table
- admin_post_id PK
- date_posted 
- title
- content

## Inquiry Table
- inquiry_id
- email
- contact_no
- content
- status

## Issue Table
- issue_id
- date_posted
- title
- content
- status
- date_resolved

## Delivery Table
- delivery_id PK
- resident_id
- date_of_arrival
- description

## Booking Table
- booking_id PK
- recreational_room_id
- start_date_time
- end_date_time
- status

## Recreational Room Type
- recreational_room_id
- description

# Sections

# Public

## Login (Public)
- Username/Password

## Contact Us (Public)
- Make inquiry

## Room View (Public)
- Room information

# Resident

## Resident Notice Board (Resident)
- Create Post 
- Mods can delete

## Admin Contact
- A page that will display the names and photos of the management team and staff, their roles and contact details - maintained by admin but visible in the residents area.

## Regulations and Rules
- The regulations and rules for living in the Hall of Residence, again maintained by admin.

## Booking Recreational Rooms
- Make booking

# Admin

## Resident Management
- Creation and maintenance of resident records.
### Admin Contact Management
### Regulations and Rules Management

## Occupancy Management
- Creation and maintenance of Occupancy records.

## Recreational Management
- See bookings, approve/decline

## Maintenance Management
- Management of the maintenance tasks outstanding.

## Public Inquiry Management
- See inquiries, mark status

## Deliveries
- Recording and advising residents of deliveries made and held in reception.

## Admin Notice Board
- A noticeboard facility to keep residents abreast of important upcoming events or ongoing maintenance issues. The update of this will be the responsibility of the administrators but the content will be made available to residents.




## Admin Notice Board (Resident)
- Create Post (Text, Post Creator Info) (See Admin Control Panel)

## Admin Control Panel (Admin)
- Resident Room Allocation
- See/remove issues
- See/remove inquiries
- Manage Resident Accounts (Add/Remove/Update)
- Create Post on Admin Notice Board








-----------------------------------------------------------

Number of halls 
Number of rooms
Flatlets
Rooms and room types
Occupied or not
Students 
Public site - go online and apply for room or more info (accessible to all)
Form for room enquiry
Admin - adding or deleting students
Notice board - what is happening, events, maintenance, problems
Student area - for residents - specific noticeboard and blog
Send in job requests
Delivery noticeboard 
Students see admin ntoicebaords 

Day to day running online- web based application for the use of the public and potential students
See what accommodation is available - can send in an enquiry form

-Admin only area
-for office staff
-manage which student are in which room
-repairs
-update and delete tenants etc

Rooms:
- Different types of rooms available

Communication:
- Through noticeboard that can be read by residents and admin : only admin can add to it (official noticeboard)

Entry to website is for username and password for residents and admin

Student can view noticeboards
Can send in jobs request form 
Will have the down blog/noticeboard to communicate with each other selling/event etc. 
