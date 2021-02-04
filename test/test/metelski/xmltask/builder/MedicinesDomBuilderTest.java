package test.metelski.xmltask.builder;

import by.metelski.xmltask.builder.MedicinesDomBuilder;
import by.metelski.xmltask.entity.Medicine;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class MedicinesDomBuilderTest extends Assert {
    private MedicinesDomBuilder medicinesDomBuilder;
    Set<Medicine> actualResult;
    Set<Medicine> expectedResult;

    @BeforeTest
    public void setUp() {
        expectedResult = new HashSet<>();
        medicinesDomBuilder = new MedicinesDomBuilder();
        Medicine flemoklav = new Medicine();
        Medicine.Version version = flemoklav.new Version();
        flemoklav.setGroup("antibiotics");
        flemoklav.setId("M-0123");
        flemoklav.setName("Флемоклав");
        flemoklav.setPharm("Astellas Pharma");
        version.setManufacturer("Astellas Pharma Europe");
        Medicine.Certificate certificate = version.getCertificate();
        certificate.setNumber("a-32214");
        certificate.setDateOfIssue("2021-01-30");
        certificate.setExpiryDate("2025-01-30");
        certificate.setRegistrationOrganisation("Minzdrav RB");
        Medicine.MedicinePackage medicinePackage = version.getMedicinePackage();
        medicinePackage.setPackageType("blister");
        medicinePackage.setAmountInPackage(10);
        medicinePackage.setPrice(100);
        Medicine.Dosage dosage = version.getDosage();
        dosage.setFrequencyOfMedication("by doctor's prescription");
        dosage.setDose(500);
        flemoklav.addAnalog("Амоксиклав");
        flemoklav.addAnalog("Хиконцил");
        flemoklav.addAnalog("Амоклав");
        flemoklav.addVersion(version);
        expectedResult.add(flemoklav);

        Medicine amoksiklav = new Medicine();
        Medicine.Version amoksiklavVersionOne = amoksiklav.new Version();
        amoksiklav.setGroup("antibiotics");
        amoksiklav.setId("M-0124");
        amoksiklav.setName("Амоксиклав");
        amoksiklav.setPharm("Sandoz");
        amoksiklavVersionOne.setManufacturer("Lekk d.d.");
        Medicine.Certificate certificate1 = amoksiklavVersionOne.getCertificate();
        certificate1.setNumber("a-322414");
        certificate1.setDateOfIssue("2020-12-14");
        certificate1.setExpiryDate("2024-12-14");
        certificate1.setRegistrationOrganisation("Minzdrav RB");
        Medicine.MedicinePackage medicinePackage1 = amoksiklavVersionOne.getMedicinePackage();
        medicinePackage1.setPackageType("blister");
        medicinePackage1.setAmountInPackage(20);
        medicinePackage1.setPrice(30);
        amoksiklavVersionOne.getDosage().setDose(875);
        amoksiklavVersionOne.getDosage().setFrequencyOfMedication("");
        amoksiklav.addAnalog("Флемоклав");
        amoksiklav.addAnalog("Хиконцил");
        amoksiklav.addAnalog("Амоклав");
        amoksiklav.addVersion(amoksiklavVersionOne);

        Medicine.Version amoksiklavVersionTwo = amoksiklav.new Version();
        amoksiklavVersionTwo.setManufacturer("Lekk d.d.");
        Medicine.Certificate certificate2 = amoksiklavVersionTwo.getCertificate();
        certificate2.setNumber("a-322414");
        certificate2.setDateOfIssue("2020-12-14");
        certificate2.setExpiryDate("2024-12-14");
        certificate2.setRegistrationOrganisation("Minzdrav RB");
        Medicine.MedicinePackage medicinePackage2 = amoksiklavVersionTwo.getMedicinePackage();
        medicinePackage2.setPackageType("blister");
        medicinePackage2.setAmountInPackage(15);
        medicinePackage2.setPrice(120);
        Medicine.Dosage dosage1 = amoksiklavVersionTwo.getDosage();
        dosage1.setFrequencyOfMedication("One time a day");
        dosage1.setDose(500);
        amoksiklav.addVersion(amoksiklavVersionTwo);
        expectedResult.add(amoksiklav);


    }

    @AfterTest
    public void tearDown() {
        medicinesDomBuilder = null;
        actualResult = null;

    }
    @Test
    public void testGetMedicines() {
        medicinesDomBuilder.buildSetMedicines("testdata/testmed.xml");
        actualResult = medicinesDomBuilder.getMedicines();
        assertEquals(actualResult, expectedResult);
    }
}
