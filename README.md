<h1>D287 – JAVA FRAMEWORKS</h1>

<section>
<h2>Task C:</h2>
<strong>Customize the HTML user interface for your customer’s application.<br>
The user interface should include the shop name, the product names, and the names of the parts.</strong><br><br>
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
<strong>Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.</strong><br><br>
I created an "about" page and made more edits in mainscreen.html.

        About.html: "Our Story" section was added.

        About.html: "Out Mission" section was added.

        About.html: "Navigation" list was made with links to the main page
<section/>

I added links to and from mainscreen.html and about.html plus controllers.

        mainscreen.html Line 16: Added a link anchor for the about page
        After: <a th:href="@{/about}" class="btn btn-primary btn-sm mb-3">About Us</a>

        about.html Line 32:
        After: <a th:href="@{/mainscreen}" class="btn btn-primary btn-sm mb-3">Return to main page</a>

<section>
<h2>Task E:</h2>
<strong> Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.
</strong><br><br>
I added 5 initial parts and products in BootStrapData starting at <strong>line 43<strong>

        if(partRepository.count() == 0 && productRepository.count() == 0){
                OutsourcedPart powerCord= new OutsourcedPart();
                powerCord.setCompanyName("Hong Kong Electronics");
                powerCord.setName("Power Cord");
                powerCord.setInv(5);
                powerCord.setPrice(2.99);
                powerCord.setId(100L);
                outsourcedPartRepository.save(powerCord);
    
                InhousePart blackFilament = new InhousePart();
                blackFilament.setName("Black Filament (50ft)");
                blackFilament.setInv(5);
                blackFilament.setPrice(24.99);
                blackFilament.setId(100L);
                partRepository.save(blackFilament);
    
                InhousePart whiteFilament = new InhousePart();
                whiteFilament.setName("White Filament (50ft)");
                whiteFilament.setInv(5);
                whiteFilament.setPrice(24.99);
                whiteFilament.setId(100L);
                partRepository.save(whiteFilament);
    
                OutsourcedPart memoryCard= new OutsourcedPart();
                memoryCard.setCompanyName("MemoryPlus");
                memoryCard.setName("Memory card (60GB");
                memoryCard.setInv(5);
                memoryCard.setPrice(34.99);
                memoryCard.setId(100L);
                outsourcedPartRepository.save(memoryCard);
    
                OutsourcedPart printingBase = new OutsourcedPart();
                printingBase.setCompanyName("Printers Outlet");
                printingBase.setName("Printing base");
                printingBase.setInv(5);
                printingBase.setPrice(3.99);
                printingBase.setId(100L);
                outsourcedPartRepository.save(printingBase);
</section>

<section>
<h2>Task F:</h2>
<strong>Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:<br>
•  The “Buy Now” button must be next to the buttons that update and delete products.<br>
•  The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.<br>
•  Display a message that indicates the success or failure of a purchase.
</strong><br><br>
</section>