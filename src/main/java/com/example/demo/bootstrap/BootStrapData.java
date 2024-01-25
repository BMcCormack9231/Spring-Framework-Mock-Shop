package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if(partRepository.count() == 0 && productRepository.count() == 0) {


            OutsourcedPart powerCord = new OutsourcedPart();
            powerCord.setCompanyName("Hong Kong Electronics");
            powerCord.setName("Power Cord");
            powerCord.setInv(550);
            powerCord.setPrice(2.99);
            powerCord.setId(100L);
            powerCord.setMinInv(500);
            powerCord.setMaxInv(1000);
            outsourcedPartRepository.save(powerCord);

            InhousePart blackFilament = new InhousePart();
            blackFilament.setName("Black Filament (50ft)");
            blackFilament.setInv(150);
            blackFilament.setPrice(24.99);
            blackFilament.setId(101L);
            blackFilament.setMinInv(100);
            blackFilament.setMaxInv(250);
            partRepository.save(blackFilament);

            InhousePart whiteFilament = new InhousePart();
            whiteFilament.setName("White Filament (50ft)");
            whiteFilament.setInv(150);
            whiteFilament.setPrice(24.99);
            whiteFilament.setId(102L);
            whiteFilament.setMinInv(100);
            whiteFilament.setMaxInv(250);
            partRepository.save(whiteFilament);

            OutsourcedPart memoryCard = new OutsourcedPart();
            memoryCard.setCompanyName("MemoryPlus");
            memoryCard.setName("Memory card (60GB)");
            memoryCard.setInv(250);
            memoryCard.setPrice(34.99);
            memoryCard.setId(103L);
            memoryCard.setMinInv(200);
            memoryCard.setMaxInv(350);
            outsourcedPartRepository.save(memoryCard);

            OutsourcedPart printingBase = new OutsourcedPart();
            printingBase.setCompanyName("Printers Outlet");
            printingBase.setName("Printing base");
            printingBase.setInv(500);
            printingBase.setPrice(3.99);
            printingBase.setId(104L);
            printingBase.setMinInv(450);
            printingBase.setMaxInv(650);
            outsourcedPartRepository.save(printingBase);



       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
            List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                System.out.println(part.getName() + " " + part.getCompanyName());
            }

            Product beginners = new Product("Beginner's Bargain Printer", 299.99, 5);
            Product DIY = new Product("DIY Deluxe Printer", 450.00, 3);
            Product weekend = new Product("Weekend Warrior Printer", 350.00, 4);
            Product designer = new Product("Designer's Deluxe Printer", 600.00, 4);
            Product commercial = new Product("Commercial Creations Printer", 999.99, 2);
            productRepository.save(beginners);
            productRepository.save(DIY);
            productRepository.save(weekend);
            productRepository.save(designer);
            productRepository.save(commercial);
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products: "+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts: "+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
