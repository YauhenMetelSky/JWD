package by.metelski.xmltask.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Medicine {
    private String id;
    private String group;
    private String name;
    private String pharm;
    private List<String> analogs = new ArrayList<>();
    private List<Version> versions = new ArrayList<>();
    private Version version = new Version();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
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
        return analogs;
    }

    public void setAnalogs(List<String> analogs) {
        this.analogs = analogs;
    }

    public void addAnalog(String medicine) {
        this.analogs.add(medicine);
    }

    public List<Version> getVersions() {
        return versions;
    }

    public void setVersions(List<Version> versions) {
        this.versions = versions;
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
            sb.append("manufacturer='").append(manufacturer).append('\'');
            sb.append(", certificate=").append(certificate);
            sb.append(", medicinePackage=").append(medicinePackage);
            sb.append(", dosage=").append(dosage);
            sb.append('}');
            return sb.toString();
        }
    }

    public class Certificate {
        private String number;
        private String dateOfIssue;
        private String expiryDate;
        private String registrationOrganisation;

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getDateOfIssue() {
            return dateOfIssue;
        }

        public void setDateOfIssue(String dateOfIssue) {

            this.dateOfIssue = dateOfIssue;
        }

        public String getExpiryDate() {
            return expiryDate;
        }

        public void setExpiryDate(String expiryDate) {
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
            sb.append("number='").append(number).append('\'');
            sb.append(", dateOfIssue='").append(dateOfIssue).append('\'');
            sb.append(", expiryDate='").append(expiryDate).append('\'');
            sb.append(", registrationOrganisation='").append(registrationOrganisation).append('\'');
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
            sb.append("packageType='").append(packageType).append('\'');
            sb.append(", amountInPackage=").append(amountInPackage);
            sb.append(", price=").append(price);
            sb.append('}');
            return sb.toString();
        }
    }

    public class Dosage {
        private int dosage;
        private String frequencyOfMedication;

        public int getDosage() {
            return dosage;
        }

        public void setDosage(int dosage) {
            this.dosage = dosage;
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
            Dosage dosage1 = (Dosage) o;
            return dosage == dosage1.dosage &&
                    Objects.equals(frequencyOfMedication, dosage1.frequencyOfMedication);
        }

        @Override
        public int hashCode() {
            return Objects.hash(dosage, frequencyOfMedication);
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Dosage{");
            sb.append("dosage=").append(dosage);
            sb.append(", frequencyOfMedication='").append(frequencyOfMedication).append('\'');
            sb.append('}');
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
                Objects.equals(versions, medicine.versions) &&
                Objects.equals(version, medicine.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, group, name, pharm, analogs, versions, version);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Medicine{");
        sb.append("id='").append(id).append('\'');
        sb.append(", group='").append(group).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", pharm='").append(pharm).append('\'');
        sb.append(", analogs=").append(analogs);
        sb.append(", versions=").append(versions);
        sb.append(", version=").append(version);
        sb.append('}');
        return sb.toString();
    }
}
