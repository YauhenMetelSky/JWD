package by.metelski.xmltask.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Medicine {
    private String id;
    private String group;
    private String name;
    private String pharm;
    private List<String> analogs = new ArrayList<>();
    private List<Version> versions = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPharm() {
        return pharm;
    }

    public void setPharm(String pharm) {
        this.pharm = pharm;
    }

    public List<String> getAnalogs() {
        return Collections.unmodifiableList(analogs);
    }

    public void setAnalogs(List<String> analogs) {
        this.analogs = analogs;
    }

    public void addAnalog(String medicine) {
        this.analogs.add(medicine);
    }

    public List<Version> getVersions() {
        return Collections.unmodifiableList(versions);
    }

    public void setVersions(List<Version> versions) {
        this.versions = versions;
    }

    public void addVersion(Version version) {
        this.versions.add(version);
    }

    public class Version {
        private String manufacturer;
        private Certificate certificate = new Certificate();
        private MedicinePackage medicinePackage = new MedicinePackage();
        private Dosage dosage = new Dosage();

        public String getManufacturer() {
            return manufacturer;
        }

        public void setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
        }

        public Certificate getCertificate() {
            return certificate;
        }

        public void setCertificate(Certificate certificate) {
            this.certificate = certificate;
        }

        public MedicinePackage getMedicinePackage() {
            return medicinePackage;
        }

        public void setMedicinePackage(MedicinePackage medicinePackage) {
            this.medicinePackage = medicinePackage;
        }

        public Dosage getDosage() {
            return dosage;
        }

        public void setDosage(Dosage dosage) {
            this.dosage = dosage;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Version version = (Version) o;
            return Objects.equals(manufacturer, version.manufacturer) &&
                    Objects.equals(certificate, version.certificate) &&
                    Objects.equals(medicinePackage, version.medicinePackage) &&
                    Objects.equals(dosage, version.dosage);
        }

        @Override
        public int hashCode() {
            return Objects.hash(manufacturer, certificate, medicinePackage, dosage);
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Version{");
            sb.append("\nmanufacturer='").append(manufacturer).append('\'');
            sb.append(", \ncertificate=").append(certificate);
            sb.append(", \nmedicinePackage=").append(medicinePackage);
            sb.append(", \ndosage=").append(dosage);
            sb.append('}');
            return sb.toString();
        }
    }

    public class Certificate {
        private String number;
        private LocalDate dateOfIssue;
        private LocalDate expiryDate;
        private String registrationOrganisation;

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public LocalDate getDateOfIssue() {
            return dateOfIssue;
        }

        public void setDateOfIssue(LocalDate dateOfIssue) {

            this.dateOfIssue = dateOfIssue;
        }

        public LocalDate getExpiryDate() {
            return expiryDate;
        }

        public void setExpiryDate(LocalDate expiryDate) {
            this.expiryDate = expiryDate;
        }

        public String getRegistrationOrganisation() {
            return registrationOrganisation;
        }

        public void setRegistrationOrganisation(String registrationOrganisation) {
            this.registrationOrganisation = registrationOrganisation;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Certificate{");
            sb.append("\nnumber='").append(number).append('\'');
            sb.append(",\ndateOfIssue='").append(dateOfIssue).append('\'');
            sb.append(",\nexpiryDate='").append(expiryDate).append('\'');
            sb.append(",\nregistrationOrganisation='").append(registrationOrganisation).append('\'');
            sb.append('}');
            return sb.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Certificate that = (Certificate) o;
            return Objects.equals(number, that.number) &&
                    Objects.equals(dateOfIssue, that.dateOfIssue) &&
                    Objects.equals(expiryDate, that.expiryDate) &&
                    Objects.equals(registrationOrganisation, that.registrationOrganisation);
        }

        @Override
        public int hashCode() {
            return Objects.hash(number, dateOfIssue, expiryDate, registrationOrganisation);
        }
    }

    public class MedicinePackage {
        private String packageType;
        private int amountInPackage;
        private double price;

        public String getPackageType() {
            return packageType;
        }

        public void setPackageType(String packageType) {
            this.packageType = packageType;
        }

        public int getAmountInPackage() {
            return amountInPackage;
        }

        public void setAmountInPackage(int amountInPackage) {
            this.amountInPackage = amountInPackage;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MedicinePackage that = (MedicinePackage) o;
            return amountInPackage == that.amountInPackage &&
                    Double.compare(that.price, price) == 0 &&
                    Objects.equals(packageType, that.packageType);
        }

        @Override
        public int hashCode() {
            return Objects.hash(packageType, amountInPackage, price);
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("MedicinePackage{");
            sb.append("\npackageType='").append(packageType).append('\'');
            sb.append(",\namountInPackage=").append(amountInPackage);
            sb.append(",\nprice=").append(price);
            sb.append('}');
            return sb.toString();
        }
    }

    public class Dosage {
        private String frequencyOfMedication;
        private int dose;

        public int getDose() {
            return dose;
        }

        public void setDose(int dose) {
            this.dose = dose;
        }

        public String getFrequencyOfMedication() {
            return frequencyOfMedication;
        }

        public void setFrequencyOfMedication(String frequencyOfMedication) {
            this.frequencyOfMedication = frequencyOfMedication;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Dosage dosage = (Dosage) o;
            return dose == dosage.dose &&
                    Objects.equals(frequencyOfMedication, dosage.frequencyOfMedication);
        }

        @Override
        public int hashCode() {
            return Objects.hash(frequencyOfMedication, dose);
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Dosage{");
            sb.append("frequencyOfMedication='").append(frequencyOfMedication).append('\'');
            sb.append(", dose=").append(dose);
            sb.append("}");
            return sb.toString();
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return Objects.equals(id, medicine.id) &&
                Objects.equals(group, medicine.group) &&
                Objects.equals(name, medicine.name) &&
                Objects.equals(pharm, medicine.pharm) &&
                Objects.equals(analogs, medicine.analogs) &&
                Objects.equals(versions, medicine.versions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, group, name, pharm, analogs, versions);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Medicine{");
        sb.append("\nid='").append(id).append('\'');
        sb.append(",\ngroup='").append(group).append('\'');
        sb.append(",\nname='").append(name).append('\'');
        sb.append(",\npharm='").append(pharm).append('\'');
        sb.append(",\nanalogs=").append(analogs);
        sb.append(",\nversions=").append(versions);
        sb.append('}');
        return sb.toString();
    }
}
