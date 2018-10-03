/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profesorp.restexample.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author chuchip
 */
@Entity
@Table(name = "clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c"),
    @NamedQuery(name = "Clientes.findByEmpCodi", query = "SELECT c FROM Clientes c WHERE c.clientesPK.empCodi = :empCodi"),
    @NamedQuery(name = "Clientes.findByCliCodi", query = "SELECT c FROM Clientes c WHERE c.clientesPK.cliCodi = :cliCodi"),
    @NamedQuery(name = "Clientes.findByCliNomb", query = "SELECT c FROM Clientes c WHERE c.cliNomb = :cliNomb"),
    @NamedQuery(name = "Clientes.findByCliNomco", query = "SELECT c FROM Clientes c WHERE c.cliNomco = :cliNomco"),
    @NamedQuery(name = "Clientes.findByCliDirec", query = "SELECT c FROM Clientes c WHERE c.cliDirec = :cliDirec"),
    @NamedQuery(name = "Clientes.findByCliPobl", query = "SELECT c FROM Clientes c WHERE c.cliPobl = :cliPobl"),
    @NamedQuery(name = "Clientes.findByCliCodpo", query = "SELECT c FROM Clientes c WHERE c.cliCodpo = :cliCodpo"),
    @NamedQuery(name = "Clientes.findByCliTelef", query = "SELECT c FROM Clientes c WHERE c.cliTelef = :cliTelef"),
    @NamedQuery(name = "Clientes.findByCliFax", query = "SELECT c FROM Clientes c WHERE c.cliFax = :cliFax"),
    @NamedQuery(name = "Clientes.findByCliNif", query = "SELECT c FROM Clientes c WHERE c.cliNif = :cliNif"),
    @NamedQuery(name = "Clientes.findByCliPercon", query = "SELECT c FROM Clientes c WHERE c.cliPercon = :cliPercon"),
    @NamedQuery(name = "Clientes.findByCliTelcon", query = "SELECT c FROM Clientes c WHERE c.cliTelcon = :cliTelcon"),
    @NamedQuery(name = "Clientes.findByCliNomen", query = "SELECT c FROM Clientes c WHERE c.cliNomen = :cliNomen"),
    @NamedQuery(name = "Clientes.findByCliDiree", query = "SELECT c FROM Clientes c WHERE c.cliDiree = :cliDiree"),
    @NamedQuery(name = "Clientes.findByCliPoble", query = "SELECT c FROM Clientes c WHERE c.cliPoble = :cliPoble"),
    @NamedQuery(name = "Clientes.findByCliCodpoe", query = "SELECT c FROM Clientes c WHERE c.cliCodpoe = :cliCodpoe"),
    @NamedQuery(name = "Clientes.findByCliTelefe", query = "SELECT c FROM Clientes c WHERE c.cliTelefe = :cliTelefe"),
    @NamedQuery(name = "Clientes.findByCliFaxe", query = "SELECT c FROM Clientes c WHERE c.cliFaxe = :cliFaxe"),
    @NamedQuery(name = "Clientes.findByCliHorenv", query = "SELECT c FROM Clientes c WHERE c.cliHorenv = :cliHorenv"),
    @NamedQuery(name = "Clientes.findByCliComenv", query = "SELECT c FROM Clientes c WHERE c.cliComenv = :cliComenv"),
    @NamedQuery(name = "Clientes.findByTarCodi", query = "SELECT c FROM Clientes c WHERE c.tarCodi = :tarCodi"),
    @NamedQuery(name = "Clientes.findByCliCodfa", query = "SELECT c FROM Clientes c WHERE c.cliCodfa = :cliCodfa"),
    @NamedQuery(name = "Clientes.findByCliTipfac", query = "SELECT c FROM Clientes c WHERE c.cliTipfac = :cliTipfac"),
    @NamedQuery(name = "Clientes.findByCliActiv", query = "SELECT c FROM Clientes c WHERE c.cliActiv = :cliActiv"),
    @NamedQuery(name = "Clientes.findByCliCodrut", query = "SELECT c FROM Clientes c WHERE c.cliCodrut = :cliCodrut"),
    @NamedQuery(name = "Clientes.findByCliDtopp", query = "SELECT c FROM Clientes c WHERE c.cliDtopp = :cliDtopp"),
    @NamedQuery(name = "Clientes.findByCliDtootr", query = "SELECT c FROM Clientes c WHERE c.cliDtootr = :cliDtootr"),
    @NamedQuery(name = "Clientes.findByCliAlbval", query = "SELECT c FROM Clientes c WHERE c.cliAlbval = :cliAlbval"),
    @NamedQuery(name = "Clientes.findByCliRecequ", query = "SELECT c FROM Clientes c WHERE c.cliRecequ = :cliRecequ"),
    @NamedQuery(name = "Clientes.findByCliAgralb", query = "SELECT c FROM Clientes c WHERE c.cliAgralb = :cliAgralb"),
    @NamedQuery(name = "Clientes.findByCliComen", query = "SELECT c FROM Clientes c WHERE c.cliComen = :cliComen"),
    @NamedQuery(name = "Clientes.findByCliRiesg", query = "SELECT c FROM Clientes c WHERE c.cliRiesg = :cliRiesg"),
    @NamedQuery(name = "Clientes.findByCueCodi", query = "SELECT c FROM Clientes c WHERE c.cueCodi = :cueCodi"),
    @NamedQuery(name = "Clientes.findByCliExeiva", query = "SELECT c FROM Clientes c WHERE c.cliExeiva = :cliExeiva"),
    @NamedQuery(name = "Clientes.findByCliTipiva", query = "SELECT c FROM Clientes c WHERE c.cliTipiva = :cliTipiva"),
    @NamedQuery(name = "Clientes.findByCliPoriva", query = "SELECT c FROM Clientes c WHERE c.cliPoriva = :cliPoriva"),
    @NamedQuery(name = "Clientes.findByCliTipdoc", query = "SELECT c FROM Clientes c WHERE c.cliTipdoc = :cliTipdoc"),
    @NamedQuery(name = "Clientes.findByCliSitfac", query = "SELECT c FROM Clientes c WHERE c.cliSitfac = :cliSitfac"),
    @NamedQuery(name = "Clientes.findByDivCodi", query = "SELECT c FROM Clientes c WHERE c.divCodi = :divCodi"),
    @NamedQuery(name = "Clientes.findByCliPdtoco", query = "SELECT c FROM Clientes c WHERE c.cliPdtoco = :cliPdtoco"),
    @NamedQuery(name = "Clientes.findByCliPrapel", query = "SELECT c FROM Clientes c WHERE c.cliPrapel = :cliPrapel"),
    @NamedQuery(name = "Clientes.findByRutCodi", query = "SELECT c FROM Clientes c WHERE c.rutCodi = :rutCodi"),
    @NamedQuery(name = "Clientes.findByCliPrecfi", query = "SELECT c FROM Clientes c WHERE c.cliPrecfi = :cliPrecfi"),
    @NamedQuery(name = "Clientes.findByCliFecalt", query = "SELECT c FROM Clientes c WHERE c.cliFecalt = :cliFecalt"),
    @NamedQuery(name = "Clientes.findByCliFeulmo", query = "SELECT c FROM Clientes c WHERE c.cliFeulmo = :cliFeulmo"),
    @NamedQuery(name = "Clientes.findByCliGener", query = "SELECT c FROM Clientes c WHERE c.cliGener = :cliGener"),
    @NamedQuery(name = "Clientes.findByCliIntern", query = "SELECT c FROM Clientes c WHERE c.cliIntern = :cliIntern"),
    @NamedQuery(name = "Clientes.findByEtiCodi", query = "SELECT c FROM Clientes c WHERE c.etiCodi = :etiCodi"),
    @NamedQuery(name = "Clientes.findByCliFeulve", query = "SELECT c FROM Clientes c WHERE c.cliFeulve = :cliFeulve"),
    @NamedQuery(name = "Clientes.findByCliFeulco", query = "SELECT c FROM Clientes c WHERE c.cliFeulco = :cliFeulco"),
    @NamedQuery(name = "Clientes.findByCliEmail1", query = "SELECT c FROM Clientes c WHERE c.cliEmail1 = :cliEmail1"),
    @NamedQuery(name = "Clientes.findByCliEmail2", query = "SELECT c FROM Clientes c WHERE c.cliEmail2 = :cliEmail2"),
    @NamedQuery(name = "Clientes.findByCliServir", query = "SELECT c FROM Clientes c WHERE c.cliServir = :cliServir"),
    @NamedQuery(name = "Clientes.findByCliEnalva", query = "SELECT c FROM Clientes c WHERE c.cliEnalva = :cliEnalva"),
    @NamedQuery(name = "Clientes.findByCliOrdrut", query = "SELECT c FROM Clientes c WHERE c.cliOrdrut = :cliOrdrut"),
    @NamedQuery(name = "Clientes.findByCliComped", query = "SELECT c FROM Clientes c WHERE c.cliComped = :cliComped")})
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClientesPK clientesPK;
    @Size(max = 50)
    @Column(name = "cli_nomb")
    private String cliNomb;
    @Size(max = 120)
    @Column(name = "cli_nomco")
    private String cliNomco;
    @Size(max = 50)
    @Column(name = "cli_direc")
    private String cliDirec;
    @Size(max = 30)
    @Column(name = "cli_pobl")
    private String cliPobl;
    @Size(max = 8)
    @Column(name = "cli_codpo")
    private String cliCodpo;
    @Size(max = 25)
    @Column(name = "cli_telef")
    private String cliTelef;
    @Size(max = 15)
    @Column(name = "cli_fax")
    private String cliFax;
    @Size(max = 30)
    @Column(name = "cli_nif")
    private String cliNif;
    @Size(max = 30)
    @Column(name = "cli_percon")
    private String cliPercon;
    @Size(max = 15)
    @Column(name = "cli_telcon")
    private String cliTelcon;
    @Size(max = 50)
    @Column(name = "cli_nomen")
    private String cliNomen;
    @Size(max = 50)
    @Column(name = "cli_diree")
    private String cliDiree;
    @Size(max = 30)
    @Column(name = "cli_poble")
    private String cliPoble;
    @Size(max = 8)
    @Column(name = "cli_codpoe")
    private String cliCodpoe;
    @Size(max = 15)
    @Column(name = "cli_telefe")
    private String cliTelefe;
    @Size(max = 15)
    @Column(name = "cli_faxe")
    private String cliFaxe;
    @Size(max = 50)
    @Column(name = "cli_horenv")
    private String cliHorenv;
    @Size(max = 80)
    @Column(name = "cli_comenv")
    private String cliComenv;
    @Column(name = "tar_codi")
    private Integer tarCodi;
    @Column(name = "cli_codfa")
    private Integer cliCodfa;
    @Size(max = 1)
    @Column(name = "cli_tipfac")
    private String cliTipfac;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cli_activ")
    private short cliActiv;
    @Size(max = 5)
    @Column(name = "cli_codrut")
    private String cliCodrut;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cli_dtopp")
    private BigDecimal cliDtopp;
    @Column(name = "cli_dtootr")
    private BigDecimal cliDtootr;
    @Column(name = "cli_albval")
    private Integer cliAlbval;
    @Column(name = "cli_recequ")
    private Short cliRecequ;
    @Column(name = "cli_agralb")
    private Integer cliAgralb;
    @Size(max = 255)
    @Column(name = "cli_comen")
    private String cliComen;
    @Column(name = "cli_riesg")
    private Double cliRiesg;
    @Size(max = 12)
    @Column(name = "cue_codi")
    private String cueCodi;
    @Column(name = "cli_exeiva")
    private Short cliExeiva;
    @Size(max = 2)
    @Column(name = "cli_tipiva")
    private String cliTipiva;
    @Size(max = 2)
    @Column(name = "cli_poriva")
    private String cliPoriva;
    @Size(max = 2)
    @Column(name = "cli_tipdoc")
    private String cliTipdoc;
    @Size(max = 2)
    @Column(name = "cli_sitfac")
    private String cliSitfac;
    @Column(name = "div_codi")
    private Integer divCodi;
    @Column(name = "cli_pdtoco")
    private Double cliPdtoco;
    @Column(name = "cli_prapel")
    private Double cliPrapel;
    @Size(max = 2)
    @Column(name = "rut_codi")
    private String rutCodi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cli_precfi")
    private int cliPrecfi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cli_fecalt")
    @Temporal(TemporalType.DATE)
    private Date cliFecalt;
    @Column(name = "cli_feulmo")
    @Temporal(TemporalType.DATE)
    private Date cliFeulmo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cli_gener")
    private short cliGener;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cli_intern")
    private short cliIntern;
    @Basic(optional = false)
    @NotNull
    @Column(name = "eti_codi")
    private short etiCodi;
    @Column(name = "cli_feulve")
    @Temporal(TemporalType.DATE)
    private Date cliFeulve;
    @Column(name = "cli_feulco")
    @Temporal(TemporalType.DATE)
    private Date cliFeulco;
    @Size(max = 60)
    @Column(name = "cli_email1")
    private String cliEmail1;
    @Size(max = 60)
    @Column(name = "cli_email2")
    private String cliEmail2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cli_servir")
    private short cliServir;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cli_enalva")
    private short cliEnalva;
    @Column(name = "cli_ordrut")
    private Short cliOrdrut;
    @Size(max = 256)
    @Column(name = "cli_comped")
    private String cliComped;
    
    @JoinColumn(name = "emp_codi", referencedColumnName = "emp_codi", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empresa empresa;
    
    @JoinColumn(name = "fpa_codi", referencedColumnName = "fpa_codi")
    @ManyToOne(fetch = FetchType.LAZY)
    private Formpago fpaCodi;
    
    @JoinColumn(name = "pai_inic", referencedColumnName = "pai_inic")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Paises paiInic;
    
    @JoinColumns({
        @JoinColumn(name = "emp_codi", referencedColumnName = "emp_codi", insertable = false, updatable = false),
        @JoinColumn(name = "sbe_codi", referencedColumnName = "sbe_codi")})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Subempresa subempresa;

    public Clientes() {
    }

    public Clientes(ClientesPK clientesPK) {
        this.clientesPK = clientesPK;
    }

    public Clientes(ClientesPK clientesPK, short cliActiv, int cliPrecfi, Date cliFecalt, short cliGener, short cliIntern, short etiCodi, short cliServir, short cliEnalva) {
        this.clientesPK = clientesPK;
        this.cliActiv = cliActiv;
        this.cliPrecfi = cliPrecfi;
        this.cliFecalt = cliFecalt;
        this.cliGener = cliGener;
        this.cliIntern = cliIntern;
        this.etiCodi = etiCodi;
        this.cliServir = cliServir;
        this.cliEnalva = cliEnalva;
    }

    public Clientes(int empCodi, int cliCodi) {
        this.clientesPK = new ClientesPK(empCodi, cliCodi);
    }

    public ClientesPK getClientesPK() {
        return clientesPK;
    }

    public void setClientesPK(ClientesPK clientesPK) {
        this.clientesPK = clientesPK;
    }

    public String getCliNomb() {
        return cliNomb;
    }

    public void setCliNomb(String cliNomb) {
        this.cliNomb = cliNomb;
    }

    public String getCliNomco() {
        return cliNomco;
    }

    public void setCliNomco(String cliNomco) {
        this.cliNomco = cliNomco;
    }

    public String getCliDirec() {
        return cliDirec;
    }

    public void setCliDirec(String cliDirec) {
        this.cliDirec = cliDirec;
    }

    public String getCliPobl() {
        return cliPobl;
    }

    public void setCliPobl(String cliPobl) {
        this.cliPobl = cliPobl;
    }

    public String getCliCodpo() {
        return cliCodpo;
    }

    public void setCliCodpo(String cliCodpo) {
        this.cliCodpo = cliCodpo;
    }

    public String getCliTelef() {
        return cliTelef;
    }

    public void setCliTelef(String cliTelef) {
        this.cliTelef = cliTelef;
    }

    public String getCliFax() {
        return cliFax;
    }

    public void setCliFax(String cliFax) {
        this.cliFax = cliFax;
    }

    public String getCliNif() {
        return cliNif;
    }

    public void setCliNif(String cliNif) {
        this.cliNif = cliNif;
    }

    public String getCliPercon() {
        return cliPercon;
    }

    public void setCliPercon(String cliPercon) {
        this.cliPercon = cliPercon;
    }

    public String getCliTelcon() {
        return cliTelcon;
    }

    public void setCliTelcon(String cliTelcon) {
        this.cliTelcon = cliTelcon;
    }

    public String getCliNomen() {
        return cliNomen;
    }

    public void setCliNomen(String cliNomen) {
        this.cliNomen = cliNomen;
    }

    public String getCliDiree() {
        return cliDiree;
    }

    public void setCliDiree(String cliDiree) {
        this.cliDiree = cliDiree;
    }

    public String getCliPoble() {
        return cliPoble;
    }

    public void setCliPoble(String cliPoble) {
        this.cliPoble = cliPoble;
    }

    public String getCliCodpoe() {
        return cliCodpoe;
    }

    public void setCliCodpoe(String cliCodpoe) {
        this.cliCodpoe = cliCodpoe;
    }

    public String getCliTelefe() {
        return cliTelefe;
    }

    public void setCliTelefe(String cliTelefe) {
        this.cliTelefe = cliTelefe;
    }

    public String getCliFaxe() {
        return cliFaxe;
    }

    public void setCliFaxe(String cliFaxe) {
        this.cliFaxe = cliFaxe;
    }

    public String getCliHorenv() {
        return cliHorenv;
    }

    public void setCliHorenv(String cliHorenv) {
        this.cliHorenv = cliHorenv;
    }

    public String getCliComenv() {
        return cliComenv;
    }

    public void setCliComenv(String cliComenv) {
        this.cliComenv = cliComenv;
    }

    public Integer getTarCodi() {
        return tarCodi;
    }

    public void setTarCodi(Integer tarCodi) {
        this.tarCodi = tarCodi;
    }

    public Integer getCliCodfa() {
        return cliCodfa;
    }

    public void setCliCodfa(Integer cliCodfa) {
        this.cliCodfa = cliCodfa;
    }

    public String getCliTipfac() {
        return cliTipfac;
    }

    public void setCliTipfac(String cliTipfac) {
        this.cliTipfac = cliTipfac;
    }

    public short getCliActiv() {
        return cliActiv;
    }

    public void setCliActiv(short cliActiv) {
        this.cliActiv = cliActiv;
    }

    public String getCliCodrut() {
        return cliCodrut;
    }

    public void setCliCodrut(String cliCodrut) {
        this.cliCodrut = cliCodrut;
    }

    public BigDecimal getCliDtopp() {
        return cliDtopp;
    }

    public void setCliDtopp(BigDecimal cliDtopp) {
        this.cliDtopp = cliDtopp;
    }

    public BigDecimal getCliDtootr() {
        return cliDtootr;
    }

    public void setCliDtootr(BigDecimal cliDtootr) {
        this.cliDtootr = cliDtootr;
    }

    public Integer getCliAlbval() {
        return cliAlbval;
    }

    public void setCliAlbval(Integer cliAlbval) {
        this.cliAlbval = cliAlbval;
    }

    public Short getCliRecequ() {
        return cliRecequ;
    }

    public void setCliRecequ(Short cliRecequ) {
        this.cliRecequ = cliRecequ;
    }

    public Integer getCliAgralb() {
        return cliAgralb;
    }

    public void setCliAgralb(Integer cliAgralb) {
        this.cliAgralb = cliAgralb;
    }

    public String getCliComen() {
        return cliComen;
    }

    public void setCliComen(String cliComen) {
        this.cliComen = cliComen;
    }

    public Double getCliRiesg() {
        return cliRiesg;
    }

    public void setCliRiesg(Double cliRiesg) {
        this.cliRiesg = cliRiesg;
    }

    public String getCueCodi() {
        return cueCodi;
    }

    public void setCueCodi(String cueCodi) {
        this.cueCodi = cueCodi;
    }

    public Short getCliExeiva() {
        return cliExeiva;
    }

    public void setCliExeiva(Short cliExeiva) {
        this.cliExeiva = cliExeiva;
    }

    public String getCliTipiva() {
        return cliTipiva;
    }

    public void setCliTipiva(String cliTipiva) {
        this.cliTipiva = cliTipiva;
    }

    public String getCliPoriva() {
        return cliPoriva;
    }

    public void setCliPoriva(String cliPoriva) {
        this.cliPoriva = cliPoriva;
    }

    public String getCliTipdoc() {
        return cliTipdoc;
    }

    public void setCliTipdoc(String cliTipdoc) {
        this.cliTipdoc = cliTipdoc;
    }

    public String getCliSitfac() {
        return cliSitfac;
    }

    public void setCliSitfac(String cliSitfac) {
        this.cliSitfac = cliSitfac;
    }

    public Integer getDivCodi() {
        return divCodi;
    }

    public void setDivCodi(Integer divCodi) {
        this.divCodi = divCodi;
    }

    public Double getCliPdtoco() {
        return cliPdtoco;
    }

    public void setCliPdtoco(Double cliPdtoco) {
        this.cliPdtoco = cliPdtoco;
    }

    public Double getCliPrapel() {
        return cliPrapel;
    }

    public void setCliPrapel(Double cliPrapel) {
        this.cliPrapel = cliPrapel;
    }

    public String getRutCodi() {
        return rutCodi;
    }

    public void setRutCodi(String rutCodi) {
        this.rutCodi = rutCodi;
    }

    public int getCliPrecfi() {
        return cliPrecfi;
    }

    public void setCliPrecfi(int cliPrecfi) {
        this.cliPrecfi = cliPrecfi;
    }

    public Date getCliFecalt() {
        return cliFecalt;
    }

    public void setCliFecalt(Date cliFecalt) {
        this.cliFecalt = cliFecalt;
    }

    public Date getCliFeulmo() {
        return cliFeulmo;
    }

    public void setCliFeulmo(Date cliFeulmo) {
        this.cliFeulmo = cliFeulmo;
    }

    public short getCliGener() {
        return cliGener;
    }

    public void setCliGener(short cliGener) {
        this.cliGener = cliGener;
    }

    public short getCliIntern() {
        return cliIntern;
    }

    public void setCliIntern(short cliIntern) {
        this.cliIntern = cliIntern;
    }

    public short getEtiCodi() {
        return etiCodi;
    }

    public void setEtiCodi(short etiCodi) {
        this.etiCodi = etiCodi;
    }

    public Date getCliFeulve() {
        return cliFeulve;
    }

    public void setCliFeulve(Date cliFeulve) {
        this.cliFeulve = cliFeulve;
    }

    public Date getCliFeulco() {
        return cliFeulco;
    }

    public void setCliFeulco(Date cliFeulco) {
        this.cliFeulco = cliFeulco;
    }

    public String getCliEmail1() {
        return cliEmail1;
    }

    public void setCliEmail1(String cliEmail1) {
        this.cliEmail1 = cliEmail1;
    }

    public String getCliEmail2() {
        return cliEmail2;
    }

    public void setCliEmail2(String cliEmail2) {
        this.cliEmail2 = cliEmail2;
    }

    public short getCliServir() {
        return cliServir;
    }

    public void setCliServir(short cliServir) {
        this.cliServir = cliServir;
    }

    public short getCliEnalva() {
        return cliEnalva;
    }

    public void setCliEnalva(short cliEnalva) {
        this.cliEnalva = cliEnalva;
    }

    public Short getCliOrdrut() {
        return cliOrdrut;
    }

    public void setCliOrdrut(Short cliOrdrut) {
        this.cliOrdrut = cliOrdrut;
    }

    public String getCliComped() {
        return cliComped;
    }

    public void setCliComped(String cliComped) {
        this.cliComped = cliComped;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Formpago getFpaCodi() {
        return fpaCodi;
    }

    public void setFpaCodi(Formpago fpaCodi) {
        this.fpaCodi = fpaCodi;
    }

    public Paises getPaiInic() {
        return paiInic;
    }

    public void setPaiInic(Paises paiInic) {
        this.paiInic = paiInic;
    }

    public Subempresa getSubempresa() {
        return subempresa;
    }

    public void setSubempresa(Subempresa subempresa) {
        this.subempresa = subempresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientesPK != null ? clientesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.clientesPK == null && other.clientesPK != null) || (this.clientesPK != null && !this.clientesPK.equals(other.clientesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "profesorp.restexample.entity.Clientes[ clientesPK=" + clientesPK + " ]";
    }
    
}
