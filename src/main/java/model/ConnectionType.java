package model;

public class ConnectionType {
    private String title;
    private String formalName;
    private boolean isDiscontinued;
    private boolean isObsolete;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFormalName() {
        return formalName;
    }

    public void setFormalName(String formalName) {
        this.formalName = formalName;
    }

    public boolean isDiscontinued() {
        return isDiscontinued;
    }

    public void setDiscontinued(boolean discontinued) {
        isDiscontinued = discontinued;
    }

    public boolean isObsolete() {
        return isObsolete;
    }

    public void setObsolete(boolean obsolete) {
        isObsolete = obsolete;
    }
}
