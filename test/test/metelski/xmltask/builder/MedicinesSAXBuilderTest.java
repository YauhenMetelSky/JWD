package test.metelski.xmltask.builder;

import by.metelski.xmltask.builder.MedicinesSAXBuilder;
import by.metelski.xmltask.entity.Medicine;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class MedicinesSAXBuilderTest extends Assert {
    private MedicinesSAXBuilder medicinesSAXBuilder;
    Set<Medicine> actualResult;
    Set<Medicine> expectedResult;

    @BeforeTest
    public void setUp() {
        expectedResult=new HashSet<>();
        medicinesSAXBuilder = new MedicinesSAXBuilder();
        Medicine flemoklav = new Medicine();
        flemoklav.setGroup("antibiotics");
        flemoklav.setId("M-0123");
        flemoklav.setName("Флемоклав");
        flemoklav.setPharm("Astellas Pharma");
        flemoklav.getVersion().setManufacturer("Astellas Pharma Europe");
        flemoklav.getVersion().getCertificate().setNumber("a-32214");
        flemoklav.getVersion().getCertificate().setDateOfIssue("2021-01-30");
        flemoklav.getVersion().getCertificate().setExpiryDate("2025-01-30");
        flemoklav.getVersion().getCertificate().setRegistrationOrganisation("Minzdrav RB");
        flemoklav.getVersion().getMedicinePackage().setPackageType("blister");
        flemoklav.getVersion().getMedicinePackage().setAmountInPackage(10);
        flemoklav.getVersion().getMedicinePackage().setPrice(100);
        flemoklav.getVersion().getDosage().setFrequencyOfMedication("by doctor's prescription");
        flemoklav.addAnalog("Амоксиклав");
        flemoklav.addAnalog("Хиконцил");
        flemoklav.addAnalog("Амоклав");
        flemoklav.getVersions().add(flemoklav.getVersion());
        expectedResult.add(flemoklav);

    }

    @AfterTest
    public void tearDown() {
        medicinesSAXBuilder = null;
        actualResult = null;

    }

    @Test
    public void testGetMedicines() {
        medicinesSAXBuilder.buildSetMedicines("testdata/testmed.xml");
        actualResult = medicinesSAXBuilder.getMedicines();
        assertEquals(actualResult, expectedResult);
    }
}
