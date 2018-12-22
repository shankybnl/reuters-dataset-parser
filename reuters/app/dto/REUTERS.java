package dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class REUTERS
{
    private String ORGS;

    private String LEWISSPLIT;

    private String CGISPLIT;

    private String OLDID;

    private TOPICS[] TOPICS;

    private String COMPANIES;

    private String NEWID;

    private TEXT TEXT;

    private String UNKNOWN;

    private PLACES PLACES;

    private String DATE;

    private String PEOPLE;

    private String EXCHANGES;

    public String getORGS ()
    {
        return ORGS;
    }
    @XmlElement
    public void setORGS (String ORGS)
    {
        this.ORGS = ORGS;
    }

    public String getLEWISSPLIT ()
    {
        return LEWISSPLIT;
    }

    @XmlAttribute
    public void setLEWISSPLIT (String LEWISSPLIT)
    {
        this.LEWISSPLIT = LEWISSPLIT;
    }

    public String getCGISPLIT ()
    {
        return CGISPLIT;
    }
    @XmlAttribute
    public void setCGISPLIT (String CGISPLIT)
    {
        this.CGISPLIT = CGISPLIT;
    }

    public String getOLDID ()
    {
        return OLDID;
    }
    @XmlAttribute
    public void setOLDID (String OLDID)
    {
        this.OLDID = OLDID;
    }

    public TOPICS[] getTOPICS ()
    {
        return TOPICS;
    }
    @XmlElement
    public void setTOPICS (TOPICS[] TOPICS)
    {
        this.TOPICS = TOPICS;
    }

    public String getCOMPANIES ()
    {
        return COMPANIES;
    }
    @XmlElement
    public void setCOMPANIES (String COMPANIES)
    {
        this.COMPANIES = COMPANIES;
    }

    public String getNEWID ()
    {
        return NEWID;
    }
    @XmlAttribute
    public void setNEWID (String NEWID)
    {
        this.NEWID = NEWID;
    }

    public TEXT getTEXT ()
    {
        return TEXT;
    }
    @XmlElement
    public void setTEXT (TEXT TEXT)
    {
        this.TEXT = TEXT;
    }

    public String getUNKNOWN ()
    {
        return UNKNOWN;
    }
    @XmlElement
    public void setUNKNOWN (String UNKNOWN)
    {
        this.UNKNOWN = UNKNOWN;
    }

    public PLACES getPLACES ()
    {
        return PLACES;
    }
    @XmlElement
    public void setPLACES (PLACES PLACES)
    {
        this.PLACES = PLACES;
    }

    public String getDATE ()
    {
        return DATE;
    }
    @XmlElement
    public void setDATE (String DATE)
    {
        this.DATE = DATE;
    }

    public String getPEOPLE ()
    {
        return PEOPLE;
    }
    @XmlElement
    public void setPEOPLE (String PEOPLE)
    {
        this.PEOPLE = PEOPLE;
    }

    public String getEXCHANGES ()
    {
        return EXCHANGES;
    }

    @XmlElement
    public void setEXCHANGES (String EXCHANGES)
    {
        this.EXCHANGES = EXCHANGES;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [ORGS = "+ORGS+", LEWISSPLIT = "+LEWISSPLIT+", CGISPLIT = "+CGISPLIT+", OLDID = "+OLDID+", TOPICS = "+TOPICS+", COMPANIES = "+COMPANIES+", NEWID = "+NEWID+", TEXT = "+TEXT+", UNKNOWN = "+UNKNOWN+", PLACES = "+PLACES+", DATE = "+DATE+", PEOPLE = "+PEOPLE+", EXCHANGES = "+EXCHANGES+"]";
    }
}
