package by.metelski.xmltask.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Medicine {
    private String id;
    private String group;
    private String name;
    private String pharmaceuticalCompany;
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
    public String getPharmaceuticalCompany() {
        return pharmaceuticalCompany;
    }
    public void setPharmaceuticalCompany(String pharmaceuticalCompany) {
        this.pharmaceuticalCompany = pharmaceuticalCompany;
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
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((certificate == null) ? 0 : certificate.hashCode());
            result = prime * result + ((dosage == null) ? 0 : dosage.hashCode());
            result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
            result = prime * result + ((medicinePackage == null) ? 0 : medicinePackage.hashCode());
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Version other = (Version) obj;
            if (certificate == null) {
                if (other.certificate != null)
                    return false;
            } else if (!certificate.equals(other.certificate))
                return false;
            if (dosage == null) {
                if (other.dosage != null)
                    return false;
            } else if (!dosage.equals(other.dosage))
                return false;
            if (manufacturer == null) {
                if (other.manufacturer != null)
                    return false;
            } else if (!manufacturer.equals(other.manufacturer))
                return false;
            if (medicinePackage == null) {
                if (other.medicinePackage != null)
                    return false;
            } else if (!medicinePackage.equals(other.medicinePackage))
                return false;
            return true;
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
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((dateOfIssue == null) ? 0 : dateOfIssue.hashCode());
            result = prime * result + ((expiryDate == null) ? 0 : expiryDate.hashCode());
            result = prime * result + ((number == null) ? 0 : number.hashCode());
            result = prime * result
                    + ((registrationOrganisation == null) ? 0 : registrationOrganisation.hashCode());
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Certificate other = (Certificate) obj;
            if (dateOfIssue == null) {
                if (other.dateOfIssue != null)
                    return false;
            } else if (!dateOfIssue.equals(other.dateOfIssue))
                return false;
            if (expiryDate == null) {
                if (other.expiryDate != null)
                    return false;
            } else if (!expiryDate.equals(other.expiryDate))
                return false;
            if (number == null) {
                if (other.number != null)
                    return false;
            } else if (!number.equals(other.number))
                return false;
            if (registrationOrganisation == null) {
                if (other.registrationOrganisation != null)
                    return false;
            } else if (!registrationOrganisation.equals(other.registrationOrganisation))
                return false;
            return true;
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
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + amountInPackage;
            result = prime * result + ((packageType == null) ? 0 : packageType.hashCode());
            long temp;
            temp = Double.doubleToLongBits(price);
            result = prime * result + (int) (temp ^ (temp >>> 32));
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            MedicinePackage other = (MedicinePackage) obj;
            if (amountInPackage != other.amountInPackage)
                return false;
            if (packageType == null) {
                if (other.packageType != null)
                    return false;
            } else if (!packageType.equals(other.packageType))
                return false;
            if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
                return false;
            return true;
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
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + dose;
            result = prime * result + ((frequencyOfMedication == null) ? 0 : frequencyOfMedication.hashCode());
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Dosage other = (Dosage) obj;
            if (dose != other.dose)
                return false;
            if (frequencyOfMedication == null) {
                if (other.frequencyOfMedication != null)
                    return false;
            } else if (!frequencyOfMedication.equals(other.frequencyOfMedication))
                return false;
            return true;
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((analogs == null) ? 0 : analogs.hashCode());
        result = prime * result + ((group == null) ? 0 : group.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((pharmaceuticalCompany == null) ? 0 : pharmaceuticalCompany.hashCode());
        result = prime * result + ((versions == null) ? 0 : versions.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Medicine other = (Medicine) obj;
        if (analogs == null) {
            if (other.analogs != null)
                return false;
        } else if (!analogs.equals(other.analogs))
            return false;
        if (group == null) {
            if (other.group != null)
                return false;
        } else if (!group.equals(other.group))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (pharmaceuticalCompany == null) {
            if (other.pharmaceuticalCompany != null)
                return false;
        } else if (!pharmaceuticalCompany.equals(other.pharmaceuticalCompany))
            return false;
        if (versions == null) {
            if (other.versions != null)
                return false;
        } else if (!versions.equals(other.versions))
            return false;
        return true;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Medicine{");
        sb.append("\nid='").append(id).append('\'');
        sb.append(",\ngroup='").append(group).append('\'');
        sb.append(",\nname='").append(name).append('\'');
        sb.append(",\npharm='").append(pharmaceuticalCompany).append('\'');
        sb.append(",\nanalogs=").append(analogs);
        sb.append(",\nversions=").append(versions);
        sb.append('}');
        return sb.toString();
    }
}
