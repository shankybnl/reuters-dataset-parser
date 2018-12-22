package dto;

import javax.xml.bind.annotation.XmlAttribute;

public class TOPICS {

    private String D;

    public String getD ()
    {
        return D;
    }

    @XmlAttribute
    public void setD (String D)
    {
        this.D = D;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [D = "+D+"]";
    }
}
