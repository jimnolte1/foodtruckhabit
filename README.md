# foodtruckhabit
Repository for challenge assignment

Please read Foodtruck Challenge.pdf for a description of the challenge.

To get started, clone this repository at https://github.com/jimnolte1/foodtruckhabit.git.

This challenge assignment uses Project Lombok. After cloning and pulling it into 
your favorite IDE, you'll need to install the Lombok plug-in and enable annotation 
processing.  Also, depending on your IDE, you'll need to set the project JDK version 
to 11. I used IntelliJ IDEA. If you're doing this from the command line, set JAVA_HOME 
accordingly.

This repo uses Maven as a build tool, so you'll need that installed to resolve 
and download all dependent distributions. Run <code>mvn clean install</code>before 
going any further. You will see three passing tests. See the code comments for 
thoughts on further testing.  

All the versions of dependencies are defined as properties near the top of the POM, 
so if you have other non-conflicting versions that you'd like to use, you can just 
update the versions there. Some of these dependencies are admittedly old.

To run it, just create simple JAVA application run configuration for <code>FoodTruckHabitApp</code> 
and kick it off. No environment variables or program arguments are needed.

This app exposes two end-points: 

<code>GET /foodtrucks</code>

Returns a JSON list of all food trucks that have a status of ISSUED OR APPROVED. The 
thinking is that the requestor isn't interested in food trucks that are not serving 
food yet. No provisions are made for expiration of permit, etc. You can use curl to 
access this end-point using the following command:

<code>$ curl -X GET curl -X GET http://localhost:8080/foodtrucks</code>


<code>GET /foodtrucks/{foodItem}</code>

Returns a JSON list of all food trucks that have a status of ISSUED OR APPROVED and 
serve the<code>foodItem</code>. Items with multiple words are supported, but in a 
very rudimentary way (the food items for the truck's permit must contain the entire 
<code>foodItem</code>, irrespective of case).You can use curl to access this end-point 
to find all food trucks that serve burritos using the following command:

<code>$ curl -X GET curl -X GET http://localhost:8080/foodtrucks/burrito</code>

