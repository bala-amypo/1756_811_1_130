







public class DeviceOwnershipRecord{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique=true)
    private String serialNumber;
    private String ownerName;
    private String ownerEmail;
    private LocalDate purchaseDate;
    private LocalDate warrantyExpiration;
    private Bool active;

    public DeviceOwnershipRecord(String serialNumber, String ownerName, String ownerEmail, LocalDate purchaseDate, LocalDate warrantyExpiration, Bool active ){
        this.id = id;
        this.serialNumber = serialNumber;
        this.ownerName = ownerName;
        this.ownerEmail = ownerEmail;
        this.purchaseDate = purchaseDate;
        this.warrantyExpiration  = warrantyExpiration;
        this.active = active;
    }

    public DeviceOwnershipRecord(){

    }

    public void setName(String serialNumber){
        this.serialNumber = serialNumber;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String ownerNamr){
        this.ownerName = ownerName;
    }

    public String getName(){
        return this.ownerNamer;
    }

    public void setName(String ownerEmail){
        this.ownerEmail = ownerEmail;
    }

    public String getName(){
        return this.ownerEmail;
    }

    public void setName(LocalDate purchaseDate){
        this.purchaseDate = purchaseDate;
    }

    public LocalDate getName(){
        return this.purchaseDate;
    }

    public void setName(LocalDate warrantyExpiration){
        this.warrantyExpiration = warrantyExpiration;
    }

    public LocalDate getName(){
        return this.warrantyExpiration;
    }

    public void setName(Bool active){
        this.active = active;
    }

    public Bool getName(){
        return this.active;
    }
}