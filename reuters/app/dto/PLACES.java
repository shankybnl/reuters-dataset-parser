package dto;

import javax.xml.bind.annotation.XmlElement;

public class PLACES {

    private String[] D;

    public String[] getD ()
    {
        return D;
    }
    @XmlElement
    public void setD (String[] D)
    {
        this.D = D;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [D = "+D+"]";
    }
}
