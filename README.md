### An internal system for a veterinary clinic

## Features
- Control of clients and their animals;
- Control of veterinarians appointment schedule;
- Register of provided services;

## General Schema

The application was made with the Spring Boot framework for handling MVC relations, PostgreSQL as the database and Apache Tomcat as a servlet container.
The general view is as follows:

![image](https://user-images.githubusercontent.com/51497214/119031149-22298c00-b981-11eb-840a-bd02bba43c82.png)



## Models relations

This is a simpler version of the entity relationship diagram without the join tables:

![image](https://user-images.githubusercontent.com/51497214/118873380-14600200-b8c0-11eb-82f1-3a4ed1862693.png)



## Appointments

To schedule an appointment, first a client and the animal are selected
![image](https://user-images.githubusercontent.com/51497214/119044584-c36c0e80-b990-11eb-8c8f-9e54e99fc23c.png)


Then a veterinarian is selected baset on the speciality
![image](https://user-images.githubusercontent.com/51497214/119044422-8a339e80-b990-11eb-8f49-ae00557bb118.png)


And finally a date is chosen
![image](https://user-images.githubusercontent.com/51497214/119044487-a20b2280-b990-11eb-97cc-53e626ea14ac.png)



## Registering a service

After the treatment the service must be registered
![image](https://user-images.githubusercontent.com/51497214/119044951-370e1b80-b991-11eb-8ca5-f0a83547d7a1.png)


The information about medicines prescribed and exams can be added to the register
![image](https://user-images.githubusercontent.com/51497214/119045087-62910600-b991-11eb-858f-687a747bbddb.png)



## Database

On the db is stored information about clients and their animals, veterinarians, appointments, services provided, medicines and exams.
![image](https://user-images.githubusercontent.com/51497214/119045299-a552de00-b991-11eb-912f-60d8182eb396.png)

The application also provides CRUD for the above
![image](https://user-images.githubusercontent.com/51497214/119045387-c74c6080-b991-11eb-8193-7706cc8d7580.png)
