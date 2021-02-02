package by.metelski.xmltask.handler;

public enum MedicineXmlTag {
    MEDICINES("medicines"),
    VERSIONS("versions"),
    VERSION("version"),
    MEDICINE("medicine"),
    CERTIFICATE("certificate"),
    PACKAGE("package"),
    ID("id"),
    GROUP("group"),
    NAME("name"),
    PHARM("pharm"),
    MANUFACTURER("manufacturer"),
    ANALOG("analog"),
    NUMBER("number"),
    DATE_OF_ISSUE("date-of-issue"),
    EXPIRY_DATE("expiry-date"),
    REGISTRATION_ORGANISATION("registration-organisation"),
    PACKAGE_TYPE("package-type"),
    AMOUNT_IN_PACKAGE("amount-in-package"),
    PRICE("price"),
    DOSE("dose"),
    ANALOGS("analogs");
    private String value;

    MedicineXmlTag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
