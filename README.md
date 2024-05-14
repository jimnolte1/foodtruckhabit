# foodtruckhabit
Repository for challenge assignment

To get started, clone this repository at https://github.com/jimnolte1/foodtruckhabit.git.

This challenge assignment uses Project Lombok. After cloning and pulling it into 
your favorite IDE, you'll need to install the Lombok plug-in and enable annotation 
processing.

This repo uses Maven as a build tool, so you'll need that installed to resolve 
and download all dependent distributions. See the POM for JAVA compilker version, 
etc. Run <code>mvn clean install</code>before going any further. You will see three passing tests. 
See the code comments for thoughts on further testing. The setup was tested with 
a fresh clone and a fresh <code>.m2</code> directory.

One other essential thing to consider for production-readiness is observability. Adding a 
dependency to <code>spring-boot-starter-actuator</code> would privide a set of pre-built 
end-points for providing the requirement. Given the time budget, not a concern for this challenge,
but it needs to be considered for any production system.

All the versions of dependencies are defined as properties near the top of the POM, so if 
you have other non-conflicting versions that you'd like to use, you can just update the versions
there.

To run it, just create a simple JAVA application run configuration for <code>FoodTruckHabitApp</code> and kick 
it off. No environment variables or program arguments are needed.

This app exposes two end-points: 

<code>GET /foodtruckhabit</code>

Returns a JSON list of all foodtrucks that have a status of ISSUED or APPROVED. The thinking is
that the requestor isn't interested in food trucks that are not serving food yet. No provisions
are made for expiration of permit, etc.

<code>GET /foodtruckhabit/{foodItem}</code>

Returns a JSON list of all foodtrucks that have a status of ISSUED or APPROVED and serve the<code>foodItem</code>.
Items with multiple words are supported, but in a very rudimentary way (the food items for the truck's permit must
contain the entire <code>foodItem</code>, irrespective of case).
