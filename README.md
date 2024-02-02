<h1>Spring Framework "Mock Shop"</h1>

<section>
This is an academic project that built using Spring Framework. The objective is to demonstrate understanding of MVC 
Architecture by designing logic for models, controllers, and views to create a full stack web application. The app is 
a mock 3D Printer shop database that contains entries for parts and kits that can be added, edited and decremented
in the view. Parts can be associated with views, and validation ensures that inventory is managed by disallowing parts
to be associated with a type of kit if the kit count is higher than the minimum threshold of the part inventory.
</section>

<h2>To Run:</h2>
<ul>
<li>Clone the repository and run it in an IDE.</li>
<li>The recommended IDE is IntelliJ Ultimate as it provides excellent support for Spring</li>
<li>An alternative is Spring Tool Suite which can be downloaded for free at this URL: https://spring.io/guides/gs/sts/</li>
<li>Spring will download necessary dependencies automatically but may need to be granted permission from firewall</li>
<li>Run the application either using the master run button or by running the method in DemoApplication.java</li>
<li>Visit localhost:8080 in your local browser to display the home page of the view (mainscreen.html)</li>
</ul>