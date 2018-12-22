package dto;

import javax.xml.bind.annotation.XmlAttribute;

public class TEXT {

    private String content;

    private String AUTHOR;

    private String BODY;

    private String DATELINE;

    private String TITLE;

    public String getContent ()
    {
        return content;
    }

    @XmlAttribute
    public void setContent (String content)
    {
        this.content = content;
    }

    public String getAUTHOR ()
    {
        return AUTHOR;
    }

    @XmlAttribute
    public void setAUTHOR (String AUTHOR)
    {
        this.AUTHOR = AUTHOR;
    }

    public String getBODY ()
    {
        return BODY;
    }

    @XmlAttribute
    public void setBODY (String BODY)
    {
        this.BODY = BODY;
    }

    public String getDATELINE ()
    {
        return DATELINE;
    }

    @XmlAttribute
    public void setDATELINE (String DATELINE)
    {
        this.DATELINE = DATELINE;
    }

    public String getTITLE ()
    {
        return TITLE;
    }

    @XmlAttribute
    public void setTITLE (String TITLE)
    {
        this.TITLE = TITLE;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [content = "+content+", AUTHOR = "+AUTHOR+", BODY = "+BODY+", DATELINE = "+DATELINE+", TITLE = "+TITLE+"]";
    }


}
