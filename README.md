<h1>D287 – JAVA FRAMEWORKS</h1>

<h2>Task C:</h2>
<strong>Customize the HTML user interface for your customer’s application.<br>
The user interface should include the shop name, the product names, and the names of the parts.</strong>

<section>
    <h3>01/11/2024</h3>
    I edited headings in mainscreen.html to represent a 3D printer shop selling parts and supplies.

        mainscreen.html Line 19: "Shop" was changed to "3D Printer Shop".
        Before:     <h1>Parts</h1>
        After:      <h1>3D Printer Shop</h1>

        mainscreen.html Line 21: "Parts" was changed to "Printer Parts".
        Before:     <h2>Parts</h2>
        After:      <h2>Printer Parts</h2>

        mainscreen.html Line 53: "Products" was changed to "Printer Kits".
        Before:     <h2>Products</h2>
        After:      <h2>Printer Kits</h2>

        mainscreen.html Line 14: "My Store" was changed to "3D Printer Shop".
        Before:        <title>My Store
        After:         <title>3D Printer Shop
</section>

<section>
<h2>Task D:</h2>
<strong>Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.</strong>
    <h3>01/13/2024</h3>
    I created an "about" page and made more edits in mainscreen.html.

        About.html: "Our Story" section was added.

        About.html: "Out Mission" section was added.

        About.html: "Navigation" list was made with links to the main page
<section/>

<section>
    <h3>01/17/2024</h3>
    I added links to and from mainscreen.html and about.html plus controllers.

        mainscreen.html Line 16: Added a link anchor for the about page
        After: <a th:href="@{/about}" class="btn btn-primary btn-sm mb-3">About Us</a>

        about.html Line 32:
        After: <a th:href="@{/mainscreen}" class="btn btn-primary btn-sm mb-3">Return to main page</a>
</section>