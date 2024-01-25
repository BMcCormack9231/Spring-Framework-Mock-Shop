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
I added 5 initial parts and products in BootStrapData starting at <strong>line 43</strong>

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
I added a buy button for each row in the Printer Kits table<br>
<strong>mainscreen.html line 88:</strong>

    <a th:href="@{/buyProduct(productID=${tempProduct.id})}" class="btn btn-primary btn-sm mb-3">Buy Now</a>

I made HTML pages for confirmation and errors for buy requests

    confirmationbuyproduct.html
    errorbuyproduct.html

A controller was needed for the "Buy Now" so I made a new class for clarity<br>
<strong>BuyProductController</strong>
    
    @GetMapping("/buyProduct")
    public String buyProduct(@RequestParam("productID") int theID, Model theModel){
        Optional<Product> productOptional = productRepository.findById((long)theID);

        if(productOptional.isPresent()){
            Product product = productOptional.get();
            product.setInv(product.getInv() - 1);
            productRepository.save(product);

            theModel.addAttribute("product", product);

            return "confirmationbuyproduct";
        }
        else
            return "errorbuyproduct";
    }

</section>
<section>
<h2>Task G:</h2>

Modify the parts to track maximum and minimum inventory by doing the following:<br>
•  Add additional fields to the part entity for maximum and minimum inventory.<br>
•  Modify the sample inventory to include the maximum and minimum fields.<br>
•  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.<br>
•  Rename the file the persistent storage is saved to.<br>
•  Modify the code to enforce that the inventory is between or at the minimum and maximum value.<br>


In the Part class I added variables for maximum and minimum inventory and made getters setters and a constructor.<br>
<strong>Part.java Line 32:</strong>
    
    @Min(value = 0, message = "Minimum value must be positive")
    int minInv;

    @Min(value = 0,message = "Maximum value must be positive")
    int maxInv;

I renamed the database by changing the number from 101 to 200 so the initial data could be re-populated with the new fields.<br>
<strong>application.properties Line 6:</strong>
    
    spring.datasource.url=jdbc:h2:file:~/spring-boot-h2-db200

Both InhousePartForm and OutsourcedPartForm had these input boxes added to the form section:<br>
<strong>InhousePartForm Line 27 + OutsourcedPartForm Line 30:</strong>

    <label for = "minInvField">Minimum Inventory</label>
    <p><input type="text" id = "minInvField" th:field="*{minInv}" placeholder="Minimum Inventory Count" class="form-control mb-4 col-4"/></p>

    <label for = "maxInvField">Maximum Inventory</label>
    <p><input type="text" id = "maxInvField" th:field="*{maxInv}" placeholder= "Maximum Inventory count" class="form-control mb-4 col-4"/></p>

I added a method to the part class to verify inventory range<br>
<strong>Part.java Line 69:</strong>

        public boolean isValidInv(){
        return inv >= minInv && inv <= maxInv;
    }

Both controllers for InhousePart and OutsourcedPart were updated with logic to display an error message when outside the min/max range<br>
<strong>AddInhousePartController Line 45 + AddOutsourcedPartController Line 46:</strong>

    if(!part.isValidInv()){
            theBindingResult.rejectValue("inv", "invalid.inventory", "Invalid inventory: value must be between minimum and maximum");
            return "InhousePartForm";
        }
</section>
<section>
<h2>Task H:</h2>
<strong>H.  Add validation for between or at the maximum and minimum fields. The validation must include the following:<br>
•  Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.<br>
•  Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.<br>
•  Display error messages when adding and updating parts if the inventory is greater than the maximum.<br>
</strong>

I decided to remove the isValid method from Part.java and instead use if / else logic to display specific error messages for low and high inventory errors
<strong>AddInhousePartController Line 45 + AddOutsourcedPartController Line 46:</strong>

    else if(part.getInv() < part.getMinInv()){
        bindingResult.rejectValue("inv", "invalid.inventory", "Invalid inventory: value is below minimum allowance");
        return "OutsourcedPartForm";
    }
    else if(part.getInv() > part.getMaxInv()){
        bindingResult.rejectValue("inv", "invalid.inventory", "Invalid inventory: value is above maximum allowance");
        return "OutsourcedPartForm";
    }

I added an if statement to EnufPartsValidator that checks if the associating a part with a product would bring the available inventory of the part below the minimum allowance. 

    if(p.getMinInv() > (p.getInv() - (product.getInv()) - myProduct.getInv())) return false;


</section>
<section>
<h2>Task I:</h2>
<strong>Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.</strong>

I added unit tests for the getters and setters of minInv and maxInv fields of the Part class.
<strong>PartTest.Java Line 130:</strong>

    @Test
    void setMaximumInv() {
        int maximumInv = 99999;
        partIn.setMaxInv(maximumInv);
        assertEquals(maximumInv,partIn.getMaxInv());
        partOut.setMaxInv(maximumInv);
        assertEquals(maximumInv,partOut.getMaxInv());
    }

    @Test
    void setMinimumInv() {
        int minimumInv = 0;
        partIn.setMinInv(minimumInv);
        assertEquals(minimumInv,partIn.getMinInv());
        partOut.setMinInv(minimumInv);
        assertEquals(minimumInv,partOut.getMinInv());
    }
</section>