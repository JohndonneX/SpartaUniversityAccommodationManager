# Sparta University  Accommodation Manager
A full stack web application handling the logistics of a university halls of residence. 

---------------------------------------------------------
# Types of users
- Public (Default)
- Resident (Account) (First Name, Last Name, Email, Contact Number, DOB, Accommodation ID?)
- Admin (Account) (First Name, Last Name, Email, Contact Number, Role)

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
- date_posted
- title
- content

## Admin Notice Table
- admin_post_id PK
- date_posted 
- title
- content

## Inquiry Table
- inquiry_id
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


# Sections

# Public

## Login (Public)
- Username/Password

## Contact Us (Public)

## Room View (Public)
- Room Type
- Make inquiry 

# Resident

## Resident Notice Board (Resident)
- Create Post (Text, Contact Details?, Post Creator Info) (See Resident Control Panel)
- Delete/Modify Post?


## Resident Control Panel
- Create Post on Resident Notice Board
- Edit Account Details?

# Admin

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
